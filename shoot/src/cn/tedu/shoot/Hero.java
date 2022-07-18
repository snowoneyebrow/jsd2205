package cn.tedu.shoot;

import java.awt.image.BufferedImage;

//英雄机
public class Hero extends FlyingObject {
    private int life;
    private int fire;

    public Hero() {
        super(97, 139, 140, 400);
        life = 3;
        fire = 0;
    }

    public void step() {
        //暂时搁置
    }

    int index = 0; //下标

    //重写getImage()获取图片
    public BufferedImage getImage() { //每10毫秒走一次
        return Images.heros[index++ % Images.heros.length]; //heros[0]和heros[1]来回切换
        /* 执行过程:
                          index=0
        10M  返回heros[0]  index=1
        20M  返回heros[1]  index=2
        30M  返回heros[0]  index=3
        40M  返回heros[1]  index=4
        50M  返回heros[0]  index=5
         */
    }

    public Bullet[] shoot() { //英雄机发射子弹（生成子弹对象）
        int xStep = width / 4;
        int yStep = 20; //固定20

        if (fire > 0) { //双倍子弹
            Bullet[] bs = new Bullet[2]; //2发子弹
            bs[0] = new Bullet(x + xStep, y - yStep);
            bs[1] = new Bullet(x + 3 * xStep, y - yStep);
            fire -= 2; //发射一次双倍火力，火力值减2
            return bs;
        } else { //单倍子弹
            Bullet[] bs = new Bullet[1]; //1发子弹
            bs[0] = new Bullet(x + 2 * xStep, y - yStep);
            //x：英雄机中间
            //y：y-20（固定）
            return bs;
        }
    }

    public void moveTo(int x, int y) { //传参：鼠标的xy坐标
        this.x = x - this.width / 2;
        this.y = y - this.height / 2;
        //英雄机的中心移动到鼠标的位置
    }

    public void addLife() {
        life++;
    }

    public void subtractLife() {
        life--;
    }

    public int getLife() {
        return life;
    }

    public void addFire() {
        fire += 40;
    }

    public void clearFire() {
        fire = 0;
    }
}
