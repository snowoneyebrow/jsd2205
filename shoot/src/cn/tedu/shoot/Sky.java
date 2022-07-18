package cn.tedu.shoot;

import java.awt.image.BufferedImage;

//天空
public class Sky extends FlyingObject {
    private int speed;
    private int y1; //第2张图片的y坐标

    public Sky() {
        super(World.WIDTH, World.HEIGHT, 0, 0);
        speed = 1;
        y1 = -World.HEIGHT;
    }

    public void step() {
        y += speed; //y+(向下)
        y1 += speed; //y1+(向下)
        //天空的左上角移动到最下面时，整张图片移动到y轴上面看不到的地方
        if (y >= World.HEIGHT) {
            y = -World.HEIGHT;
        }
        //同上
        if (y1 >= World.HEIGHT) {
            y1 = -World.HEIGHT;
        }
    }

    //重写getImage()获取图片
    public BufferedImage getImage() { //每10毫秒走一次
        return Images.sky;
    }

    public int getY1() {
        return y1;
    }
}
