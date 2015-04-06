package fr.iutvalence.sokoban;

public class Position {

	/**
	 * La position en abscisse
	 */
	private int x;

	/**
	 * La position en ordonnée
	 */
	private int y;

	/**
	 * Constructeur par defaut
	 * Crée un objet avec les valeurs de posX et posY à 0
	 */
	public Position(){
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Constructeur à deux paramètres
	 * Crée un objet avec les valeurs passées en paramètres 
	 * @param posX La valeur en abscisse a affecter
	 * @param posY la valeur en ordonnée a affecter
	 */
	public Position(int posX, int posY){
		this.x = posX;
		this.y = posY;
	}

	/**
	 * Retourne la position en abscisse
	 * @return La position en abscisse
	 */
	public int getX() {
		return x;
	}

	/**
	 * Modifie la valeur de l'abscisse
	 * @param posX La valeur en abscisse a affecter
	 */
	public void setX(int posX) {
		this.x = posX;
	}

	/**
	 * Retourne la position en ordonnée
	 * @return La position en ordonnée
	 */
	public int getY() {
		return y;
	}

	/**
	 * Modifie la valeur de l'ordonnée
	 * @param x La valeur en ordonnée a affecter
	 */
	public void setY(int posY) {
		this.y = posY;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (this.x != other.x)
			return false;
		if (this.y != other.y)
			return false;
		return true;
	}

}