package model;

public class BoostVie extends Consommables{
	
	
	public BoostVie(int coordX, int coordY) {
		super("Monster Energy",coordX, coordY);
	}
	
	/*
	 * Cette methode rend de la vie à un hero
	 */
	public void donneVie(Hero joueur) {
		joueur.setVie(joueur.getVieMax());
	}
}
