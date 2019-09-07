import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * La classe PlayerView ha la funzione di:
 * disegnare il Player.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class PlayerView 
{
	private int x, y;
	private boolean right, run, hit, left, up, down;
	// dimensioni costanti
	private final double dimension = GameWindow.scalingFactor;
	private final int DIM5 = (int) (5*dimension);
	private final int DIM10 = (int) (10*dimension);
	private final int DIM15 = (int) (15*dimension);
	private final int DIM25 = (int) (25*dimension);
	private final int DIM35 = (int) (35*dimension);
	private final int DIM40 = (int) (40*dimension);
	private final int DIM130 = (int) (130*dimension);
	
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
	 * settare la variabile right con la variabile passata per parametro.
	 * @param right
	 */
	protected void setRight(boolean right)
	{
		this.right = right;
	}
	/**
	 * Ha la funzione di:
	 * settare la variabile hit con la variabile passata per parametro.
	 * @param hit
	 */
	protected void setHit(boolean hit)
	{
		this.hit = hit;
	}
	/**
	 * Ha la funzione di:
	 * settare la variabile left con la variabile passata per parametro.
	 * @param left
	 */
	protected void setLeft(boolean left)
	{
		this.left = left;
	}
	/**
	 * Ha la funzione di:
	 * settare la variabile up con la variabile passata per parametro.
	 * @param up
	 */
	protected void setUp(boolean up)
	{
		this.up = up;
	}
	/**
	 * Ha la funzione di:
	 * settare la variabile down con la variabile passata per parametro.
	 * @param down
	 */
	protected void setDown(boolean down)
	{
		this.down = down;
	}
	
	/**
	 * Ha la funzione di:
	 * restituire la variabile coordinates.
	 * @return coordinates
	 */
	protected Point getCoordinates() 
	{
		Point coordinates = new Point(this.x, this.y);
		return coordinates;
	}
	/**
	 * Ha la funzione di:
	 * restituire la variabile run.
	 * @return run
	 */
	protected boolean getRun()
	{
		return run;
	}
	/**
	 * Ha la funzione di:
	 * restituire la variabile right.
	 * @return right
	 */
	protected boolean getRight()
	{
		return right;
	}
	/**
	 * Ha la funzione di:
	 * restituire la variabile hit.
	 * @return hit
	 */
	protected boolean getHit()
	{
		return hit;
	}
	/**
	 * Ha la funzione di:
	 * restituire la variabile down.
	 * @return down
	 */
    protected boolean getDown()
    {
        return down;
    }
	/**
	 * Ha la funzione di:
	 * restituire la variabile left.
	 * @return left
	 */
    protected boolean getLeft()
    {
        return left;
    }
	/**
	 * Ha la funzione di:
	 * restituire la variabile up.
	 * @return up
	 */
    protected boolean getUp()
    {
        return up;
	}
	
	public void paint(Graphics g)
	{	
		if(right)
		{
			// gamba 2 piano
			if(run)
			{
				g.setColor(Color.blue);
				g.fillOval(-DIM15*2+x, -DIM25*2+y, DIM40, DIM25);
				g.setColor(Color.black);
				g.drawOval(-DIM15*2+x, -DIM25*2+y, DIM40, DIM25);
			}
			else
			{
				g.setColor(Color.blue);
				g.fillOval(x, -DIM25*2+y, DIM25, DIM40);
				g.setColor(Color.black);
				g.drawOval(x, -DIM25*2+y, DIM25, DIM40);
			}
			// corpo
			g.setColor(Color.red);
			g.fillOval(-DIM25+x, -DIM25*4+y, DIM25*2, DIM40+DIM35);
			g.setColor(Color.black);
			g.drawOval(-DIM25+x, -DIM25*4+y, DIM25*2, DIM40+DIM35);
			if(run)	
			{
				// scarpa 2 piano
				g.setColor(Color.darkGray);
				g.fillOval(-DIM35+x, -DIM40-DIM5+y, DIM10, DIM25);
				g.setColor(Color.black);
				g.drawOval(-DIM35+x, -DIM40-DIM5+y, DIM10, DIM25);
				// gamba 1 piano
				g.setColor(Color.blue);
				g.fillOval(-DIM10+x, -DIM40-DIM5+y, DIM40, DIM25);
				g.setColor(Color.black);
				g.drawOval(-DIM10+x, -DIM40-DIM5+y, DIM40, DIM25);
				// scarpa 1 piano
				g.setColor(Color.darkGray);
				g.fillOval(DIM25+x, -DIM25*2+y, DIM10, DIM25);
				g.setColor(Color.black);
				g.drawOval(DIM25+x, -DIM25*2+y, DIM10, DIM25);
			}
			else
			{
				// scarpa 2 piano
				g.setColor(Color.darkGray);
				g.fillOval(DIM5+x, -DIM15+y, DIM25, DIM10);
				g.setColor(Color.black);
				g.drawOval(DIM5+x, -DIM15+y, DIM25, DIM10);
				// gamba 1 piano
				g.setColor(Color.blue);
				g.fillOval(-DIM10+x, -DIM40-DIM5+y, DIM25, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM10+x, -DIM40-DIM5+y, DIM25, DIM40);
				// scarpa 1 piano
				g.setColor(Color.darkGray);
				g.fillOval(-DIM5+x, -DIM10+y, DIM25, DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM5+x, -DIM10+y, DIM25, DIM10);
			}
			// testa
			g.setColor(Color.pink);
			g.fillOval(-DIM15+x, -DIM130+y, DIM40, DIM40);
			g.setColor(Color.blue);
			g.fillArc(-DIM15+x, -DIM130+y, DIM40, DIM40, 0, 180);			// cappello
			g.setColor(Color.black);
			g.drawOval(-DIM15+x, -DIM130+y, DIM40, DIM40);
			g.setColor(Color.blue);
			g.fillOval(DIM15+x, -DIM130+DIM10+y, DIM25, DIM10);				// aletta cappello
			g.setColor(Color.black);
			g.fillArc(DIM5+x, -DIM130+DIM15+y, DIM15*2, DIM15*2, 180, 30);	// bocca
			g.fillArc(DIM10+x, -DIM130+DIM15+y, DIM10, DIM10, 180, 180);	// occhio
			if(hit)
			{
				// arma
				g.setColor(Color.orange);
				g.fillOval(DIM25+x, DIM5-DIM130+y, DIM10, DIM40+DIM25);
				g.setColor(Color.black);
				g.drawOval(DIM25+x, DIM5-DIM130+y, DIM10, DIM40+DIM25);
				g.setColor(Color.orange);
				g.fillOval(DIM25+x, -DIM35*2+y, DIM10, DIM10);
				g.setColor(Color.black);
				g.fillRect(DIM15+x, DIM5-DIM130+y, DIM35, DIM10*2);			// ascia
				g.drawOval(DIM25+x, -DIM35*2+y, DIM10, DIM10);
				// braccio
				g.setColor(Color.blue);
				g.fillOval(x, -DIM40*2-DIM5+y, DIM35, DIM15);
				g.setColor(Color.black);
				g.drawOval(x, -DIM40*2-DIM5+y, DIM25+DIM10, DIM15);
				g.setColor(Color.pink);
				g.fillOval(DIM10*2+x, -DIM40*2-DIM5+y, DIM15, DIM15);
				g.setColor(Color.black);
				g.drawOval(DIM10*2+x, -DIM40*2-DIM5+y, DIM15, DIM15);
			}
			else
			{
				// arma
				g.setColor(Color.orange);	
				g.fillOval(-DIM15+x, -DIM40-DIM15+y, DIM40+DIM25, DIM10);
				g.setColor(Color.black);	
				g.drawOval(-DIM15+x, -DIM40-DIM15+y, DIM40+DIM25, DIM10);
				g.setColor(Color.orange);	
				g.fillOval(-DIM15+x, -DIM40-DIM15+y, DIM10, DIM10);
				g.setColor(Color.black);	
				g.fillRect(DIM35+x, -DIM40-DIM25+y, DIM10*2, DIM15*2);		// ascia
				g.drawOval(-DIM15+x, -DIM40-DIM15+y, DIM10, DIM10);
				// braccio
				g.setColor(Color.blue);
				g.fillOval(-DIM5+x, -DIM35*2-DIM10+y, DIM15, DIM25+DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM5+x, -DIM35*2-DIM10+y, DIM15, DIM25+DIM10);
				g.setColor(Color.pink);
				g.fillOval(-DIM5+x, -DIM40-DIM15+y, DIM15, DIM15);
				g.setColor(Color.black);
				g.drawOval(-DIM5+x, -DIM40-DIM15+y, DIM15, DIM15);
			}
		}
		else
		{
			// gamba 2 piano
			if(run)
			{
				g.setColor(Color.blue);
				g.fillOval(-DIM15*2+x, -DIM25*2+y, DIM40, DIM25);
				g.setColor(Color.black);
				g.drawOval(-DIM15*2+x, -DIM25*2+y, DIM40, DIM25);
			}
			else
			{
				g.setColor(Color.blue);
				g.fillOval(-DIM25+x, -DIM25*2+y, DIM25, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM25+x, -DIM25*2+y, DIM25, DIM40);
			}
			// corpo
			g.setColor(Color.red);
			g.fillOval(-DIM25+x, -DIM25*4+y, DIM25*2, DIM40+DIM35);
			g.setColor(Color.black);
			g.drawOval(-DIM25+x, -DIM25*4+y, DIM25*2, DIM40+DIM35);
			if(run)
			{
				// scarpa 2 piano
				g.setColor(Color.darkGray);
				g.fillOval(-DIM35+x, -DIM40-DIM15+y, DIM10, DIM25);
				g.setColor(Color.black);
				g.drawOval(-DIM35+x, -DIM40-DIM15+y, DIM10, DIM25);
				// gamba 1 piano
				g.setColor(Color.blue);
				g.fillOval(-DIM10+x, -DIM35-DIM10+y, DIM40, DIM25);
				g.setColor(Color.black);
				g.drawOval(-DIM10+x, -DIM35-DIM10+y, DIM40, DIM25);
				// scarpa 1 piano
				g.setColor(Color.darkGray);
				g.fillOval(DIM25+x, -DIM40+y, DIM10, DIM25);
				g.setColor(Color.black);
				g.drawOval(DIM25+x, -DIM40+y, DIM10, DIM25);
			}
			else
			{
				// scarpa 2 piano
				g.setColor(Color.darkGray);
				g.fillOval(-DIM15*2+x, -DIM15+y, DIM25, DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM15*2+x, -DIM15+y, DIM25, DIM10);
				// gamba 1 piano
				g.setColor(Color.blue);
				g.fillOval(-DIM15+x, -DIM35-DIM10+y, DIM25, DIM40);
				g.setColor(Color.black);
				g.drawOval(-DIM15+x, -DIM35-DIM10+y, DIM25, DIM40);
				// scarpa 1 piano
				g.setColor(Color.darkGray);
				g.fillOval(-DIM10*2+x, -DIM10+y, DIM25, DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM10*2+x, -DIM10+y, DIM25, DIM10);
			}
			// testa
			g.setColor(Color.pink);
			g.fillOval(-DIM25+x, -DIM130+y, DIM40, DIM40);
			g.setColor(Color.blue);
			g.fillArc(-DIM25+x, -DIM130+y, DIM40, DIM40, 0,180);				// cappello
			g.setColor(Color.black);
			g.drawOval(-DIM25+x, -DIM130+y, DIM40, DIM40);
			g.setColor(Color.blue);
			g.fillOval(-DIM35+x, DIM10-DIM130+y, DIM25, DIM10);					// aletta cappello
			g.setColor(Color.black);
			g.fillArc(-DIM35+x, -DIM130+DIM15+y, DIM15*2, DIM15*2, -30, 30);	// bocca
			g.fillArc(-DIM15+x, -DIM130+DIM15+y, DIM10, DIM10, 180, 180);		// occhio
			if(hit)
			{
				// arma
				g.setColor(Color.orange);	
				g.fillOval(-DIM35+x, DIM5-DIM130+y, DIM10, DIM40+DIM25);
				g.setColor(Color.black);	
				g.drawOval(-DIM35+x, DIM5-DIM130+y, DIM10, DIM40+DIM25);
				g.setColor(Color.orange);	
				g.fillOval(-DIM35+x, -DIM35*2+y, DIM10, DIM10);
				g.setColor(Color.black);	
				g.fillRect(-DIM35-DIM10+x, DIM5-DIM130+y, DIM35, DIM10*2);		// ascia
				g.drawOval(-DIM35+x, -DIM35*2+y, DIM10, DIM10);
				// braccio
				g.setColor(Color.blue);
				g.fillOval(-DIM35+x, DIM15*3+y-DIM130, DIM25+DIM10, DIM15);
				g.setColor(Color.black);
				g.drawOval(-DIM35+x, DIM15*3+y-DIM130, DIM25+DIM10, DIM15);
				g.setColor(Color.pink);
				g.fillOval(-DIM35+x, DIM15*3+y-DIM130, DIM15, DIM15);
				g.setColor(Color.black);
				g.drawOval(-DIM35+x, DIM15*3+y-DIM130, DIM15, DIM15);
			}
			else
			{
				// arma
				g.setColor(Color.orange);	
				g.fillOval(-DIM25*2+x, -DIM40-DIM15+y, DIM40+DIM25, DIM10);
				g.setColor(Color.black);	
				g.drawOval(-DIM25*2+x, -DIM40-DIM15+y, DIM40+DIM25, DIM10);
				g.setColor(Color.orange);	
				g.fillOval(DIM5+x, -DIM40-DIM15+y, DIM10, DIM10);
				g.setColor(Color.black);	
				g.fillRect(-DIM25*2+x, DIM40+DIM25+y-DIM130, DIM10*2, DIM15*2);	// ascia
				g.drawOval(DIM5+x, -DIM40-DIM15+y, DIM10, DIM10);
				// braccio
				g.setColor(Color.blue);
				g.fillOval(-DIM10+x, -DIM40*2+y, DIM15, DIM25+DIM10);
				g.setColor(Color.black);
				g.drawOval(-DIM10+x, -DIM40*2+y, DIM15, DIM25+DIM10);
				g.setColor(Color.pink);
				g.fillOval(-DIM10+x, -DIM40-DIM15+y, DIM15, DIM15);
				g.setColor(Color.black);
				g.drawOval(-DIM10+x, -DIM40-DIM15+y, DIM15, DIM15);
			}
		}
	}
}
