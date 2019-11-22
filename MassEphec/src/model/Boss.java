package model;

public class Boss extends Monstre {
	private int credit;
	private String speech;

	public Boss(int degats, String nom, int vie, int coordX, int coordY, int credit, String speech) {
		super(degats, nom, vie, coordX, coordY);
		this.credit = credit;
		this.speech = speech;
	}

	public int getCredit() {
		return credit;
	}


	public String getSpeech() {
		return speech;
	}

	public void donneCreditJoueur(Hero joueur) {
		joueur.setCredit(joueur.getCredit()+this.credit);
	}
	public void mauvaiseNote(Hero joueur) {
		joueur.setVie(joueur.getVie() - getDegats());
	}
	
}
