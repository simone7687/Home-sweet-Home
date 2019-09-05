/**
 * 
 * La classe Players ha la funzione di:
 * gestire il Player.
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
	 * gestire l'animazione e il danno degli attachi del Player.
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
	 * gestire l'animazione e lo spostamento della corsa del Player.
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

	static void setLifeInitial()
	{
		PlayerController.life = PlayerModel.START_LIFE;
	}

	void setLeft(boolean left)
	{
	   	model.setLeft(left);
	}

	void setUp(boolean up)
	{
		model.setUp(up);
	}

	void setDown(boolean down)
	{
		model.setDown(down);
	}
}