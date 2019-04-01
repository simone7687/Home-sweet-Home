import java.awt.Dimension;

public class Main 
{
	public static void main(String[] args)
	{
		// pre-game
		GameStart start = new GameStart();
		Dimension windowDimension = start.getWindowDimension();
		if(windowDimension != null)
		{
			System.out.println("Avvio gioco...");
			
			// finestra
			GameWindows windows = new GameWindows(windowDimension);
			try {
				Thread.sleep(100);	// per sicurezza (per aspettare GameImage)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// player
			Players player = new Players(start.getPlayerName());
			windows.player = player;
			
			// punti
			new GameScores();
			
			// immagine
			GameImages image = new GameImages();
			player.gameImages = image;
			image.player = player;
			
			// fine
			windows.add(image);
			windows.setVisible(true);	// mostra il frame
			System.out.println("Completato!");
		}
		else
		{
			System.out.println("Chiusura!");
		}
	}
}
