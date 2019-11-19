package model;

public class Consommables {
	
	private String nom;
	private int coordX;
	private int coordY;
	
	public Consommables(String nom, int coordX, int coordY) {
		this.nom= nom;
		this.coordX=coordX;
		this.coordY=coordY;		
	}
	
	/*
	 * Fournit le nom du consommable
	 * @return {String} le nom
	 */
	public String getNom() {
		return this.nom;
	}
	
	/*
	 * Fournit la coordonnee X du consommable
	 * @return {int} 
	 */
	public int getCoordX() {
		return this.coordX;
	}
	
	/*
	 * Fournit la coordonnee Y du consommable
	 * @return {int} 
	 */
	public int getCoordY() {
		return this.coordY;
	}
}
