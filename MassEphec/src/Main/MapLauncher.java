package Main;

import controller.MapController;
import model.Hero;
import model.Pc;
import vue.GamePanel;
import model.Arme;

public class MapLauncher {

	public static void main (String [] args) {
		Hero hero = new Hero("HeroTest", 100, 0, 0, new Pc());
		new GamePanel(1280, 720, hero);

	}
}
