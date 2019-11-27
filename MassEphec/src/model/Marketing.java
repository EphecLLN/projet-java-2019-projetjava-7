/**
 * 
 */
package model;

/**
 * @author emman
 *
 */
public class Marketing extends Hero {
	// Variable d'instance 
	
	Costard costard;
	
	public Marketing() {
		super("Market", 100,0,0);
		this.costard = new Costard();
	}

}
