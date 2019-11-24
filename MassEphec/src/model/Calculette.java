/**
 * 
 */
package model;

/**
 * @author emmanuel foureau
 */
public class Calculette extends Arme {

	public Calculette () {
		super("Calculette", 0, 20);
	}
	
	/**
	 * Cette méthode permet de faire une attaque spéciale 
	 * Cette attaque possède un mutiplicateur de 125% des dégats de l'arme
	 * Un buff de 10% de degats est appliquée après l'attaque
	 * @param ennemi : Le monstre subissant l'attaque
	 */
	
	public void attaqueSpeciale(Monstre ennemi) {
		int totalDegat = (int) (this.getDegat() * 1.25);
		this.setDegat((int)(this.getDegat() + this.getDegat() * 0.1));
		ennemi.setVie(ennemi.getVie() - totalDegat);
	}
}
