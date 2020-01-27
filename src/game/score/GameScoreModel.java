package game.score;

import game.player.PlayerModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gestione del punteggio
 * @author 20025270
 * @version 1.0
 *
 */
public class GameScoreModel
{
	private static int score = 0;
	private static int scoreLevel = 100;
	private static int scoreHit = 10;
	
	/**
	 * Aggiunge punti in base al livello.
	 * @param level
	 */
	public static void addScoreLevel(int level)
	{
		score += scoreLevel*level;
	}
	
	/**
	 * Restituisce il punteggio
	 * @return int rappresentante il punteggio attuale
	 */
	public static int getScore()
	{
		return score;
	}
	
	public static void setScore(int nscore)
	{
		score = nscore;
	}
	
	/**
	 * Aggiunge punti quando viene inflitto un colpo
	 */
	public static void addScoreHit()
	{
		score += scoreHit;
	}
	
	/**
	 * Salva il punteggio su file (classifica)
	 */
	public static void writeScoreToFile()
	{
	    try 
	    {
	    	String path = new File(".").getCanonicalPath().toString();
	    	BufferedWriter f = new BufferedWriter(new FileWriter(path + "\\score.txt", true));
			f.write(PlayerModel.getPlayerName() + ":" + GameScoreModel.getScore());
			f.write(System.getProperty("line.separator"));
			f.close();
		} 
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	    System.out.println("Punteggio totalizzato: " + GameScoreModel.score);
	}
	
	/*
	 * Trova il punteggio massimo del file
	 */
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
		
		int index = -1, max = 0;
		ArrayList<String> scores = new ArrayList<String>();
		while (s.hasNextLine()) 
		{
			index++;
			String line = s.nextLine();
			scores.add(line);
			String[] split = line.split(":");
			if (Integer.parseInt(split[1]) > max)
				max = Integer.parseInt(split[1]);
		}
		s.close();
		
		return scores.get(index);
	}
}
