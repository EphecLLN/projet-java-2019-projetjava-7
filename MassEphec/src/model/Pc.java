/**
 * 
 */
package model;

/**
 * @author Emmanuel Foureau
 */
public class Pc extends Arme {
	
	public Pc () {
		super("Pc", 0, 20);
	}
	
	/**
	 * Cette m�thode permet d'effectuer une attaque sp�ciale
	 * Cette attaque poss�de un multiplicateur de 150 % des d�gats de l'arme
	 * @param ennemi : Le monstre subissant l'attaque
	 */
	
	public void attaqueSpeciale(Monstre ennemi) { 
		int totalDegat = (int) (this.getDegat() * 1.5);
		ennemi.setVie(ennemi.getVie() - totalDegat);
	}
}
