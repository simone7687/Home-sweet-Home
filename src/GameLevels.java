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
	private static int levelSpawnMultiplier = 4;		// ogni levelSpawnMultiplier livelli si aggiunge un zombie in ogni spawn
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
		GameScores.addScoreLevel(level);
		
		level++;
		System.out.println("Livelli " + level);
		
		Zombies.zombieSpawnNumber += (int) (zombieStartNumber*1/3);
		if(level%levelSpawnMultiplier == 0)
		{
			Zombies.n_zombie_spawn_multiplier++;
			Zombies.zombieSpawnNumber -= Zombies.zombieSpawnNumber%Zombies.n_zombie_spawn_multiplier*Zombies.n_zombie_spawn_multiplier;
		}
		if(Zombies.spawnTime-200*level+300 > 1000)
		{
			Zombies.spawnTime += -200*level+300;
		}
		else
		{
			Zombies.spawnTime = Zombies.spawnTime*2/3+1000;
		}
	}
}