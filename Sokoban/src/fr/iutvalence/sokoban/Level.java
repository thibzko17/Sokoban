package fr.iutvalence.sokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	
	/**
	 * Charge un niveau à partir d'un fichier
	 * @param filePath
	 */
	public void loadFromFile(String filePath){
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(filePath));
			
			// Ligne courrante
			String currentLine;
			
			// Contient l'ensemble des lignes
			StringBuilder allLines = new StringBuilder();
			
			/* On parcours le fichier:
			 *   - Récupère le nombre de lignes
			 *   - Récupère le nombre max de caractères par lignes
			 *   - Stocke le contunu du fichier dans une variable
			 */
			while((currentLine = buffer.readLine()) != null){
				this.mapHeight++;
				if(this.mapWidth < currentLine.length())
					this.mapWidth++;
				allLines.append(currentLine);
				allLines.append('\n');
			}
			
			// On initialise le tableau this.map
			this.map = new CellCharacter[this.mapHeight][this.mapWidth];
			
			// On remplit le tableau map
			for (int line = 0; line < this.mapHeight; line++) {
				for (int column = 0; column < this.mapWidth; column++) {
					char currentChar = allLines.toString().charAt(line * 10 + column);
					Position pos = new Position(line, column);
					switch (currentChar) {
						case '#':
							this.addCell(CellCharacter.WALL, pos);
							break;
						case ' ':
							this.addCell(CellCharacter.FLOOR, pos);
							break;
						case '.':
							this.addCell(CellCharacter.TARGET, pos);
							break;
						case '@':
							this.addCell(CellCharacter.PLAYER, pos);
							break;
						case '+':
							this.addCell(CellCharacter.PLAYER_ON_TARGET, pos);
							break;
						case '$':
							this.addCell(CellCharacter.BOX, pos);
							break;
						case '*':
							this.addCell(CellCharacter.BOX_ON_TARGET, pos);
							break;
						default:
							this.addCell(CellCharacter.FLOOR, pos);
							break;
					}
				}
			}		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidMapPositionException e) {
			e.printStackTrace();
		}
	}
	
}
