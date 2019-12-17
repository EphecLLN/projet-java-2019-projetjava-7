package model;


public class Hero extends Personnage {
	
	private int credit, vieMax; 
	private Arme arme;
	public String classe;// IT compta ou market
	public int mapNum;
	private boolean enCombat;
	private LinkedList listVie= new LinkedList();
	
	public Hero(String nom, String path,int vie, int x, int y, Arme arme) {
		super(nom, path,vie,x,y);
		this.vieMax = vie;
		this.credit=0;
		this.arme = arme;
		this.mapNum = 1;
	}
	
	/*
	 * Fournit le nombre de credits que l'etudiant possede
	 * @return {int} le nombre de credits
	 */
	public int getCredit() {
		return this.credit;
	}
	public int getVieMax() {
		return this.vieMax;
	}
	/*
	 * Modifie le nombre de credits que l'etudiant possede
	 * @param {int} le nombre de credits à ajouter
	 */
	public void setCredit(int creds) {
		this.credit=creds;
		setChanged();
		notifyObservers();
	}
	/*
	
	/*
	 * Fournit l'arme que l'etudiant possede
	 * @return {Arme} 
	 */
	public Arme getArme() {
		return this.arme;
	}
	
	public void setArme(Arme arm) {
		this.arme = arm;
	}
	
	public void setMapNum(int mapNum) {
		this.mapNum = mapNum;
		setChanged();
		notifyObservers();
	}
	
	public int getMapNum() {
		return this.mapNum;
	}
	
	public String toString() {
		return this.getNom() + " vous avez encore " + this.getVie() + " points de vies.";
	}
	/*
	 * Fait bouger l'etudiant d'une case vers la droite
	 */
	public void bougerDroite() {
		
		this.setCoordX(this.getCoordX()+1);
		setChanged();
		notifyObservers();
	}
	/*
	 * Fait bouger l'etudiant d'une case vers la gauche
	 */
	public void bougerGauche() {
		this.setCoordX(this.getCoordX()-1);
		setChanged();
		notifyObservers();
	}
	/*
	 * Fait bouger l'etudiant d'une case vers le haut
	 */
	public void bougerHaut() {
		this.setCoordY(this.getCoordY()-1);
		setChanged();
		notifyObservers();
	}
	/*
	 * Fait bouger l'etudiant d'une case vers le bas
	 */
	public void bougerBas() {
		this.setCoordY(this.getCoordY()+1);
		setChanged();
		notifyObservers();
	}
	
	public void setEnCombat (boolean enCombat) {
		if(enCombat) {
			this.enCombat = true;
		}
		else {
			this.enCombat = false;
		}
	}
	
	public boolean getEnCombat() {
		return this.enCombat;
	}
	
	public LinkedList getList() {
		return this.listVie;
	}
	
}
