package cn.tedu.submarine;

import javax.swing.ImageIcon;

//侦察潜艇类
public class ObserveSubmarine extends SeaObject implements EnemyScore {
    ObserveSubmarine() {
        super(63, 19);
    }

    public void move() {
        x += speed; //x+（向右）
    }

    public ImageIcon getImage() {
        return Images.obsersubm;
    }

    public int getScore() {
        return 10;
    }
}
