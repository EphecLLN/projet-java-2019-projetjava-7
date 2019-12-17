/**
 * 
 */
package model;
import java.util.Observable;

/**
 * @author emman
 *
 */
public abstract class Arme extends Observable{
	// Variables d'instance 
	private String nomArme;
	private int experience = 0;
	private int degat;
	private int niveau = 1;
	private Hero hero;
	private final int experienceMax = 100;
	
	public Arme(String nomArme, int experience, int degat) {
		this.nomArme = nomArme;
		this.setExperience(experience);
		this.setDegat(degat);
	}
	
	/**
	 * Setter de la variable "nomArme"
	 * @param nomArme : La nouvelle valeur de "nomArme" pour l'objet courant
	 */
	
	
	public String getNomArme () {
		return this.nomArme;
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
		
	}
	
	/**
	 * Setter de la variable "experience"
	 * experience < experienceMax && experience => 0
	 * @param experience : La nouvelle valeur d'"experience" pour l'objet courant
	 */
	
	public void setExperience (int experience) {
		if (experience >= 0) {
			this.experience = this.experience+ experience;
			if(this.experience>experienceMax) {
				niveau++;
				this.experience= this.experience-experienceMax;
			}
		}
	}
	
	/**
	 * Getter de la variable "experience"
	 * @return experience : La valeur de la variable "experience" de l'objet courant
	 */
	
	public int getExperience () {
		return this.experience;
	}
	
	/**
	 * Setter de la variable "niveau"
	 * @param niveau : La nouvelle valeur de la variable "niveau" pour l'objet courant
	 */
	
	public void setNiveau (int niveau) {
		if (niveau > 0) {
			this.niveau = niveau;
			setChanged();
			notifyObservers();
	}
}
	/**
	 * Getter de la variable "niveau"
	 * @return niveau : La valeur de la variable "niveau" de l'objet courant
	 */
	
	public int getNiveau () {
		return this.niveau;
	}
	
	/**
	 * Setter de la variable "degat"
	 * @param degat : La nouvelle valeur de la variable "degat" pour l'objet courant
	 */
	
	public void setDegat (int degat) {
		if (degat >= 0) {
			this.degat = degat;
		}
	}
	/**
	 * Getter de la variable "degat"
	 * @return degat : La valeur de la variable "degat" de l'objet courant
	 */
	
	public int getDegat () {
		return this.degat;
	}
	
	/**
	 * Getter de la variable "hero"
	 */
	
	public Hero getHero () {
		return this.hero;
	}
	
	/**
	 * Cette classe permet d'ajouter de l'exp � l'arme
	 * Si experience >= experienceMax alors arme.niveauSuperieur()
	 * @param experience
	 */
	
	public void ajouterExp(int experience) {
		if ((this.getExperience() + experience) >= experienceMax) {
			this.setExperience(this.getExperience() + experience - experienceMax);
			this.niveauSuperieur();
		}
		else if (this.experience >= 0){
			this.setExperience(this.experience + experience);
		}
	}
	
	/**
	 * Cette classe permet l'augmentation du niveau 
	 * de l'arme apr�s avoir atteint l'exp requis
	 * Niveau + 1 et augmentation des d�gats
	 */
	
	public void niveauSuperieur() {
		int degat = this.getDegat();
		this.setNiveau(this.getNiveau() + 1);
		this.setDegat(degat + ((this.getNiveau() / 10) * degat));
	}
	
	public void attaque(Monstre monstre) {
		monstre.setVie(monstre.getVie() - this.getDegat());
	}
	
	public abstract void attaqueSpeciale(Monstre ennemi);
	
	public abstract String msgAttSpe();	
	
	public abstract String attSpeDegat();
	
	
}
