package Main;
import vue.*;
import model.*;
import controller.*;

public class MainCombatTest {

	public MainCombatTest() {
		new Combat(new Hero(null, 0, 0, 0, null), new Boss(0, null, 0, 0, 0, 0, null), new CombatControllerGUI());
	}
	
	public static void main (String [] args) {
		new MainCombatTest();
		
	}

}
