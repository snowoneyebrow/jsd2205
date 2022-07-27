package exception;

import java.io.FileOutputStream;
import java.io.IOException;

//JDK7时，java推出了一个新的特性：Autocloseable，自动关闭特性。旨在解决异常处理机制中繁琐的关闭流操作。
public class AutoCloseableDemo {
    public static void main(String[] args) {
        /*
        新语法特性要求我们将需要在finally中调用close()方法关闭的那些对象在try的()中定义并初始化即可。
        编译器在编译时会自动补充finally并调用close()方法关闭它们，还原后的代码可参考FinallyDemo2。
        try的()中只能定义并初始化那些实现了Autocloseable接口的类。所有的流都实现了该接口。
         */
        try (
                FileOutputStream fos = new FileOutputStream("fos.dat");
        ) {
            fos.write(123);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
