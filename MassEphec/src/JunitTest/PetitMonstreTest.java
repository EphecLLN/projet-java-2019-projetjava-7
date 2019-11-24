package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class PetitMonstreTest {

	@Test
	void testDonneExpArme() {
		Arme arm = new Arme("bg",0,0);
		PetitMonstre petitMons = new PetitMonstre(5, "conn", 5, 0, 0, 0, 5);
		petitMons.donneExpArme(arm);
		assertEquals(5, arm.getExperience());
	
		
	}

}
