package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Personnage;

class PersonnageTest {

	@Test
	void testEnVie() {
		Personnage test = new Personnage("test");
		assertTrue(test.enVie(50));
		assertFalse(test.enVie(0));
		assertFalse(test.enVie(-10));
	}

}
