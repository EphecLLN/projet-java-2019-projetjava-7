package controller;

import model.Personnage;
import vue.CombatVueConsole;

public class CombatController {
	private Personnage model;
	private CombatVueConsole view = null;
	
	public CombatController(Personnage model) {
		this.model = model;
	}
	
	public void diminuerVie(int degat) {
		model.setVie(model.getVie() - degat);
		control();
	}
	
	public void control() {
		if (view != null) {
			if (model.enVie(model.getVie())) {
			
			}
		}
	}
	
	public void addView(CombatVueConsole view) {
		this.view = view;
	}
	
}
