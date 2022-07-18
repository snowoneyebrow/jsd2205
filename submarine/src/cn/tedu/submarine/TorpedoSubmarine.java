package cn.tedu.submarine;

import javax.swing.ImageIcon;

//鱼雷潜艇类
public class TorpedoSubmarine extends SeaObject implements EnemyScore {
    TorpedoSubmarine() {
        super(64, 20);
    }

    public void move() {
        x += speed; //x+（向右）
    }

    public ImageIcon getImage() {
        return Images.torpesubm;
    }

    public int getScore() {
        return 40;
    }
}
