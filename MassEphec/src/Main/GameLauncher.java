package Main;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.MouvementController;
import db.Jdbc;
import model.Hero;
import vue.Combat;
import vue.GamePanel;
import vue.Login;

public class GameLauncher extends Thread {

	private Login loginPage;
	private MotherClasse classeMere = new MotherClasse();
	private Hero hero;
	private GamePanel map;
	private JFrame mainFrame = new JFrame();
	
	public GameLauncher(Hero hero) {
			this.hero = hero;
			mainFrame.setTitle("MassEphec");
			mainFrame.setSize(new Dimension(1280, 835));
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setVisible(true);
			
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				map = new GamePanel(1280, 835, hero, new MouvementController(hero), mainFrame);
			}
		});
	}

	public static void main(String[] args) {
		 try {
	            Jdbc.main(null);
	        }catch(Exception e){System.out.println(e);}
	        finally{
	            System.out.println("Tables construites.");
	        }   
			new Login();
	}
}
