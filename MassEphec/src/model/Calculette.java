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
	public String toString() {
		return "Vous avez choisi la classe Compta et vous maniez la calculette! Vos d�gats sont de " + this.getDegat()
	+ "!\nEt votre attaque sp�ciale permet d'augmenter vos d�gats de 10%"; 
	}
	public String atkSpe() {
		return "Vous vous acharnez sur les calculs et mettez 125% de degats � votre ennemi.\n"
				+ "Pour un total de " + this.getDegat() * 1.25
				+ "\nTout en augmentant vos degats de 10% ";
	}
}
