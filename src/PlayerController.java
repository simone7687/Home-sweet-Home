import java.awt.Point;

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
	static final int START_LIFE = 100;
	static int life = START_LIFE;
	static String name;
	// corri
	private int speed = (int) (30 * GameWindow.scalingFactor);
	private Point coordinates = new Point((GameWindow.windowDimension.width / 2), (int) (GameWindow.windowDimension.height / 2));
	boolean right, left, up, down, run;
	// attacco
	private final int HIT_REPAINT_TIME_MAX = 50;
	private int power = 10;
	private boolean hit;
	boolean currentHit = true;
	GameView gameImages;
	
	PlayerController(String name)
	{
		System.out.println("Creazione personaggio...");
		PlayerController.name = name;
		setCoordinates(coordinates);
		setRun(run);
		setRight(right);
		setHit(hit);
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
			this.hit = hit;
			setHit(hit);
			currentHit = false;
		}
		else
		{
			this.hit = hit;
			ZombiesController.damage(right, coordinates.x, coordinates.y, power);	// danno
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
		setRight(right);	// per gli hit
		if(walk)
		{
			if(right && GameWindow.windowDimension.width>coordinates.x+speed)
			{
				run = true;
				coordinates.x += speed;
				//setRight(right);
			}
			else if(left && 0 < coordinates.x-speed)
			{
				run = true;
				coordinates.x -= speed;
				//setRight(right);
			}
			if(up && BackgroundView.DIM200 < coordinates.y-speed)
			{
				run = true;
				coordinates.y -= speed;
			}
			else if(down && GameWindow.windowDimension.height > coordinates.y+speed)
			{
				run = true;
				coordinates.y += speed;
			}
			setCoordinates(coordinates);
			setRun(run);
		}
		else
		{
			run = false;
			setRun(run);
		}
	}
}