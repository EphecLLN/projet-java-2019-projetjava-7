/**
 * 
 */
package model;

/**
 * @author emman
 *
 */
public class Comptabilite extends Hero{
	// Variable d'instance

	
	public Comptabilite(String n) {
		super(n, "res/compta.jpg", 100, 6,0, new Calculette());
	}
}
