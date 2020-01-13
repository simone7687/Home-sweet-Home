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
 * Controller per gli Zombie
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class ZombieController implements Runnable
{
	public static Thread thread;
	private static LinkedList<ZombieModel> l;
	// Spawn
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
	 * Aggiunge nodeAddNumber a l
	 * @param nodeAddNumber
	 * @param l
	 */
	private void addNodes(int nodeAddNumber, LinkedList<ZombieModel> l)
	{
		for(int i=0; i< nodeAddNumber; i++)
			l.add(new ZombieModel(ZombieType.Normal, GameWindow.windowDimension, GameWindow.scalingFactor));
	}
	
	/**
	 * Controlla l'animazione della corsa degli Zombie
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
						l.get(i).right();;
					if(l.get(i).getCoordinates().x > 730*GameWindow.scalingFactor)
						l.get(i).left();;
					if(l.get(i).getCoordinates().y > 220*GameWindow.scalingFactor)
						l.get(i).up();
				}
				else if(l.get(i).getLife() > 0)
				{
					PlayerController.life -= l.get(i).getPower();
				}
			}
			else
			{
				l.get(i).run(false);
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
		int a = 0;
		for(int i=0; i<zombieCurrentNumber && l.size()!=0; i++)	// Livelli
		{
			if(l.get(i).getCoordinates().y > y-100*GameWindow.scalingFactor && l.get(i).getCoordinates().y < y+60*GameWindow.scalingFactor)
			{
				if(right && l.get(i).getCoordinates().x > x && l.get(i).getCoordinates().x < x+(45+30)*GameWindow.scalingFactor && l.get(i).getLife() > 0)
				{
					l.get(i).decreaseLife(power);
					l.get(i).getCoordinates().x += (rand.nextInt(60)+20)*GameWindow.scalingFactor;
					GameScoreModel.addScoreHit();
					a++;
				}
				else if(!right && l.get(i).getCoordinates().x< x && l.get(i).getCoordinates().x > x-(45+30)*GameWindow.scalingFactor && l.get(i).getLife() > 0)
				{
					l.get(i).decreaseLife(power);
					l.get(i).getCoordinates().x -= (rand.nextInt(40)+40)*GameWindow.scalingFactor;
					GameScoreModel.addScoreHit();
					a++;
				}
			}
		}
		
		if(a==0 && PlayerController.life < 150 && PlayerController.life > 0 && y < 300*GameWindow.scalingFactor && x > 570*GameWindow.scalingFactor && x < 730*GameWindow.scalingFactor)
			PlayerController.life += power/5;
	}
	
	/**
	 * Verifica se il livello e' terminato
	 * @return Restituisce true se il livello e' terminato
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
				l.get(i).paintView(g);	// Per puntare alla lista n i
			}
		}
	}
	
	@Override
	public void run()
	{
		System.out.println("Avvio thread per lo spawn zombie...");
		int i = 0;
		
		while(true)
		{
			try {
				Thread.sleep(spawnTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			zombieCurrentNumber = l.size();
			
			// Spawn
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
			
			//Fine
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
				PlayerController.resetPlayerLife();
			}
		}
	}
}