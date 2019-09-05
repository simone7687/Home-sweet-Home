import java.awt.Point;

public class PlayerModel
{
	static final int START_LIFE = 100;
	static String name;
	// corri
	private Point coordinates = new Point((GameWindow.windowDimension.width / 2), (int) (GameWindow.windowDimension.height / 2));
	private int speed = (int) (30 * GameWindow.scalingFactor);
	private boolean left, up, down;
	// attacco
	private int power = 10;

	void setLeft(boolean left)
	{
		this.left = left;
	}

	void setUp(boolean up)
	{
		this.up = up;
	}

	void setDown(boolean down)
	{
		this.down = down;
	}
    
    void setCoordinatesDx()
    {
        coordinates.x += speed;
    }

    void setCoordinatesSx()
    {
        coordinates.x -= speed;
    }

    void setCoordinatesUp()
    {
        coordinates.y += speed;
    }

    void setCoordinatesDown()
    {
        coordinates.y -= speed;
	}

    Point getCoordinates()
	{
	    return coordinates;
    }

    int getSpeed()
	{
	    return speed;
    }

    boolean getDown()
    {
        return down;
    }

    boolean getLeft()
    {
        return left;
    }

    boolean getUp()
    {
        return up;
    }

    int getPower()
    {
        return power;
    }
}
