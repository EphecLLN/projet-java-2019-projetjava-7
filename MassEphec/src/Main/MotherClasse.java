package Main;
import vue.*;
import model.*;

import javax.swing.JFrame;

import controller.*;


public class MotherClasse {

	public MotherClasse() {
	}
	
	public void createCombat(Hero hero, Boss boss) {
		new Combat(hero, boss, new CombatControllerGUI(hero, boss));
	}
	

}

