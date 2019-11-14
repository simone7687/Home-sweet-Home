package game.player;

import game.window.BackgroundView;
import game.GameView;
import game.window.GameWindow;
import game.zombie.ZombiesController;

/**
 * 
 * La classe game.player.PlayerController ha la funzione di:
 * controllare il Player.
 * @author 20024652 - 20025270
 * @version 1.0
 *
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
	 * Il metodo hit ha la funzione di:
	 * controllare e animare il danno inflitto dal Player.
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
			ZombiesController.damage(getRight(), model.getCoordinates().x, model.getCoordinates().y, model.getPower());	// danno
			setHit(hit);
			currentHit = true;
		}
		try {
			Thread.sleep(HIT_REPAINT_TIME_MAX);	// per non far diventare il player un fantasma																	// rivedere: adesso e' inutile
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameImages.repaint();
	}
	/**
	 * Il metodo walk ha la funzione di:
	 * spostare e animare il Player in base ai tasti premudi.
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
	 * Ha la funzione di:
	 * settare la vita del Player ai valori iniziali.
	 */
	public static void setLifeInitial()
	{
		PlayerController.life = PlayerModel.START_LIFE;
	}
}