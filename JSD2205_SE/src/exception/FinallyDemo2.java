package exception;

import java.io.FileOutputStream;
import java.io.IOException;

//异常处理机制在IO中的实际应用
public class FinallyDemo2 {
    public static void main(String[] args) {
        FileOutputStream fos = null; //局部变量使用前必须初始化
        try {
            fos = new FileOutputStream("fos.dat");
            //这里可能路径不对，new不成功，所以上面必须初始化为null
            fos.write(1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
