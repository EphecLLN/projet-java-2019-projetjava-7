package model;
public class Hero extends Personnage{
	
	private int credit; 
	private Arme arme;
	private String classe;// IT compta ou market
	
	public Hero(String nom, int vie, int x, int y, Arme arme, String classe) {
		super(nom,vie,x,y);
		this.credit=0;
		this.arme=arme;
		this.classe=classe;
	}
	
	/*
	 * Fournit le nombre de credits que l'etudiant possede
	 * @return {int} le nombre de credits
	 */
	public int getCredit() {
		return this.credit;
	}
	/*
	 * Modifie le nombre de credits que l'etudiant possede
	 * @param {int} le nombre de credits à ajouter
	 */
	public void setCredit(int creds) {
		this.credit=creds;
	}
	/*
	 * Fournit la classe du hero
	 * @return {String} sa classe
	 */
	public String getClasse() {
		return this.classe;
	}
	/*
	 * Fournit l'arme que l'etudiant possede
	 * @return {Arme} 
	 */
	public Arme getArme() {
		return this.arme;
	}
	/*
	 * Fait bouger l'etudiant d'une case vers la droite
	 */
	public void bougerDroite() {
		if(this.getCoordX()<15) {
			this.setCoordX(this.getCoordX()+1);
		}
	}
	/*
	 * Fait bouger l'etudiant d'une case vers la gauche
	 */
	public void bougerGauche() {
		if(this.getCoordX()>0) {
			this.setCoordX(this.getCoordX()-1);
		}
	}
	/*
	 * Fait bouger l'etudiant d'une case vers le haut
	 */
	public void bougerHaut() {
		if(this.getCoordY()>0) {
			this.setCoordY(this.getCoordY()-1);
		}
	}
	/*
	 * Fait bouger l'etudiant d'une case vers le bas
	 */
	public void bougerBas() {
		if(this.getCoordY()<15) {
			this.setCoordY(this.getCoordY()+1);
		}
	}
	/*
	 * attaque un monstre en lui enlevant de la vie;
	 * @param{Monstre} le monstre a attaquer
	 */
	/*public void attaque(Monstre m) {
		this.arme.attaqueDeBase(m);
	}*/
}