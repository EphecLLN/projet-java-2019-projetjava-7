package vue;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.CombatController;
import model.*;
import controller.*;

public class CombatVueConsole extends CombatVue implements Observer {
	
	private boolean fin = false;
	protected Scanner sc;
	
	
	public CombatVueConsole(Hero modelHero, Boss modelBoss, CombatController controller) {
		super(modelHero, modelBoss, controller);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();
	}

	public void enableWarning() {
		System.out.println("Le combat est fini !");
		fin = true;
	}
	
	public void disableWarning() {
		System.out.println("Le combat continue.");
	}
	
	public void update(Observable o, Object arg) {
		System.out.println(arg);
	}
	
	private class ReadInput implements Runnable {
		public void run() {
			System.out.println("\n \nAujourd'hui vous allez vous battre contre... " + bossModel.getNom() + "\n Il arrive! \n \n"
					+ bossModel.getNom()+": \n" + bossModel.getSpeech() + "\n");
			while(!fin) {
				System.out.println("Ecrivez Attaque ou AttaqueSpe !");
					switch (sc.nextLine().toLowerCase()) {
						case "attaque" :  
							combat.attaqueBoss();
							break;
						case "attaquespe" :
							combat.attaqueSpe();
							break;
						default :
							System.out.println("Donnée entrée incorrecte, veuillez réessayer");
							break;
					}
				}
			sc.close();
			}
		
	}
}
