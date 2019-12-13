package game.zombie;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 * 
 * La classe game.zombie.ZombieNodeModel e' un nodo che contiene:
 * la posizione e i valori per la gestione grafica di uno Zombie.
 * @author 20024652 - 20025270
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
				// TODO: segnale di errore
		}

		Random rand = new Random();
		coordinates = new Point(rand.nextInt(spawnArea.width), spawnArea.height);
		life = lifeStart;
	}
	
	/**
	 * Ha la funzione di:
	 * settare la variabile run con la variabile passata per parametro.
	 * @param runvalue
	 */
	public void run(boolean runvalue)
	{
		run = runvalue;
	}
	/**
	 * TODO:javadoc
	 */
	public void up()
	{
		coordinates.y -= speed;
	}
	/**
	 * TODO:javadoc
	 */
	public void right()
	{
		coordinates.x += speed;
	}
	/**
	 * TODO:javadoc
	 */
	public void left()
	{
		coordinates.x -= speed;
	}

	/**
	 * Ha la funzione di:
	 * restituire la variabile coordinates.
	 * @return coordinates
	 */
	public Point getCoordinates()
	{
		return coordinates;
	}
	/**
	 * TODO:javadoc
	 * @return
	 */
	public int getPower()
	{
		return power;
	}
	/**
	 * Ha la funzione di:
	 * restituire la variabile life.
	 * @return life
	 */
	public int getLife()
	{
		return life;
	}
	
	/**
	 * Il metodo decreaseLife ha la funzione di:
	 * sottrarre alla vita il danno.
	 * @param damage
	 */
	public int decreaseLife(int damage)
	{
		life -= damage;
		return life;
	}
	
	/**
	 * //TODO: javadoc
	 */
	public void paintView(Graphics g)
	{
		view.paint(g, life*(100/lifeStart), coordinates, run);
	}
}