package game.score;

import game.GameView;
import game.zombie.ZombieController;

/**
 * 
 * Gestisce il passaggio del gioco ad un nuovo livello.
 * @author 20025270
 * @version 1.0
 *
 */
public class GameLevel
{
	public static int level = 1;
	private static int levelSpawnMultiplier = 3;	// Ad ogni levelSpawnMultiplier aggiunge un zombie
	private static int zombieStartNumber = 3;
	
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
			levelUp();
		
		ZombieController.thread.start();
	}
	
	/**
	 * Aumenta il livello di difficolt� del gioco. Diminuisce il tempo necessario 
	 * allo spawn degli zombie e aumenta il numero degli stessi ad ogni successivo 
	 * livello e spawn.
	 */
	public static void levelUp()
	{
		GameScoreModel.addScoreLevel(level);
		
		level++;
		System.out.println("Livello " + level);
		// Aumenta zombie
		ZombieController.zombiesToSpawn += 1 + Math.floor(zombieStartNumber * 1/4);
		// Aumenta zombie ad agni spawn
		if(level % levelSpawnMultiplier == 0)
		{
			ZombieController.zombiesSpawnMultiplier++;
			if(ZombieController.spawnTime < 10000 || GameView.timeRepaintWalk < 200)
			{
				ZombieController.spawnTime += (1000 * ZombieController.zombiesSpawnMultiplier);
				GameView.timeRepaintWalk += (10 * ZombieController.zombiesSpawnMultiplier);
			}
		}
		else
		{
			// Diminuisce tempo ad ogni spawn
			if(ZombieController.spawnTime > 7000)
				ZombieController.spawnTime -= 1000;
			
			// Aumenta velocit� del gioco
			if(GameView.timeRepaintWalk > 100)
				GameView.timeRepaintWalk -= 10;
		}
	}
	
	
	public static void setLevel(int level)
	{
		GameLevel.level = 1;
		GameScoreModel.setScore(0);
		ZombieController.zombiesSpawnMultiplier = 1;
		ZombieController.spawnTime = 10000;
		GameView.timeRepaintWalk = 200;
		
		System.out.println("Livello " + GameLevel.level);
		
		ZombieController.zombiesToSpawn = zombieStartNumber;
		for(int i = 2; i<=level; i++)
		{
			levelUp();
		}
	}
}