package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Monstre;
import model.Pc;

class PcTest {

	@Test
	void testAttaqueSpeciale() {
		Pc arme = new Pc(); // Pc a 20 de degats
		Monstre monstre = new Monstre(0, "test", 100, 0,0);
		arme.attaqueSpeciale(monstre);
		assertEquals(70, monstre.getVie());
	}

}
