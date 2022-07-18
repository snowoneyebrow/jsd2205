# 语言基础第一天：

王克晶(WKJ)

1. 所负责的模块(第一阶段)：共19天课程

   - 语言基础：讲6天，讲语法规则、规定---------不需要理解、背下来就行(多练)
   - 面向对象：讲10天，讲编程思想、思路-------需要理解、思考(多练、多想)
   - API基础与二进制：讲3天，讲常用的工具----不需要理解、背下来就行(多练)

4. 下载和安装JDK和Idea：

   doc.canglaoshi.org

   JDK：一路下一步，尽量装在C盘下，一定不要用中文命名---不要企图运行它(相当于油)
   IDEA：一路下一步，装好后一定要保证在电脑桌面上有一个运行的快捷方式(相当于汽车)

5. 下载每日内容：

   doc.canglaoshi.org/tts

## 笔记：

1. Java开发环境：

   - java编译运行过程：

     - 编译期：.java源文件，经过编译，生成.class字节码文件

     - 运行期：JVM加载.class并运行.class(0和1)

       > 特点：跨平台，一次编译到处运行

   - 名词解释：

     - JVM：java虚拟机(Java Virtual Machine)

       ​          加载.class并运行.class

     - JRE：java运行环境(Java Runtime Environment)

       ​         除了包含JVM以外还包含了运行java程序所必须的环境

       ​         JRE = JVM+java系统类库(小零件)

     - JDK：java开发工具包(Java Development Kit)

       ​          除了包含JRE以外还包含了开发java程序所必须的命令工具(java, javac)

       ​          JDK = JRE+编译、运行等命令工具(java, javac)

       > 说明：
       >
       > 1. 运行java程序的最小环境为JRE
       > 2. 开发java程序的最小环境为JDK

2. idea：

   - 是JetBrains公司的，分为社区版(免费的)和终级版(收费的)

   - 开发步骤：

     - 新建Java项目/工程-------------------------小区

     - 新建Java包------------------------------------楼+单元

     - 新建Java类------------------------------------房子

       ```java
       package day01; //声明包day01(楼+单元)
       public class HelloWorld { //声明类HelloWorld(房子)
           //主方法，为程序的入口(大门口)，程序的执行从main开始，main结束则程序结束
           public static void main(String[] args) {
               //输出hello world
               //1)严格区分大小写
               //2)所有符号都必须是英文模式的
               //3)每句话必须以分号结尾
               System.out.println("hello world"); //双引号中的原样输出
               System.out.println("欢迎大家来到达内");
           }
       }
       ```

   - 注释：解释性文本(计算机是不执行的)

     - 单行注释：//
     - 多行注释：/*      */ ------------------------明天讲
     - 文档注释：/**    */ ------------------------面向对象时讲

## 补充：

1. IDE：集成开发环境(Integrated Development Environment)，一整套带图形界面的功能强大的工具，常见的有idea和eclipse

2. Java：以前是Sun公司的，现在Sun已经被Oracle收购了，所以我们说java是Oracle公司的

3. 明日单词：中英文必须对应起来

   ```java
   1)int:整型
   2)long:长整型
   3)double:浮点型
   4)boolean:布尔型
   5)char:字符型
   6)true:真 
   7)false:假
   8)unicode：统一码、通用码、万国码
   9)age:年龄
   10)score:成绩
   11)demo:例子
   12)var:变量
   13)data:数据
   14)type:类型
       
   内存单位换算:
     1G=1024M(兆)
     1M=1024KB(千字节)
     1KB=1024B(字节)
     1B=8bit(位)
   ```