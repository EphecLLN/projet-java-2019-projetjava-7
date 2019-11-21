package model;

public class BoostVie extends Consommables{
	
	private int montantVie;
	
	public BoostVie(int coordX, int coordY) {
		super("Monster Energy",coordX, coordY);
		this.montantVie= 100;
	}
	
	/*
	 * Cette methode rend de la vie à un hero
	 */
	public void donneVie(Hero joueur) {
		joueur.setVie(montantVie);
	}
}
