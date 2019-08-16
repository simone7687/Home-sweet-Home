import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class PauseBottonImages 
{
	protected Dimension bottonPauseSize = new Dimension((int) (50*GameWindow.dimension), (int) (25*GameWindow.dimension));
	protected Point bottonPauseCoordinates = new Point((int) (10*GameWindow.dimension), (int) (10*GameWindow.dimension));
	protected Dimension bottonRestartSize = new Dimension((int) (200*GameWindow.dimension), (int) (150*GameWindow.dimension));
	protected Point bottonRestartCoordinates = new Point((int) (GameWindow.windowDimension.width-bottonRestartSize.width)/2, (int) (450*GameWindow.dimension));
	static boolean pause = false;
	private int DIM15 = (int) (15*GameWindow.dimension);
	private int DIM5 = (int) (5*GameWindow.dimension);
	private int DIM2 = (int) (2*GameWindow.dimension);
	private Polygon p1 = new Polygon();
	private Polygon p2 = new Polygon();
	
	public void paint(Graphics g)
	{	
		// pausa
		if(PlayerController.life > 0)
		{
			p1.addPoint(bottonPauseCoordinates.x+(bottonPauseSize.width/2)-DIM2-DIM5, bottonPauseCoordinates.y+DIM5);
			p1.addPoint(bottonPauseCoordinates.x+(bottonPauseSize.width/2)-DIM2-DIM5, bottonPauseCoordinates.y-DIM5+bottonPauseSize.height);
			p1.addPoint(bottonPauseCoordinates.x+(bottonPauseSize.width/2)+bottonPauseSize.height-DIM2-DIM5*3, bottonPauseCoordinates.y+bottonPauseSize.height/2);
			
			g.setColor(Color.black);
			g.fillRoundRect(bottonPauseCoordinates.x, bottonPauseCoordinates.y, bottonPauseSize.width, bottonPauseSize.height, 10, 10);
			g.setColor(Color.white);
			g.drawRoundRect(bottonPauseCoordinates.x, bottonPauseCoordinates.y, bottonPauseSize.width, bottonPauseSize.height, 10, 10);
			if(pause)
			{
				g.fillPolygon(p1);
			}
			else
			{
				g.fillRect(bottonPauseCoordinates.x+(bottonPauseSize.width/2)+DIM2, bottonPauseCoordinates.y+DIM5, DIM5, bottonPauseSize.height-(DIM5*2));
				g.fillRect(bottonPauseCoordinates.x+(bottonPauseSize.width/2)-DIM2-DIM5, bottonPauseCoordinates.y+DIM5, DIM5, bottonPauseSize.height-(DIM5*2));
			}
		}
		// restart
		else
		{
			p2.addPoint(bottonRestartCoordinates.x+(bottonRestartSize.width-bottonRestartSize.height)/2+DIM15*3+DIM5, bottonRestartCoordinates.y+DIM15*3);
			p2.addPoint(bottonRestartCoordinates.x+(bottonRestartSize.width-bottonRestartSize.height)/2+DIM15*3+DIM5, bottonRestartCoordinates.y+bottonRestartSize.height-DIM15*3);
			p2.addPoint(bottonRestartCoordinates.x+(bottonRestartSize.width-bottonRestartSize.height)/2+bottonRestartSize.height-DIM15*2-DIM2*2-DIM5, bottonRestartCoordinates.y+bottonRestartSize.height/2);
			
			g.setColor(Color.black);
			g.fillRoundRect(bottonRestartCoordinates.x, bottonRestartCoordinates.y, bottonRestartSize.width, bottonRestartSize.height, 10, 10);
			g.setColor(Color.white);
			g.drawRoundRect(bottonRestartCoordinates.x, bottonRestartCoordinates.y, bottonRestartSize.width, bottonRestartSize.height, 10, 10);
			g.fillOval(bottonRestartCoordinates.x+(bottonRestartSize.width-bottonRestartSize.height)/2+DIM15, bottonRestartCoordinates.y+DIM15, bottonRestartSize.height-DIM15*2, bottonRestartSize.height-DIM15*2);
			g.setColor(Color.black);
			g.fillOval(bottonRestartCoordinates.x+(bottonRestartSize.width-bottonRestartSize.height)/2+DIM15+DIM2, bottonRestartCoordinates.y+DIM15+DIM2, bottonRestartSize.height-DIM15*2-DIM2*2, bottonRestartSize.height-DIM15*2-DIM2*2);
			g.setColor(Color.white);
			g.fillPolygon(p2);
		}
	}
}