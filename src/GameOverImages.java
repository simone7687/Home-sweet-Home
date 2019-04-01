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
public class GameOverImages 
{
	//dimensioni costanti
	private final int DIMFONT = (int) (100*GameWindows.dimension);
	private final int DIMX = (int) (350*GameWindows.dimension);
	private final int DIMY = (int) (350*GameWindows.dimension);
	public void paint(Graphics g)
	{	
		Font FONT = new Font("Helvetica", Font.BOLD, (int) (DIMFONT));
		g.setFont(FONT);
		g.setColor(Color.black);
		g.fillRect(0,0, GameWindows.windowDimension.width,GameWindows.windowDimension.height);
		g.setColor(Color.red);
		g.drawString("Game Over", DIMX,DIMY);
	}
}