package model;

public class Monstre extends Personnage {
	private int degats;
	private String path;
	
	public Monstre(int degats, String path, String nom, int vie, int coordX, int coordY) {
		super(nom, vie, coordX, coordY);
		this.degats = degats;
		this.path = path;
	}

	public int getDegats() {
		return degats;
	}

	public void attaque(Hero hero1) {
		hero1.setVie(hero1.getVie() - getDegats());
	}
	
	public String getPath() {
		return this.path;
	}
	public String toString() {
		return "Le grand " + this.getNom() + " possède encore " + this.getVie() + " points de vie, ATTENTION!";
	}
}
