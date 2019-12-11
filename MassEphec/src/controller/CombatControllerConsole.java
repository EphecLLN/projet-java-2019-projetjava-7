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
	
	
	public void attaqueBoss() {
		hero.getArme().attaque(boss);
		attaqueHero();
		control();
	}
	
	public void attaqueHero() {
		boss.attaque(hero);
	}
	
	public void attaqueSpe() {
		hero.getArme().attaqueSpeciale(boss);
		attaqueHero();
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
			}
		}
	}
	
	public void addView(CombatVueConsole view) {
		this.view = view;
	}
	
}
