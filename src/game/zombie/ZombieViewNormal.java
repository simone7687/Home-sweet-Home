package game.zombie;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * Disegna uno Zombie
 * @author 20025270
 * @version 1.0
 *
 */
public class ZombieViewNormal implements ZombieView
{
	private Double scalingFactor = 1.0;
	private int xTargetCenter;
	
	// Dimensioni costanti
	private int DIM5 = (int) (5*scalingFactor);
	private int DIM10 = (int) (10*scalingFactor);
	private int DIM15 = (int) (15*scalingFactor);
	private int DIM25 = (int) (25*scalingFactor);
	private int DIM35 = (int) (35*scalingFactor);
	private int DIM40 = (int) (40*scalingFactor);
	private int DIM120 = (int) (120*scalingFactor);

	public ZombieViewNormal(int xTargetCenter)
	{
		this.xTargetCenter = xTargetCenter;
	}
	
	public ZombieViewNormal(int xTargetCenter, Double scalingFactor)
	{
		this.scalingFactor = scalingFactor;
		this.xTargetCenter = xTargetCenter;

		DIM5 = (int) (5 * scalingFactor);
		DIM10 = (int) (10 * scalingFactor);
		DIM15 = (int) (15 * scalingFactor);
		DIM25 = (int) (25 * scalingFactor);
		DIM35 = (int) (35 * scalingFactor);
		DIM40 = (int) (40 * scalingFactor);
		DIM120 = (int) (120 * scalingFactor);
	}

	public void paint(Graphics g, int lifePercentage, Point cordinates, boolean run)
	{
		int dimLife = (int) (lifePercentage*scalingFactor/2);
		int x = cordinates.x;
		int y = cordinates.y;

		if(x < xTargetCenter)
		{
			// Vita
			g.setColor(Color.black);
			g.fillRect(-DIM15+x, -DIM15-DIM120+y, DIM25*2, DIM10);
			g.setColor(Color.green);
			g.fillRect(-DIM15+x, -DIM15-DIM120+y, dimLife, DIM10);
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
			g.fillRect(-DIM35+x, -DIM15-DIM120+y, dimLife, DIM10);
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
