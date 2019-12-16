package Main;
 
import controller.MouvementController;
import model.Hero;
import model.IT;
import model.Pc;
import vue.GamePanel;
import model.Arme;

public class MapLauncher {

	public static void main (String [] args) {
		Hero hero = new IT("bg");
		MouvementController controller =  new MouvementController(hero);
		GamePanel view = new GamePanel(1280, 720, hero, controller);
		controller.addView(view);


	}
}
