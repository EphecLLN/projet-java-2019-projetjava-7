package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Monstre;

class MonstreTest {

	@Test
	void testAttaque() {
		Hero testHero = new Hero("Test", 100, 0, 0,"IT");
		Monstre testMonstre = new Monstre("Boss1", 100, 0, 0, 30);
		assertEquals(100,testHero.getVie());
		testMonstre.attaque(testHero);
		assertEquals(70, testHero.getVie());
		testMonstre.attaque(testHero);
		assertEquals(40, testHero.getVie());
		
	}

}
