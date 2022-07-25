# 课程介绍
![image](.\image.png)
- Web前端：学习如何开发页面
- 数据库：学习如何对数据进行增删改查
- SpringBoot：学习如何接收请求以及如何对请求做出响应，包括把前端和数据库整合

# HTML
- Hyper Text Markup Language：超文本标记语言
- 超文本：不仅仅是纯文本，还包括字体相关和多媒体相关（图片，音频，视频）
- 作用：负责搭建页面结构和准备页面内容，相当于盖房子（毛坯房）
- 学习HTML主要学习的是有哪些标签，以及标签的使用方式

# 01文本相关
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>01文本相关</title>
</head>
<body>
<!-- 内容标题h1-h6：独占一行，字体加粗，自带上下间距 -->
<!-- align：对齐方式 -->
<h1 align="right">内容标题1</h1> <!-- h1+Tab：快速输入h1标签 -->
<h2 align="center">内容标题2</h2> <!-- Ctrl+D：复制当前行 -->
<h3>内容标题3</h3>
<h4>内容标题4</h4>
<h5>内容标题5</h5>
<h6>内容标题6</h6>
<hr> <!-- hr：水平分割线 -->
<!-- 段落标签p：独占一行，自带上下间距 -->
<p>段落标签1</p>
<p>段落
    标签2</p> <!-- 回车实际显示是空格 -->
<p>段落<br>标签3</p> <!-- br：换行 -->
<!-- Shift+回车：快速换行 -->
加粗<b>标签</b>
斜体<i>标签</i>
下划线<u>标签</u>
删除线<s>标签</s>
<h1>列表标签：两种</h1>
<h2>无序列表</h2>
<ul> <!-- unordered list：无序列表 -->
    <li>刘备</li> <!-- list item：列表项 -->
    <li>孙尚香</li>
    <li>诸葛亮</li>
    <li>夏侯惇</li>
    <li>刘禅</li>
</ul>
<h2>有序列表</h2>
<ol><!-- ordered list：有序列表 -->
    <li>Java基础</li>
    <ul> <!-- 列表嵌套：有序列表和无序列表可以任意无限嵌套 -->
        <li>变量</li>
        <li>数据类型</li>
        <li>运算符</li>
    </ul>
    <li>JavaAPI</li>
    <li>Web前端</li>
</ol>
</body>
</html>
```

# 02简历练习
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>02简历练习</title>
</head>
<body>
<h1 align="center">个人简历</h1>
<hr>
<h2>基本信息</h2>
<p>姓名：<b>苍老师</b></p>
<p>性别：<i>男</i></p>
<p>爱好：<s>摄影</s></p>

<h2>个人经历</h2>
<ul>
    <li>小学9年</li>
    <li>中学6年</li>
    <li>高中12年</li>
</ul>

<h2>获得荣誉</h2>
<ol>
    <li>知名度最高奖</li>
    <li>达内体重达人</li>
</ol>
</body>
</html>
```

# 03图片标签
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>03图片标签</title>
</head>
<body>
<!-- 注释：
Ctrl+/
Ctrl+Shift+/
c+Tab
-->

<!-- 相对路径：访问站内资源时用 -->
<img src="a.png" alt="图片不能显示时显示的文本" width="80%"> <!-- 同级目录 -->
<img src="../b.webp" title="鼠标悬停时显示的文本" width="1000"> <!-- 上级目录 -->=
<img src="abc/c.png" width="1000"> <!-- 下级目录 -->

<!-- 绝对路径：访问站外资源时用 -->
<img src="https://cdn.tmooc.cn/tmooc-web/css/img/img2019052301x.jpg"> <!-- 盗链 -->

<!-- 设置图片的宽高：
1、像素：width="1000" height="1000"，只设置宽度时高度会自动等比例缩放
2、百分比：指上级的百分比，比如img的上级是body
-->
</body>
</html>
```

# 04超链接
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>04超链接</title>
</head>
<body>
<!-- href：设置资源路径，和图片标签的src属性类似 -->
<a href="https://www.tsdm39.net/forum.php">超链接1</a>
<a href="02简历练习.html">超链接2</a>
<a href="a.png">超链接3</a>
<!-- a标签包裹文本为文本超链接，包裹图片为图片超链接 -->
<a href="https://zh.moegirl.org.cn/欢迎来到实力至上主义的教室">
    <img src="a.png" width="500" alt="欢迎来到实力至上主义的教室">
</a>
</body>
</html>
```

