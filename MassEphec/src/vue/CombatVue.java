package vue;

import model.*;
import controller.*;
import java.util.Observer;

public abstract class CombatVue implements Observer{

	protected Hero heroModel;
	protected Boss bossModel;
	protected CombatController combat;
	protected MapController map;
	
	public CombatVue(Hero heroModel, Boss bossModel, CombatController combat) {
		this.heroModel = heroModel;
		this.bossModel = bossModel;
		this.combat = combat;
		this.map = map;
		heroModel.addObserver(this);
		bossModel.addObserver(this);
		
	}
	
	public abstract void enableWarning();
	
	public abstract void disableWarning();

}
