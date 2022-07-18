package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./fos.dat");
        while (true) {
            int r = fis.read();
            if (r == -1) {
                break;
            } else {
                System.out.println(r);
            }
        }
        fis.close();
    }
}
