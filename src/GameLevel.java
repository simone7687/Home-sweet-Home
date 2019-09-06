/**
 * 
 * La classe GameLevel ha la funzione di:
 * gestire il passaggio del gioco ad un nuovo livello.
 * @author 20024652
 * @version 1.0
 *
 */
public class GameLevel
{
	static int level = 1;
	private static int levelSpawnMultiplier = 6;	// ogni levelSpawnMultiplier aggiunge un zombie in ogni spawn
	private static int zombieStartNumber = 6;
	
	GameLevel()
	{
		System.out.println("Livello " + level);
		
		ZombiesController.zombieSpawnNumber = zombieStartNumber;
		ZombiesController.thread.start();
	}
	
	GameLevel(int level)
	{
		System.out.println("Livello " + GameLevel.level);
		
		ZombiesController.zombieSpawnNumber = zombieStartNumber;
		for(int i = 2; i<=level; i++)
		{
			setNewLevel();
		}
		ZombiesController.thread.start();
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
		ZombiesController.zombieSpawnNumber += (int) (zombieStartNumber*1/4);
		// aumenta zombie ad agni spawn
		if(level%levelSpawnMultiplier == 0)
		{
			ZombiesController.n_zombie_spawn_multiplier++;
			if(ZombiesController.spawnTime < 10000 || GameView.timeRepaintWalk < 200)
			{
				ZombiesController.spawnTime += (1000 * ZombiesController.n_zombie_spawn_multiplier);
				GameView.timeRepaintWalk += (10 * ZombiesController.n_zombie_spawn_multiplier);
			}
		}
		else
		{
			// diminuisce tempo ad ogni spawn
			if(ZombiesController.spawnTime > 7000)
			{
				ZombiesController.spawnTime -= 1000;
			}
			// aumenta velocità del gioco
			if(GameView.timeRepaintWalk > 100)
			{
				GameView.timeRepaintWalk -= 10;
			}
		}
	}
	
	/**
	 * Ha la funzione di:
	 * impostare il livello in base alla variabile passata per parametro.
	 * @param down
	 */
	public static void setLevel(int level)
	{
		GameLevel.level = 1;
		GameScoreModel.setScore(0);
		ZombiesController.n_zombie_spawn_multiplier = 1;
		ZombiesController.spawnTime = 10000;
		GameView.timeRepaintWalk = 200;
		
		System.out.println("Livello " + GameLevel.level);
		
		ZombiesController.zombieSpawnNumber = zombieStartNumber;
		for(int i = 2; i<=level; i++)
		{
			setNewLevel();
		}
	}
}