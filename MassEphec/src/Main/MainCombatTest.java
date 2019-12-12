package Main;
import vue.*;
import model.*;
import controller.*;

public class MainCombatTest {

	public MainCombatTest() {
		Hero h = new IT("Georges");
		new Combat(h, new Boss(0, null, 100, 0, 0, 0, null), new CombatControllerConsole(h,new Boss(5, "Mr Delvigne",100, 0, 0, 20, "Bonsoir messieurs, j'ai vu votre devoir hier il �tait... Int�ressant.")));
	}
	
	public static void main (String [] args) {
		new MainCombatTest();
		
	}

}
