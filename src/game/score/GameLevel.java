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
	//private static int levelSpawnMultiplier = 2;	// Ad ogni levelSpawnMultiplier aggiunge uno zombie
	private static int zombieStartNumber = 2;
	
	public GameLevel()
	{
		System.out.println("Livello " + level);
		
		ZombieController.zombiesToSpawn = zombieStartNumber;
		ZombieController.thread.start();
	}
	
	/*
	public GameLevel(int level)
	{
		System.out.println("Livello " + GameLevel.level);
		
		ZombieController.zombiesToSpawn = zombieStartNumber;
		for(int i = 2; i <= level; i++)
			levelUp();
		
		ZombieController.thread.start();
	}
	*/
	
	/**
	 * Aumenta il livello di difficoltà del gioco. Diminuisce il tempo necessario 
	 * allo spawn degli zombie e aumenta il numero degli stessi ad ogni successivo 
	 * livello e spawn.
	 */
	public static void levelUp()
	{
		GameScoreModel.addScoreLevel(level);
		
		level++;
		System.out.println("Livello " + level);
		// Aumenta zombie in base al livello
		ZombieController.zombiesToSpawn += 1 + Math.floor(ZombieController.zombiesToSpawn * 1/4);
		System.out.println("Zombie to spawn " + ZombieController.zombiesToSpawn);
		
		// Aumenta zombie ad agni spawn
		/*
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
		*/
			// Diminuisce tempo ad ogni spawn
			
		//if(ZombieController.spawnTime > 7000)
				ZombieController.spawnTime -= 500;
			
			// Aumenta velocità del gioco
			//if(GameView.timeRepaintWalk > 100)
				GameView.timeRepaintWalk -= 10;
		//}
	}
	
	
	public static void resetLevel()
	{
		GameLevel.level = 1;
		GameScoreModel.setScore(0);
		//ZombieController.spawnMultiplier = 1;
		ZombieController.spawnTime = 10000;
		GameView.timeRepaintWalk = 200;
		
		System.out.println("Livello " + GameLevel.level);
		
		/*
		ZombieController.zombiesToSpawn = zombieStartNumber;
		for(int i = 2; i<=level; i++)
		{
			levelUp();
		}
		*/
	}
}