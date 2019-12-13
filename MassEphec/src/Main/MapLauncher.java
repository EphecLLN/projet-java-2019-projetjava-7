package Main;

import controller.MapController;
import model.Hero;
import model.Pc;
import vue.GamePanel;
import model.Arme;

public class MapLauncher {

	public static void main (String [] args) {
<<<<<<< HEAD
		new GamePanel(1000, 800);
=======
		Hero hero = new Hero("HeroTest", 100, 0, 0, new Pc());
		new GamePanel(1280, 720, hero);
>>>>>>> 9a27ad97eb60045103ef4cae16fd79f680ad28f9
	}
}
