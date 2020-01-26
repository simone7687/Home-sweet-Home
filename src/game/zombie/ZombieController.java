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
 * Controller per gli Zombie
 * @author 20024652 - 20025270
 * @version 1.0
 */
public class ZombieController implements Runnable
{
	public static Thread thread; 
	private static LinkedList<ZombieModel> zombies;
	// Spawn
	public static int zombiesToSpawn;
	public static int spawnMultiplier = 1;
	public static int spawnTime = 10000;
	
	public ZombieController()
	{
		System.out.println("Creazione zombie...");
		
		zombies = new LinkedList<ZombieModel>();
		thread = new Thread(this);
	}
	
	/**
	 * Aggiunge nuovi zombie alla lista di zombie
	 * @param zombieToSpawn
	 * @param l
	 */
	private void addZombie(int zombieToSpawn, LinkedList<ZombieModel> l)
	{
		for(int i = 0; i< zombieToSpawn; i++)
			l.add(new ZombieModel(ZombieType.Normal, GameWindow.windowDimension, GameWindow.scalingFactor));
	}
	
	/**
	 * Controlla l'animazione della corsa degli Zombie
	 * @param walk
	 */
	public void walk(boolean walk)
	{
		for (ZombieModel zombie : zombies)
		{
			if(walk)
			{
				zombie.run(true);
				if(zombie.getCoordinates().y > 220 * GameWindow.scalingFactor || zombie.getCoordinates().x < 570*GameWindow.scalingFactor || zombie.getCoordinates().x > 730*GameWindow.scalingFactor)
				{
					if(zombie.getCoordinates().x < 570 * GameWindow.scalingFactor)
						zombie.right();
					if(zombie.getCoordinates().x > 730 * GameWindow.scalingFactor)
						zombie.left();
					if(zombie.getCoordinates().y > 220 * GameWindow.scalingFactor)
						zombie.up();
				}
				else if(zombie.getLife() > 0)
				{
					PlayerController.life -= zombie.getPower();
				}
			}
			else
			{
				zombie.run(false);
			}
		}
	}
	
	/**
	 * Controlla il danno subito o inflitto dagli Zombie
	 * @param right
	 * @param x
	 * @param y
	 * @param power
	 */
	public static void damage(boolean right, int x, int y, int power)
	{
		Random rand = new Random();
		int hits = 0;
		
		for (ZombieModel zombie : zombies)	// Livelli
		{
			if(zombie.getCoordinates().y > y - 100 * GameWindow.scalingFactor && zombie.getCoordinates().y < y + 60 * GameWindow.scalingFactor)
			{
				if(right && zombie.getCoordinates().x > x && zombie.getCoordinates().x < x + (45+30) * GameWindow.scalingFactor && zombie.getLife() > 0)
				{
					zombie.decreaseLife(power);
					zombie.getCoordinates().x += (rand.nextInt(60) + 20) * GameWindow.scalingFactor;
					GameScoreModel.addScoreHit();
					hits++;
				}
				else if(!right && zombie.getCoordinates().x < x && zombie.getCoordinates().x > x - (45+30) * GameWindow.scalingFactor && zombie.getLife() > 0)
				{
					zombie.decreaseLife(power);
					zombie.getCoordinates().x -= (rand.nextInt(40) + 40) * GameWindow.scalingFactor;
					GameScoreModel.addScoreHit();
					hits++;
				}
			}
		}
		
		if(hits == 0 && PlayerController.life < 150 && PlayerController.life > 0 && y < 300 * GameWindow.scalingFactor && x > 570 * GameWindow.scalingFactor && x < 730 * GameWindow.scalingFactor)
			PlayerController.life += power/5;
	}
	
	/**
	 * Verifica se il livello e' terminato
	 * @return Restituisce true se il livello è terminato = tutti gli zombie morti
	 */
	private boolean endLevel()
	{
		for(int i = 0; i < zombiesToSpawn; i++)
		{
			if(zombies.get(i).getLife() > 0)
				return false;
		}
		return true;
	}
	
	/**
	 * Disegna lo zombie
	 * @param g
	 */
	public void paint(Graphics g)
	{
		for (ZombieModel zombie : zombies)
		{
			if(zombie.getLife() > 0)
				zombie.paintView(g);
		}
	}
	
	@Override
	public void run()
	{
		System.out.println("Avvio thread per lo spawn zombie...");
		int spawned = 0;
		
		while(true)
		{
			try 
			{
				Thread.sleep(spawnTime);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			// Spawn
			if(spawned >= zombiesToSpawn && PlayerController.life > 0 && endLevel())
			{
				zombies.clear();
				System.out.println("Fine livello!");
				spawned = 0;
				GameLevel.levelUp();
					
				try 
				{
					Thread.sleep(spawnTime);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			else if (spawned != zombiesToSpawn)
			{
				addZombie(spawnMultiplier, zombies);
				spawned += spawnMultiplier;
			}
			
			//Fine
			if(PlayerController.life < 0)
			{
				GameScoreModel.writeScoreToFile();
				GameOverView.setRecord(GameScoreModel.getHighestScoreFromFile());
				
				GamePauseController.pause();
				
				System.out.println("Restart");
				GameOverView.setRecord("");
				zombies.clear();
				spawned = 0;
				GameLevel.resetLevel();
				PlayerController.resetPlayerLife();
			}
		}
	}
}