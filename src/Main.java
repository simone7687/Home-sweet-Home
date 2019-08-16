import java.awt.Dimension;

public class Main 
{
	public static void main(String[] args)
	{
		// pre-game
		GameSettings start = new GameSettings();
		Dimension windowDimension = start.getWindowDimension();
		if(windowDimension != null)
		{
			System.out.println("Avvio gioco...");
			
			// finestra
			GameWindow windows = new GameWindow(windowDimension);
			
			// player
			PlayerController player = new PlayerController(start.getPlayerName());
			
			// punti
			new GameScore();
			
			// immagine
			GameImages image = new GameImages();
			player.gameImages = image;
			image.player = player;
			windows.addKeyListener(image);		// abilita tasti nella finestra
			windows.addMouseListener(image);	// abilita mouse nella finestra
			// fine
			windows.add(image);
			windows.setVisible(true);			// mostra il frame
			System.out.println("Completato!");
		}
		else
		{
			System.out.println("Chiusura!");  //quando si chiude la finestra con la x stampa Chiusura!
		}
	}
}
