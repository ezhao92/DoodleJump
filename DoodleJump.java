import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class DoodleJump extends GameDriver{
	Hero h;
	ArrayList<Platform> p;
	BufferedImage background;
	BufferedImage paddle1;
	BufferedImage paddle2;
	BufferedImage manLeft;
	BufferedImage manRight;
	Random rnd = new Random();
	int timer = 0;
	boolean isMoving = false;


	public int rndBit() {
		if(rnd.nextInt(2)==0) {
			return 1;
		} else {
			return -1;
		}
	}

	public DoodleJump(){
		p = new ArrayList<Platform>();

		try{
			paddle1 = ImageIO.read(new File("bar.png"));
			paddle2 = ImageIO.read(new File("bar2.png"));
			manLeft = ImageIO.read(new File("Doodle1Left.png"));
			manRight = ImageIO.read(new File("Doodle1.png"));
			background = ImageIO.read(new File("background.png"));
			} catch (IOException e) {System.out.println(e);}


		h = new Hero(50, 50, 100, 100, 8, manLeft, manRight );
		for(int i = 0;i<9; i++) {
			p.add(new Platform(10,200,rnd.nextInt(600),70*i,5,rndBit()* rnd.nextInt(3), paddle1, paddle2));

		}

	}

	public void paint(Graphics window){
		Graphics2D twoDGraph = (Graphics2D)window;
		if(back == null)
			back = (BufferedImage)(createImage(getWidth(),getHeight()));
		Graphics graphToBack = back.createGraphics();
		graphToBack.setColor(Color.red);

		Graphics2D win = (Graphics2D) graphToBack;
		win.setColor(Color.WHITE);
		win.fill(new Rectangle(0, 0, 800, 600));
		this.drawBG(win);

		this.platformMoveAndDraw(win);
		h.moveAndDraw(win, keys, p);
		win.setColor(Color.BLACK);
		win.drawString(h.getScore(),50,50);
		twoDGraph.drawImage(back, null, 0, 0);

	}

	public void platformMoveAndDraw(Graphics2D window){
		timer++;

		if(timer>30+rnd.nextInt(10)){

			p.add(new Platform(10,200,rnd.nextInt(600),0,5,rndBit()* rnd.nextInt(3), paddle1, paddle2));
			timer = 0;
		}
		for(int i = 0; i < p.size(); i++) {
			p.get(i).moveAndDraw(window, (int)h.getYSpeed());

		}
	}
	public void drawBG(Graphics2D window) {
		window.drawImage(background, 0, 0, null);
		window.drawImage(background, 0, 0, null);
	}
}