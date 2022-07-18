package cn.tedu.submarine;

import javax.swing.ImageIcon;

//水雷潜艇类
public class MineSubmarine extends SeaObject implements EnemyLife {
    MineSubmarine() {
        super(63, 19);
    }

    public void move() {
        x += speed; //x+（向右）
    }

    public ImageIcon getImage() {
        return Images.minesubm;
    }

    public Mine shootMine() {
        //水雷艇右上角=水雷艇左上角+水雷艇宽
        //水雷左上角=水雷艇高-水雷高(11)
        return new Mine(this.x + this.width, this.y - 11);
    }

    public int getLife() {
        return 1;
    }
}
