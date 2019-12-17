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

public class MapLauncher{
	
	
	
	public static void main (String [] args) {
		Hero hero = new IT("bg");
		MouvementController controller =  new MouvementController(hero);
		GamePanel panel = new GamePanel(1280, 720, hero, controller);
		controller.addView(panel);
	}
}
