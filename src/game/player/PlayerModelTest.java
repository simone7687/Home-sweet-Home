package game.player;

import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class PlayerModelTest 
{
    @Test
	public void testMovement() 
	{
        Point coordinates = new Point(500, 500);
        
        PlayerModel player = new PlayerModel(coordinates, 1);

        assertNotNull(player.getCoordinates());

        assertNotNull(player.getSpeed());

        player.moveRight(0);

        assertEquals(coordinates.x, player.getCoordinates().x);

        player.moveLeft(coordinates.x);

        assertEquals(coordinates.x, player.getCoordinates().x);

        player.moveUp(coordinates.y);

        assertEquals(coordinates.y, player.getCoordinates().x);

        player.moveDown(coordinates.y);

        assertEquals(coordinates.y, player.getCoordinates().x);
    }
}
