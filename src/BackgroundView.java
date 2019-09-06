import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * La classe WallpaperImages ha la funzione di:
 * disegnare lo sfondo.
 * @author 20024652
 * @version 1.0
 *
 */
public class BackgroundView
{
	BackgroundView()
	{
		System.out.println("Creazione sfondo...");
	}
	
	// dimensioni costanti
	private final int DIM10 = (int) (10 * GameWindow.scalingFactor);
	private final int DIM50 = (int) (50 * GameWindow.scalingFactor);
	static final int DIM200 = (int) (200 * GameWindow.scalingFactor);	// utilizzato anche in player
	private final int DIMFONT1 = (int) (25 * GameWindow.scalingFactor);
	private final int DIMFONT2 = (int) (20 * GameWindow.scalingFactor);
	// colori 
	private final Color WOOD_COLOR = new Color(250, 131, 0);
	private final Color HOUSE_COLOR = new Color(255, 220, 0);
	private final GradientPaint SKY_COLOR = new GradientPaint (0, 0, Color.cyan, GameWindow.windowDimension.width, GameWindow.windowDimension.height, Color.blue);
	// testo
	private final Font FONT1 = new Font("Helvetica", Font.BOLD, DIMFONT1);
	private final Font FONT2 = new Font("Helvetica", Font.BOLD, DIMFONT2);
	
