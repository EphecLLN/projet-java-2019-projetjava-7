package Main;

import controller.MapController;
import controller.MouvementController;
import model.Hero;
import model.Pc;
import vue.GamePanel;
import model.Arme;

public class MapLauncher {

	public static void main (String [] args) {
<<<<<<< HEAD
		Hero hero = new Hero("HeroTest", 100, 6, 0, new Pc());
		MouvementController controller =  new MouvementController(hero);
		GamePanel view = new GamePanel(1280, 720, hero, controller);
		controller.addView(view);
=======

		//new GamePanel(1000, 800, hero);
		Hero hero = new Hero("HeroTest", 100, 0, 0, new Pc());
		new GamePanel(1280, 720, hero);


>>>>>>> 33c1be8a178c6e2888c5a3e73498c7956c72c8b8
	}
}
