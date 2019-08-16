/**
 * 
 * La classe GameLevels ha la funzione di:
 * gestire il passaggio del gioco ad un nuovo livello.
 * @author 20024652
 * @version 1.0
 *
 */
public class GameLevels
{
	static int level = 1;
	private static int levelSpawnMultiplier = 6;	// ogni levelSpawnMultiplier aggiunge un zombie in ogni spawn
	private static int zombieStartNumber = 6;
	
	GameLevels()
	{
		System.out.println("Livelli " + level);
		
		Zombies.zombieSpawnNumber = zombieStartNumber;
		Zombies.thread.start();
	}
	GameLevels(int livel)
	{
		System.out.println("Livelli " + GameLevels.level);
		
		Zombies.zombieSpawnNumber = zombieStartNumber;
		for(int i = 2; i<=livel; i++)
		{
			setNewLevel();
		}
		Zombies.thread.start();
	}
	
	/**
	 * Il metodo setNewLevel ha la funzione di:
	 * aumentare il gioco di un livello con
	 * la diminuzione di tempo necessario a spawnare gli Zombie e
	 * l'aumento del numero di zombie spawnati ad ogni livello e ad ogni spawn.
	 */
	public static void setNewLevel()
	{
		GameScore.addScoreLevel(level);
		
		level++;
		System.out.println("Livelli " + level);
		// aumenta zombie
		Zombies.zombieSpawnNumber += (int) (zombieStartNumber*1/4);
		// aumenta zombie ad agni spawn
		if(level%levelSpawnMultiplier == 0)
		{
			Zombies.n_zombie_spawn_multiplier++;
			if(Zombies.spawnTime < 10000 || GameImages.timeRepaintWalk < 200)
			{
				Zombies.spawnTime += (1000*Zombies.n_zombie_spawn_multiplier);
				GameImages.timeRepaintWalk += (10*Zombies.n_zombie_spawn_multiplier);
			}
		}
		else
		{
			// diminuisce tempo ad ogni spawn
			if(Zombies.spawnTime > 7000)
			{
				Zombies.spawnTime -= 1000;
			}
			// aumenta velocità del gioco
			if(GameImages.timeRepaintWalk > 100)
			{
				GameImages.timeRepaintWalk -= 10;
			}
		}
	}
	public static void setLevel(int level)
	{
		GameScore.score = 0;
		Zombies.n_zombie_spawn_multiplier = 1;
		Zombies.spawnTime = 10000;
		GameImages.timeRepaintWalk = 200;
		
		System.out.println("Livello " + GameLevels.level);
		
		Zombies.zombieSpawnNumber = zombieStartNumber;
		for(int i = 2; i<=level; i++)
		{
			setNewLevel();
		}
	}
}