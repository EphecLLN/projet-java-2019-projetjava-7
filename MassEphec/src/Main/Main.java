package Main;

import model.*;
import controller.*;
import vue.*;

public class Main {
	public Main() {
		IT hero= new IT("Toto");
		Boss prof= new Boss(5, "Mr Delvigne",100, 0, 0, 20, "Bonjour messieurs");
		CombatController c=new CombatController(hero,prof);
		CombatVueConsole cv= new CombatVueConsole(hero,c);
		c.addView(cv);
	}
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}

}
