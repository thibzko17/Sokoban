package fr.iutvalence.sokoban;

/**
 * Main de l'application
 * 
 * @author Thibault
 */
public class Main {
	
	public static void main(String[] args){
		Level level = new Level();
		level.loadFromFile("F:\\level1.txt");
		System.out.print(level);
	}
}
