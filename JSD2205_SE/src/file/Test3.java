package file;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取file包中大小超过1000字节的所有子项
 * 输出这些子项的名字和实际占用的字节数
 */
public class Test3 {
    public static void main(String[] args) {
        File dir = new File("./src/file");
        if (dir.isDirectory()) {
            File[] subs = dir.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return file.length() > 1000;
                }
            });
            for (int i = 0; i < subs.length; i++) {
                File sub = subs[i];
                System.out.println(sub.getName() + ":" + sub.length() + "字节");
            }
        }
    }
}
