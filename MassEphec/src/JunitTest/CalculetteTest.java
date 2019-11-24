package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Arme;
import model.Calculette;
import model.Monstre;

class CalculetteTest {

	@Test
	void testAttaqueSpeciale() {
		Calculette calc = new Calculette();
		Monstre monstre = new Monstre(0, "test", 100, 0,0);
		calc.attaqueSpeciale(monstre);
		assertEquals(75, monstre.getVie());
		assertEquals(22, calc.getDegat());
	}

}
