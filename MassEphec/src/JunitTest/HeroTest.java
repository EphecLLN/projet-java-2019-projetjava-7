package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class HeroTest {

	@Test
	void testConstructeur() {//test constructeur avec maxime et IT
		Pc arm= new Pc();
		IT nv = new IT();
		assertEquals(0,nv.getCredit());
		assertEquals("IT",nv.getClass().getSimpleName());
	}
	@Test
	void testSetCredit() {//test de setCredit en ajoutant 60 credits
		Pc arm= new Pc();
		IT nv = new IT();
		nv.setCredit(60);
		assertEquals(60,nv.getCredit());
	}
	@Test
	void testBougerDroite() {//test de la methode bougerDroite, on test lorsque la coord x vaut 0 et vaut 15(cas critique)
		Pc arm= new Pc();
		IT nv = new IT();
		nv.bougerDroite();
		assertEquals(1,nv.getCoordX());
		nv.setCoordX(15);
		nv.bougerDroite();
		assertEquals(15,nv.getCoordX());
	}
	@Test
	void testBougerGauche() {//test de la methode bougerGauche, on test lorsque la coord x vaut 0(cas critique) et vaut 15
		Pc arm= new Pc();
		IT nv = new IT();
		nv.bougerGauche();
		assertEquals(0,nv.getCoordX());
		nv.setCoordX(15);
		nv.bougerGauche();
		assertEquals(14,nv.getCoordX());
	}
	@Test
	void testBougerHaut() {//test de la methode bougerHaut, on test lorsque la coord Y vaut 0(cas critique) et vaut 15
		Pc arm= new Pc();
		IT nv = new IT();
		nv.bougerHaut();
		assertEquals(0,nv.getCoordY());
		nv.setCoordY(15);
		nv.bougerHaut();
		assertEquals(14,nv.getCoordY());
	}
	@Test
	void testBougerBas() {//test de la methode bougerBas, on test lorsque la coord Y vaut 0 et vaut 15(cas critique)
		Pc arm= new Pc();
		IT nv = new IT();
		nv.bougerBas();
		assertEquals(1,nv.getCoordY());
		nv.setCoordY(15);
		nv.bougerBas();
		assertEquals(15,nv.getCoordY());
	}
}