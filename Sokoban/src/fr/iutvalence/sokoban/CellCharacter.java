package fr.iutvalence.sokoban;

/**
 * Représente les élements qui constituent
 *   le niveau de jeu selon les conventions xsb
 * @author Thibault
 * @verison 1.0
 */
public enum CellCharacter {
	
	/**
	 * Mur
	 */
	WALL('#'),
	
	/**
	 * FLOOR
	 */
	FLOOR(' '),
	
	/**
	 * Case cible
	 */
	TARGET('.'),
	
	/**
	 * Joueur
	 */
	PLAYER('@'),
	
	/**
	 * Joueur sur case cible
	 */
	PLAYER_ON_TARGET('+'),
	
	/**
	 * Caisse
	 */
	BOX('$'),
	
	/**
	 * Caisse sur cible
	 */
	BOX_ON_TARGET('*');
	
	/**
	 * Nom de l'élément
	 */
	private char name;
	
	/**
	 * Constructeur
	 * @param name Le nom de l'élément
	 */
	CellCharacter(char name){
		this.name = name;
	}
	
	/**
	 * Retourne le nom de l'élément
	 * @return Le nom de l'élément
	 */
	public char getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return Character.toString(this.name);
	}	
	
}
