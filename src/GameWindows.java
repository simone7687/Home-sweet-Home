import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * 
 * La classe GameWindows ha la funzione di:
 * creare la finestra del gioco.
 * @author 20024652
 * @version 1.0
 *
 */
public class GameWindows extends JFrame implements KeyListener
{
	private final String TITLE = "Survive for a night";
	private final int START_LEVEL = 1;
	static Dimension windowDimension = new Dimension();
	static double dimension;	// per adattare i vari disegni alla dimensione dello schermo
	Players player;
	
	GameWindows(Dimension windowDimension)
	{
		System.out.println("Creazione della finestra...");
		
		setName(TITLE);										// titolo
		setSize(windowDimension);							// dimensione
		setResizable(false);								// ridimensionabile
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	// rende attiva la chiusura
		addKeyListener(this);								// abilita tasti
		
		dimension = windowDimension.getHeight()/720;
		GameWindows.windowDimension = windowDimension;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// muovi
		if(e.getKeyCode() == KeyEvent.VK_D) player.right = true;
		if(e.getKeyCode() == KeyEvent.VK_A) player.left = true;
		if(e.getKeyCode() == KeyEvent.VK_W) player.up = true;
		if(e.getKeyCode() == KeyEvent.VK_S) player.down = true;
		// intro
		if(e.getKeyCode() == KeyEvent.VK_SPACE) if(GameImages.day) {new GameLevels(START_LEVEL); GameImages.day = false;}
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
}