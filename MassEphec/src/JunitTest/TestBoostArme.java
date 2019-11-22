package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class TestBoostArme {

	@Test
	void testConstructeur() {
		BoostArme b= new BoostArme(2,4);
		assertEquals("RedBull",b.getNom());
		assertEquals(2,b.getCoordX());
		assertEquals(4,b.getCoordY());
	}
	
	@Test
	void testDonneExp() {
		BoostArme b= new BoostArme(2,4);
		Arme arm= new Arme("PC",0,0);
		Hero nv = new Hero("maxime",50,0,0,arm,"IT");
		b.donneExp(nv);
		assertEquals(99,nv.getArme().getExperience());
	}

}
