package com.webserver.test;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

//字节数组输出流，低级流
//通过这个流写出的数据会保存在其内部的字节数组中
public class BAOSDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(baos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("helloworld");
        pw.close();

        byte[] array = baos.toByteArray();
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));
        /*
        12
        [104, 101, 108, 108, 111, 119, 111, 114, 108, 100, 13, 10]

        a：97，13：/r，10：/n
         */
    }
}
