package com.webserver.controller;

import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;
import qrcode.QRCodeUtil;

import java.io.OutputStream;

public class ToolsController {
    public void createQR(HttpServletRequest request, HttpServletResponse response){
        String content=request.getParameter("content");
        response.setContentType("image/jpg");
        OutputStream out=response.getOutputStream();
        try {
            QRCodeUtil.encode(content, "./logo.jpg", out, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        //String line = "https://www.52pojie.cn/";
        //QRCodeUtil.encode(line, "./qr.jpg");
        //QRCodeUtil.encode(line,"./logo.jpg","./qr.jpg",true);
        //OutputStream out = new FileOutputStream("./qr.jpg");
        //QRCodeUtil.encode(line, "./logo.jpg", out, true);
    }
}
