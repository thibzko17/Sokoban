package fr.iutvalence.sokoban;

import fr.iutvalence.sokoban.exception.InvalidMapPositionException;


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
	
	/**
	 * Ajoute une cellule à une position donnée
	 * @param cell Le type de cellule a ajouter
	 * @param position La position où placer la cellule
	 * @throws InvalidMapPositionException 
	 */
	public void addCell(CellCharacter cell, Position position) throws InvalidMapPositionException{
		if(position.getX() < 0 || position.getX() > (this.mapWidth - 1)
		   || position.getY() < 0 || position.getY() > (this.mapHeight - 1)		
		){
			throw new InvalidMapPositionException();
		}
		
		this.map[position.getX()][position.getY()] = cell;
	}
	
}
