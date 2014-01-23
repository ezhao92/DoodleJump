import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.Rectangle;

public class GameDriver extends Canvas implements KeyListener, Runnable
{
	
	protected boolean[] keys;
	protected BufferedImage back;	

	
	public GameDriver()
	{
		//set up all variables related to the game
		
		// number of key possibilities
		keys = new boolean[5];
	
		
		    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   
   public void paint(Graphics window)
   {
		// ***START **** copy and paste if planning to override
		Graphics2D twoDGraph = (Graphics2D)window;
        if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		Graphics graphToBack = back.createGraphics();
		graphToBack.setColor(Color.red);
        // *** END **** copy and paste
        
        
        
       
	    //twoDGraph.drawImage(back, null, 0, 0);    
		
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
		
			case 'A' : keys[2]=true; break;
			case 'D' : keys[3]=true; break;
			case 'F' : keys[4]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
		
		
			case 'A' : keys[2]=false; break;
			case 'D' : keys[3]=false; break;
			case 'F' : keys[4]=false; break;
		}
	}


	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(15);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
  	
  
}