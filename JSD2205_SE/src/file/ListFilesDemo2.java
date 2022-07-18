package file;

import java.io.File;
import java.io.FileFilter;

/**
 * 有条件的获取一个目录中的部分子项
 */
public class ListFilesDemo2 {
    public static void main(String[] args) {
        /*
            获取file目录中名字含有字母"s"的所有子项

            Filter:过滤器
            accept:接受
            contains:包含
         */
        FileFilter filter = new FileFilter() {
            //定义是否接受参数file所表示元素的条件
            public boolean accept(File file) {
                String name = file.getName();
                //return name.indexOf("s")>=0;
                //indexOf()返回第一次出现的位置，范围0到数组长度-1，若没出现则返回-1
                return name.contains("s");
                //String的contains方法用于判断当前字符串是否包含给定内容
            }
        };

        File dir = new File("./src/file");
        if (dir.isDirectory()) {
            /*
                File重写的:File[] listFiles(FileFilter filter)
                该方法返回当前File对象表示的目录中所有满足给定过滤器要求的子项。
                listFiles会将这个目录中每个子项所对应的File对象逐一传给过滤器filter重写的accept方法，
                并将accept方法返回true的所有子项返回。
             */
            File[] subs = dir.listFiles(filter);
            System.out.println("共:" + subs.length + "个子项");
            for (int i = 0; i < subs.length; i++) {
                System.out.println(subs[i].getName());
            }
        }
    }
}
