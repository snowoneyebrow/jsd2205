package cn.tedu.submarine;

import java.io.Serializable;

//存档
public class SaveInfo implements Serializable {
    public static final long serialVersionUID = 42L;

    private Battleship ship = new Battleship();
    private SeaObject[] submarines = {};
    private Mine[] mines = {};
    private Bomb[] bombs = {};

    private int subEnterIndex = 0; //潜艇入场计数
    private int mineEnterIndex = 0; //水雷入场计数
    private int score = 0;

    public SaveInfo(Battleship ship, SeaObject[] submarines, Mine[] mines, Bomb[] bombs, int subEnterIndex, int mineEnterIndex, int score) {
        this.ship = ship;
        this.submarines = submarines;
        this.mines = mines;
        this.bombs = bombs;
        this.subEnterIndex = subEnterIndex;
        this.mineEnterIndex = mineEnterIndex;
        this.score = score;
    }

    public Battleship getShip() {
        return ship;
    }

    public void setShip(Battleship ship) {
        this.ship = ship;
    }

    public SeaObject[] getSubmarines() {
        return submarines;
    }

    public void setSubmarines(SeaObject[] submarines) {
        this.submarines = submarines;
    }

    public Mine[] getMines() {
        return mines;
    }

    public void setMines(Mine[] mines) {
        this.mines = mines;
    }

    public Bomb[] getBombs() {
        return bombs;
    }

    public void setBombs(Bomb[] bombs) {
        this.bombs = bombs;
    }

    public int getSubEnterIndex() {
        return subEnterIndex;
    }

    public void setSubEnterIndex(int subEnterIndex) {
        this.subEnterIndex = subEnterIndex;
    }

    public int getMineEnterIndex() {
        return mineEnterIndex;
    }

    public void setMineEnterIndex(int mineEnterIndex) {
        this.mineEnterIndex = mineEnterIndex;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
