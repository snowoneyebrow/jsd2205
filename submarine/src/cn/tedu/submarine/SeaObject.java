package cn.tedu.submarine;

import java.io.Serializable;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.Graphics;

public abstract class SeaObject implements Serializable {
    public static final int LIVE = 0;
    public static final int DEAD = 1;
    protected int state = LIVE; //当前状态，默认为活着

    protected int width; //宽 //暂时protected
    protected int height; //高
    protected int x; //x坐标
    protected int y; //y坐标
    protected int speed; //移动速度

    public SeaObject(int width, int height) { //侦察，鱼雷，水雷潜艇
        this.width = width;
        this.height = height;
        x = -width; //负的潜艇的宽，在屏幕左边未出现
        Random rand = new Random();
        y = rand.nextInt(World.HEIGHT - height - 150 + 1) + 150; //海平面高到(窗口高-潜艇高)之间
        speed = rand.nextInt(3) + 1; //1到3
    }

    public SeaObject(int width, int height, int x, int y, int speed) { //战舰，炸弹，水雷
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public abstract void move();

    public abstract ImageIcon getImage();

    public boolean isLive() {
        return state == LIVE;
    }

    public boolean isDead() {
        return state == DEAD;
    }

    public void paintImage(Graphics g) { //g：画笔
        if (this.isLive()) { //this可省略
            this.getImage().paintIcon(null, g, this.x, this.y);
        }
    }

    public boolean isOutOfBounds() { //越界
        return this.x >= World.WIDTH;
    }

    public boolean isHit(SeaObject other) { //检测碰撞
        //假设：this：潜艇，other：炸弹
        int x1 = this.x - other.width;
        int x2 = this.x + this.width;
        int y1 = this.y - other.height;
        int y2 = this.y + this.height;
        int x = other.x;
        int y = other.y;

        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    public void goDead() {
        state = DEAD;
    }

}
