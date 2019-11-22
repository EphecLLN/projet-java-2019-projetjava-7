package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

<<<<<<< HEAD
import model.Hero;
import model.Monstre;
=======
import model.*;
>>>>>>> d51345a160d82ea6e9eb79474bf8df77d71f3618

class MonstreTest {

	@Test
	void testAttaque() {
		Arme arm= new Arme("PC",0,0);
		Hero testHero = new Hero("Test", 100, 0, 0, arm,"IT");
		Monstre testMonstre = new Monstre(30, "Boss1", 100, 0, 0);
		assertEquals(100,testHero.getVie());
		testMonstre.attaque(testHero);
		assertEquals(70, testHero.getVie());
		testMonstre.attaque(testHero);
		assertEquals(40, testHero.getVie());
		
	}

}
