import java.awt.event.MouseEvent;

public class GamePause extends PauseBottonImages
{
	GamePause()
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
			{
				resume();
				pause = false;
			}
			else
			{
				pause();
				pause = true;
			}
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
		Zombies.thread.suspend();
	}
	@SuppressWarnings("deprecation")
	void resume()
	{
		Zombies.thread.resume();
	}
}