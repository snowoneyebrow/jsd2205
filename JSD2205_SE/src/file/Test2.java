package file;

import java.io.File;

/**
 * 向控制台打桩输出file包中所有子项的名字和占用的空间大小
 * 提示:
 * "./src/file"
 * File类的getName()和length()方法
 */
public class Test2 {
    public static void main(String[] args) {
        File dir = new File("./src/file");
        if (dir.isDirectory()) {
            File[] subs = dir.listFiles();
            for (int i = 0; i < subs.length; i++) {
                File sub = subs[i];
                System.out.println(sub.getName() + ":" + sub.length() + "字节");
            }
        }
    }
}
