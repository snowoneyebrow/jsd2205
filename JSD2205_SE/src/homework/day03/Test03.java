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
