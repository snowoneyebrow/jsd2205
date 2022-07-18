package cn.tedu.shoot;

import java.awt.image.BufferedImage;

//大敌机
public class BigAirplane extends FlyingObject implements EnemyScore {
    private int speed;

    public BigAirplane() {
        super(66, 89);
        speed = 2;
    }

    public void step() {
        y += speed; //y+(向下)
    }

    int index = 1; //下标

    //重写getImage()获取图片
    public BufferedImage getImage() { //每10毫秒走一次
        if (isLive()) {
            return Images.bairs[0];
        } else if (isDead()) {
            BufferedImage img = Images.bairs[index++];
            if (index == Images.bairs.length) {
                state = REMOVE;
            }
            return img;
        }
        return null;
    }

    public int getScore() {
        return 3; //打掉大敌机，玩家得3分
    }
}
