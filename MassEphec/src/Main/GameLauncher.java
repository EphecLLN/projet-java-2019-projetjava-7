package Main;

import controller.MouvementController;
import model.Hero;
import vue.Combat;
import vue.GamePanel;
import vue.Login;

public class GameLauncher extends Thread {

	private Login loginPage;
	private MotherClasse classeMere = new MotherClasse();
	private Hero hero;
	private GamePanel map;
	
	public GameLauncher(Hero hero) {
			this.hero = hero;
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				map = new GamePanel(1280, 835, hero, new MouvementController(hero));
			}
		});
	}

	public static void main(String[] args) {
		new Login();
	}

}
