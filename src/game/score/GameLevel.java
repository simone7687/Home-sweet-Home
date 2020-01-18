package game.score;

import game.GameView;
import game.zombie.ZombieController;

/**
 * 
 * Gestisce il passaggio del gioco ad un nuovo livello.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class GameLevel
{
	public static int level = 1;
	private static int levelSpawnMultiplier = 6;	// Ad ogni levelSpawnMultiplier aggiunge un zombie in ogni spawn
	private static int zombieStartNumber = 6;
	
	GameLevel()
	{
		System.out.println("Livello " + level);
		
		ZombieController.zombiesToSpawn = zombieStartNumber;
		ZombieController.thread.start();
	}
	
	public GameLevel(int level)
	{
		System.out.println("Livello " + GameLevel.level);
		
		ZombieController.zombiesToSpawn = zombieStartNumber;
		for(int i = 2; i<=level; i++)
			setNewLevel();
		
		ZombieController.thread.start();
	}
	
	/**
	 * Aumenta il livello di difficoltà del gioco. Diminuisce il tempo necessario 
	 * allo spawn degli zombie e aumenta il numero dgli stessi ad ogni successivo 
	 * livello e spawn.
	 */
	public static void setNewLevel()
	{
		GameScoreModel.addScoreLevel(level);
		
		level++;
		System.out.println("Livello " + level);
		// Aumenta zombie
		ZombieController.zombiesToSpawn += (int) (zombieStartNumber*1/4);
		// Aumenta zombie ad agni spawn
		if(level % levelSpawnMultiplier == 0)
		{
			ZombieController.spawnMultiplier++;
			if(ZombieController.spawnTime < 10000 || GameView.timeRepaintWalk < 200)
			{
				ZombieController.spawnTime += (1000 * ZombieController.spawnMultiplier);
				GameView.timeRepaintWalk += (10 * ZombieController.spawnMultiplier);
			}
		}
		else
		{
			// Diminuisce tempo ad ogni spawn
			if(ZombieController.spawnTime > 7000)
				ZombieController.spawnTime -= 1000;
			
			// Aumenta velocità del gioco
			if(GameView.timeRepaintWalk > 100)
				GameView.timeRepaintWalk -= 10;
		}
	}
	
	
	public static void setLevel(int level)
	{
		GameLevel.level = 1;
		GameScoreModel.setScore(0);
		ZombieController.spawnMultiplier = 1;
		ZombieController.spawnTime = 10000;
		GameView.timeRepaintWalk = 200;
		
		System.out.println("Livello " + GameLevel.level);
		
		ZombieController.zombiesToSpawn = zombieStartNumber;
		for(int i = 2; i<=level; i++)
		{
			setNewLevel();
		}
	}
}