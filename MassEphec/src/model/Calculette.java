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
	public String toString() {
		return "Vous avez choisi la classe Compta et vous maniez la calculette! Vos dégats sont de " + this.getDegat()
	+ "!\nEt votre attaque spéciale permet d'augmenter vos dégats de 10%"; 
	}
	public String atkSpe() {
		return "Vous vous acharnez sur les calculs et mettez 125% de degats à votre ennemi.\n"
				+ "Pour un total de " + this.getDegat() * 1.25
				+ "\nTout en augmentant vos degats de 10% ";
	}
}
