package Main;
import vue.*;
import model.*;
import controller.*;


public class MainCombatTest {

	public MainCombatTest() {
		Hero h = new IT("Georges");
		Boss b = new Boss(5, "Mr Delvigne",100, 0, 0, 20, "Bonsoir messieurs, j'ai vu votre devoir hier il �tait... Int�ressant.");
		new Combat(h, b, new CombatControllerGUI(h,b));
	}
	
	public static void main (String [] args) {
		new MainCombatTest();
		
	}

}

