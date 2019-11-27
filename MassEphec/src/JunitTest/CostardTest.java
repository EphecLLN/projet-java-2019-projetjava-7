/**
 * 
 */
package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Arme;
import model.Costard;
import model.Hero;
import model.Marketing;
import model.Monstre;

/**
 * @author emmanuel foureau
 *
 */
class CostardTest {

	@Test
	void test() {
		Costard test = new Costard();
		Marketing heroTest = new Marketing();
		Monstre testMonstre = new Monstre(0, "test", 100, 0, 0);
		test.setHero(heroTest);
		test.attaqueSpeciale(testMonstre);
		assertEquals(72, testMonstre.getVie());
		assertEquals(114, heroTest.getVie());
		
	}

}
