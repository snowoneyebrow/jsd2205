package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/io/ISRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);

        int d;
        while ((d = isr.read()) != -1) {
            System.out.print((char) d);
        }

        isr.close();
    }
}
