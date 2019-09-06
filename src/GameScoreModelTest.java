import static org.junit.Assert.*;

import org.junit.Test;

public class GameScoreModelTest {

	@Test
	public void addScoreLevelTest() 
	{
		assertEquals(0, GameScoreModel.getScore());
		
		GameScoreModel.addScoreHit();
		assertEquals(10, GameScoreModel.getScore());
		
		GameScoreModel.setScore(50);
		assertEquals(50, GameScoreModel.getScore());

		GameScoreModel.addScoreLevel(1);
		assertEquals(150, GameScoreModel.getScore());
	}

}
