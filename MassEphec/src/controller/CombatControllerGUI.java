package controller;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.*;
import vue.*;

public class CombatControllerGUI {
	
	private Hero hero;
	private Boss boss;
	private Combat view = null;
	public CombatControllerGUI(Hero hero, Boss boss) {
		this.hero = hero;
		this.boss = boss;
		
	}
	
	public void attaqueHero() {
		
	}
	
	public void attaqueSpec() {
		
	}
	
	public void attaqueBoss() {
		
	}
	
	public void consommable() {
		
	}
	
	public void ajouterCredit() {
		
	}
	public void addView(Combat view) {
		this.view = view;
	}
}
