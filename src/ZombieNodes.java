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
public class ZombieNodes extends ZombieImages
{
	int life = 100;
	Point coordinates = new Point();
	ZombieNodes next;
	boolean right, left, up, down, run;
	
	ZombieNodes()
	{
		Random rand = new Random();
		coordinates.y = GameWindows.windowDimension.height-100;
		coordinates.x = rand.nextInt(GameWindows.windowDimension.width);
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
		setRight(right);
	}
}