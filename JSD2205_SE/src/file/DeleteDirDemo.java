package file;

import java.io.File;

/**
 * 删除一个目录
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        File dir = new File("./demo");
        if (dir.exists()) {
            //delete在删除目录时要求该目录必须是一个【空目录】
            dir.delete();
            System.out.println("目录已删除");
        } else {
            System.out.println("目录不存在");
        }
    }
}
