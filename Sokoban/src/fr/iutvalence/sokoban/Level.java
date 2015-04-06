package fr.iutvalence.sokoban;


/**
 * Représente un niveau de jeu
 * @author Thibault
 * @version 1.0
 */
public class Level {
	
	/**
	 * Numéro du niveau
	 */
	private static int levelNumber = 0;
	
	/**
	 * La carte du niveau
	 */
	private CellCharacter[][] map;
	
	/**
	 * Hauteur du niveau
	 */
	private int mapHeight;
	
	/**
	 * Largeur du niveau
	 */
	private int mapWidth;
	
	public Level(){
		Level.levelNumber++;
		this.mapHeight = 0;
		this.mapWidth = 0;
		this.map = null;
	}
	
}