	public void paint(Graphics g, boolean dayLight)
	{	
		FontMetrics fm = g.getFontMetrics();
		
		// strada
		g.setColor(Color.gray);
		g.fillRect(0, 0, GameWindow.windowDimension.width, GameWindow.windowDimension.height);
		g.setColor(Color.black);
		g.drawRect(0, 0, GameWindow.windowDimension.width, GameWindow.windowDimension.height);
		// cielo
		Graphics2D g2d = (Graphics2D) g;
		if(dayLight)
		{
			g2d.setPaint(SKY_COLOR);
			g2d.fillRect(0, 0, GameWindow.windowDimension.width, DIM200);
			g.setColor(Color.yellow);
			g.fillOval(DIM50/2, DIM50/2, DIM50, DIM50);
			
			g.setFont(FONT1);
			g.setColor(Color.black);
			g.drawString("Ciao! Non far entrare nessuno in casa", DIM50, DIM200 + DIM50);
			g.drawString("Di giorno e' tranquillo, ma di notte...", DIM50, DIM200 + DIM50 + 40);
			g.drawString("Muoviti con: W(su')  D(giu')  A(dx)  S(sx)", DIM50, DIM200 + DIM50 + 80);
			g.drawString("Utilizza il martello con: ENTER, per colpire gli zombie o riparare la porta", DIM50, DIM200 + DIM50 + 120);
			
			String s = "Se sei pronto premi: SPACE";
			g.drawString(s, GameWindow.windowDimension.width /2 - fm.stringWidth(s)/2, DIM200 * 3 + DIM50);
		}
		else
		{
			g.setColor(Color.black);
			g.fillRect(0, 0, GameWindow.windowDimension.width, DIM200);
			g.setColor(Color.white);
			g.fillOval(DIM50/2, DIM50/2, DIM50, DIM50);
			
			g.setColor(Color.black);
			g.fillRoundRect(DIM200 * 2 + DIM10, DIM50 + DIM10, DIM50 * 2-DIM10 * 3, DIM50 * 2 - DIM10 * 3, 5, 5);
			
		}
		
		// casa
		g.setColor(HOUSE_COLOR);
		g.fillRect(0+DIM200, 0, GameWindow.windowDimension.width-DIM200*2, DIM200);
		g.setColor(Color.black);
		g.drawRect(0+DIM200, 0, GameWindow.windowDimension.width-DIM200*2, DIM200);
		
		// porta
		g.setColor(WOOD_COLOR);
		g.fillRect(DIM200*3, DIM50, DIM50*2,DIM50*3);
		g.setColor(Color.black);
		g.drawRect(DIM200*3, DIM50, DIM50*2,DIM50*3);
		
		if(PlayerController.life < 1)
			g.fillRect(DIM200*3, DIM50, DIM50*2, DIM50*3);
		else if(PlayerController.life < 15)
			g.fillRect(DIM200*3, DIM50, DIM50*2, DIM50*5/2);
		else if(PlayerController.life < 30)
			g.fillRect(DIM200*3, DIM50, DIM50*2, DIM50*2);
		else if(PlayerController.life < 45)
			g.fillRect(DIM200*3, DIM50, DIM50*2, DIM50*3/2);
		else if(PlayerController.life < 60)
			g.fillRect(DIM200*3, DIM50, DIM50*2, DIM50);
		else if(PlayerController.life < 75)
			g.fillRect(DIM200*3, DIM50, DIM50*2, DIM50/2);
		else if(PlayerController.life > 90)
			g.drawOval(DIM200*3+DIM50+DIM10*2, DIM50+DIM50*3/2, DIM10*3/2, DIM10*3/2);
				
		if(PlayerController.life > 100)
		{
			g.setColor(WOOD_COLOR);
			g.fillRect(DIM200*3-DIM50/2, DIM50*3/2, DIM200-DIM50, DIM50/2);
			g.setColor(Color.black);
			g.drawRect(DIM200*3-DIM50/2, DIM50*3/2, DIM200-DIM50, DIM50/2);
			g.setColor(Color.darkGray);
			g.drawOval(DIM200*3-DIM50/2+DIM10, DIM50*3/2+DIM10, DIM10/2, DIM10/2);
			g.drawOval(DIM200*3-DIM50*3/2+DIM200-DIM10, DIM50*3/2+DIM10, DIM10/2, DIM10/2);
			g.setColor(Color.black);
			g.fillOval(DIM200*3-DIM50/2+DIM10, DIM50*3/2+DIM10, DIM10/2, DIM10/2);
			g.fillOval(DIM200*3-DIM50*3/2+DIM200-DIM10, DIM50*3/2+DIM10, DIM10/2, DIM10/2);
		}
		if(PlayerController.life > 149)
		{
			g.setColor(WOOD_COLOR);
			g.fillRect(DIM200*3-DIM50/2, DIM50*3, DIM200-DIM50, DIM50/2);
			g.setColor(Color.black);
			g.drawRect(DIM200*3-DIM50/2, DIM50*3, DIM200-DIM50, DIM50/2);
			g.setColor(Color.darkGray);
			g.drawOval(DIM200*3-DIM50/2+DIM10, DIM50*3+DIM10, DIM10/2, DIM10/2);
			g.drawOval(DIM200*3-DIM50*3/2+DIM200-DIM10, DIM50*3+DIM10, DIM10/2, DIM10/2);
			g.setColor(Color.black);
			g.fillOval(DIM200*3-DIM50/2+DIM10, DIM50*3+DIM10, DIM10/2, DIM10/2);
			g.fillOval(DIM200*3-DIM50*3/2+DIM200-DIM10, DIM50*3+DIM10, DIM10/2, DIM10/2);
		}
		
		// finestra
		g.setColor(WOOD_COLOR);
		g.fillRoundRect(DIM200*2, DIM50, DIM50*2-DIM10, DIM50*2-DIM10, 10, 10);
		g.setColor(Color.black);
		g.drawRoundRect(DIM200*2, DIM50, DIM50*2-DIM10, DIM50*2-DIM10, 10, 10);
		if(dayLight)
		{
			g2d.setPaint(SKY_COLOR);
			g2d.fillRoundRect(DIM200*2+DIM10, DIM50+DIM10, DIM50*2-DIM10*3, DIM50*2-DIM10*3, 5, 5);
			g.setColor(Color.black);
			g.drawRoundRect(DIM200*2+DIM10, DIM50+DIM10, DIM50*2-DIM10*3, DIM50*2-DIM10*3, 5, 5);
		}
		else
		{
			g.setColor(Color.black);
			g.fillRoundRect(DIM200*2+DIM10, DIM50+DIM10, DIM50*2-DIM10*3, DIM50*2-DIM10*3, 5, 5);
			g.setFont(FONT2);
			g.setColor(Color.blue);
			//g.drawString("Porta: " + Players.life, DIM200*3, DIM50-DIM10);
			g.drawString("Score: " + GameScoreModel.getScore(), DIM200 + DIM50 - DIM10 * 2, DIM200 - DIM10 * 2);
			g.drawString("Livello: " + GameLevel.level, DIM200 * 4 + DIM50 * 3, DIM200 - DIM10 * 2);
		}
	}
}
