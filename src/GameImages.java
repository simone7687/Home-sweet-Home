import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;

/**
 * 
 * La classe GameImages ha la funzione di:
 * gestire la grafica e il repaint.
 * @author 20024652
 * @version 1.0
 *
 */
public class GameImages extends Panel implements Runnable
{
	private final int REPAINT_WALK = 200;
	static boolean day = true;
	
	private BufferedImage  bf;
	
	private WallpaperImages wallpaper;
	private GameOverImages gameOver;
	public Players player;	// creata e introdotta nel main
	private Zombies zombie;
	private Thread walkThread;
	
	GameImages()
	{
		System.out.println("Creazione immagini...");
		
		bf = new BufferedImage(GameWindows.windowDimension.width, GameWindows.windowDimension.height, BufferedImage.TYPE_INT_RGB);
		
		wallpaper = new WallpaperImages();
		zombie = new Zombies();
		gameOver = new GameOverImages();
		
		walkThread = new Thread(this);
		walkThread.start();
	}
	
	// http://javacodespot.blogspot.com/2010/08/java-flickering-problem.html?m=1
	public void update(Graphics g)
	{
	       paint(g);
	}
	
	public void paint(Graphics g)
	{
		if(Players.life > 0)
		{
			super.paint(bf.getGraphics());
			wallpaper.paint(bf.getGraphics(),day);
			zombie.paint(bf.getGraphics());
			player.paint(bf.getGraphics());
		}
		else
		{
			gameOver.paint(bf.getGraphics());
																																														// aggiungere bottone per rigiocare
		}
		g.drawImage(bf,0,0,null);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Avvio thread per il repaint e la camminata...");
		
		boolean walk = true;	// on/off
		boolean repaint = true;	// on/off 	// per i lag
		while(Players.life > 0)
		{
			if(repaint)
			{
				player.walk(walk);
				zombie.walk(walk);
				if(walk)
				{
					walk = false;
				}
				else
				{
					walk = true;
				}
				
				repaint = false;
			}
			else
			{
				repaint = true;
			}
			try {
					Thread.sleep(REPAINT_WALK/2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			repaint();
		}
		GameScores.printScore();
		System.out.println("Game Over");
	}
}