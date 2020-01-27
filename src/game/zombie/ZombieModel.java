package game.zombie;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 * 
 * Contiene la posizione e i valori per la gestione grafica di uno Zombie
 * @author 20025270
 * @version 1.0
 *
 */
public class ZombieModel
{
	private int lifeStart, power, speed;
	private int life;
	private Point coordinates;
	private boolean run;
	private ZombieView view;

	public ZombieModel(ZombieType type, Dimension spawnArea, Double scalingFactor)
	{
		switch (type)
		{
			case Normal:
				lifeStart = 100;
				power = 5;
				speed = (int) (15 * scalingFactor);
				view = new ZombieViewNormal(spawnArea.width/2, scalingFactor);
			default:
				break;
		}

		Random rand = new Random();
		coordinates = new Point(rand.nextInt(spawnArea.width), spawnArea.height);
		life = lifeStart;
	}
	
	/**
	 * Setta la variabile run con la variabile passata per parametro.
	 * @param runvalue
	 */
	public void run(boolean runvalue)
	{
		run = runvalue;
	}
	
	/**
	 * Muove lo zombie sull'asse Y verso l'alto
	 */
	public void up()
	{
		coordinates.y -= speed;
	}
	
	/**
	 * Muove lo zombie sull'asse X verso destra
	 */
	public void right()
	{
		coordinates.x += speed;
	}
	
	/**
	 * Muove lo zombie sull'asse X verso sinistra
	 */
	public void left()
	{
		coordinates.x -= speed;
	}

	/**
	 * Rstituisce la variabile coordinates.
	 * @return coordinates
	 */
	public Point getCoordinates()
	{
		return coordinates;
	}
	
	public int getPower()
	{
		return power;
	}
	
	/**
	 * Restituisce la variabile life
	 * @return life
	 */
	public int getLife()
	{
		return life;
	}
	
	/**
	 * Decrementa la vita in base al danno subito
	 * @param damage
	 */
	public int decreaseLife(int damage)
	{
		life -= damage;
		return life;
	}
	
	/**
	 * Disegna lo zombie
	 */
	public void paintView(Graphics g)
	{
		view.paint(g, life*(100/lifeStart), coordinates, run);
	}
}