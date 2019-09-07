import java.awt.Point;

public class PlayerModel
{
	static final int START_LIFE = 100;
	static String name;
	// corri
	private Point coordinates = new Point((GameWindow.windowDimension.width / 2), (int) (GameWindow.windowDimension.height / 2));
	private int speed = (int) (30 * GameWindow.scalingFactor);
	// attacco
	private int power = 10;
    
	/**
	 * Ha la funzione di:
	 * controllare se il player e' hai confini della finestra e
	 * spostare il Player a destra in base alla sua velocità.
	 */
    void moveRight()
    {
		if (GameWindow.windowDimension.width > coordinates.x + speed)
		{coordinates.x += speed;}
    }

	/**
	 * Ha la funzione di:
	 * controllare se il player e' hai confini della finestra e
	 * spostare il Player a sinistra in base alla sua velocità.
	 */
    void moveLeft()
    {
		if (0 < coordinates.x - speed)
		{coordinates.x -= speed;}
    }

	/**
	 * Ha la funzione di:
	 * controllare se il player e' hai confini della finestra e
	 * spostare il Player in alto in base alla sua velocità.
	 */
    void moveUp()
    {
		if (BackgroundView.getBorderY() < coordinates.y - speed)
		{coordinates.y -= speed;}
    }

	/**
	 * Ha la funzione di:
	 * controllare se il player e' hai confini della finestra e
	 * spostare il Player in basso in base alla sua velocità.
	 */
    void moveDown()
    {
		if (GameWindow.windowDimension.height > coordinates.y + speed)
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
