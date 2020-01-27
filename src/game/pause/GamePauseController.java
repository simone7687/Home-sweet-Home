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
		// In base alle coordinate decide se il click è stato fatto sul pulsante pausa
		if(event.getX() >= pauseButtonCoordinates.x && event.getY() >= pauseButtonCoordinates.y && 
				event.getX() <= pauseButtonCoordinates.x + pauseButtonSize.width && 
				event.getY() <= pauseButtonCoordinates.y + pauseButtonSize.height)
		{
			if(getIsPaused())
			{
				resume();
				System.out.println("RESUMED");
			}
			else
			{
				pause();
				System.out.println("PAUSED");
			}
		}
	}

	/**
	 * Ricomincia il gioco.
	 * @param event
	 */
	public void clickRestart(MouseEvent event)
	{
		if(event.getX() >= restartButtonCoordinates.x && event.getY() >= restartButtonCoordinates.y && 
				event.getX() <= restartButtonCoordinates.x + restartButtonSize.width && 
				event.getY() <= restartButtonCoordinates.y + restartButtonSize.height)
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