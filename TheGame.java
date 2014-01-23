import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Component;

public class TheGame extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;



	public TheGame()
	{
		super("Doodle Jump");
		setSize(WIDTH,HEIGHT);

		DoodleJump game = new DoodleJump();
		((Component)game).setFocusable(true);
		getContentPane().add(game);
		setVisible(true);
	}



	public static void main( String args[] )
	{
		TheGame run = new TheGame();
	}
}