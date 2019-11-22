package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Arme;
import model.BoostVie;
import model.Hero;

class TestBoostVie {

	@Test
	void testConstructeur() {
		BoostVie b= new BoostVie(2,4);
		assertEquals("Monster Energy",b.getNom());
		assertEquals(2,b.getCoordX());
		assertEquals(4,b.getCoordY());
	}
	
	@Test
	void testDonneVie() {
		BoostVie b= new BoostVie(2,4);
		Arme arm= new Arme("PC",0,0);
		Hero nv = new Hero("maxime",50,0,0,arm,"IT");
		b.donneVie(nv);
		assertEquals(100,nv.getVie());
	}

}
