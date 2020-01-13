package game.window;

import game.score.GameScoreModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 
 * Disegna la scritta GameOver al termine
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class GameOverView 
{
	// Dimensioni costanti
	private final int DIMFONT1 = (int) (100*GameWindow.scalingFactor);
	private final int DIMFONT2 = (int) (20*GameWindow.scalingFactor);
	private final int DIMX = (int) (350*GameWindow.scalingFactor);
	private final int DIMY = (int) (350*GameWindow.scalingFactor);
	private static String record = new String();

	/**
	 * Setta la variabile record con la variabile passata per parametro
	 * @param left
	 */
	public static void setRecord(String str)
	{
		record = str;
	}

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
		g.drawString("Scores: " + GameScoreModel.getScore(), DIMX+2*DIMFONT2, DIMY+DIMFONT2);
		if (!record.isEmpty())
		{g.drawString("Record - " + record, DIMX+2*DIMFONT2, DIMY+DIMFONT2*2);}
		else
		{g.drawString("Caricamento...", DIMX+2*DIMFONT2, DIMY+DIMFONT2*2);}
	}
}