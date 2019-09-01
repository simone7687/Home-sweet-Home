import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 
 * La classe GameOverImages ha la funzione di:
 * disegnare la scritta GameOver.
 * @author 20024652
 * @version 1.0
 *
 */
public class GameOverView 
{
	// dimensioni costanti
	private final int DIMFONT1 = (int) (100*GameWindow.scalingFactor);
	private final int DIMFONT2 = (int) (20*GameWindow.scalingFactor);
	private final int DIMX = (int) (350*GameWindow.scalingFactor);
	private final int DIMY = (int) (350*GameWindow.scalingFactor);
	public void paint(Graphics g)
	{	
		Font FONT1 = new Font("Helvetica", Font.BOLD, (int) (DIMFONT1));
		Font FONT2 = new Font("Helvetica", Font.BOLD, (int) (DIMFONT2));
		
		g.setFont(FONT1);
		g.setColor(Color.black);
		g.fillRect(0,0, GameWindow.windowDimension.width,GameWindow.windowDimension.height);
		g.setColor(Color.red);
		g.drawString("Game Over", DIMX, DIMY-DIMFONT2);
		
		g.setFont(FONT2);
		g.drawString("Scores: " + GameScore.score , DIMX+2*DIMFONT2, DIMY+DIMFONT2);
	}
}