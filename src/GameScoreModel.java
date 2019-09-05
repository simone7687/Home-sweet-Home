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
public class GameScoreModel
{
	static int score;
	static int scoreLevel = 100;
	static int scoreHit = 10;
	
	GameScoreModel()
	{
		System.out.println("Creazione dello score...");
		score = 0;
	}
	
	/**
	 * Il metodo addScoreLevel ha la funzione di:
	 * aggiungere punti in base al livello.
	 * @param level
	 */
	static void addScoreLevel(int level)
	{
		score += scoreLevel*level;
	}
	
	/**
	 * Il metodo addScoreLevel ha la funzione di:
	 * aggiungere punti dei colpi inflitti.
	 */
	static void addScoreHit()
	{
		score += scoreHit;
	}
	
	/**
	 * Il metodo printScore ha la funzione di:
	 * aggiungere il punteggio al file.
	 */
	static void printScore()
	{
	    try 
	    {
	    	String path = new File(".").getCanonicalPath().toString();
	    	BufferedWriter f = new BufferedWriter(new FileWriter(path + "\\score.txt", true));
			f.write(PlayerModel.name + ": " + GameScoreModel.score);
			f.write(System.getProperty("line.separator"));
			f.close();
		} 
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	    System.out.println("Punteggio totalizzato: " + GameScoreModel.score);
	}
}
