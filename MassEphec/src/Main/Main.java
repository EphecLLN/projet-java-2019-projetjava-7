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
		}
		Boss prof= new Boss(5, "Mr Delvigne",100, 0, 0, 20, "Bonjour messieurs");
		CombatController c =new CombatController(h,prof);
		CombatVueConsole cv = new CombatVueConsole(h, prof, c);
		c.addView(cv);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Donnez moi votre nom");
		String nom=sc.nextLine();
		System.out.println("Donnez moi votre classe");
		String classe=sc.nextLine();
		System.out.println("Bonjour à toi "+nom+" étudiant en "+classe);
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main(nom,classe);
			}
		});
	}

}
