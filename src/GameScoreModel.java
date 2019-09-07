import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
	
	public static int getScore()
	{
		return score;
	}
	
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
	public static void writeScoreToFile()
	{
	    try 
	    {
	    	String path = new File(".").getCanonicalPath().toString();
	    	BufferedWriter f = new BufferedWriter(new FileWriter(path + "\\score.txt", true));
			f.write(PlayerModel.getName() + ":" + GameScoreModel.getScore());
			f.write(System.getProperty("line.separator"));
			f.close();
		} 
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	    System.out.println("Punteggio totalizzato: " + GameScoreModel.score);
	}
	
	
	public static String getHighestScoreFromFile()
	{
		String path = "";
		try 
		{
			path = new File(".").getCanonicalPath().toString();
		} 
		catch (IOException e) 
		{
			
		}
		
		//Se il path non esiste, restituisce null
		if (path == "")
			return null;
		
		Scanner s = null;
		try 
		{
			if (path != "")
				s = new Scanner(new File(path + "\\score.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		if (s == null)
			return null;
		
		int indexMax, index = -1, max = 0;
		ArrayList<String> scores = new ArrayList<String>();
		while (s.hasNextLine())
		{
			index++;
			String line = s.nextLine();
			scores.add(line);
			String[] split = line.split(":");
			if (Integer.parseInt(split[1]) > max)
			{
				indexMax = index;
				max = Integer.parseInt(split[1]);
			}
		}
		s.close();
		
		return scores.get(index);
	}
}
