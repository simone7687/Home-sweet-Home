package game.zombie;

import game.pause.GamePauseController;
import game.player.PlayerController;
import game.score.GameLevel;
import game.score.GameScoreModel;
import game.window.GameOverView;
import game.window.GameWindow;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

/**
 * 
 * La classe game.zombie.ZombiesController ha la funzione di:
 * controllare gli Zombie.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class ZombieController implements Runnable
{
	private final int POWER = 5;
	private final int SPEED = (int) (15*GameWindow.scalingFactor);
	public static Thread thread;
	private static LinkedList<ZombieModel> l;
	// spawn
	public static int zombieSpawnNumber;
	private static int zombieCurrentNumber;
	public static int n_zombie_spawn_multiplier = 1;
	public static int spawnTime = 10000;
	
	public ZombieController()
	{
		System.out.println("Creazione zombie...");
		
		l=new LinkedList<ZombieModel>();
		thread = new Thread(this);
	}
	
	/**
	 * Il metodo addNodes ha la funzione di:
	 * aggiungere nodeAddNumber a l.
	 * @param nodeAddNumber
	 * @param l
	 */
	private void addNodes(int nodeAddNumber, LinkedList<ZombieModel> l)
	{
		for(int i=0; i<nodeAddNumber; i++)
		{
			l.add(new ZombieModel(GameWindow.windowDimension.width));
		}
	}
	/**
	 * Il metodo walk ha la funzione di:
	 * controllare l'animazione della corsa degli Zombie.
	 * @param walk
	 */
	public void walk(boolean walk)
	{
		for(int i=0; i < zombieCurrentNumber && l.size()!=0; i++)
		{
			if(walk)
			{
				l.get(i).run(true);
				if(l.get(i).getCoordinates().y > 220*GameWindow.scalingFactor || l.get(i).getCoordinates().x < 570*GameWindow.scalingFactor || l.get(i).getCoordinates().x > 730*GameWindow.scalingFactor)
				{
					if(l.get(i).getCoordinates().x < 570*GameWindow.scalingFactor)
						l.get(i).getCoordinates().x += SPEED;
					if(l.get(i).getCoordinates().x > 730*GameWindow.scalingFactor) 
						l.get(i).getCoordinates().x -= SPEED;
					if(l.get(i).getCoordinates().y > 220*GameWindow.scalingFactor)
						l.get(i).getCoordinates().y -= SPEED;
				}
				else if(l.get(i).getLife() > 0)
				{
					PlayerController.life -= POWER;
				}
			}
			else
			{
				l.get(i).run(false);
			}
			l.get(i).set();
		}
	}
	/**
	 * Il metodo damage ha la funzione di:
	 * controllare il danno subito o inflitto dagli Zombie.
	 * @param right
	 * @param x
	 * @param y
	 * @param power
	 */
	public static void damage(boolean right, int x, int y, int power)
	{
		Random rand = new Random();
		int a = 0;
		for(int i=0; i<zombieCurrentNumber && l.size()!=0; i++)	// livelli
		{
			if(l.get(i).getCoordinates().y > y-100*GameWindow.scalingFactor && l.get(i).getCoordinates().y < y+60*GameWindow.scalingFactor)
			{
				if(right && l.get(i).getCoordinates().x > x && l.get(i).getCoordinates().x < x+(45+30)*GameWindow.scalingFactor && l.get(i).getLife() > 0)
				{
					l.get(i).decreaseLife(power);
					l.get(i).getCoordinates().x += (rand.nextInt(60)+20)*GameWindow.scalingFactor;
					l.get(i).set();
					GameScoreModel.addScoreHit();
					a++;
				}
				else if(!right && l.get(i).getCoordinates().x< x && l.get(i).getCoordinates().x > x-(45+30)*GameWindow.scalingFactor && l.get(i).getLife() > 0)
				{
					l.get(i).decreaseLife(power);
					l.get(i).getCoordinates().x -= (rand.nextInt(40)+40)*GameWindow.scalingFactor;
					l.get(i).set();
					GameScoreModel.addScoreHit();
					a++;
				}
			}
		}
		if(a==0 && PlayerController.life < 150 && PlayerController.life > 0 && y < 300*GameWindow.scalingFactor && x > 570*GameWindow.scalingFactor && x < 730*GameWindow.scalingFactor)
		{
			PlayerController.life += power/5;
		}
	}
	/**
	 * Il metodo endLevel ha la funzione di:
	 * verificare se il livello e' terminato.
	 * Restituisce true se il livello e' terminato.
	 * @return
	 */
	private boolean endLevel()
	{
		for(int i=0; i<zombieSpawnNumber; i++)
		{
			if(l.get(i).getLife() > 0)
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
			if(l.get(i).getLife() > 0)
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
				GameScoreModel.writeScoreToFile();
				GameOverView.setRecord(GameScoreModel.getHighestScoreFromFile());
				
				GamePauseController.pause();
				
				System.out.println("Restart");
				GameOverView.setRecord("");
				l.removeAll(l);
				i = 0;
				GameLevel.setLevel(1);
				PlayerController.setLifeInitial();
			}
		}
	}
}