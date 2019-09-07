import java.awt.Point;

public class PlayerModel
{
	static final int START_LIFE = 100;
	static String name;
	// corri
	private Point coordinates = new Point();
	private int speed = 30;
	// attacco
	private int power = 10;
    
	PlayerModel(Point coordinates, int scalingFactor)
	{
		speed = (int) (30 * scalingFactor);
		this.coordinates = coordinates;
	}

	/**
	 * Ha la funzione di:
	 * controllare se il player e' hai confini della finestra e
	 * spostare il Player a destra in base alla sua velocità.
	 */
    void moveRight(int width)
    {
		if (width > coordinates.x + speed)
		{coordinates.x += speed;}
    }

	/**
	 * Ha la funzione di:
	 * controllare se il player e' hai confini della finestra e
	 * spostare il Player a sinistra in base alla sua velocità.
	 */
    void moveLeft(int width)
    {
		if (width < coordinates.x - speed)
		{coordinates.x -= speed;}
    }

	/**
	 * Ha la funzione di:
	 * controllare se il player e' hai confini della finestra e
	 * spostare il Player in alto in base alla sua velocità.
	 */
    void moveUp(int height)
    {
		if (height < coordinates.y - speed)
		{coordinates.y -= speed;}
    }

	/**
	 * Ha la funzione di:
	 * controllare se il player e' hai confini della finestra e
	 * spostare il Player in basso in base alla sua velocità.
	 */
    void moveDown(int height)
    {
		if (height > coordinates.y + speed)
		{coordinates.y += speed;}
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
	 * restituire la variabile power.
	 * @return power
	 */
    int getPower()
    {
        return power;
    }
}
