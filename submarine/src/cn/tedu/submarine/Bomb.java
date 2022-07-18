package cn.tedu.submarine;

import javax.swing.ImageIcon;

//炸弹类
public class Bomb extends SeaObject {
    Bomb(int x, int y) {
        super(9, 12, x, y, 3);
    }

    public void move() {
        y += speed; //y+（向下）
    }

    public ImageIcon getImage() {
        return Images.bomb;
    }

    public boolean isOutOfBounds() { //越界
        return this.y >= World.HEIGHT;
    }
}
