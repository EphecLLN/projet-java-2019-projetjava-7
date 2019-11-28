package Main;

import model.*;
import controller.*;
import vue.*;
import java.util.Scanner;

public class Main {
	public Main(String n, String classe) {
		Hero h;
		if(classe.equals("IT")) {
			h=new IT(n);
		}else if(classe.equals("Marketing")) {
			h=new Marketing(n);
		}else {
			h=new Comptabilite(n);
		}System.out.println(h.getArme());
		Boss prof= new Boss(5, "Mr Delvigne",100, 0, 0, 20, "Bonsoir messieurs, j'ai vu votre devoir hier il était... Intéressant.");
		CombatController c =new CombatController(h,prof);
		CombatVueConsole cv = new CombatVueConsole(h, prof, c);
		c.addView(cv);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Donnez moi votre nom");
		String nom=sc.nextLine();
		System.out.println("Donnez moi votre classe (IT, Compta ou Marketing)");
		String classe = sc.nextLine();
		
	/*	while (true) {
			switch(sc.nextLine().toLowerCase()) {
				case "it" : 
					classe = "IT";
					break;
				case "compta" :
					classe = "Comptabilite";
					break;
				case "marketing" :
					classe = "Marketing";
					break;
				default :
					System.out.println("Ceci n'est pas une classe valide, réessayez!");
			}
		}*/
		
		System.out.println("Bonjour à toi "+ nom +" étudiant en "+ classe);
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main(nom,classe);
			}
		});
	}

}
