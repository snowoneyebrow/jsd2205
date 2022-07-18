package cn.tedu.shooter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShootGame extends JPanel{
	public static final int WIDTH=480;
	public static final int HEIGHT=852;
	
	private FlyingObject[] flyings = {}; //存所有敌人（敌机、蜜蜂）
	private Bullet[] bullets = {};
	private Hero hero = new Hero();
	
	public static BufferedImage airplane;
	public static BufferedImage background;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage gameover;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage pause;
	public static BufferedImage start;
	
	static { //静态图片
		try {
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public void action() { //启动执行代码
		Timer timer = new Timer();
		timer.schedule(new TimerTask() { //匿名内部类
			public void run() {
				
			}
		},10,10);
	}
	
	public abstract class Aoo{ //抽象类可以没有抽象方法
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(background,0,0,null);
		g.drawImage(hero0,200,600,null);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("龙霸天下"); //参数：窗口名字
		ShootGame game = new ShootGame(); //创建面板对象
		frame.add(game); //面板放在窗口上面
		frame.setSize(WIDTH, HEIGHT); //窗口大小
		frame.setAlwaysOnTop(true); //窗口置顶
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //窗口关闭
		frame.setLocationRelativeTo(null); //位置
		frame.setVisible(true); //尽快调用paint方法
		game.action(); //启动
	}
}
