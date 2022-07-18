package cn.tedu.submarine;

import javax.swing.ImageIcon;

//水雷类
public class Mine extends SeaObject {
    Mine(int x, int y) {
        super(11, 11, x, y, 1);
    }

    public void move() {
        y -= speed; //y-（向上）
    }

    public ImageIcon getImage() {
        return Images.mine;
    }

    public boolean isOutOfBounds() { //越界
        return this.y <= 150 - this.height;
    }
}
