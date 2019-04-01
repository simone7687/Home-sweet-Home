import java.awt.Graphics;
import java.awt.Panel;

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
	private final int REPAINT_TIME = 200;
	static boolean day = true;
	private WallpaperImages wallpaper;
	private GameOverImages gameOver;
	public Players player;	// creata e introdotta nel main
	private Zombies zombie;
	private Thread repaintThread;
	
	GameImages()
	{
		System.out.println("Creazione immagini...");
		
		wallpaper = new WallpaperImages();
		zombie = new Zombies();
		gameOver = new GameOverImages();
		
		repaintThread = new Thread(this);
		repaintThread.start();
	}
	
	public void paint(Graphics g)
	{
		if(Players.life > 0)
		{
			super.paint(g);
			wallpaper.paint(g,day);
			zombie.paint(g);
			player.paint(g);
		}
		else
		{
			gameOver.paint(g);
										// aggiungere bottone per rigiocare
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Avvio thread per il repaint...");
		
		boolean i = true;	// on/off
		while(Players.life > 0)
		{
			// corri on/off
			player.walk(i);
			zombie.walk(i);
			if(i)
			{
				i = false;
			}
			else
			{
				i = true;
			}
			try {
					Thread.sleep(REPAINT_TIME);
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