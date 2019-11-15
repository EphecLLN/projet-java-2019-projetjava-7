package model;

public class Personnage {

	private int vie;
	private int coordX;
	private int coordY;
	private String nom;
	/**
	 * @param vie
	 * @param coordX
	 * @param coordY
	 * @param nom
	 */
	public Personnage(String nom, int vie, int coordX, int coordY) {
		this.nom = nom;
		this.vie = vie;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public int getCoordX() {
		return coordX;
	}
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	public int getCoordY() {
		return coordY;
	}
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean enVie(int vie) {
		return vie > 0;
	}
	
	
}
