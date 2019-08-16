import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * 
 * La classe GameImages ha la funzione di:
 * gestire la grafica e il repaint.
 * @author 20024652
 * @version 1.0
 *
 */
public class GameImages extends Panel implements Runnable, KeyListener, MouseListener
{
	static int timeRepaintWalk = 200;
	static boolean dayLight = true;
	private final int START_LEVEL = 1;
	
	private BufferedImage  bf;
	
	private BackgroundImages wallpaper;
	private GameOverImages gameOver;
	public PlayerController player;	// creata e introdotta nel main
	private Zombies zombie;
	private Thread walkThread;
	private GamePause pause;
	
	GameImages()
	{
		System.out.println("Creazione immagini...");
		
		bf = new BufferedImage(GameWindow.windowDimension.width, GameWindow.windowDimension.height, BufferedImage.TYPE_INT_RGB);
		
		wallpaper = new BackgroundImages();
		zombie = new Zombies();
		gameOver = new GameOverImages();
		pause = new GamePause();
		
		walkThread = new Thread(this);
		walkThread.start();
		
		addKeyListener(this);		// abilita tasti nell'immagine
		addMouseListener(this);		// abilita mouse nell'immagine
	}
	
	// http://javacodespot.blogspot.com/2010/08/java-flickering-problem.html?m=1
	public void update(Graphics g)
	{
	       paint(g);
	}
	
	public void paint(Graphics g)
	{
		if(PlayerController.life > 0)
		{
			super.paint(bf.getGraphics());
			wallpaper.paint(bf.getGraphics(),dayLight);
			zombie.paint(bf.getGraphics());
			player.paint(bf.getGraphics());
		}
		else
		{
			gameOver.paint(bf.getGraphics());
		}
		pause.paint(bf.getGraphics());
		g.drawImage(bf,0,0,null);
	}
	
	@Override
	public void run() 
	{
		System.out.println("Avvio thread per il repaint e la camminata...");
		
		boolean walk = true;	// on/off
		boolean repaint = true;	// on/off 	// per i lag
		while(true)
		{
			if(repaint && !PauseBottonImages.pause)
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
			try 
			{
				Thread.sleep(timeRepaintWalk/2);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		// muovi
		if(e.getKeyCode() == KeyEvent.VK_D) player.right = true;
		if(e.getKeyCode() == KeyEvent.VK_A) player.left = true;
		if(e.getKeyCode() == KeyEvent.VK_W) player.up = true;
		if(e.getKeyCode() == KeyEvent.VK_S) player.down = true;
		// intro
		if(e.getKeyCode() == KeyEvent.VK_SPACE) if(GameImages.dayLight) {new GameLevels(START_LEVEL); GameImages.dayLight = false;}
		// picchia
		if(e.getKeyCode() == KeyEvent.VK_ENTER) if(player.currentHit) {player.hit(true);}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// muovi
		if(e.getKeyCode() == KeyEvent.VK_D) player.right = false;
		if(e.getKeyCode() == KeyEvent.VK_A) player.left = false;
		if(e.getKeyCode() == KeyEvent.VK_W) player.up = false;
		if(e.getKeyCode() == KeyEvent.VK_S) player.down = false;
		// picchia
		if(e.getKeyCode() == KeyEvent.VK_ENTER)	if(!player.currentHit) {player.hit(false);}
	}
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(PlayerController.life > 0)
		{
			pause.clickPause(e);
		}
		else
		{
			pause.clickRestart(e);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}