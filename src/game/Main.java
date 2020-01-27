package game;

import java.awt.Dimension;

import game.player.PlayerController;
import game.window.GameWindow;

public class Main
{
	public static void main(String[] args)
	{
		// Dialog iniziali
		GameSettings start = new GameSettings();
		Dimension windowDimension = start.showWindowDimensionDialog();
		if(windowDimension != null)
		{
			System.out.println("Avvio gioco...");

			//Fattore di moltiplicazione per l'adattamento della grafica
			double factor;
			if (windowDimension.height == 720)
				factor = 1.0;
			else if (windowDimension.height == 1080)
				factor = 1.3;
			else factor = 1.5;

			// Creazione finestra
			GameWindow window = new GameWindow(windowDimension, factor);

			// Creazione Player
			PlayerController player = new PlayerController(start.showPlayerNameDialog());

			GameView view = new GameView();
			player.gameView = view;
			view.player = player;

			//Abilita mouse e tastiera
			window.addKeyListener(view);
			window.addMouseListener(view);
			window.add(view);
			window.setVisible(true);
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
