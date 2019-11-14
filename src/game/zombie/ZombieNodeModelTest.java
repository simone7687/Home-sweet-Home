package game.zombie;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZombieNodeModelTest 
{
	@Test
	public void testCoordinates() 
	{
		ZombieNodeModel zombie = new ZombieNodeModel(500);

		assertNotNull(zombie.getCoordinates());
	}
	
	@Test
	public void testLife() 
	{
		ZombieNodeModel zombie = new ZombieNodeModel(500);

		assertNotNull(zombie.getLife());
		
		assertEquals(100, zombie.getLife());
		
		zombie.decreaseLife(5);
		assertEquals(95, zombie.getLife());	
	}
}
