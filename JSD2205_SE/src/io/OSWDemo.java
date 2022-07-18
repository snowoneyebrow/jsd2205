package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class OSWDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("osw.txt");
        OutputStreamWriter osw=new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        String line="eferwfwedqw";
        osw.write(line);
        osw.write("\r\n");
        osw.write("123423567658");
        System.out.println("写出完毕");

        osw.close(); //must
    }
}
