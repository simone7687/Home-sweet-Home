import static org.junit.Assert.*;

import org.junit.Test;

public class ZombieNodeModelTest 
{
	ZombieNodeModel zombie = new ZombieNodeModel();

	@Test
	public void testCoordinates() 
	{
		assertNotNull(zombie.getCoordinates());
	}
	
	@Test
	public void testLife() 
	{
		assertNotNull(zombie.getLife());
		
		assertEquals(100, zombie.getLife());
		
		zombie.decreaseLife(5);
		assertEquals(95, zombie.getLife());
		
	}

}
