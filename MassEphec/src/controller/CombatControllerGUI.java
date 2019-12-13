package controller;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.*;
import vue.*;

public class CombatControllerGUI {
	
	private Hero hero;
	private Boss boss;
	private Combat view = null;
	
	public CombatControllerGUI(Hero hero, Boss boss) {
		this.hero = hero;
		this.boss = boss;
		
	}
	
	public void attaqueHero() {
		hero.getArme().attaque(boss);
		attaqueBoss();
		control();
	}
	
	public void attaqueSpe() {
		hero.getArme().attaqueSpeciale(boss);
		attaqueBoss();
		control();
	}
	
	public void attaqueBoss() {
		boss.attaque(hero);
	}
	
	public void consommable() {
		
	}
	
	public void ajouterCredit() {
		hero.setCredit(hero.getCredit() + boss.getCredit());
	}
	public void control() {
		if (!boss.enVie()) {
			ajouterCredit();
			view.bossMort();
		}if(!hero.enVie()) {
			view.heroMort();
		}
	}
	public void addView(Combat view) {
		this.view = view;
	}
}
