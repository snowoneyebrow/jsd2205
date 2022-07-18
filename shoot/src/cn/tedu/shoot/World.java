package cn.tedu.shoot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class World extends JPanel {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;

    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int PAUSE = 2;
    public static final int GAME_OVER = 3;
    private int state = START;

    private Sky sky = new Sky();
    private Hero hero = new Hero();
    private FlyingObject[] enemies = {};
    private Bullet[] bullets = {};

    //生成小敌机、大敌机、小蜜蜂
    public FlyingObject nextOne() {
        Random rand = new Random();
        int type = rand.nextInt(20); //0-19
        if (type < 5) { //0-4
            return new Bee();
        } else if (type < 13) { //5-12
            return new Airplane();
        } else { //13-19
            return new BigAirplane();
        }
    }

    private int enterIndex = 0;

    public void enterAction() { //敌人入场
        enterIndex++;
        if (enterIndex % 40 == 0) {
            FlyingObject obj = nextOne();
            enemies = Arrays.copyOf(enemies, enemies.length + 1);
            enemies[enemies.length - 1] = obj;
        }
    }

    private int shootIndex = 0;

    public void shootAction() { //子弹入场
        shootIndex++;
        if (shootIndex % 30 == 0) {
            Bullet[] bs = hero.shoot();
            bullets = Arrays.copyOf(bullets, bullets.length + bs.length);
            System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length);
        }
    }

    public void stepAction() {
        sky.step();
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].step();
        }
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].step();
        }
    }

    public void outOfBoundsAction() {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i].isOutOfBounds()) {
                enemies[i] = enemies[enemies.length - 1];
                enemies = Arrays.copyOf(enemies, enemies.length - 1);
            }
        }
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isOutOfBounds()) {
                bullets[i] = bullets[bullets.length - 1];
                bullets = Arrays.copyOf(bullets, bullets.length - 1);
            }
        }
    }

    private int score = 0;

    public void bulletBangAction() {
        for (int i = 0; i < bullets.length; i++) {
            Bullet b = bullets[i];
            for (int j = 0; j < enemies.length; j++) {
                FlyingObject f = enemies[j];
                if (b.isLive() && f.isLive() && b.isHit(f)) {
                    b.goDead();
                    f.goDead();
                    if (f instanceof EnemyScore) {
                        EnemyScore es = (EnemyScore) f;
                        score += es.getScore();
                    }
                    if (f instanceof EnemyAward) {
                        EnemyAward ea = (EnemyAward) f;
                        int type = ea.getAwardType();
                        switch ((type)) {
                            case EnemyAward.FIRE:
                                hero.addFire();
                                break;
                            case EnemyAward.LIFE:
                                hero.addLife();
                                break;
                        }
                    }
                }
            }
        }
    }

    public void heroBangAction() {
        for (int i = 0; i < enemies.length; i++) {
            FlyingObject f = enemies[i];
            if (f.isLive() && hero.isLive() && f.isHit(hero)) {
                f.goDead();
                hero.subtractLife();
                hero.clearFire();
            }
        }
    }

    public void checkGameOverAction() {
        if (hero.getLife() <= 0) {
            state = GAME_OVER;
        }
    }

    public void action() { //启动程序的执行
        MouseAdapter m = new MouseAdapter() {
            public void mouseMoved(MouseEvent e) { //重写鼠标移动事件
                if (state == RUNNING) {
                    int x = e.getX();
                    int y = e.getY();
                    hero.moveTo(x, y);
                }
            }

            public void mouseClicked(MouseEvent e) { //重写鼠标点击事件
                switch (state) {
                    case START:
                        state = RUNNING;
                        break;
                    case GAME_OVER: //清理现场
                        score = 0;
                        sky = new Sky();
                        hero = new Hero();
                        enemies = new FlyingObject[0]; //0个元素的数组
                        bullets = new Bullet[0];
                        state = START;
                        break;
                }
            }

            public void mouseExited(MouseEvent e) { //重写鼠标移出事件
                if (state == RUNNING) {
                    state = PAUSE;
                }
            }

            public void mouseEntered(MouseEvent e) { //重写鼠标移入事件
                if (state == PAUSE) {
                    state = RUNNING;
                }
            }
        };
        this.addMouseListener(m);
        this.addMouseMotionListener(m);

        Timer timer = new Timer();
        int interval = 10;
        timer.schedule(new TimerTask() {
            public void run() {
                if(state==RUNNING){
                    enterAction(); //敌人入场
                    shootAction(); //子弹入场
                    stepAction(); //飞行物移动
                    outOfBoundsAction(); //删除越界的敌人和子弹
                    bulletBangAction(); //子弹与敌人的碰撞
                    heroBangAction();
                    checkGameOverAction();
                }
                repaint(); //不能放上面的if里面，否则暂停时没图
            }
        }, interval, interval);
    }

    //重写paint()画，g:画笔
    public void paint(Graphics g) {
        g.drawImage(sky.getImage(), sky.x, sky.y, null); //画天空
        g.drawImage(sky.getImage(), sky.x, sky.getY1(), null); //画天空2
        g.drawImage(hero.getImage(), hero.x, hero.y, null); //画英雄机
        for (int i = 0; i < enemies.length; i++) {
            FlyingObject f = enemies[i];
            g.drawImage(f.getImage(), f.x, f.y, null); //画敌人
        }
        for (int i = 0; i < bullets.length; i++) {
            Bullet b = bullets[i];
            g.drawImage(b.getImage(), b.x, b.y, null); //画子弹
        }

        g.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        g.drawString("SCORE: " + score, 10, 30);
        g.drawString("LIFE: " + hero.getLife(), 10, 60);

        switch (state){
            case START:
                g.drawImage(Images.start, 0, 0, null);
                break;
            case PAUSE:
                g.drawImage(Images.pause, 0, 0, null);
                break;
            case GAME_OVER:
                g.drawImage(Images.gameover, 0, 0, null);
                break;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("龙霸天下");
        World world = new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH + 16, HEIGHT + 39);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); //1)设置窗口可见  2)尽快调用paint()方法

        world.action();
    }
}
