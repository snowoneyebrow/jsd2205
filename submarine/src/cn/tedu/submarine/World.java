package cn.tedu.submarine;

import javax.swing.*;
import java.awt.Graphics;
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

//整个游戏窗口
public class World extends JPanel {
    public static final int WIDTH = 641; //宽
    public static final int HEIGHT = 479; //高

    public static final int RUNNING = 0; //运行
    public static final int PAUSE = 1; //暂停
    public static final int GAME_OVER = 2; //游戏结束
    private int state = RUNNING; //当前状态（默认为运行）

    private Battleship ship = new Battleship();
    private SeaObject[] submarines = {};
    private Mine[] mines = {};
    private Bomb[] bombs = {};

    //生成潜艇对象
    public SeaObject nextSubmarine() {
        Random rand = new Random();
        int type = rand.nextInt(20); //0到19，控制概率
        if (type < 10) { //0到9，侦察潜艇
            return new ObserveSubmarine();
        } else if (type < 16) { //10到15，鱼雷潜艇
            return new TorpedoSubmarine();
        } else { //16到19，水雷潜艇
            return new MineSubmarine();
        }
    }

    private int subEnterIndex = 0; //潜艇入场计数

    public void submarineEnterAction() { //侦察艇、鱼雷艇、水雷艇入场，每10毫秒走一次
        subEnterIndex++; //每10毫秒增1
        if (subEnterIndex % 40 == 0) { //400毫秒走一次
            submarines = Arrays.copyOf(submarines, submarines.length + 1);
            submarines[submarines.length - 1] = nextSubmarine();
        }
    }

    private int mineEnterIndex = 0; //水雷入场计数

    public void mineEnterAction() { //水雷入场
        mineEnterIndex++;
        if (mineEnterIndex % 100 == 0) {
            for (int i = 0; i < submarines.length; i++) {
                if (submarines[i] instanceof MineSubmarine) { //只有MineSubmarine才执行
                    MineSubmarine ms = (MineSubmarine) submarines[i];
                    Mine obj = ms.shootMine();
                    mines = Arrays.copyOf(mines, mines.length + 1);
                    mines[mines.length - 1] = obj;
                }
            }
        }
    }

