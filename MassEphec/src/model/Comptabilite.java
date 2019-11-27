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

	Calculette calculette;
	
	public Comptabilite() {
		super("Comptable", 100, 0,0);
		this.calculette = new Calculette();
	}
}
