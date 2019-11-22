/**
 * Classe test de la classe Arme
 */
package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Arme;
import model.Personnage;

/**
 * @author emmanuel
 * Date de création : 15/11/19
 */
class ArmeTest {
	

	/**
	 * Classe test pour la classe "setExperience"
	 */
	@Test
	void testSetExperience() {
		Arme test = new Arme("Test", 0, 30);
		test.setExperience(101);
		assertEquals(1, test.getExperience());
		test.setExperience(-1);
		assertEquals(0, test.getExperience());
		test.setExperience(1);
		assertEquals(1, test.getExperience());
	}
	
	/**
	 * Classe test pour la classe "niveauSperieur"
	 */
	
	void testAjouterExp() {
		Arme test = new Arme("Test", 0, 30);
		test.setNiveau(1);
		test.niveauSuperieur();
		assertEquals(2, test.getNiveau());
	}
}
