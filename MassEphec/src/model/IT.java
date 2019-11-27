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
	
	public IT() {
		super("Informaticien", 100, 0, 0);
		this.pc = new Pc();
	}
	
}
