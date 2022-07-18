package cn.tedu.submarine;

import javax.swing.ImageIcon;

//战舰类
public class Battleship extends SeaObject {
    private int life; //命

    Battleship() {
        super(66, 26, 270, 124, 20);
        life = 5;
    }

    public void move() {

    }

    public void moveLeft() {
        x -= speed;
        if (x < 0) {
            x = 0;
        }
    }

    public void moveRight() {
        x += speed;
        if (x + width > World.WIDTH) {
            x = World.WIDTH - width;
        }
    }

    public ImageIcon getImage() {
        return Images.battleship;
    }

    public Bomb shootBomb() {
        return new Bomb(this.x + 30, this.y + 20); //炸弹坐标
    }

    public void addLife(int num) {
        life += num;
    }

    public int getLife() {
        return life;
    }

    public void subtractLife() {
        life--;
    }
}
