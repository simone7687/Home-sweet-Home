package game.pause;

import game.zombie.ZombieController;
import java.awt.event.MouseEvent;

/**
 *  Controller per GamePauseView. Gestisce i tasti play & pausa
 * @author 20025270
 * @version 1.0
 *
 */
public class GamePauseController extends GamePauseView
{
	/**
	 * Mette in pause/riprendere il gioco.
	 * @param event
	 */
	public void clickPause(MouseEvent event)
	{
		// In base alle coordinate decide se il click è stato fatto sul pulsante
		if(event.getX() >= bottonPauseCoordinates.x && event.getY() >= bottonPauseCoordinates.y && 
				event.getX() <= bottonPauseCoordinates.x+bottonPauseSize.width && 
				event.getY() <= bottonPauseCoordinates.y+bottonPauseSize.height)
		{
			if(getIsPaused())
			{
				resume();
				System.out.println("RESUME");
			}
			else
			{
				pause();
				System.out.println("PAUSA");
			}
		}
	}

	/**
	 * Ricomincia il gioco.
	 * @param event
	 */
	public void clickRestart(MouseEvent event)
	{
		if(event.getX() >= bottonRestartCoordinates.x && event.getY() >= bottonRestartCoordinates.y && 
				event.getX() <= bottonRestartCoordinates.x+bottonRestartSize.width && 
				event.getY() <= bottonRestartCoordinates.y+bottonRestartSize.height)
		{
			resume();
		}
	}
	
	@SuppressWarnings("deprecation")
    public static void pause()
	{
		ZombieController.thread.suspend();
	}

	@SuppressWarnings("deprecation")
	void resume()
	{
		ZombieController.thread.resume();
	}
}