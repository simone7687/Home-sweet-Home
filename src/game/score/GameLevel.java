package game.score;

import game.GameView;
import game.zombie.ZombieController;

/**
 * 
 * La classe game.score.GameLevel ha la funzione di:
 * gestire il passaggio del gioco ad un nuovo livello.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class GameLevel
{
	public static int level = 1;
	private static int levelSpawnMultiplier = 6;	// ad ogni levelSpawnMultiplier aggiunge un zombie in ogni spawn
	private static int zombieStartNumber = 6;
	
	GameLevel()
	{
		System.out.println("Livello " + level);
		
		ZombieController.zombieSpawnNumber = zombieStartNumber;
		ZombieController.thread.start();
	}
	
	public GameLevel(int level)
	{
		System.out.println("Livello " + GameLevel.level);
		
		ZombieController.zombieSpawnNumber = zombieStartNumber;
		for(int i = 2; i<=level; i++)
		{
			setNewLevel();
		}
		ZombieController.thread.start();
	}
	
	/**
	 * Il metodo setNewLevel ha la funzione di:
	 * aumentare il gioco di un livello con
	 * la diminuzione di tempo necessario a spawnare gli Zombie e
	 * l'aumento del numero di zombie spawnati ad ogni livello e ad ogni spawn.
	 */
	public static void setNewLevel()
	{
		GameScoreModel.addScoreLevel(level);
		
		level++;
		System.out.println("Livello " + level);
		// aumenta zombie
		ZombieController.zombieSpawnNumber += (int) (zombieStartNumber*1/4);
		// aumenta zombie ad agni spawn
		if(level%levelSpawnMultiplier == 0)
		{
			ZombieController.n_zombie_spawn_multiplier++;
			if(ZombieController.spawnTime < 10000 || GameView.timeRepaintWalk < 200)
			{
				ZombieController.spawnTime += (1000 * ZombieController.n_zombie_spawn_multiplier);
				GameView.timeRepaintWalk += (10 * ZombieController.n_zombie_spawn_multiplier);
			}
		}
		else
		{
			// diminuisce tempo ad ogni spawn
			if(ZombieController.spawnTime > 7000)
			{
				ZombieController.spawnTime -= 1000;
			}
			// aumenta velocità del gioco
			if(GameView.timeRepaintWalk > 100)
			{
				GameView.timeRepaintWalk -= 10;
			}
		}
	}
	
	public static void setLevel(int level)
	{
		GameLevel.level = 1;
		GameScoreModel.setScore(0);
		ZombieController.n_zombie_spawn_multiplier = 1;
		ZombieController.spawnTime = 10000;
		GameView.timeRepaintWalk = 200;
		
		System.out.println("Livello " + GameLevel.level);
		
		ZombieController.zombieSpawnNumber = zombieStartNumber;
		for(int i = 2; i<=level; i++)
		{
			setNewLevel();
		}
	}
}