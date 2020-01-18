package game.pause;

import game.player.PlayerController;
import game.window.GameWindow;

import java.awt.*;

/**
 * Disegna il bottone di pausa e di restart.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class GamePauseView 
{
	protected Dimension bottonPauseSize = new Dimension((int) (50 * GameWindow.scalingFactor), (int) (25 * GameWindow.scalingFactor));
	protected Point bottonPauseCoordinates = new Point((int) (10 * GameWindow.scalingFactor), (int) (10 * GameWindow.scalingFactor));
	protected Dimension bottonRestartSize = new Dimension((int) (200 * GameWindow.scalingFactor), (int) (150 * GameWindow.scalingFactor));
	protected Point bottonRestartCoordinates = new Point((int) (GameWindow.windowDimension.width - bottonRestartSize.width)/2, (int) (450 * GameWindow.scalingFactor));
	private static boolean isPaused = false;
	private int DIM15 = (int) (15 * GameWindow.scalingFactor);
	private int DIM5 = (int) (5 * GameWindow.scalingFactor);
	private int DIM2 = (int) (2 * GameWindow.scalingFactor);
	private Polygon p1 = new Polygon();
	private Polygon p2 = new Polygon();


    public static boolean getIsPaused()
	{
	    return isPaused;
	}

	/**
	 * Cambia il valore della variabile isPaused.
	 */
    protected static void changePauseStatus()
	{
	    isPaused = !isPaused;
    }
	
	public void paint(Graphics g)
	{	
		// Tasto pausa
		if(PlayerController.life > 0)
		{
			p1.addPoint(bottonPauseCoordinates.x+(bottonPauseSize.width/2) - DIM2 - DIM5, bottonPauseCoordinates.y + DIM5);
			p1.addPoint(bottonPauseCoordinates.x+(bottonPauseSize.width/2) - DIM2 - DIM5, bottonPauseCoordinates.y - DIM5+bottonPauseSize.height);
			p1.addPoint(bottonPauseCoordinates.x+(bottonPauseSize.width/2) + bottonPauseSize.height - DIM2 - DIM5 * 3, bottonPauseCoordinates.y + bottonPauseSize.height/2);
			
			g.setColor(Color.black);
			g.fillRoundRect(bottonPauseCoordinates.x, bottonPauseCoordinates.y, bottonPauseSize.width, bottonPauseSize.height, 10, 10);
			g.setColor(Color.white);
			g.drawRoundRect(bottonPauseCoordinates.x, bottonPauseCoordinates.y, bottonPauseSize.width, bottonPauseSize.height, 10, 10);
			
			if(isPaused)
				g.fillPolygon(p1);
			else
			{
				g.fillRect(bottonPauseCoordinates.x + (bottonPauseSize.width / 2) + DIM2, bottonPauseCoordinates.y + DIM5, DIM5, bottonPauseSize.height - (DIM5*2));
				g.fillRect(bottonPauseCoordinates.x + (bottonPauseSize.width / 2) - DIM2 - DIM5, bottonPauseCoordinates.y + DIM5, DIM5, bottonPauseSize.height - (DIM5*2));
			}
		}
		// Tasto riprendi
		else
		{
			p2.addPoint(bottonRestartCoordinates.x + (bottonRestartSize.width - bottonRestartSize.height)/2 + DIM15 * 3 + DIM5, bottonRestartCoordinates.y + DIM15 * 3);
			p2.addPoint(bottonRestartCoordinates.x + (bottonRestartSize.width - bottonRestartSize.height)/2 + DIM15 * 3 + DIM5, bottonRestartCoordinates.y + bottonRestartSize.height - DIM15 * 3);
			p2.addPoint(bottonRestartCoordinates.x + (bottonRestartSize.width - bottonRestartSize.height)/2 + bottonRestartSize.height - DIM15 * 2 - DIM2 * 2 - DIM5, bottonRestartCoordinates.y+bottonRestartSize.height/2);
			
			g.setColor(Color.black);
			g.fillRoundRect(bottonRestartCoordinates.x, bottonRestartCoordinates.y, bottonRestartSize.width, bottonRestartSize.height, 10, 10);
			g.setColor(Color.white);
			g.drawRoundRect(bottonRestartCoordinates.x, bottonRestartCoordinates.y, bottonRestartSize.width, bottonRestartSize.height, 10, 10);
			g.fillOval(bottonRestartCoordinates.x+(bottonRestartSize.width - bottonRestartSize.height)/2+DIM15, bottonRestartCoordinates.y+DIM15, bottonRestartSize.height-DIM15*2, bottonRestartSize.height-DIM15*2);
			g.setColor(Color.black);
			g.fillOval(bottonRestartCoordinates.x+(bottonRestartSize.width - bottonRestartSize.height)/2+DIM15+DIM2, bottonRestartCoordinates.y + DIM15 + DIM2, bottonRestartSize.height - DIM15 * 2-DIM2 * 2, bottonRestartSize.height - DIM15 * 2 - DIM2 * 2);
			g.setColor(Color.white);
			g.fillPolygon(p2);
		}
	}
}