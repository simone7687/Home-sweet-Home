import java.awt.event.MouseEvent;

/**
 * 
 * La classe PlayerImages ha la funzione di:
 * controllare il bottone di pausa e di restart.
 * @author 20024652
 * @version 1.0
 *
 */
public class GamePauseController extends GamePauseView
{
	/**
	 * Il metodo clickPause ha la funzione di:
	 * mettere in pause/resume il gioco.
	 * @param ------------------
	 */
	void clickPause(MouseEvent event)
	{
		if(event.getX() >= bottonPauseCoordinates.x && event.getY() >= bottonPauseCoordinates.y && 
				event.getX() <= bottonPauseCoordinates.x+bottonPauseSize.width && 
				event.getY() <= bottonPauseCoordinates.y+bottonPauseSize.height)
		{
			if(pause)
				resume();
			else
				pause();
			
			pause = !pause;
		}
	}

	/**
	 * Il metodo clickRestart ha la funzione di:
	 * ricominciare il gioco.
	 * @param ---------------------------
	 */
	void clickRestart(MouseEvent evente)
	{
		if(evente.getX() >= bottonRestartCoordinates.x && evente.getY() >= bottonRestartCoordinates.y && 
				evente.getX() <= bottonRestartCoordinates.x+bottonRestartSize.width && 
				evente.getY() <= bottonRestartCoordinates.y+bottonRestartSize.height)
		{
			resume();
		}
	}
	
	@SuppressWarnings("deprecation")
	static void pause()
	{
		ZombiesController.thread.suspend();
	}
	@SuppressWarnings("deprecation")
	void resume()
	{
		ZombiesController.thread.resume();
	}
}