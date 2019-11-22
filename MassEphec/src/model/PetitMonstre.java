package model;

public class PetitMonstre extends Monstre {
	
	int experience;
	
	public PetitMonstre(int degats, String nom, int vie, int coordX, int coordY, int credit, int experience) {
		super(degats, nom, vie, coordX, coordY);
		this.experience = experience;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public void donneExpArme(Arme arme) {
		arme.ajouterExp(experience);
	}
}
