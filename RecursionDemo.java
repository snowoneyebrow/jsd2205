package file;

import java.io.File;

public class RecursionDemo {
    public static long sum = 0;

    public static void main(String[] args) {
        File parent = new File("C:\\Users\\Lin\\Desktop\\jsd2205\\ext-array-sort\\");
        scanAndCount(parent);
        System.out.println(sum+"字节");
    }

    public static void scanAndCount(File parent) {
        File[] dirs = parent.listFiles();
        for (File dir : dirs) {
            if (dir.isDirectory()) {
                scanAndCount(dir); //递归
            }
            if (dir.isFile()) {
                System.out.println(dir.getName() + "," + dir.length());
                sum += dir.length();
            }
        }
    }
}
