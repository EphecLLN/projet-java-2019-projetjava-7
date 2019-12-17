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
	 * Cette méthode permet d'effectuer une attaque spéciale
	 * Cette attaque possède un multiplicateur de 150 % des dégats de l'arme
	 * @param ennemi : Le monstre subissant l'attaque
	 */
	
	public void attaqueSpeciale(Monstre ennemi) { 
		int totalDegat = (int) (this.getDegat() * 1.5);
		ennemi.setVie(ennemi.getVie() - totalDegat);
	}
	public String toString() {
		return "Vous avez choisi la classe IT et vous maniez le Pc! Vos dégats sont de " + this.getDegat() + "!\n";
	}
	
	public String msgAttSpe() {
		return  "Et votre attaque spéciale vous permet d'écraser votre adversaire avec votre Pc et d'infliger 150% de dégats! \n"; 
	}
	
	public String attSpeDegat() {
		return "Votre attaque spéciale a fait " + (int) this.getDegat() * 1.5 + " dégats!\n";
	}
}
