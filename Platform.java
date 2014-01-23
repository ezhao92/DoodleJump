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

public class Platform{
	int height, width, xPos, yPos, speed, xSpeed;
	Color color;
	Rectangle r1;
	BufferedImage img;
	BufferedImage img2;
	BufferedImage imgCurrent;
	public Platform(int h, int w, int x, int y, int s, int xS,  BufferedImage image, BufferedImage image2){
		xPos = x;
		yPos = y;
		speed = s;
		xSpeed = xS;
		img = image;
		img2 = image2;
		height = img.getHeight();
		width = img.getWidth();
		r1 = new Rectangle(xPos, yPos, width, height);
	}
	public void moveAndDraw(Graphics2D window, int yS){

		if(yS < 0){
			yPos += Math.abs(yS);
		}
		if(xPos > (800-width)){
			xSpeed = -xSpeed;
		}
		if(xPos < (0)){
			xSpeed = -xSpeed;
		}
			xPos += xSpeed;

		if(xSpeed!=0){
			imgCurrent = img2;
		}else imgCurrent = img;

		r1.setLocation(xPos, yPos);
		window.setColor(color);
		window.drawImage(imgCurrent,xPos, yPos, null);
	}

	public Rectangle getRec() {
		return r1;
	}

	public int getHeight() {
		return height;
	}

	public int getYPos(){
		return yPos;
	}
	public int getXSpeed(){
		return xSpeed;
	}
}