/**
 * 
 */
package model;

/**
 * @author Emmanuel Foureau
 */
public class Pc extends Arme {
	
	public Pc () {
		super("Pc", 0, 20);
	}
	
	public void attaqueGit(Monstre ennemi) { 
		int totalDegat = (int) (this.getDegat() * 2);
		ennemi.setVie(ennemi.getVie() - totalDegat);
	}
}
