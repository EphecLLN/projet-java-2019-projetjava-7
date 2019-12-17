package model;
import java.util.Observable;

public class Personnage extends Observable {

	private int vie;
	private int coordX;
	private int coordY;
	private String nom;
	private String path;
	/**
	 * @param vie
	 * @param coordX
	 * @param coordY
	 * @param nom
	 */
	public Personnage(String nom, String path,  int vie, int coordX, int coordY) {
		this.nom = nom;
		this.vie = vie;
		this.coordX = coordX;
		this.coordY = coordY;
		this.path = path;
	}
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		if (vie < 0) {
			this.vie = 0;
		}else {
			this.vie = vie;
		}
		setChanged();
		notifyObservers(this);
	}
	public int getCoordX() {
		return coordX;
	}
	public void setCoordX(int coordX) {
		this.coordX = coordX;
		setChanged();
		notifyObservers();
	}
	public int getCoordY() {
		return coordY;
	}
	public void setCoordY(int coordY) {
		this.coordY = coordY;
		setChanged();
		notifyObservers();
	}
	public String getNom() {
		return nom;
	}
	public String getPath() {
		return this.path;
	}
	
	public boolean enVie() {
		return this.vie > 0;
	}
	
	
}
