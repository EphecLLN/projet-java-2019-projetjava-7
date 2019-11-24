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
	 * Cette m�thode permet de faire une attaque sp�ciale 
	 * Cette attaque poss�de un mutiplicateur de 125% des d�gats de l'arme
	 * Un buff de 10% de degats est appliqu�e apr�s l'attaque
	 * @param ennemi : Le monstre subissant l'attaque
	 */
	
	public void attaqueSpeciale(Monstre ennemi) {
		int totalDegat = (int) (this.getDegat() * 1.25);
		this.setDegat((int)(this.getDegat() + this.getDegat() * 0.1));
		ennemi.setVie(ennemi.getVie() - totalDegat);
	}
}
