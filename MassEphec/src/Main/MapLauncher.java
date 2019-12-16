package Main;
 
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MouvementController;
import model.Hero;
import model.IT;
import model.Pc;
import vue.GamePanel;
import model.Arme;

public class MapLauncher extends JFrame{
	
	private static int WIDHT = 1280;
	private static int HEIGHT = 720;
	
	public MapLauncher() {
		this.setTitle("MassEphec");
		this.setSize(new Dimension(WIDHT, HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main (String [] args) {
		Hero hero = new IT("bg");
		MouvementController controller =  new MouvementController(hero);
		JFrame frame = new MapLauncher();
		GamePanel panel = new GamePanel(1280, 720, hero, controller, frame);
		controller.addView(panel);
	}
}
