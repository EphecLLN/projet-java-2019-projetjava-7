package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Personnage;

class PersonnageTest {

	@Test
	void testEnVie() {
		Personnage test = new Personnage("", 0, 0, 0);
		assertTrue(test.enVie());
		assertFalse(test.enVie());
		assertFalse(test.enVie());
	}

}
