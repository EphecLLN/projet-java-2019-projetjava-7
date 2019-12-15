package Main;

import controller.MapController;
import controller.MouvementController;
import model.Hero;
import model.Pc;
import vue.GamePanel;
import model.Arme;

public class MapLauncher {

	public static void main (String [] args) {
		Hero hero = new Hero("HeroTest", 100, 6, 0, new Pc());
		MouvementController controller =  new MouvementController(hero);
		GamePanel view = new GamePanel(1280, 720, hero, controller);
		controller.addView(view);


	}
}