# 05表格标签
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>05表格标签</title>
</head>
<body>
<table border="1">
    <tr> <!-- table row：行-->
        <td colspan="2" align="center">1-1</td> <!-- td：列--> <!-- td：列合并-->
        <td rowspan="2">1-3</td> <!-- 行合并默认居中，不用设置 -->
        <td rowspan="3">1-4</td>
    </tr>
    <tr>
        <td>2-1</td>
        <td>2-2</td>
    </tr>
    <tr>
        <td colspan="3" align="center">3-1</td>
    </tr>
</table>

<table border="1">
    <!-- caption：表格标题 -->
    <caption>购物车</caption>
    <tr>
        <th>编号</th> <!-- table head：表头，自动加粗并居中 -->
        <th>商品名</th>
        <th>价格</th>
    </tr>
    <tr>
        <td>1</td>
        <td>华为手机</td>
        <td>5600</td>
    </tr>
    <tr>
        <td>2</td>
        <td>小米手环</td>
        <td>600</td>
    </tr>
</table>
</body>
</html>
```

# 06表单
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>06表单</title>
</head>
<!--
作用：获取用户输入的各种信息并提交给服务器
学习form表单就是学习form表单中有哪些控件
-->
<body>
<!--
action：设置提交地址
maxlength：输入字符的最大长度
value：设置初始值
readonly：只读
（当属性的名和值相同时，如readonly="readonly"，则可以省略值只写名）
name参数必须写
placeholder：占位文本，初始提示
-->
<form action="https://cn.bing.com/">
    用户名：<input type="text" maxlength="5" value="abc" readonly name="username" placeholder="请输入用户名"><br>
    密码：<input type="password" name="password" placeholder="请输入密码"><br>

    <!-- 单选框的value属性必须写，否则无论选什么提交的都是on -->
    <!-- checked设置默认选中 -->
    <!-- name属性的值要一样 -->
    性别：<input type="radio" name="gender" value="m" id="r1" checked>
    <label for="r1">男</label>
    <input type="radio" name="gender" value="w" id="r2">
    <label for="r2">女</label><br>

    兴趣爱好：<input type="checkbox" name="hobby" value="other" checked>异性
    <input type="checkbox" name="hobby" value="man">男同
    <input type="checkbox" name="hobby" value="woman">女同<br>

    生日：<input type="date" name="birthday"><br>
    照片：<input type="file" name="pic"><br> <!-- 上传文件 -->
    城市：
    <select name="city">
        <option value="beijing">北京</option>
        <option value="shanghai">上海</option>
        <option value="guangzhou" selected>广州</option>
    </select><br>

    <input type="submit" value="注册">
    <input type="reset"> <!-- 重置按钮 -->
    <input type="button" value="自定义"> <!-- 自定义按钮 -->
</form>
</body>
</html>
```

# 07分区标签
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>07分区标签</title>
</head>
<!--
分区标签可以理解为一个容器，用来装多个有相关性的标签，对多个标签进行统一管理
如何对页面进行分区？
一个页面至少分为3大区：头、体、脚，每个大区里有n个小的分区
常见的分区标签：
div：块级分区标签，特点：独占一行
span：行内分区标签，特点：共占一行
HTML5版本新增加的几个分区标签，作用和div一样，目的是为了提高代码可读性
header：头
main：主体
footer：脚
section：区域
nav：导航
-->
<body>
<div>div1</div>
<div>div2</div>
<div>div3</div>
<span>span1</span>
<span>span2</span>
<span>span3</span>
</body>
</html>
```

# 08CSS引入方式
```html
<!DOCTYPE html>
<html lang="en">
<!--
Cascading Style Sheet：层叠样式表（美化页面、装修）
如何在html页面中添加CSS样式代码？
三种引入方式：
内联样式：在标签的style属性中添加样式代码，弊端：不能复用
内部样式：在head标签里添加style标签，标签体内写样式代码，可以复用但是只能在当前页面复用不能多页面复用
外部样式：在单独的css样式文件中写样式代码，在html页面中通过link标签引入，可以实现多页面复用
工作中外部样式用的多，因为可以多页面复用而且可以将html代码和CSS样式代码分离开，学习过程中内部样式用的多
-->
<head>
    <meta charset="UTF-8">
    <title>08CSS引入方式</title>
    <style>
        h2 {
            color: aqua;
        }
    </style>
    <!-- 引入CSS样式文件 -->
    <link rel="stylesheet" href="my.css">
