package game.window;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Crea la finestra del gioco
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class GameWindow extends JFrame
{
	private final String TITLE = "Home Sweet Home";
	public static Dimension windowDimension = new Dimension();
	public static double scalingFactor;	// Per adattare i vari disegni alla dimensione dello schermo
	
	public GameWindow(Dimension windowDimension, double scalingFactor)
	{
		System.out.println("Creazione della finestra...");
		
		setTitle(TITLE);									// Titolo
		setSize(windowDimension);							// Dimensione
		setResizable(false);								// Non ridimensionabile
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// Rende attiva la chiusura
		
		GameWindow.scalingFactor = scalingFactor;
		GameWindow.windowDimension = windowDimension;
	}
}