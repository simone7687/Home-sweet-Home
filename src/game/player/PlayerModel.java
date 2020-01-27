package game.player;

import java.awt.*;

/**
 * 
 * La classe game.player.PlayerModel ha la funzione di:
 * contenere le variabili del Player.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class PlayerModel
{
	static final int START_LIFE = 100;
	private static String playerName;

	private Point coordinates = new Point();
	private int speed = 30;
	// Forza attacco
	private int attackPower = 10;
    
	PlayerModel(Point coordinates, int scalingFactor)
	{
		speed = (int) (speed * scalingFactor);
		this.coordinates = coordinates;
	}

	/**
	 * Restituisce il nome del giocatore
	 */
	public static String getPlayerName()
    {
    	return PlayerModel.playerName;
    }

	/**
	 * Salva il nome del giocatore
	 * @param il nome da salvare
	 */
	public static void setPlayerName(String name)
    {
    	PlayerModel.playerName = name;
    }

	/**
	 * Sposta il Player a destra in base alla sua velocità controllando se ha
	 * raggiunto il limite della finestra
	 */
	void moveRight(int width)
	{
		if (width > coordinates.x + speed)
			coordinates.x += speed;
	}

	/**
	 * Sposta il Player a sinistra in base alla sua velocità controllando se ha
	 * raggiunto il limite della finestra
	 */
    void moveLeft(int width)
    {
		if (width < coordinates.x - speed)
			coordinates.x -= speed;
    }

	/**
	 * Sposta il Player in alto in base alla sua velocità controllando se ha
	 * raggiunto il limite della finestra
	 */
    void moveUp(int height)
    {
		if (height < coordinates.y - speed)
			coordinates.y -= speed;
    }

	/**
	 * Sposta il Player in basso in base alla sua velocità controllando se ha
	 * raggiunto il limite della finestra
	 */
    void moveDown(int height)
    {
		if (height > coordinates.y + speed)
			coordinates.y += speed;
	}

	/**
	 * Restituisce le coordinate del player
	 * @return coordinates
	 */
    Point getCoordinates()
	{
	    return coordinates;
    }

	/**
	 * Restituisce la forza dell'attacco
	 * @return power
	 */
    int getPower()
    {
        return attackPower;
    }

	/**
	 * Restituisce la velocità
	 * @return speed
	 */
    int getSpeed()
    {
        return speed;
    }
}
