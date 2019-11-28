package vue;

import model.*;
import java.util.Observer;

public abstract class CombatVue implements Observer{

	protected Hero heroModel;
	protected Boss bossModel;
	protected CombatController controller;
	
	CombatVue(Hero heroModel, Boss bossModel, combatController controller) {
		this.heroModel = heroModel;
		this.bossModel = bossModel;
		this.controller = controller;
		heroModel.addObserver(this);
		bossModel.addObserver(this);
		
	}
	
	public abstract void enableWarning();
	
	public abstract void disableWarning();

}
