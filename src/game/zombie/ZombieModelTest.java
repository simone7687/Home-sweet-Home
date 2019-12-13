package game.zombie;

import static org.junit.Assert.*;

import java.awt.Dimension;
import org.junit.Test;

public class ZombieModelTest
{
	@Test
	public void testCoordinates()
	{
		ZombieModel zombie = new ZombieModel(ZombieType.Normal, new Dimension(500,500), 1.0);

		assertNotNull(zombie.getCoordinates());
	}
	
	@Test
	public void testLife()
	{
		ZombieModel zombie = new ZombieModel(ZombieType.Normal, new Dimension(500,500), 1.0);

		assertNotNull(zombie.getLife());
		
		assertEquals(100, zombie.getLife());
		
		zombie.decreaseLife(5);
		assertEquals(95, zombie.getLife());
	}
}
