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
	
	private FlyingObject[] flyings = {}; //�����е��ˣ��л����۷䣩
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
	
	static { //��̬ͼƬ
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
		
	public void action() { //����ִ�д���
		Timer timer = new Timer();
		timer.schedule(new TimerTask() { //�����ڲ���
			public void run() {
				
			}
		},10,10);
	}
	
	public abstract class Aoo{ //���������û�г��󷽷�
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(background,0,0,null);
		g.drawImage(hero0,200,600,null);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("��������"); //��������������
		ShootGame game = new ShootGame(); //����������
		frame.add(game); //�����ڴ�������
		frame.setSize(WIDTH, HEIGHT); //���ڴ�С
		frame.setAlwaysOnTop(true); //�����ö�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���ڹر�
		frame.setLocationRelativeTo(null); //λ��
		frame.setVisible(true); //�������paint����
		game.action(); //����
	}
}
