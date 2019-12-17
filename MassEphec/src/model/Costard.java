package model;

public class Costard extends Arme{
	
	public Costard () {
		super("Costard", 0 , 20);
	}
	
	/**
	 * Cette méthode permet de faire une attaque spéciale
	 * Elle applique un multiplicateur de degat de 140% 
	 * Le personnage se rend 50% des degats effectués
	 * @param ennemi : Le monstre subissant l'attaque
	 */
	
	public void attaqueSpeciale(Monstre ennemi) {
		int degatTotal = (int)(this.getDegat() + (this.getDegat() * 0.4));
		ennemi.setVie(ennemi.getVie() - degatTotal);
		this.getHero().setVie(this.getHero().getVie() + (int) (degatTotal / 2));
	}
	
	public String toString() {
		return "Vous avez choisi la classe Market vous avez et vous maniez le costard! Vos d�gats sont de " + this.getDegat()
		+ "!\n";
	}
	
	public String msgAttSpe() {
		return  "Votre attaque sp�ciale est que vous r�g�nerez la moiti� des d�gats que vous infligez\n"; 
	}
	
	public String attSpeDegat() {
		return "Votre attaque sp�ciale a fait " + (int)this.getDegat()*1.4 + "Degats!\n";
	}

}
