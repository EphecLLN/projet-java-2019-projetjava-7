/**
 * 
 */
package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Arme;
import model.Costard;
import model.Hero;
import model.Monstre;

/**
 * @author emmanuel foureau
 *
 */
class CostardTest {

	@Test
	void test() {
		Arme test = new Arme("test", 0, 0);
		Hero heroTest = new Hero("test",100,0,0,test,"market");
		Monstre testMonstre = new Monstre(0, "test", 100, 0, 0);
		test.setHero(heroTest);
		test.attaqueSpeciale(testMonstre);
		assertEquals(72, testMonstre.getVie());
		assertEquals(114, heroTest.getVie());
		
	}

}
