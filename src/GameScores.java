import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * La classe GameScores ha la funzione di:
 * gestire il punteggio.
 * @author 20024652
 * @version 1.0
 *
 */
public class GameScores
{
	static int scores;
	static int scoreLevel = 100;
	static int scoreHit = 10;
	
	GameScores()
	{
		System.out.println("Creazione dello score...");
		scores = 0;
	}
	
	/**
	 * Il metodo addScoreLevel ha la funzione di:
	 * aggiungere punti in base al livello.
	 * @param level
	 */
	static void addScoreLevel(int level)
	{
		scores+=scoreLevel*level;
	}
	/**
	 * Il metodo addScoreLevel ha la funzione di:
	 * aggiungere punti dei colpi inflitti.
	 */
	static void addScoreHit()
	{
		scores += scoreHit;
	}
	/**
	 * Il metodo printScore ha la funzione di:
	 * aggiungere il punteggio al file.
	 */
	static void printScore()
	{
	    try {
	    	String path = new File(".").getCanonicalPath().toString();
			BufferedWriter f = new BufferedWriter(new FileWriter(path + "\\score.txt", true));
			f.write(Players.name+": "+GameScores.scores);
			f.write(System.getProperty("line.separator"));
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Punteggio totalizzato: "+GameScores.scores);
	}
}
