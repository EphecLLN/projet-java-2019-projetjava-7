package controller;

import model.*;
import vue.CombatVueConsole;

public class CombatController {
	private Hero hero;
	private Boss boss;
	private CombatVueConsole view = null;
	
	public CombatController(Hero model, Boss boss) {
		this.hero = model;
		this.boss = boss;
	}
	
	
	public void attaqueBoss() {
		hero.getArme().attaque(boss);
		control();
	}
	
	public void attaqueHero() {
		boss.attaque(hero);
		control();
	}
	
	public void attaqueSpe() {
		hero.getArme().attaqueSpeciale(boss);
		control();
	}
	
	public void ajouterCredit() {
		hero.setCredit(hero.getCredit() + boss.getCredit());
		System.out.println("Vous avez gagn� " + boss.getCredit() + " cr�dits !");
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
