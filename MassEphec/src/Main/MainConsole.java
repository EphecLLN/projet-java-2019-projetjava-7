package Main;

import model.*;

import controller.*;
import vue.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MainConsole {
	public MainConsole(String n, String classe) {
		System.out.println("Bonjour à toi "+ n +" étudiant en "+ classe);
		Hero h;
		if(classe.equals("IT")) {
			h=new IT(n);
			h.getArme().setHero(h);
		}else if(classe.equals("Marketing")) {
			h=new Marketing(n);
			h.getArme().setHero(h);
		}else {
			h=new Comptabilite(n);
			h.getArme().setHero(h);
		}System.out.println(h.getArme());
		Boss prof= new Boss(5,"", "Mr Delvigne",100, 0, 0, 20, "Bonsoir messieurs, j'ai vu votre devoir hier il ï¿½tait... Intï¿½ressant.");
		CombatControllerConsole c =new CombatControllerConsole(h,prof);
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
				System.out.println("Mauvaise entrÃ©e");
			}
		}

		String classee = classe;
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new MainConsole (nom, classee);
			}
		});
	}

}