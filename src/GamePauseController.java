import java.awt.event.MouseEvent;

public class GamePauseController extends GamePauseView
{
	GamePauseController()
	{
		System.out.println("");
	}
	
	void clickPause(MouseEvent e)
	{
		if(e.getX() >= bottonPauseCoordinates.x && e.getY() >= bottonPauseCoordinates.y && 
				e.getX() <= bottonPauseCoordinates.x+bottonPauseSize.width && 
				e.getY() <= bottonPauseCoordinates.y+bottonPauseSize.height)
		{
			if(pause)
				resume();
			else
				pause();
			
			pause = !pause;
		}
	}
	void clickRestart(MouseEvent e)
	{
		if(e.getX() >= bottonRestartCoordinates.x && e.getY() >= bottonRestartCoordinates.y && 
				e.getX() <= bottonRestartCoordinates.x+bottonRestartSize.width && 
				e.getY() <= bottonRestartCoordinates.y+bottonRestartSize.height)
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