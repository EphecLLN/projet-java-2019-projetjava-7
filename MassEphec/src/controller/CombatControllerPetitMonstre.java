package controller;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.*;
import vue.*;


public class CombatControllerPetitMonstre {
	private Hero hero;
	private PetitMonstre monstre;
	private CombatPetitMonstre view = null;
	
	public CombatControllerPetitMonstre(Hero hero, PetitMonstre monstre) {
		this.hero = hero;
		this.monstre = monstre;
		
	}
	
	public void attaqueHero() {
		hero.getArme().attaque(monstre);
		attaqueBoss();
		control();
	}
	
	public void attaqueSpe() {
		hero.getArme().attaqueSpeciale(monstre);
		attaqueBoss();
		control();
	}
	
	public void attaqueBoss() {
		monstre.attaque(hero);
	}
	
	public void consommable() {
		
	}
	
	public void ajouterExp() {
		hero.getArme().setExperience(monstre.getExperience());
	}
	public void control() {
		if (!monstre.enVie()) {
			ajouterExp();
			hero.setEnCombat(false);
			view.bossMort();
		}if(!hero.enVie()) {
			view.heroMort();
		}
	}
	public void addView(CombatPetitMonstre view) {
		this.view = view;
	}
}

