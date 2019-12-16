package controller;

import vue.*;
import model.*;
import controller.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class MouvementController {
	private Hero hero;
	private GamePanel view = null;
		
	public MouvementController(Hero h) {
		this.hero=h;
	}
	
	 public void haut(int a){
		 if(a==0) {
			 hero.bougerHaut();
		 }
	 }
	 
	 public void bas(int a) {
		 if(a==0) {
			 hero.bougerBas();
		 }
	 }
	 
	 public void droite(int a) {
		 if(a==0) {
			 hero.bougerDroite();
		 }
	 }
	 
	 public void gauche(int a) {
		 if(a==0) {
			 hero.bougerGauche();
		 }
	 }
	 
	 public void ajouterExpArme(int exp) {
		 hero.getArme().ajouterExp(exp);
	 }
	 
	 public void changeMap() {
		 hero.setMapNum(hero.getMapNum() + 1);
	 }
	 
	 public void enterFight(boolean enCombat) {
		 hero.setEnCombat(enCombat);
	 }
	 public void addView(GamePanel panel) {
		 this.view = panel;
	 }
	 
}
