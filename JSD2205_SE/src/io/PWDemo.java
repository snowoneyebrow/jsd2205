package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw = new PrintWriter("./pw.txt", String.valueOf(StandardCharsets.UTF_8));
        //PrintWriter pw1 = new PrintWriter("./pw.txt", "UTF_8");
        pw.println("test123");
        pw.println("371vdsvc");
        System.out.println("写出完毕");
        pw.close();
    }
}
