package Main;

import model.Comptabilite;
import model.Hero;
import model.IT;
import model.Marketing;

public class CreationHero {
	
	private Hero hero;
	
	public CreationHero(String nom, String classe) {
		switch (classe) {
		case "IT" :
			hero = new IT(nom);
			hero.getArme().setHero(hero);
			break;
		case "Marketing":
			hero = new Marketing(nom);
			hero.getArme().setHero(hero);
			break;
		case "Comptabilite":
			hero = new Comptabilite(nom);
			hero.getArme().setHero(hero);
			break;
		}
	}
	public Hero getHero() {
		return hero;
	}

}
