package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

//小蜜蜂
public class Bee extends FlyingObject implements EnemyAward {
    private int xSpeed; //x坐标移动速度
    private int ySpeed; //y坐标移动速度
    private int awardType; //奖励类型

    public Bee() {
        super(60, 51);
        xSpeed = 1;
        ySpeed = 2;
        Random rand = new Random();
        awardType = rand.nextInt(2); //0到1
    }

    public void step() {
        x += xSpeed; //x+(向右或向左)
        y += ySpeed; //y+(向下)
        //蜜蜂左上角顶到最左边，或蜜蜂右上角顶到最右边，即左上角顶到(窗口宽-蜜蜂宽)
        if (x <= 0 || x >= World.WIDTH - width) {
            xSpeed *= -1; //切换左走还是右走
        }
    }

    int index = 1; //下标

    //重写getImage()获取图片
    public BufferedImage getImage() { //每10毫秒走一次
        if (isLive()) {
            return Images.bees[0];
        } else if (isDead()) {
            BufferedImage img = Images.bees[index++];
            if (index == Images.bees.length) {
                state = REMOVE;
            }
            return img;
        }
        return null;
    }

    public int getAwardType() {
        return awardType; //返回奖励类型
    }
}
