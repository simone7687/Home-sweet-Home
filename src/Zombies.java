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
public class Zombies implements Runnable
{
	private final int POWER = 5;
	private final int SPEED = (int) (15*GameWindows.dimension);
	static Thread thread;
	private static LinkedList<ZombieNodes> l;
	// spawn
	static int zombieSpawnNumber;
	private static int zombieCurrentNumber;
	static int n_zombie_spawn_multiplier = 1;
	static int spawnTime = 10000;
	
	Zombies()
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
				if(l.get(i).coordinates.y > 220*GameWindows.dimension || l.get(i).coordinates.x < 570*GameWindows.dimension || l.get(i).coordinates.x > 730*GameWindows.dimension) 				//da rivedere
				{
					if(l.get(i).coordinates.x < 570*GameWindows.dimension)
					{
						l.get(i).right = true;
						l.get(i).coordinates.x += SPEED;
					}
					if(l.get(i).coordinates.x > 730*GameWindows.dimension) 
					{
						l.get(i).left = true;
						l.get(i).coordinates.x -= SPEED;
					}
					if(l.get(i).coordinates.y > 220*GameWindows.dimension)
					{
						l.get(i).down = true;
						l.get(i).coordinates.y -= SPEED;
					}
				}
				else if(l.get(i).life > 0)
				{
					Players.life -= POWER;
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
			if(l.get(i).coordinates.y > y-100*GameWindows.dimension && l.get(i).coordinates.y < y+60*GameWindows.dimension)
			{
				if(right && l.get(i).coordinates.x > x && l.get(i).coordinates.x < x+(45+30)*GameWindows.dimension && l.get(i).life > 0)
				{
					l.get(i).life -= power;
					l.get(i).coordinates.x += (rand.nextInt(60)+20)*GameWindows.dimension;
					l.get(i).set();
					GameScores.addScoreHit();
					a++;
				}
				else	if(!right && l.get(i).coordinates.x<x && l.get(i).coordinates.x > x-(45+30)*GameWindows.dimension && l.get(i).life > 0)
				{
					l.get(i).life -= power;
					l.get(i).coordinates.x -= (rand.nextInt(40)+40)*GameWindows.dimension;
					l.get(i).set();
					GameScores.addScoreHit();
					a++;
				}
			}
		}
		if(a==0 && Players.life < 150 && Players.life > 0 && y < 300*GameWindows.dimension && x > 570*GameWindows.dimension && x < 730*GameWindows.dimension)
		{
			Players.life += power/5;
		}
	}
	/**
	 * Il metodo endLevel ha la funzione di:
	 * verificare se il livello � finito.
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
	/**
	 * Il metodo deleteNodes ha la funzione di:
	 * eliminare tutti i nodi di una lista
	 * @param l
	 */
	private void deleteNodes(LinkedList<ZombieNodes> l)
	{
		{
			for(int nodeNumber=l.size()-1; nodeNumber>=0; nodeNumber--)
			{
				l.remove(nodeNumber);
			}
		}
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
		boolean spawn = true;
		while(spawn)	//non va bene for, problemi con la pausa
		{
			// da spostarli in una finzione termina gioco, che setta i valori predefiniti
			if(Players.life <= 0)
			{
				Thread.interrupted();
			}
			
			try {
				Thread.sleep(spawnTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			zombieCurrentNumber = l.size();
			//spawn
			if(i >= zombieSpawnNumber)
			{
				if(endLevel())
				{
					deleteNodes(l);
					System.out.println("Fine livello!");
					i = 0;
					try {
						Thread.sleep(spawnTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					GameLevels.setNewLevel();
				}
			}
			else
			{
				addNodes(n_zombie_spawn_multiplier, l);
				i += 1*n_zombie_spawn_multiplier;
			}
		}
	}
}