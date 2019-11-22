package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Arme;
import model.Hero;

class BossTest {

	@Test
	void testDonneCreditJoueur() {
		Arme arm = new Arme();
		Hero joueur = new Hero("maxime",100,0,0,arm,"IT");
		
	}

}
