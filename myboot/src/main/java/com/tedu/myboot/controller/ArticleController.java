package com.tedu.myboot.controller;

import com.tedu.myboot.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    private static File articleDir;

    static {
        articleDir = new File("./articles");
        if (!articleDir.exists()) {
            articleDir.mkdirs();
        }
    }

    @RequestMapping("/writeArticle")
    public void writeArticle(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("开始处理文章发表操作！");

        //获取用户在页面上输入的信息
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String content = request.getParameter("content");
        System.out.println(title + "," + author + "\r\n" + content);

        /*
            writeArticle.html表单提交时，请求应当是：
            http://localhost:8080/writeArticle?title=xxx&author=&content=xxx
            在上面的请求提交中author参数是包含的，但是没有参数值，此时如果调用：
            String author = request.getParameter("author");
            那么返回的字符串就是空字符串（说明本次请求包含参数author，但是该参数没有值）

            直接在地址栏上手敲路径
            http://localhost:8080/writeArticle?title=xxx
            在上面的请求提交中author参数是不包含的，此时如果调用：
            String author = request.getParameter("author");
            那么返回的字符串就是null（说明本次请求不包含参数author）

            获取参数时：当本次请求包含该参数，但是该参数没有值时，返回值为空字符串。
            当本次请求不包含该参数时，返回值为null
         */
        if (title == null || author == null || content == null
                || title.isEmpty() || author.isEmpty() || content.isEmpty()) {
            try {
                response.sendRedirect("/article_fail.html");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File articleFile = new File(articleDir, title + ".obj");
        if (articleFile.exists()) { //文件存在，说明是重复的标题
            try {
                response.sendRedirect("/article_fail.html");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Article article = new Article(title, author, content);
        try (
                FileOutputStream fos = new FileOutputStream(articleFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(article);
            response.sendRedirect("./article_success.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/articleList")
    public void articleList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("开始处理显示文章列表！");

        List<Article> articleList = new ArrayList<>();
        File[] subs = articleDir.listFiles(f -> f.getName().endsWith(".obj"));
        for (File sub : subs) {
            try (
                    FileInputStream fis = new FileInputStream(sub);
                    ObjectInputStream ois = new ObjectInputStream(fis);
            ) {
                Article article = (Article) ois.readObject();
                articleList.add(article);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.println("<!DOCTYPE html>");
            pw.println("<html lang=\"en\">");
            pw.println("<head>");
            pw.println("<meta charset=\"UTF-8\">");
            pw.println("<title>文章列表</title>");
            pw.println("</head>");
            pw.println("<body style=\"background:url('/tsukiniyorisou.jpg') no-repeat center bottom fixed;background-size:contain\">");
            pw.println("<center>");
            pw.println("<h1 style=\"color:#E50080\">文章列表</h1>");
            pw.println("<table border=\"2\" bgcolor=\"#FE91CC\">");
            pw.println("<tr>");
            pw.println("<td>标题</td>");
            pw.println("<td>作者</td>");
            pw.println("<td>内容</td>");
            pw.println("</tr>");

            for (Article article : articleList) {
                pw.println("<tr>");
                pw.println("<td>" + article.getTitle() + "</td>");
                pw.println("<td>" + article.getAuthor() + "</td>");
                pw.println("<td>" + article.getContent() + "</td>");
                pw.println("<td><a href=\"/deleteArticle?title=" + article.getTitle() + "\">删除</a></td>");
                pw.println("</tr>");
            }

            pw.println("</table>");
            pw.println("</center>");
            pw.println("</body>");
            pw.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteArticle")
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");

        File articleFile = new File(articleDir, title + ".obj");
        if (articleFile.exists()) {
            System.out.println(articleFile.getName());
            articleFile.delete();
        }

        try {
            response.sendRedirect("/articleList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
