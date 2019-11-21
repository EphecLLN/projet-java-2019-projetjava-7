package model;

public class BoostArme extends Consommables{
	
	private int montantExp;
	
	public BoostArme(int coordX, int coordY) {
		super("RedBull",coordX, coordY);
		this.montantExp=99;
	}
	
	/*
	 * Cette methode attribue de l'exp a une arme 
	 */
	public void donneExp(Hero er) {
		er.getArme().setExperience(this.montantExp);
	}
}
