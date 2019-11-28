/**
 * 
 */
package model;

/**
 * @author emman
 *
 */
public class IT extends Hero {
	// Variable d'instance 
	private Pc pc;
	
	public IT(String nom) {
		super(nom, 1000, 0, 0);
		this.pc = new Pc();
	}
	
}
