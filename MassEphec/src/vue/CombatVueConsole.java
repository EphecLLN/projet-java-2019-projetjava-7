package vue;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.CombatController;
import model.Personnage;

public class CombatVueConsole implements Observer {
	
	protected Personnage modelH;
	protected CombatController controller;
	private boolean fin = false;
	
	protected Scanner sc;
	
	public CombatVueConsole(Personnage model, CombatController controller) {
		// super
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
		System.out.println(o);
		System.out.println(arg);
	}
	
	private class ReadInput implements Runnable {
		public void run() {
			
			while(!fin) {
				System.out.println("Ecrivez Attaque ou AttaqueSpe !");
				String attaque = sc.nextLine();
				switch (attaque) {
					case "Attaque" :  
				}
			}
		}
	}
}
