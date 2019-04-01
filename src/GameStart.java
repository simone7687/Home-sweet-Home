import java.awt.Dimension;

import javax.swing.JOptionPane;

/**
 * 
 * La classe GameStart ha la funzione di:
 * settare valori del gioco prima di essere avviato.
 * @author 20024652
 * @version 1.0
 *
 */
public class GameStart
{
	private final Dimension FULLHD = new Dimension(1920, 1080);
	private final Dimension HD = new Dimension(1280, 720);
	private final Dimension SD = new Dimension(960, 540);
	private final Object[] POSSIBLEVALUES = {"SD", "HD", "FullHD"};
	
	GameStart()
	{
		System.out.println("Avvio pre-gioco...");
	}
	
	/**
	 * Il metodo getGameGraphics ha la funzione di:
	 * far selezionare la dimensione della finestra al giocatore.
	 * @return Dimensione della finestra
	 */
	Dimension getWindowDimension()
	{
		System.out.println("Selezionare la dimensione della finestra...");
		Object sel_input = JOptionPane.showInputDialog(null,"Scegliere la dimensione della finestra","Grafica",JOptionPane.INFORMATION_MESSAGE,null,POSSIBLEVALUES,POSSIBLEVALUES[0]);	// preassemblato
		if(sel_input != null)
		{
			if(sel_input == POSSIBLEVALUES[2])
			{
				return FULLHD;
			}
			if(sel_input == POSSIBLEVALUES[1]) 
			{
				return HD;
			}
			if(sel_input == POSSIBLEVALUES[0]) 
			{
				return SD;
			}
			System.out.println("Dimensione selezionata: " + sel_input + ".");
		}
		return null;
	}
	
	/**
	 * Il metodo getPlayerName ha la funzione di:
	 * far scrivere il nome del Player al giocatore.
	 * @return Nome del Player
	 */
	String getPlayerName()
	{
		System.out.println("Come ti chiami?");
		String name = JOptionPane.showInputDialog ("Come ti chiami?", "Player");	// preassemblato
		if(name != null && name != "Player")
		{
			System.out.println("Ciao " + name + ".");
			return name;
		}
		else
		{
			System.out.println("Ciao.");
			return name;
		}
	}
}