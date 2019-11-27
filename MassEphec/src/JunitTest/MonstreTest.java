package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class MonstreTest {

	@Test
	void testAttaque() {
		Pc arm = new Pc();
		IT testHero = new IT();
		Monstre testMonstre = new Monstre(30, "Boss1", 100, 0, 0);
		assertEquals(100,testHero.getVie());
		testMonstre.attaque(testHero);
		assertEquals(70, testHero.getVie());
		testMonstre.attaque(testHero);
		assertEquals(40, testHero.getVie());
		
	}

}
