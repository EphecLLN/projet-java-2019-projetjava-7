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
		Boss prof= new Boss(5, "Mr Delvigne",100, 0, 0, 20, "Bonsoir messieurs, j'ai vu votre devoir hier il �tait... Int�ressant.");
		CombatController c =new CombatController(h,prof);
		CombatVueConsole cv = new CombatVueConsole(h, prof, c);
		c.addView(cv);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Donnez moi votre nom");
		String nom=sc.nextLine();
		String classe="";
		boolean bonneEntree=true;
		while(bonneEntree) {
			System.out.println("Donnez moi votre classe (IT, Comptabilite ou Marketing)");
			classe = sc.nextLine();
			if(classe.equals("IT") || classe.equals("Marketing") || classe.equals("Comptabilite")) {
				bonneEntree=false;
			}
			else {
				System.out.println("Mauvaise entrée");
			}
		}
		String classes=classe;
		System.out.println("Bonjour �toi "+ nom +" �tudiant en "+ classes);
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new Main(nom,classes);
			}
		});
	}

}
