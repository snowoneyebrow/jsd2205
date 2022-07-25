# day01-Test01
```java
package homework.day01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//程序启动后，要求用户输入一个文件名，如果文件存在则提示并要求用户更换，
//直到该文件还不存在为止，然后将这个文件在当前目录中创建出来。
public class Test01 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个文件名：");
            String name = scan.nextLine();
            File file = new File("./" + name);
            if (file.exists()) {
                System.out.println("该文件名已存在，请更换！");
            } else {
                file.createNewFile();
                System.out.println(file.getName() + "创建成功！");
                break;
            }
        }
    }
}
```

# day01-Test02
```java
package homework.day01;

import java.io.File;
import java.io.FileFilter;

//列出当前目录中所有名字包含s的子项
//使用匿名内部类和lambda两种写法
public class Test02 {
    public static void main(String[] args) {
        File dir = new File("./");
        if (dir.isDirectory()) {
            File[] subs = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().contains("s");
                }
            });
            for (int i = 0; i < subs.length; i++) {
                System.out.println(subs[i].getName());
            }
        }

        File dir1 = new File("./");
        if (dir1.isDirectory()) {
            File[] subs1 = dir1.listFiles(f -> f.getName().contains("s"));
            for (int i = 0; i < subs1.length; i++) {
                System.out.println(subs1[i].getName());
            }
        }
    }
}
```

# day02-Test01
```java
package homework.day02;

import java.io.File;
import java.util.Scanner;

//程序启动后要求用户输入一个关键字，然后列出当前项目下所有名字中包含该关键字的子项
public class Test01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入关键字：");
        String key = s.nextLine();
        File dir = new File("./src/io/"); //定位当前目录
        if (dir.isDirectory()) { //判断是否为目录
            File files[] = dir.listFiles(); //获取该目录下所有子项
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName(); //获取每一个子项的名字
                if (fileName.contains(key)) { //判断名字中是否包含key的内容
                    System.out.println(fileName); //包含就输出这个名字
                }
            }
        }
    }
}
```

# day02-Test02
```java
package homework.day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//复制一个文件
public class Test02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./test.txt");
        FileOutputStream fos = new FileOutputStream("./test_cp.txt");

        int d;
        while ((d = fis.read()) != -1) {
            fos.write(d);
        }
        System.out.println("复制完毕!");

        fis.close();
        fos.close();
    }
}
```

# day02-Test03
```java
package homework.day02;

import java.io.*;

//将当前目录下的所有文件都复制一份，复制的文件命名为：原文件名_cp.后缀
public class Test03 {
    public static void main(String[] args) throws IOException {
        String address = "./src/io/";
        File dir = new File(address);
        if (dir.isDirectory()) {
            File[] subs = dir.listFiles(f -> f.isFile());
            for (int i = 0; i < subs.length; i++) {
                String name = subs[i].getName();
                int index = name.lastIndexOf(".");
                String addressCopy = address + "temp/";
                new File(addressCopy).mkdir();
                String nameCopy = addressCopy + name.substring(0, index) + "_cp" + name.substring(index);

                FileInputStream fis = new FileInputStream(address + name);
                FileOutputStream fos = new FileOutputStream(nameCopy);

                int d;
                byte[] data = new byte[1024 * 10]; //10kb
                while ((d = fis.read(data)) != -1) {
                    //一次性至少读data数组长度的字节进来（10k），返回值（d）为实际读了多少个字节
                    fos.write(data, 0, d);
                }

                fis.close();
                fos.close();
            }
        }
    }
}
```

# day03-Test01
```java
package homework.day03;

import java.io.*;

//使用缓冲流完成文件的复制操作
public class Test01 {
    public static void main(String[] args) throws IOException {
        /*
        try后面加括号，自动关闭流：

        原写法：
        try {
            FileInputStream fis = new FileInputStream(file);
            int a = 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        java7后的新写法：
        try (
                FileInputStream fis = new FileInputStream(file);
        ) {
            int a = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
         */

        try (
                FileInputStream fis = new FileInputStream("test.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream("test_cp.txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            int d;
            while ((d = bis.read()) != -1) {
                bos.write(d);
            }
            System.out.println("复制完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

# day03-User
```java
package homework.day03;

import java.io.Serializable;

public class User implements Serializable {
    public static final long serialVersionUID = 42L;

    private String name; //用户名
    private String pwd; //密码
    private String nick; //昵称
    private int age; //年龄

    public User(String name, String pwd, String nick, int age) {
        this.name = name;
        this.pwd = pwd;
        this.nick = nick;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nick='" + nick + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

# day03-Test02
```java
package homework.day03;

import java.io.*;
import java.util.Scanner;

//设计一个类：User，当前程序启动后要求用户顺序输入User的四个信息
//然后实例化一个User对象保存这四个信息并将该对象序列化到文件中
//文件名的命名规则：用户名.obj
public class Test02 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String pwd = scanner.nextLine();
        System.out.println("请输入昵称：");
        String nick = scanner.nextLine();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();

        User user = new User(name, pwd, nick, age);

        try (
                FileOutputStream fos = new FileOutputStream("./" + name + ".obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(user);
            System.out.println("写出完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

# day03-Test03
```java
package homework.day03;

import java.io.*;

//将当前目录下的所有obj文件获取到，并进行反序列化后输出每个用户的信息（直接输出反序列化后的User对象即可）
public class Test03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String address = "./";
        File dir = new File(address);
        if (dir.isDirectory()) {
            File[] subs = dir.listFiles(f -> f.getName().endsWith(".obj"));
            for (int i = 0; i < subs.length; i++) {
                try (
                        FileInputStream fis = new FileInputStream(address + subs[i]);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                ) {
                    Object obj = ois.readObject();
                    if (obj instanceof User) {
                        User user = (User) obj; //readObject()返回Object类型，向下造型
                        System.out.println(user);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

# day08-Test01
```java
package homework.day08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//向一个List集合中添加10个数字1-10，并将它们遍历出来并输出到控制台。
public class Test01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int i = it.next();
            System.out.println(i);
        }
    }
}
```

# day08-Test02
```java
package homework.day08;

import java.util.ArrayList;
import java.util.Collection;

public class Test02 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        for (String s : c) {
            System.out.println(s);
        }
    }
}
```

# day08-Test03
```java
package homework.day08;

import java.util.ArrayList;
import java.util.Random;

//生成10个0-100之间的不重复的随机数，并输出
public class Test03 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(101); //0到100，含头不含尾
            if (array.contains(r)) {
                i--;
            } else {
                array.add(r);
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
```

# day08-Test04
```java
package homework.day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//将整数1-100存入一个List集合中并输出，之后将集合中40-60的元素翻转后并输出
public class Test04 {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            array.add(i);
        }
        System.out.println(Arrays.toString(array.toArray()));
        Collections.reverse(array.subList(39, 60));
        //下标0对应1，下标39对应40，下标59对应60，含头不含尾
        System.out.println(Arrays.toString(array.toArray()));
    }
}
```
