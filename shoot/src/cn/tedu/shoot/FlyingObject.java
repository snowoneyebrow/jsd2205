package cn.tedu.shoot;

import java.util.Random;
import java.awt.image.BufferedImage;

public abstract class FlyingObject {
    public static final int LIVE = 0;
    public static final int DEAD = 1;
    public static final int REMOVE = 2; //删除的
    protected int state = LIVE;

    protected int width;
    protected int height;
    protected int x;
    protected int y;

    public FlyingObject(int width, int height) { //小敌机、大敌机、小蜜蜂
        this.width = width;
        this.height = height;
        Random rand = new Random();
        x = rand.nextInt(World.WIDTH - width + 1); //0到(窗口宽-小敌机、大敌机、小蜜蜂宽)之间
        y = -height; //负的小敌机、大敌机、小蜜蜂的高
    }

    public FlyingObject(int width, int height, int x, int y) { //英雄机、天空、子弹
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public abstract void step(); //移动

    public abstract BufferedImage getImage(); //获取对象的图片

    public boolean isLive() {
        return state == LIVE;
    }

    public boolean isDead() {
        return state == DEAD;
    }

    public boolean isRemove() {
        return state == REMOVE;
    }

    public boolean isOutOfBounds() { //判断敌人是否越界
        return y >= World.HEIGHT;
    }

    public boolean isHit(FlyingObject other) { //检测碰撞
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
