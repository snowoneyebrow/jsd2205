package homework.day03;

import java.io.*;

/**
 * 将当前目录下的所有obj文件获取到，并进行反序列化后输出每个用户的信息(直接输出反序列化后的User对象即可)
 *
 * @author Xiloer
 */

public class Test03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //生成obj文件到硬盘
        User user1 = new User("张三", "123", "张桑", 31);
        User user2 = new User("李四", "456", "李桑", 32);
        User user3 = new User("王五", "789", "王桑", 33);
        user1.initialize();
        user2.initialize();
        user3.initialize();

        String address = "./";
        File dir = new File(address);
        if (dir.isDirectory()) {
            File[] subs = dir.listFiles(f -> f.getName().endsWith(".obj"));

            for (int i = 0; i < subs.length; i++) {
                File sub = subs[i];

                FileInputStream fis = new FileInputStream(address + sub);
                ObjectInputStream ois = new ObjectInputStream(fis);

                Object obj = ois.readObject();
                if (obj instanceof User) {
                    User user = (User) obj; //readObject()返回Object类型，向下造型
                    System.out.println(user);
                }

                fis.close();
            }
        }
    }
}