</head>
<body>
<h1 style="color:red">内联样式1</h1>
<h1 style="color:pink">内联样式2</h1>
<h2>内部样式1</h2>
<h2>内部样式2</h2>
<h3>外部样式1</h3>
<h3>外部样式2</h3>
</body>
</html>
```

# css
```css
h3 {
    color: chocolate;
}
```

# 09选择器
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>09选择器</title>
    <!-- html注释 -->
    <style> /* css注释 */
    /* 标签名选择器：选取页面中所有同名标签 */

    /* id选择器：当需要选择页面中某一个元素时使用 */
    #h1-1 {
        color: red;
    }

    /* 类选择器：当需要选择页面中多个不相关的元素时，给多个元素添加相同的class，然后通过类选择器进行选择 */
    .c1 {
        color: cornflowerblue;
    }

    /* 分组选择器：将多个选择器合并成一个选择器 */
    h3, #h1-1, .c1 {
        background-color: darkorange;
    }

    /* 属性选择器：通过元素的属性选择元素 */
    input[type="text"] {
        color: darkviolet;
    }

    /* 任意元素选择器：匹配页面中所有的元素 */
    * {
        /* 边框：粗细 样式 颜色 */
        border: 1px solid red;
    }
    </style>
</head>
<body>
<input type="text" placeholder="请输入">
<input type="password">
<h3>我是新来的</h3>
<h1 class="c1">冰箱</h1>
<h1>洗衣机</h1>
<h1 id="h1-1">电视</h1>
<h2 class="c1">香蕉</h2>
<h2>苹果</h2>
<h2>橘子</h2>
</body>
</html>
```

# 10选择器练习
```html
<!DOCTYPE html>
<html lang="en">
<!--
通过内部样式实现以下效果：
1、把张学友改成绿色
2、把刘德华和悟空改成蓝色
3、修改取经2人和刘备的背景为黄色
4、修改密码框的背景为红色
5、给所有元素添加红色的边框
-->
<head>
    <meta charset="UTF-8">
    <title>10选择器练习</title>
    <style>
        #p1 {
            color: green
        }

        .c1 {
            color: blue;
        }

        h1, h2 {
            background-color: yellow;
        }

        input[type="password"] {
            background-color: red;
        }

        * {
            border: 1px solid red;
        }
    </style>
</head>
<body>
<p id="p1">张学友</p>
<p class="c1">刘德华</p>
<p>郭富城</p>
<h1 class="c1">悟空</h1>
<h1>八戒</h1>
<h2>刘备</h2>
<input type="text">
<input type="password">
</body>
</html>
```

# 11选择器续
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>11选择器续</title>
    <style>
        /* 子孙后代选择器，一直串下去 */
        /*body div div p {
            color: red;
        }*/

        /* 子元素选择器，匹配到就停 */
        body > div > div > p {
            color: red;
        }

        /* 伪类选择器（下面写的顺序不能变） */
        a:link { /* 未访问 */
            color: red;
        }

        a:visited { /* 访问过 */
            color: green;
        }

        a:hover { /* 悬停 */
            color: pink;
        }

        a:active { /* 点击激活 */
            color: yellow;
        }
    </style>
</head>
<body>
<a href="10选择器练习.html">超链接1</a>
<a href="09选择器.html">超链接2</a>
<a href="08CSS引入方式.html">超链接3</a>
<p>p1</p>
<div>
    <p>p2</p>
    <div><p>p3</p></div>
    <div>
        <p>p4</p>
        <div><p>p5</p></div>
    </div>
</div>
</body>
</html>
```

# 12选择器练习
```html
<!DOCTYPE html>
<html lang="en">
<!--
通过内部样式实现以下效果：
1、关羽绿色
2、张飞和苹果黄色
3、文本框和所有水果背景红色
4、p2字体粉色
5、p2和p3背景黄色
6、达内官网未访问绿色，访问过红色，悬停黄色，点击粉色
-->
<head>
    <meta charset="UTF-8">
    <title>12选择器练习</title>
    <style>
        #li1 {
            color: green;
        }

        .c1 {
            color: yellow;
        }

        input[type="text"], body > p {
            background-color: red;
        }

        body > div > div > p {
            color: pink;
        }

        body div div p {
            background-color: yellow;
        }

        a:link {
            color: green;
        }

        a:visited {
            color: red;
        }

        a:hover {
            color: yellow;
        }

        a:active {
            color: pink;
        }
    </style>
</head>
<body>
<ul>
    <li>刘备</li>
    <li id="li1">关羽</li>
    <li class="c1">张飞</li>
</ul>
<p>香蕉</p>
<p class="c1">苹果</p>
<input type="text">
<input type="password">
<div>
    <p>p1</p>
    <div><p>p2</p></div>
    <div>
        <div><p>p3</p></div>
    </div>
</div>
<a href="www.tedu1.com">达内官网1</a>
</body>
</html>
```
