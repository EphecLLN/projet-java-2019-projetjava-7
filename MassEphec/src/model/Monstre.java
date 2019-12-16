package model;

public class Monstre extends Personnage {
	private int degats;
	
	public Monstre(int degats, String path, String nom, int vie, int coordX, int coordY) {
		super(nom, path, vie, coordX, coordY);
		this.degats = degats;
	}

	public int getDegats() {
		return degats;
	}

	public void attaque(Hero hero1) {
		hero1.setVie(hero1.getVie() - getDegats());
	}
	
	public String toString() {
		return "Le grand " + this.getNom() + " possède encore " + this.getVie() + " points de vie, ATTENTION!";
	}
}
