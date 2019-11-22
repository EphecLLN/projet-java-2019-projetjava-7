package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class BossTest {

	@Test
	void testDonneCreditJoueur() {
		Arme arm = new Arme("bg",0,0);
		Hero joueur = new Hero("maxime",100,0,0,arm,"IT");
		Boss bossy = new Boss(3, "nom", 1, 1, 1, 5, "Speech");
		bossy.donneCreditJoueur(joueur);
		assertEquals(5,joueur.getCredit());
		joueur.setCredit(14);
		bossy.donneCreditJoueur(joueur);
		assertEquals(19, joueur.getCredit());
	}
	void testMauvaiseNote() {
		Arme arm = new Arme("bg",0,0);
		Hero joueur = new Hero("maxime",100,0,0,arm,"IT");
		Boss bossy = new Boss(3, "nom", 1, 1, 1, 5, "Speech");
		bossy.mauvaiseNote(joueur);
		assertEquals(97,joueur.getVie());
		joueur.setVie(3);
		bossy.mauvaiseNote(joueur);
		assertEquals(0, joueur.getVie());
	}
}
