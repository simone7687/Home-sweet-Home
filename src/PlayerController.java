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
	 * controllare e animare il danno inflitto dal Player.
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
	 * Il metodo walk ha la funzione di:
	 * spostare e animare il Player in base ai tasti premudi.
	 * @param walk
	 */
	void walk(boolean walk)
	{
		if(walk)
		{
			if(getRight())
			{
				setRun(true);
				model.moveRight();
			}
			else if(getLeft())
			{
				setRun(true);
				model.moveLeft();
			}
			if(getUp())
			{
				setRun(true);
				model.moveUp();
			}
			else if(getDown())
			{
				setRun(true);
				model.moveDown();
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
	static void setLifeInitial()
	{
		PlayerController.life = PlayerModel.START_LIFE;
	}
}