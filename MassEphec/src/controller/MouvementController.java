package controller;

import vue.*;
import model.*;
import controller.*;
import java.util.Observable;
import java.util.Observer;

public class MouvementController {
	private Hero hero;
	private GamePanel map;
		
	public MouvementController(Hero h, GamePanel m) {
		this.hero=h;
		this.map=m;
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
	 
}
