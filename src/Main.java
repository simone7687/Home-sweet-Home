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
			
			double factor;
			if (windowDimension.height == 720)
				factor = 1.0;
			else if (windowDimension.height == 1080)
				factor = 1.3;
			else factor = 1.5;
			
			// finestra
			GameWindow windows = new GameWindow(windowDimension, factor);
			
			GameScoreModel score = new GameScoreModel();
			
			// player
			PlayerController player = new PlayerController(start.getPlayerName());
			
			GameView view = new GameView();
			player.gameImages = view;
			view.player = player;
			
			//Abilita mouse e tastiera
			windows.addKeyListener(view);
			windows.addMouseListener(view);
			windows.add(view);
			windows.setVisible(true);
			System.out.println("Avvio completato!");
		}
		else
		{
			//E' stato premuto annulla
			System.out.println("Chiusura!");
			Runtime.getRuntime().exit(0);
		}
	}
}