    public void moveAction() { //海洋对象移动
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].move();
        }
        for (int i = 0; i < mines.length; i++) {
            mines[i].move();
        }
        for (int i = 0; i < bombs.length; i++) {
            bombs[i].move();
        }
    }

    public void outOfBoundsAction() {
        for (int i = 0; i < submarines.length; i++) {
            if (submarines[i].isOutOfBounds() || submarines[i].isDead()) { //若越界，或DEAD
                submarines[i] = submarines[submarines.length - 1];
                submarines = Arrays.copyOf(submarines, submarines.length - 1);
            }
        }

        for (int i = 0; i < mines.length; i++) {
            if (mines[i].isOutOfBounds() || mines[i].isDead()) {
                mines[i] = mines[mines.length - 1];
                mines = Arrays.copyOf(mines, mines.length - 1);
            }
        }

        for (int i = 0; i < bombs.length; i++) {
            if (bombs[i].isOutOfBounds() || bombs[i].isDead()) {
                bombs[i] = bombs[bombs.length - 1];
                bombs = Arrays.copyOf(bombs, bombs.length - 1);
            }
        }
    }

    private int score = 0;

    public void bombBangAction() { //每10ms走一次
        for (int i = 0; i < bombs.length; i++) {
            Bomb b = bombs[i];
            for (int j = 0; j < submarines.length; j++) {
                SeaObject s = submarines[j];
                if (b.isLive() && s.isLive() && b.isHit(s)) {
                    b.goDead();
                    s.goDead();
                    if (s instanceof EnemyScore) {
                        EnemyScore es = (EnemyScore) s;
                        score += es.getScore();
                    }
                    if (s instanceof EnemyLife) {
                        EnemyLife el = (EnemyLife) s;
                        int num = el.getLife();
                        ship.addLife(num);
                    }
                }
            }
        }
    }

    public void mineBangAction() {
        for (int i = 0; i < mines.length; i++) {
            Mine m = mines[i];
            if (m.isLive() && ship.isLive() && m.isHit(ship)) {
                m.goDead();
                ship.subtractLife();
            }
        }
    }

    public void checkGameOverAction() {
        if (ship.getLife() <= 0) {
            state = GAME_OVER;
        }
    }

    public void action() { //启动程序的执行
        KeyAdapter k = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    if (state == GAME_OVER) {
                        score = 0;
                        ship = new Battleship();
                        submarines = new SeaObject[0];
                        mines = new Mine[0];
                        bombs = new Bomb[0];
                        state = RUNNING;
                    }
                }

                /*
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    if (state == RUNNING) {
                        state = PAUSE;
                    } else if (state == PAUSE) {
                        state = RUNNING;
                    }
                }
                 */

                if (e.getKeyCode() == KeyEvent.VK_P) {
                    state = PAUSE;
                    int r = JOptionPane.showConfirmDialog(World.this, "保存游戏吗？");
                    if (r == JOptionPane.YES_OPTION) {
                        SaveInfo saveInfo = new SaveInfo(ship, submarines, mines, bombs, subEnterIndex, mineEnterIndex, score);
                        try {
                            FileOutputStream fos = new FileOutputStream("./save.obj");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(saveInfo);
                            oos.close();
                        } catch (IOException ex) {

                        }
                    }
                    state = RUNNING;
                }

                if (state == RUNNING) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        Bomb obj = ship.shootBomb();
                        bombs = Arrays.copyOf(bombs, bombs.length + 1);
                        bombs[bombs.length - 1] = obj;
                        //System.out.println(111);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        ship.moveLeft();
                        //System.out.println(222);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        ship.moveRight();
                        //System.out.println(333);
                    }
                }
            }
        };
        this.addKeyListener(k);

        Timer timer = new Timer(); //定时器对象
        int interval = 10; //定时间隔：10毫秒

        //定时计划表
        //第1个10：从程序启动到第1次触发的时间间隔
        //第2个10：从第1次触发到第2次触发的时间间隔...（2到3，3到4...）
        timer.schedule(new TimerTask() {
            @Override
            public void run() { //定时干的事（每10毫秒自动执行，不用手动调用run()）
                if (state == RUNNING) {
                    submarineEnterAction(); //侦察艇、鱼雷艇、水雷艇入场
                    mineEnterAction(); //水雷入场
                    moveAction();
                    outOfBoundsAction();
                    //System.out.println(submarines.length + "," + mines.length + "," + bombs.length);
                    bombBangAction();
                    mineBangAction();
                    checkGameOverAction();
                    repaint(); //重画，重新调用paint()
                }
            }
        }, interval, interval); //参数类型：TimerTask，long，long
    }

    public void paint(Graphics g) { //每10毫秒走一次
        Images.sea.paintIcon(null, g, 0, 0); //画海洋图
        ship.paintImage(g);
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].paintImage(g);
        }
        for (int i = 0; i < mines.length; i++) {
            mines[i].paintImage(g);
        }
        for (int i = 0; i < bombs.length; i++) {
            bombs[i].paintImage(g);
        }
        g.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        g.drawString("SCORE: " + score, 150, 50); //坐标
        g.drawString("LIFE: " + ship.getLife(), 350, 50);
        if (state == GAME_OVER) {
            Images.gameover.paintIcon(null, g, 0, 0);
        }
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("龙霸天下");
        World world = new World(); //将World类的实例变量赋值
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH + 16, HEIGHT + 39);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); //此处默认调用paint方法，java默认给的paint方法是空的，所以要重写

        File file = new File("./save.obj");
        if (file.exists()) {
            int r = JOptionPane.showConfirmDialog(world, "是否读取存档？");
            if (r == JOptionPane.YES_OPTION) {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    SaveInfo saveInfo = (SaveInfo) ois.readObject();

                    world.ship = saveInfo.getShip();
                    world.submarines = saveInfo.getSubmarines();
                    world.mines = saveInfo.getMines();
                    world.bombs = saveInfo.getBombs();
                    world.subEnterIndex = saveInfo.getSubEnterIndex();
                    world.mineEnterIndex = saveInfo.getMineEnterIndex();
                    world.score = saveInfo.getScore();

                    ois.close();
                } catch (Exception e) {

                }
            }
        }

        world.action();
    }
}
