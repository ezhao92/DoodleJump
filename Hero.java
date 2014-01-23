import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Hero{
	int height, width, xPos, yPos, speed;
	double ySpeed;
	Color color;
	Rectangle r1;
	boolean endGame;
	int score = 0;
	BufferedImage imgL;
	BufferedImage imgR;
	BufferedImage imgCurrent;
	Hero(int h, int w, int x, int y, int s, BufferedImage imageL, BufferedImage imageR){
		xPos = x;
		yPos = y;
		speed = s;
		imgL = imageL;
		imgR = imageR;
		height = imgL.getHeight();
		width = imgL.getWidth();
		imgCurrent = imgR;
		r1 = new Rectangle(xPos, yPos, width, height);
	}

	public void moveAndDraw(Graphics2D window, boolean[] dir, ArrayList<Platform> p) {

	    boolean onPlatform = false;
	    
	    for(int i = 0; i < p.size(); i++) {
	    	Rectangle r2 = p.get(i).getRec();
				if (r1.intersects(r2) && ySpeed > 0) {
						onPlatform = true;
						score = score + 100;
				}
		 }

		do{
	    	if(!onPlatform) {
	    	ySpeed += 0.5;
	   	 } else {
	    	ySpeed = -15;
	   	 }

	   	yPos += ySpeed+5;

	    if(xPos<0){
	    	xPos = 799;
	    }else if(xPos>800){
	    	xPos = 1;
	    }
	   

	    if(yPos>=600){
	    	endGame = true;
	    	System.exit(0);
	    }

		if(dir[2]){
			xPos -= 2*speed;
			imgCurrent = imgL;
			
		}
		if(dir[3]){
			xPos += 2*speed;
			imgCurrent = imgR;
		}

		r1.setLocation(xPos, yPos);
		window.setColor(color);
		window.drawImage(imgCurrent, xPos, yPos, null);
		}while(endGame = false);
	}

	public int getXPos(){
		return xPos;
	}
	public int getYPos(){
		return yPos;
	}
	public Rectangle getRec(){
		return r1;
	}
	public int getSpeed(){
		return speed;
	}
	public int getYSpeed(){
		return (int)ySpeed;
	}
	public String getScore(){
		return "" +score;
	}



}