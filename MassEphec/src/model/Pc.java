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
	public String toString() {
		return "Vous avez choisi la classe IT et vous maniez le Pc! Vos d�gats sont de " + this.getDegat() + "!\n";
	}
	
	public String msgAttSpe() {
		return  "Et votre attaque sp�ciale vous permet d'�craser votre adversaire avec votre Pc et d'infliger 150% de d�gats! \n"; 
	}
	
	public String attSpeDegat() {
		return "Votre attaque sp�ciale a fait " + (int) this.getDegat() * 1.5 + " d�gats!\n";
	}
}
