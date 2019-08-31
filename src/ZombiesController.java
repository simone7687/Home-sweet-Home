import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

/**
 * 
 * La classe Zombies ha la funzione di:
 * gestire la grafica degli Zombie.
 * @author 20024652
 * @version 1.0
 *
 */
public class ZombiesController implements Runnable
{
	private final int POWER = 5;
	private final int SPEED = (int) (15*GameWindow.dimension);
	static Thread thread;
	private static LinkedList<ZombieNodes> l;
	// spawn
	static int zombieSpawnNumber;
	private static int zombieCurrentNumber;
	static int n_zombie_spawn_multiplier = 1;
	static int spawnTime = 10000;
	
	ZombiesController()
	{
		System.out.println("Creazione zombie...");
		
		l=new LinkedList<ZombieNodes>();
		thread = new Thread(this);
	}
	
	/**
	 * Il metodo addNodes ha la funzione di:
	 * aggiungere nodeAddNumber a l.
	 * @param nodeAddNumber
	 * @param l
	 */
	private void addNodes(int nodeAddNumber, LinkedList<ZombieNodes> l)
	{
		for(int i=0; i<nodeAddNumber; i++)
		{
			l.add(new ZombieNodes());
		}
	}
	/**
	 * Il metodo walk ha la funzione di:
	 * gestire l'animazione e lo spostamento della corsa degli Zombie.
	 * @param walk
	 */
	void walk(boolean walk)
	{
		for(int i=0; i<zombieCurrentNumber && l.size()!=0; i++)
		{
			if(walk)
			{
				l.get(i).run=true;
				if(l.get(i).coordinates.y > 220*GameWindow.dimension || l.get(i).coordinates.x < 570*GameWindow.dimension || l.get(i).coordinates.x > 730*GameWindow.dimension)
				{
					if(l.get(i).coordinates.x < 570*GameWindow.dimension)
					{
						l.get(i).coordinates.x += SPEED;
					}
					if(l.get(i).coordinates.x > 730*GameWindow.dimension) 
					{
						l.get(i).coordinates.x -= SPEED;
					}
					if(l.get(i).coordinates.y > 220*GameWindow.dimension)
					{
						l.get(i).coordinates.y -= SPEED;
					}
				}
				else if(l.get(i).life > 0)
				{
					PlayerController.life -= POWER;
				}
			}
			else
			{
				l.get(i).run = false;
			}
			l.get(i).set();
		}
	}
	/**
	 * Il metodo damage ha la funzione di:
	 * gestire l'animazione e il danno subiti dagli Zombie.
	 * @param right
	 * @param x
	 * @param y
	 * @param power
	 */
	static void damage(boolean right, int x, int y, int power)
	{
		Random rand = new Random();
		int a = 0;
		for(int i=0; i<zombieCurrentNumber && l.size()!=0; i++)	// livelli
		{
			if(l.get(i).coordinates.y > y-100*GameWindow.dimension && l.get(i).coordinates.y < y+60*GameWindow.dimension)
			{
				if(right && l.get(i).coordinates.x > x && l.get(i).coordinates.x < x+(45+30)*GameWindow.dimension && l.get(i).life > 0)
				{
					l.get(i).life -= power;
					l.get(i).coordinates.x += (rand.nextInt(60)+20)*GameWindow.dimension;
					l.get(i).set();
					GameScore.addScoreHit();
					a++;
				}
				else	if(!right && l.get(i).coordinates.x<x && l.get(i).coordinates.x > x-(45+30)*GameWindow.dimension && l.get(i).life > 0)
				{
					l.get(i).life -= power;
					l.get(i).coordinates.x -= (rand.nextInt(40)+40)*GameWindow.dimension;
					l.get(i).set();
					GameScore.addScoreHit();
					a++;
				}
			}
		}
		if(a==0 && PlayerController.life < 150 && PlayerController.life > 0 && y < 300*GameWindow.dimension && x > 570*GameWindow.dimension && x < 730*GameWindow.dimension)
		{
			PlayerController.life += power/5;
		}
	}
	/**
	 * Il metodo endLevel ha la funzione di:
	 * verificare se il livello è finito.
	 * @return
	 */
	private boolean endLevel()
	{
		for(int i=0; i<zombieSpawnNumber; i++)
		{
			if(l.get(i).life > 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public void paint(Graphics g)
	{
		for(int i=0; i<zombieCurrentNumber && l.size()!=0; i++)
		{
			if(l.get(i).life > 0)
			{
				l.get(i).paint(g);	// per puntare alla lista n i
			}
		}
	}
	@Override
	public void run()
	{
		System.out.println("Avvio thread per lo spawn zombie...");
		//zombieCurrentNumber=l.size();
		int i = 0;
		while(true)	//non va bene for, problemi con la pausa
		{
			try {
				Thread.sleep(spawnTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			zombieCurrentNumber = l.size();
			//spawn
			if(i >= zombieSpawnNumber && PlayerController.life > 0)
			{
				if(endLevel())
				{
					l.removeAll(l);
					System.out.println("Fine livello!");
					i = 0;
					try {
						Thread.sleep(spawnTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					GameLevel.setNewLevel();
				}
			}
			else
			{
				addNodes(n_zombie_spawn_multiplier, l);
				i += 1*n_zombie_spawn_multiplier;
			}
			//fine
			if(PlayerController.life < 0)
			{
				//GameScores.printScore();
				
				GamePauseController.pause();
				
				System.out.println("Restart");
				l.removeAll(l);
				i = 0;
				GameLevel.setLevel(1);
				PlayerController.life = PlayerController.START_LIFE;
			}
		}
	}
}