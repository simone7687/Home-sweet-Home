package game.pause;

import game.player.PlayerController;
import game.window.GameWindow;

import java.awt.*;

/**
 * Disegna il pulsante di pausa e di restart.
 * @author 20025270
 * @version 1.0
 *
 */
public class GamePauseView 
{
	protected Dimension pauseButtonSize = new Dimension((int) (50 * GameWindow.scalingFactor), (int) (25 * GameWindow.scalingFactor));
	protected Point pauseButtonCoordinates = new Point((int) (10 * GameWindow.scalingFactor), (int) (10 * GameWindow.scalingFactor));
	protected Dimension restartButtonSize = new Dimension((int) (200 * GameWindow.scalingFactor), (int) (150 * GameWindow.scalingFactor));
	protected Point restartButtonCoordinates = new Point((int) (GameWindow.windowDimension.width-restartButtonSize.width)/2, (int) (450 * GameWindow.scalingFactor));
	private static boolean isPaused = false;
	
	private int DIM15 = (int) (15 * GameWindow.scalingFactor);
	private int DIM5 = (int) (5 * GameWindow.scalingFactor);
	private int DIM2 = (int) (2 * GameWindow.scalingFactor);
	
	private Polygon pauseButton = new Polygon();
	private Polygon resumeButton = new Polygon();


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
			pauseButton.addPoint(pauseButtonCoordinates.x + (pauseButtonSize.width/2) - DIM2-DIM5, pauseButtonCoordinates.y + DIM5);
			pauseButton.addPoint(pauseButtonCoordinates.x + (pauseButtonSize.width/2) - DIM2-DIM5, pauseButtonCoordinates.y - DIM5 + pauseButtonSize.height);
			pauseButton.addPoint(pauseButtonCoordinates.x + (pauseButtonSize.width/2) + pauseButtonSize.height - DIM2 - DIM5 * 3, pauseButtonCoordinates.y + pauseButtonSize.height/2);
			
			g.setColor(Color.black);
			g.fillRoundRect(pauseButtonCoordinates.x, pauseButtonCoordinates.y, pauseButtonSize.width, pauseButtonSize.height, 10, 10);
			g.setColor(Color.white);
			g.drawRoundRect(pauseButtonCoordinates.x, pauseButtonCoordinates.y, pauseButtonSize.width, pauseButtonSize.height, 10, 10);
			
			if(isPaused)
				g.fillPolygon(pauseButton);
			else
			{
				g.fillRect(pauseButtonCoordinates.x+(pauseButtonSize.width/2)+DIM2, pauseButtonCoordinates.y+DIM5, DIM5, pauseButtonSize.height-(DIM5*2));
				g.fillRect(pauseButtonCoordinates.x+(pauseButtonSize.width/2)-DIM2-DIM5, pauseButtonCoordinates.y+DIM5, DIM5, pauseButtonSize.height-(DIM5*2));
			}
		}
		// Tasto riprendi
		else
		{
			resumeButton.addPoint(restartButtonCoordinates.x+(restartButtonSize.width-restartButtonSize.height)/2+DIM15*3+DIM5, restartButtonCoordinates.y+DIM15*3);
			resumeButton.addPoint(restartButtonCoordinates.x+(restartButtonSize.width-restartButtonSize.height)/2+DIM15*3+DIM5, restartButtonCoordinates.y+restartButtonSize.height-DIM15*3);
			resumeButton.addPoint(restartButtonCoordinates.x+(restartButtonSize.width-restartButtonSize.height)/2+restartButtonSize.height-DIM15*2-DIM2*2-DIM5, restartButtonCoordinates.y+restartButtonSize.height/2);
			
			g.setColor(Color.black);
			g.fillRoundRect(restartButtonCoordinates.x, restartButtonCoordinates.y, restartButtonSize.width, restartButtonSize.height, 10, 10);
			g.setColor(Color.white);
			g.drawRoundRect(restartButtonCoordinates.x, restartButtonCoordinates.y, restartButtonSize.width, restartButtonSize.height, 10, 10);
			g.fillOval(restartButtonCoordinates.x+(restartButtonSize.width-restartButtonSize.height)/2+DIM15, restartButtonCoordinates.y+DIM15, restartButtonSize.height-DIM15*2, restartButtonSize.height-DIM15*2);
			g.setColor(Color.black);
			g.fillOval(restartButtonCoordinates.x+(restartButtonSize.width-restartButtonSize.height)/2+DIM15+DIM2, restartButtonCoordinates.y+DIM15+DIM2, restartButtonSize.height-DIM15*2-DIM2*2, restartButtonSize.height-DIM15*2-DIM2*2);
			g.setColor(Color.white);
			g.fillPolygon(resumeButton);
		}
	}
}