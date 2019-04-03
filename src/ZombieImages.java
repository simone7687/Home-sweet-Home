import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * La classe ZombieImages ha la funzione di:
 * disegnare uno Zombie.
 * @author 20024652
 * @version 1.0
 *
 */
public class ZombieImages 																																	// aggiungere barra con la vita
{
	private int x, y;
	private boolean run;
	// dimensioni costanti
	private final int DIM5 = (int) (5*GameWindows.dimension);
	private final int DIM10 = (int) (10*GameWindows.dimension);
	private final int DIM15 = (int) (15*GameWindows.dimension);
	private final int DIM25 = (int) (25*GameWindows.dimension);
	private final int DIM35 = (int) (35*GameWindows.dimension);
	private final int DIM40 = (int) (40*GameWindows.dimension);
	private final int DIM120 = (int) (120*GameWindows.dimension);
	
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
	
	public void paint(Graphics g)
	{	
		if(x < GameWindows.windowDimension.getWidth()/2)
		{
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
				g.setColor(Color.green);
				g.fillOval(DIM5+x,-DIM25*3+y, DIM25+DIM10, DIM15);
				g.setColor(Color.black);
				g.drawOval(DIM5+x,-DIM25*3+y, DIM25+DIM10, DIM15);
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
				g.setColor(Color.green);
				g.fillOval(x,-DIM25*3+y, DIM25+DIM10, DIM15);
				g.setColor(Color.black);
				g.drawOval(x,-DIM25*3+y, DIM25+DIM10, DIM15);
			}
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
				// braccio  1 piano
				g.setColor(Color.green);
				g.fillOval(-DIM40+x,-DIM35*2+y, DIM25+DIM10, DIM15);
				g.setColor(Color.black);
				g.drawOval(-DIM40+x,-DIM35*2+y, DIM25+DIM10, DIM15);
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
				// Braccio
				g.setColor(Color.green);
				g.fillOval(-DIM35+x,-DIM35*2+y, DIM25+DIM10, DIM15);
				g.setColor(Color.black);
				g.drawOval(-DIM35+x,-DIM35*2+y, DIM25+DIM10, DIM15);
			}
			// Testa
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
	}
}
