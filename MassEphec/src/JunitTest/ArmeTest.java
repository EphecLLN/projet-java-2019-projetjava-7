/**
 * Classe test de la classe Arme
 */
package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Arme;
import model.Pc;
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
	void testAjouterExp() {
		Pc test = new Pc();
		test.ajouterExp(101);
		assertEquals(1, test.getExperience());
	}
	
	/**
	 * Classe test pour la classe "niveauSperieur"
	 */
	@Test
	void testNiveauSuperieur() {
		Arme test = new Pc();
		test.setNiveau(1);
		test.niveauSuperieur();
		assertEquals(2, test.getNiveau());
	}
}
