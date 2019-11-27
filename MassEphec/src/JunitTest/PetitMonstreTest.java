package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class PetitMonstreTest {

	@Test
	void testDonneExpArme() {
		Pc arm = new Pc();
		PetitMonstre petitMons = new PetitMonstre(5, "conn", 5, 0, 0, 0, 5);
		petitMons.donneExpArme(arm);
		assertEquals(5, arm.getExperience());
	
		
	}

}
