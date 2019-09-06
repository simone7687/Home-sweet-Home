import java.awt.event.MouseEvent;

public class GamePauseController extends GamePauseView
{
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