package cn.tedu.shoot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Images {
    public static BufferedImage start;    //启动
    public static BufferedImage pause;    //暂停
    public static BufferedImage gameover; //游戏结束
    public static BufferedImage sky;      //天空
    public static BufferedImage bullet;   //子弹
    public static BufferedImage[] heros;  //英雄机数组
    public static BufferedImage[] airs;   //小敌机数组
    public static BufferedImage[] bairs;  //大敌机数组
    public static BufferedImage[] bees;   //小蜜蜂数组

    static { //给图片赋值
        start = readImage("start.png");
        pause = readImage("pause.png");
        gameover = readImage("gameover.png");

        sky = readImage("background.png");
        bullet = readImage("bullet.png");

        heros = new BufferedImage[2]; //2张图片
        heros[0] = readImage("hero0.png");
        heros[1] = readImage("hero1.png");

        airs = new BufferedImage[5]; //5张图片
        bairs = new BufferedImage[5]; //5张图片
        bees = new BufferedImage[5]; //5张图片
        airs[0] = readImage("airplane.png");
        bairs[0] = readImage("bigairplane.png");
        bees[0] = readImage("bee.png");
        for (int i = 1; i < airs.length; i++) { //赋值爆破图
            airs[i] = readImage("bom" + i + ".png");
            bairs[i] = readImage("bom" + i + ".png");
            bees[i] = readImage("bom" + i + ".png");
        }
    }

    //读取图片，fileName：图片名称
    public static BufferedImage readImage(String fileName) {
        try {
            //读取与FlyingObject同包中的图片（小改过，加了前缀路径）
            BufferedImage img = ImageIO.read(FlyingObject.class.getResource("./img/" + fileName));
            return img;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
