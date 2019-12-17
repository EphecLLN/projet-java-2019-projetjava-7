package controller;

import model.*;
import vue.CombatVueConsole;

public class CombatControllerConsole {
	private Hero hero;
	private Boss boss;
	private CombatVueConsole view = null;
	
	public CombatControllerConsole(Hero model, Boss boss) {
		this.hero = model;
		this.boss = boss;
	}
	
	
	public void attaqueHero() {
		hero.getArme().attaque(boss);
		attaqueBoss();
		control();
	}
	
	public void attaqueBoss() {
		boss.attaque(hero);
	}
	
	public void attaqueSpe() {
		hero.getArme().attaqueSpeciale(boss);
		attaqueBoss();
		control();
	}
	
	public void ajouterCredit() {
		hero.setCredit(hero.getCredit() + boss.getCredit());
		System.out.println("Vous avez gagné " + boss.getCredit() + " crédits !");
	}
	
	public void control() {
		if (view != null) {
			if (hero.enVie() && boss.enVie()) {
				view.disableWarning();
			}
			else  {
				view.enableWarning();
				ajouterCredit();
			}
		}
	}
	
	public void addView(CombatVueConsole view) {
		this.view = view;
	}
	
}
