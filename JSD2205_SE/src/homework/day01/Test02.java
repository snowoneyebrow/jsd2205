package homework.day01;

import java.io.File;
import java.io.FileFilter;

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
