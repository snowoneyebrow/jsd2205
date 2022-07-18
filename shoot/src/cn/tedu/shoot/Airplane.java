package cn.tedu.shoot;

import java.awt.image.BufferedImage;

//小敌机
public class Airplane extends FlyingObject implements EnemyScore {
    private int speed;

    public Airplane() {
        super(48, 50);
        speed = 2;
    }

    public void step() {
        y += speed; //y+(向下)
    }

    int index = 1; //下标

    //重写getImage()获取图片
    public BufferedImage getImage() { //每10毫秒走一次
        if (isLive()) {
            return Images.airs[0];
        } else if (isDead()) {
            BufferedImage img = Images.airs[index++]; //获取爆破图
            if (index == Images.airs.length) { //若index为5，则表示到最后一张爆破图了
                state = REMOVE; //将当前状态修改为REMOVE删除的
            }
            return img;
            /*
            执行过程:
                              index=1
            10M  img=airs[1]  index=2          返回airs[1]
            20M  img=airs[2]  index=3          返回airs[2]
            30M  img=airs[3]  index=4          返回airs[3]
            40M  img=airs[4]  index=5(REMOVE)  返回airs[4]
            50M  不返回图片
            */
        }
        return null; //REMOVE状态时，不返回图片
    }

    public int getScore() {
        return 1; //打掉小敌机，玩家得1分
    }
}
