import java.awt.Point;
import java.util.Random;

/**
 * 
 * La classe ZombieNodes e' un nodo che contiene:
 * la posizione e i valori per la gestione grafica di uno Zombie.
 * @author 20024652
 * @version 1.0
 *
 */
public class ZombieNodeModel extends ZombieView
{
	private final int LIFESTART = 100;
	int life = LIFESTART;
	Point coordinates = new Point();
	ZombieNodeModel next;
	boolean run;
	
	ZombieNodeModel()
	{
		Random rand = new Random();
		coordinates.y = GameWindow.windowDimension.height-100;
		coordinates.x = rand.nextInt(GameWindow.windowDimension.width);
		set();
	}
	
	/**
	 * Il metodo set ha la funzione di:
	 * aggiornare le variabili dell'estensione di questo nodo.
	 */
	void set()
	{
		setCoordinates(coordinates);
		setRun(run);
		setLifePercentage(life*(100/LIFESTART));
	}
}