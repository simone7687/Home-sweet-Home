package game.player;

import game.GameView;
import game.window.BackgroundView;
import game.window.GameWindow;
import game.zombie.ZombieController;

/**
 * Controller per il Player.
 * @author 20024652 - 20025270
 * @version 1.0
 */

public class PlayerController extends PlayerView
{
	public static int life;
	public GameView gameImages;
	private PlayerModel model = new PlayerModel(getCoordinates(), (int) GameWindow.scalingFactor);
	public boolean currentHit = true;
	private final int HIT_REPAINT_TIME_MAX = 50;
	
	public PlayerController(String name)
	{
		System.out.println("Creazione personaggio...");
		life = PlayerModel.START_LIFE;
		PlayerModel.setPlayerName(name);
		setCoordinates(model.getCoordinates());
	}
	
	/**
	 * Controlla e anima il danno inflitto dal Player.
	 * @param hit
	 */
	public void hit(boolean hit)
	{
		if(hit)
		{
			setHit(hit);
			currentHit = false;
		}
		else
		{
			ZombieController.damage(getRight(), model.getCoordinates().x, model.getCoordinates().y, model.getPower());	// danno
			setHit(hit);
			currentHit = true;
		}
		try {
			Thread.sleep(HIT_REPAINT_TIME_MAX);	// per non far diventare il player un fantasma																	// rivedere: adesso e' inutile
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gameImages.repaint();
	}

	/**
	 * Sposta e anima il Player in base ai tasti premuti.
	 * @param walk
	 */
	public void walk(boolean walk)
	{
		if(walk)
		{
			if(getRight())
			{
				setRun(true);
				model.moveRight(GameWindow.windowDimension.width);
			}
			else if(getLeft())
			{
				setRun(true);
				model.moveLeft(0);
			}
			if(getUp())
			{
				setRun(true);
				model.moveUp(BackgroundView.getBorderY());
			}
			else if(getDown())
			{
				setRun(true);
				model.moveDown(GameWindow.windowDimension.height);
			}
			setCoordinates(model.getCoordinates());
		}
		else
		{
			setRun(false);
		}
	}

	/**
	 * Reset della vita del Player ai valori iniziali.
	 */
	public static void resetPlayerLife()
	{
		PlayerController.life = PlayerModel.START_LIFE;
	}
}