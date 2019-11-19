package model;

public class Monstre extends Personnage {
	private int degats;
	
	public Monstre(int degats, String nom, int vie, int coordX, int coordY) {
		super(nom, vie, coordX, coordY);
		this.degats = degats;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}
	public void attaque(Hero hero1) {
		hero1.setVie(hero1.getVie() - getDegats());
	}
}
