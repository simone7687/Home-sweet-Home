package game.window;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * 
 * La classe game.window.GameWindow ha la funzione di:
 * creare la finestra del gioco.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class GameWindow extends JFrame
{
	private final String TITLE = "Home Sweet Home";
	public static Dimension windowDimension = new Dimension();
	public static double scalingFactor;	// per adattare i vari disegni alla dimensione dello schermo
	
	public GameWindow(Dimension windowDimension, double scalingFactor)
	{
		System.out.println("Creazione della finestra...");
		
		setTitle(TITLE);									// titolo
		setSize(windowDimension);							// dimensione
		setResizable(false);								// non ridimensionabile
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// rende attiva la chiusura
		
		GameWindow.scalingFactor = scalingFactor;
		GameWindow.windowDimension = windowDimension;
	}
}