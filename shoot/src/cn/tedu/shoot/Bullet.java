package cn.tedu.shoot;

import java.awt.image.BufferedImage;

//子弹
public class Bullet extends FlyingObject {
    private int speed;

    public Bullet(int x, int y) { //子弹可以有多个，子弹的初始坐标依赖于当前英雄机的坐标
        super(8, 20, x, y);
        speed = 3;
    }

    public void step() {
        y -= speed; //y-(向上)
    }

    //重写getImage()获取图片
    public BufferedImage getImage() { //每10毫秒走一次
        if (isLive()) {
            return Images.bullet;
        } else if (isDead()) {
            state = REMOVE; //REMOVE：删除的
        }
        return null; //死了的和删除的，都不返回图片
        /*
        执行过程:
        1)若活着的，返回bullet图片
        2)若死了的，将当前状态修改为REMOVE删除的，同时不返回图片
        3)若删除的，不返回图片
         */
    }

    public boolean isOutOfBounds() { //判断子弹是否越界
        return y <= -height; //子弹的y<=负的子弹的高
    }
}
