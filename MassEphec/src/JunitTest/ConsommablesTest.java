package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Consommables;

class ConsommablesTest {

	@Test
	void testConstructeur() {
		Consommables c= new Consommables("Burn",2,4);
		assertEquals("Burn",c.getNom());
		assertEquals(2,c.getCoordX());
		assertEquals(4,c.getCoordY());
	}

}
