import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * 
 * La classe GameWindows ha la funzione di:
 * creare la finestra del gioco.
 * @author 20024652
 * @version 1.0
 *
 */
public class GameWindows extends JFrame
{
	private final String TITLE = "Home sweet Home";
	static Dimension windowDimension = new Dimension();
	static double dimension;	// per adattare i vari disegni alla dimensione dello schermo
	
	GameWindows(Dimension windowDimension)
	{
		System.out.println("Creazione della finestra...");
		
		setTitle(TITLE);									// titolo
		setSize(windowDimension);							// dimensione
		setResizable(false);								// ridimensionabile
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	// rende attiva la chiusura
		
		dimension = windowDimension.getHeight()/720;
		GameWindows.windowDimension = windowDimension;
	}
}