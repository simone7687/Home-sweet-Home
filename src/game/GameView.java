package game;

import game.pause.GamePauseController;
import game.pause.GamePauseView;
import game.player.PlayerController;
import game.score.GameLevel;
import game.window.BackgroundView;
import game.window.GameOverView;
import game.window.GameWindow;
import game.zombie.ZombieController;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 *
 * Questa classe si occupa della grafica e del repaint.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */

public class GameView extends Panel implements Runnable, KeyListener, MouseListener
{
	public static int timeRepaintWalk = 200;
	static boolean dayLight = true;
	private final int START_LEVEL = 1;

	private BufferedImage graphics;

	private BackgroundView wallpaper;
	private GameOverView gameOver;
	public PlayerController player;	// creata e introdotta nel main
	private ZombieController zombie;
	private Thread walkThread;
	private GamePauseController pause;

	public GameView()
	{
		System.out.println("Creazione immagini...");

		graphics = new BufferedImage(GameWindow.windowDimension.width, GameWindow.windowDimension.height, BufferedImage.TYPE_INT_RGB);

		wallpaper = new BackgroundView();
		zombie = new ZombieController();
		gameOver = new GameOverView();
		pause = new GamePauseController();

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
			super.paint(graphics.getGraphics());
			wallpaper.paint(graphics.getGraphics(), dayLight);
			zombie.paint(graphics.getGraphics());
			player.paint(graphics.getGraphics());
		}
		else
			gameOver.paint(graphics.getGraphics());

		pause.paint(graphics.getGraphics());
		g.drawImage(graphics,0,0,null);
	}

	@Override
	public void run()
	{
		System.out.println("Avvio thread per il repaint e la camminata...");

		boolean walk = true;
		boolean repaint = true;
		while(true)
		{
			if(repaint && !GamePauseView.getIsPaused())
			{
				player.walk(walk);
				zombie.walk(walk);
				if(walk)
					walk = false;
				else
					walk = true;

				repaint = false;
			}
			else
				repaint = true;

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
		// Gestione movimento del giocatore
		if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.setRight(true);
		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
			player.setLeft(true);
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)
			player.setUp(true);
		if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)
			player.setDown(true);

		// Gestione avvio della partita
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(GameView.dayLight)
			{
				new GameLevel(START_LEVEL);
				GameView.dayLight = false;
			}
		}

		// Gestione della 'lotta' e del danno
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE)
			if(player.currentHit)
				player.hit(true);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// Gestione movimento del giocatore
		if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.setRight(false);
		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
			player.setLeft(false);
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)
			player.setUp(false);
		if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)
			player.setDown(false);

		// Gestione della 'lotta' e del danno
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE)
			if(!player.currentHit)
				player.hit(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {}


	@Override
	public void mouseClicked(MouseEvent e)
	{
		// Pausa al click del mouse
		if(PlayerController.life > 0)
			pause.clickPause(e);
		else
			pause.clickRestart(e);
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