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
public class GameWindow extends JFrame
{
	private final String TITLE = "Home Sweet Home";
	static Dimension windowDimension = new Dimension();
	static double scalingFactor;	// per adattare i vari disegni alla dimensione dello schermo
	
	GameWindow(Dimension windowDimension, double scalingFactor)
	{
		System.out.println("Creazione della finestra...");
		
		setTitle(TITLE);									// titolo
		setSize(windowDimension);							// dimensione
		setResizable(false);								// non ridimensionabile
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// rende attiva la chiusura
		
		this.scalingFactor = scalingFactor;
		this.windowDimension = windowDimension;
	}
}