package game.pause;

import game.zombie.ZombieController;

import java.awt.event.MouseEvent;

/**
 * 
 * La classe game.pause.GamePauseController ha la funzione di:
 * controllare il bottone di pausa e di restart.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class GamePauseController extends GamePauseView
{
	/**
	 * Il metodo clickPause ha la funzione di:
	 * mettere in pause/resume il gioco.
	 * @param event
	 */
	public void clickPause(MouseEvent event)
	{
		if(event.getX() >= bottonPauseCoordinates.x && event.getY() >= bottonPauseCoordinates.y && 
				event.getX() <= bottonPauseCoordinates.x+bottonPauseSize.width && 
				event.getY() <= bottonPauseCoordinates.y+bottonPauseSize.height)
		{
			if(getStatusPause())
				resume();
			else
				pause();
			
			changeStatusPause();
		}
	}

	/**
	 * Il metodo clickRestart ha la funzione di:
	 * ricominciare il gioco.
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