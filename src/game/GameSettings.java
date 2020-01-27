package game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

/**
 * 
 * La classe GameSettings ha la funzione di impostare i 
 * valori del gioco prima prima del suo avvio.
 * @author 20024652 - 20025270
 * @version 1.0
 *
 */
public class GameSettings
{
	private final Dimension FULLHD = new Dimension(1920, 1080);
	private final Dimension HD = new Dimension(1280, 720);
	private final Object[] POSSIBLEVALUES = {"1280x720", "1920x1080", "FILL SCREEN"};
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	GameSettings()
	{
		System.out.println("Avvio pre-gioco...");
	}
	
	/**
	 * Mostra il dialog per selezionare la dimensione della finestra di gioco
	 * @return La dimensione selezionata dall'utente
	 */
	public Dimension showWindowDimensionDialog()
	{
		System.out.println("Selezionare la dimensione della finestra...");
		String sel_input = (String) JOptionPane.showInputDialog(null,"Scegliere la dimensione della finestra","Grafica",JOptionPane.INFORMATION_MESSAGE,null,POSSIBLEVALUES,POSSIBLEVALUES[0]);
		if(sel_input != null)
		{
			System.out.println("Dimensione selezionata: " + sel_input + ".");

			switch(sel_input)
			{
				case "1280x720":
					return HD;
				case "1920x1080":
					return FULLHD;
				case "FILL SCREEN":
					return new Dimension(screenSize.width, screenSize.height);						
			}
		}
		return null;
	}
	
	/**
	 * Chiede il nome del giocatore
	 * @return Nome del Player
	 */
	public String showPlayerNameDialog()
	{
		System.out.println("Come ti chiami?");
		String name = JOptionPane.showInputDialog("Come ti chiami?", "Player");
		if (name == null)
		{
			// Premuto annulla
			System.out.println("Scelta non effettuata. Chiusura.");
			Runtime.getRuntime().exit(0);
			return null;
		}
		else if(!name.isEmpty())
		{
			System.out.println("Ciao " + name + ".");
			return name;
		}
		else
		{
			name = "Anonimo";
			System.out.println("Ciao.");
			return name;
		}
	}
}