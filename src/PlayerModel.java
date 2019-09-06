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

	/**
	 * Ha la funzione di:
	 * settare la variabile left con la variabile passata per parametro.
	 * @param left
	 */
	void setLeft(boolean left)
	{
		this.left = left;
	}

	/**
	 * Ha la funzione di:
	 * settare la variabile up con la variabile passata per parametro.
	 * @param up
	 */
	void setUp(boolean up)
	{
		this.up = up;
	}

	/**
	 * Ha la funzione di:
	 * settare la variabile down con la variabile passata per parametro.
	 * @param down
	 */
	void setDown(boolean down)
	{
		this.down = down;
	}
    
	/**
	 * Ha la funzione di:
	 * spostare il Player a destra in base alla sua velocità.
	 */
    void setCoordinatesDx()
    {
        coordinates.x += speed;
    }

	/**
	 * Ha la funzione di:
	 * spostare il Player a sinistra in base alla sua velocità.
	 */
    void setCoordinatesSx()
    {
        coordinates.x -= speed;
    }

	/**
	 * Ha la funzione di:
	 * spostare il Player in alto in base alla sua velocità.
	 */
    void setCoordinatesUp()
    {
        coordinates.y += speed;
    }

	/**
	 * Ha la funzione di:
	 * spostare il Player in basso in base alla sua velocità.
	 */
    void setCoordinatesDown()
    {
        coordinates.y -= speed;
	}

	/**
	 * Ha la funzione di:
	 * restituire la variabile coordinates.
	 * @return coordinates
	 */
    Point getCoordinates()
	{
	    return coordinates;
    }

	/**
	 * Ha la funzione di:
	 * restituire la variabile speed.
	 * @return speed
	 */
    int getSpeed()
	{
	    return speed;
    }

	/**
	 * Ha la funzione di:
	 * restituire la variabile down.
	 * @return down
	 */
    boolean getDown()
    {
        return down;
    }

	/**
	 * Ha la funzione di:
	 * restituire la variabile left.
	 * @return left
	 */
    boolean getLeft()
    {
        return left;
    }

	/**
	 * Ha la funzione di:
	 * restituire la variabile up.
	 * @return up
	 */
    boolean getUp()
    {
        return up;
    }

	/**
	 * Ha la funzione di:
	 * restituire la variabile power.
	 * @return power
	 */
    int getPower()
    {
        return power;
    }
}
