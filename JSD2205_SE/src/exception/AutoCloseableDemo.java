package exception;

import java.io.FileOutputStream;
import java.io.IOException;

public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (
                FileOutputStream fos = new FileOutputStream("fos.dat");
        ) {
            int a = 123;
            fos.write(a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
