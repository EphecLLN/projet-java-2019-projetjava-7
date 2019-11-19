package JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Arme;
import model.Hero;

class HeroTest {

	@Test
	void testConstructeur() {//test constructeur avec maxime et IT
		Arme arm= new Arme();
		Hero nv = new Hero("maxime",100,0,0,arm,"IT");
		assertEquals(0,nv.getCredit());
		assertEquals("IT",nv.getClasse());
	}
	@Test
	void testSetCredit() {//test de setCredit en ajoutant 60 credits
		Arme arm= new Arme();
		Hero nv = new Hero("maxime",100,0,0,arm,"IT");
		nv.setCredit(60);
		assertEquals(60,nv.getCredit());
	}
	@Test
	void testBougerDroite() {//test de la methode bougerDroite, on test lorsque la coord x vaut 0 et vaut 15(cas critique)
		Arme arm= new Arme();
		Hero nv = new Hero("maxime",100,0,0,arm,"IT");
		nv.bougerDroite();
		assertEquals(1,nv.getCoordX());
		nv.setCoordX(15);
		nv.bougerDroite();
		assertEquals(15,nv.getCoordX());
	}
	@Test
	void testBougerGauche() {//test de la methode bougerGauche, on test lorsque la coord x vaut 0(cas critique) et vaut 15
		Arme arm= new Arme();
		Hero nv = new Hero("maxime",100,0,0,arm,"IT");
		nv.bougerGauche();
		assertEquals(0,nv.getCoordX());
		nv.setCoordX(15);
		nv.bougerGauche();
		assertEquals(14,nv.getCoordX());
	}
	@Test
	void testBougerHaut() {//test de la methode bougerHaut, on test lorsque la coord Y vaut 0(cas critique) et vaut 15
		Arme arm= new Arme();
		Hero nv = new Hero("maxime",100,0,0,arm,"IT");
		nv.bougerHaut();
		assertEquals(0,nv.getCoordY());
		nv.setCoordY(15);
		nv.bougerHaut();
		assertEquals(14,nv.getCoordY());
	}
	@Test
	void testBougerBas() {//test de la methode bougerBas, on test lorsque la coord Y vaut 0 et vaut 15(cas critique)
		Arme arm= new Arme();
		Hero nv = new Hero("maxime",100,0,0,arm,"IT");
		nv.bougerBas();
		assertEquals(1,nv.getCoordY());
		nv.setCoordY(15);
		nv.bougerBas();
		assertEquals(15,nv.getCoordY());
	}
}