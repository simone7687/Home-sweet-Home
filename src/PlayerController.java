/**
 * 
 * La classe PlayerController ha la funzione di:
 * controllare il Player.
 * @author 20024652
 * @version 1.0
 *
 */

public class PlayerController extends PlayerView
{
	static int life;
	GameView gameImages;
	private PlayerModel model = new PlayerModel();
	boolean currentHit = true;
	private final int HIT_REPAINT_TIME_MAX = 50;
	
	PlayerController(String name)
	{
		System.out.println("Creazione personaggio...");
		life = PlayerModel.START_LIFE;
		PlayerModel.name = name;
		setCoordinates(model.getCoordinates());
	}
	
	/**
	 * Il metodo hit ha la funzione di:
	 * controllare l'animazione e il danno inflitto dal Player.
	 * @param hit
	 */
	void hit(boolean hit)
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
	 * Il metodo hit ha la funzione di:
	 * controllare l'animazione della corsa del Player.
	 * @param walk
	 */
	void walk(boolean walk)
	{
		setRight(getRight());	// per gli hit
		if(walk)
		{
			if(getRight() && GameWindow.windowDimension.width>model.getCoordinates().x+model.getSpeed())
			{
				setRun(true);
				model.setCoordinatesDx();
				//setRight(right);
			}
			else if(model.getLeft() && 0 < model.getCoordinates().x-model.getSpeed())
			{
				setRun(true);
				model.setCoordinatesSx();
				//setRight(right);
			}
			if(model.getUp() && BackgroundView.DIM200 < model.getCoordinates().y-model.getSpeed())
			{
				setRun(true);
				model.setCoordinatesDown();
			}
			else if(model.getDown() && GameWindow.windowDimension.height > model.getCoordinates().y+model.getSpeed())
			{
				setRun(true);
				model.setCoordinatesUp();
			}
			setCoordinates(model.getCoordinates());
			setRun(getRun());
		}
		else
		{
			setRun(false);
			setRun(getRun());
		}
	}
	/**
	 * Ha la funzione di:
	 * settare la vita del Player ai valori iniziali.
	 */
	static void setLifeInitial()
	{
		PlayerController.life = PlayerModel.START_LIFE;
	}
	/**
	 * Ha la funzione di:
	 * settare la variabile left con la variabile passata per parametro.
	 * @param left
	 */
	void setLeft(boolean left)
	{
	   	model.setLeft(left);
	}
	/**
	 * Ha la funzione di:
	 * settare la variabile up con la variabile passata per parametro.
	 * @param up
	 */
	void setUp(boolean up)
	{
		model.setUp(up);
	}
	/**
	 * Ha la funzione di:
	 * settare la variabile down con la variabile passata per parametro.
	 * @param down
	 */
	void setDown(boolean down)
	{
		model.setDown(down);
	}
}