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
	private static int score = 0;
	private static int scoreLevel = 100;
	private static int scoreHit = 10;
	
	/**
	 * Il metodo addScoreLevel ha la funzione di:
	 * aggiungere punti in base al livello.
	 * @param level
	 */
	public static void addScoreLevel(int level)
	{
		score += scoreLevel*level;
	}
	
	/**
	 * Ha la funzione di:
	 * restituire la variabile score.
	 * @return score
	 */
	public static int getScore()
	{
		return score;
	}
	
	/**
	 * Ha la funzione di:
	 * settare la variabile score con la variabile passata per parametro.
	 * @param nscore
	 */
	public static void setScore(int nscore)
	{
		score = nscore;
	}
	
	/**
	 * Il metodo addScoreLevel ha la funzione di:
	 * aggiungere punti dei colpi inflitti.
	 */
	public static void addScoreHit()
	{
		score += scoreHit;
	}
	
	/**
	 * Il metodo printScore ha la funzione di:
	 * aggiungere il punteggio al file.
	 */
	public static void printScore()
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
