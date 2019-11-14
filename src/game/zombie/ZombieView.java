package game.zombie;

import game.window.GameWindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * La classe game.zombie.ZombieView ha la funzione di:
 * disegnare uno Zombie.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class ZombieView
{
	private int x, y;
	private int lifePercentage;
	private boolean run;
	// dimensioni costanti
	private final int DIM5 = (int) (5*GameWindow.scalingFactor);
	private final int DIM10 = (int) (10*GameWindow.scalingFactor);
	private final int DIM15 = (int) (15*GameWindow.scalingFactor);
	private final int DIM25 = (int) (25*GameWindow.scalingFactor);
	private final int DIM35 = (int) (35*GameWindow.scalingFactor);
	private final int DIM40 = (int) (40*GameWindow.scalingFactor);
	private final int DIM120 = (int) (120*GameWindow.scalingFactor);
	private int DIM1LIFE;
	
	/**
	 * Ha la funzione di:
	 * settare le coordinate passate per parametro.
	 * @param coordinates
	 */
	protected void setCoordinates(Point coordinates) 
	{
		this.x = coordinates.x;
		this.y = coordinates.y;
	}
	/**
	 * Ha la funzione di:
	 * settare la variabile run con la variabile passata per parametro.
	 * @param run
	 */
	protected void setRun(boolean run)
	{
		this.run = run;
	}
	/**
	 * Ha la funzione di:
	 * settare la variabile lifePercentage con la variabile passata per parametro.
	 * @param lifePercentage
	 */
	protected void setLifePercentage(int lifePercentage)
	{
		this.lifePercentage = lifePercentage;
	}
	
	public void paint(Graphics g)
	{	
		DIM1LIFE = (int) (lifePercentage*GameWindow.scalingFactor/2);
		
		if(x < GameWindow.windowDimension.getWidth()/2)
		{
			// vita
			g.setColor(Color.black);
			g.fillRect(-DIM15+x, -DIM15-DIM120+y, DIM25*2, DIM10);
			g.setColor(Color.green);
			g.fillRect(-DIM15+x, -DIM15-DIM120+y, DIM1LIFE, DIM10);
			g.setColor(Color.black);
			g.drawRect(-DIM15+x, -DIM15-DIM120+y, DIM25*2, DIM10);
			if(run)
			{
				// gamba 2 piano
				g.setColor(Color.green);
				g.fillOval(-DIM10+x,-DIM40+y, DIM10*2, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM10+x,-DIM40+y, DIM10*2, DIM40);
				// scarpa 2 piano
				g.setColor(Color.DARK_GRAY);
				g.fillOval(-DIM5+x,-DIM5+y, DIM10*2, DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM5+x,-DIM5+y, DIM10*2, DIM10);
				// braccio 2 piano
				g.setColor(Color.green);
				g.fillOval(x,-DIM40*2+y, DIM25+DIM10, DIM15);
				g.setColor(Color.black);
				g.drawOval(x,-DIM40*2+y, DIM25+DIM10, DIM15);
			}
			else
			{
				// gamba 2 piano
				g.setColor(Color.green);
				g.fillOval(DIM5+x,-DIM40+y, DIM10*2, DIM40);
				g.setColor(Color.black);
				g.drawOval(DIM5+x,-DIM40+y, DIM10*2, DIM40);
				// braccio 2 piano
				g.setColor(Color.green);
				g.fillOval(DIM5+x,-DIM40*2+y, DIM25+DIM10, DIM15);
				g.setColor(Color.black);
				g.drawOval(DIM5+x,-DIM40*2+y, DIM25+DIM10, DIM15);
			}
			// corpo
			g.setColor(Color.blue);
			g.fillOval(-DIM10*2+x,-DIM35*2-DIM10*2+y, DIM40, DIM35*2+DIM5);
			g.setColor(Color.black);
			g.drawOval(-DIM10*2+x,-DIM35*2-DIM10*2+y, DIM40, DIM35*2+DIM5);
			if(run)
			{
				// gamba 1 piano
				g.setColor(Color.green);
				g.fillOval(x,-DIM35+y, DIM10*2, DIM40);
				g.setColor(Color.black);
				g.drawOval(x,-DIM35+y, DIM10*2, DIM40);
				// braccio 1 piano
				if(lifePercentage > 50)
				{
					g.setColor(Color.green);
					g.fillOval(DIM5+x,-DIM25*3+y, DIM25+DIM10, DIM15);
					g.setColor(Color.black);
					g.drawOval(DIM5+x,-DIM25*3+y, DIM25+DIM10, DIM15);
				}
				else
				{
					g.setColor(Color.red);
					g.fillOval(DIM5+x,-DIM25*3+DIM5/2+y, DIM10, DIM10);
				}
				// scarpa 1 piano
				g.setColor(Color.darkGray);
				g.fillOval(DIM5+x,y, DIM10*2, DIM10);
				g.setColor(Color.black);
				g.drawOval(DIM5+x,y, DIM10*2, DIM10);
			}
			else
			{
				// scarpa 1 piano
				g.setColor(Color.darkGray);
				g.fillOval(DIM10+x,-DIM5+y, DIM10*2, DIM10);
				g.setColor(Color.black);
				g.drawOval(DIM10+x,-DIM5+y, DIM10*2, DIM10);
				// gamba 1 piano
				g.setColor(Color.green);
				g.fillOval(-DIM10+x,-DIM35+y, DIM10*2, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM10+x,-DIM35+y, DIM10*2, DIM40);
				// scarpa 1 piano
				g.setColor(Color.darkGray);
				g.fillOval(-DIM5+x,y, DIM10*2, DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM5+x,y, DIM10*2, DIM10);
				// braccio 1 piano
				if(lifePercentage > 50)
				{
					g.setColor(Color.green);
					g.fillOval(x,-DIM25*3+y, DIM25+DIM10, DIM15);
					g.setColor(Color.black);
					g.drawOval(x,-DIM25*3+y, DIM25+DIM10, DIM15);
				}
				else
				{
					g.setColor(Color.red);
					g.fillOval(DIM5/2+x,-DIM25*3+y, DIM10, DIM10);
				}
			}
			if(lifePercentage > 10)
			{
				// testa
				g.setColor(Color.green);
				g.fillOval(-DIM10+x,-DIM120+y, DIM40, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM10+x,-DIM120+y, DIM40, DIM40);
				g.setColor(Color.black);
				// bocca
				g.fillArc(-DIM5+x,-DIM120+DIM15+y, DIM25, DIM15*2, -20,20);
				g.setColor(Color.red);
				g.drawArc(-DIM5+x,-DIM120+DIM15+y, DIM25, DIM15*2, -20,20);
				g.setColor(Color.yellow);
				// occhio
				g.fillOval(DIM15+x,-DIM120+DIM10+y, DIM10, DIM15);
				g.setColor(Color.red);
				g.drawOval(DIM15+x,-DIM120+DIM10+y, DIM10, DIM15);
				g.setColor(Color.black);
				g.fillOval(DIM10*2+x,-DIM120+DIM15+y, DIM15-DIM10, DIM15-DIM10);
			}
			else
			{
				g.setColor(Color.red);
				g.fillOval(-DIM15/2+x,-DIM120+DIM15*2+y, DIM15, DIM10);
			}
		}
		else
		{
			// vita
			g.setColor(Color.black);
			g.fillRect(-DIM35+x, -DIM15-DIM120+y, DIM25*2, DIM10);
			g.setColor(Color.green);
			g.fillRect(-DIM35+x, -DIM15-DIM120+y, DIM1LIFE, DIM10);
			g.setColor(Color.black);
			g.drawRect(-DIM35+x, -DIM15-DIM120+y, DIM25*2, DIM10);
			if(run)
			{
				// gamba 2 piano
				g.setColor(Color.green);
				g.fillOval(-DIM10+x,-DIM40+y, DIM10*2, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM10+x,-DIM40+y, DIM10*2, DIM40);
				// scarpa 2 piano
				g.setColor(Color.darkGray);
				g.fillOval(-DIM15+x,-DIM5+y, DIM10*2, DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM15+x,-DIM5+y, DIM10*2, DIM10);
				// braccio  2 piano
				g.setColor(Color.green);
				g.fillOval(-DIM35+x,-DIM40*2+y, DIM25+DIM10, DIM15);
				g.setColor(Color.black);
				g.drawOval(-DIM35+x,-DIM40*2+y, DIM25+DIM10, DIM15);
			}
			else
			{
				// gamba 2 piano
				g.setColor(Color.green);
				g.fillOval(-DIM25+x,-DIM40+y, DIM10*2, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM25+x,-DIM40+y, DIM10*2, DIM40);
				// braccio  2 piano
				g.setColor(Color.green);
				g.fillOval(-DIM40+x,-DIM40*2+y, DIM25+DIM10, DIM15);
				g.setColor(Color.black);
				g.drawOval(-DIM40+x,-DIM40*2+y, DIM25+DIM10, DIM15);
			}
			// corpo
			g.setColor(Color.blue);
			g.fillOval(-DIM10*2+x,-DIM35*2-DIM10*2+y, DIM40, DIM35*2+DIM5);
			g.setColor(Color.black);
			g.drawOval(-DIM10*2+x,-DIM35*2-DIM10*2+y, DIM40, DIM35*2+DIM5);
			if(run)
			{
				// gamba 1 piano
				g.setColor(Color.green);
				g.fillOval(-DIM10*2+x,-DIM35+y, DIM10*2, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM10*2+x,-DIM35+y, DIM10*2, DIM40);
				if(lifePercentage > 50)
				{
					// braccio  1 piano
					g.setColor(Color.green);
					g.fillOval(-DIM40+x,-DIM35*2+y, DIM35, DIM15);
					g.setColor(Color.black);
					g.drawOval(-DIM40+x, -DIM35*2+y, DIM35, DIM15);
				}
				else
				{
					g.setColor(Color.red);
					g.fillOval(-DIM5+x, -DIM35*2+DIM5/2+y, DIM10, DIM10);
				}
				// scarpa 1 piano
				g.setColor(Color.darkGray);
				g.fillOval(-DIM25+x,y, DIM10*2, DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM25+x,+y, DIM10*2, DIM10);
			}
			else
			{
				// scarpa 2 piano
				g.setColor(Color.DARK_GRAY);
				g.fillOval(-DIM15*2+x,-DIM5+y, DIM10*2, DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM15*2+x,-DIM5+y, DIM10*2, DIM10);
				// gamba 1 piano
				g.setColor(Color.green);
				g.fillOval(-DIM10+x,-DIM35+y, DIM10*2, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM10+x,-DIM35+y, DIM10*2, DIM40);
				// scarpa 1 piano
				g.setColor(Color.DARK_GRAY);
				g.fillOval(-DIM15+x,y, DIM10*2, DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM15+x,y, DIM10*2, DIM10);
				if(lifePercentage > 50)
				{
					// braccio  1 piano
					g.setColor(Color.green);
					g.fillOval(-DIM35+x, -DIM35*2+y, DIM35, DIM15);
					g.setColor(Color.black);
					g.drawOval(-DIM35+x, -DIM35*2+y, DIM35, DIM15);
				}
				else
				{
					g.setColor(Color.red);
					g.fillOval(x, -DIM35*2+DIM5/2+y, DIM10, DIM10);
				}
			}
			if(lifePercentage > 10)
			{
				// testa
				g.setColor(Color.green);
				g.fillOval(-DIM15*2+x,-DIM120+y, DIM40, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM15*2+x,-DIM120+y, DIM40, DIM40);
				// bocca
				g.setColor(Color.black);
				g.fillArc(-DIM10*2+x,DIM15-DIM120+y, DIM25, DIM15*2, 180, 20);					
				g.setColor(Color.red);
				g.drawArc(-DIM10*2+x,DIM15-DIM120+y, DIM25, DIM15*2, 180, 20);
				// occhio
				g.setColor(Color.yellow);
				g.fillOval(-DIM25+x,DIM10-DIM120+y, DIM10, DIM15);
				g.setColor(Color.red);
				g.drawOval(-DIM25+x,DIM10-DIM120+y, DIM10, DIM15);
				g.setColor(Color.black);
				g.fillOval(-DIM25+x,DIM15-DIM120+y, DIM15-DIM10, DIM15-DIM10);	// occhio
			}
			else
			{
				g.setColor(Color.red);
				g.fillOval(-DIM15/2+x,-DIM120+DIM15*2+y, DIM15, DIM10);
			}
		}
	}
}
