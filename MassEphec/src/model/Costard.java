package model;

public class Costard extends Arme{
	
	public Costard () {
		super("Costard", 0 , 20);
	}
	
	/**
	 * Cette m�thode permet de faire une attaque sp�ciale
	 * Elle applique un multiplicateur de degat de 140% 
	 * Le personnage se rend 50% des degats effectu�s
	 * @param ennemi : Le monstre subissant l'attaque
	 */
	
	public void attaqueSpeciale(Monstre ennemi) {
		/*
		int degatTotal = (int)(this.getDegat() + (this.getDegat() * 1.4));
		ennemi.setVie(ennemi.getVie() - degatTotal);
		this.getHero().setVie(this.getHero().getVie() + (int) (degatTotal / 2));
		*/
	}
}
