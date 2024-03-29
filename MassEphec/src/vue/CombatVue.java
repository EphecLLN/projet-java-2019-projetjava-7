package vue;

import model.*;
import controller.*;
import java.util.Observer;

public abstract class CombatVue implements Observer{

	protected Hero heroModel;
	protected Boss bossModel;
	
	public CombatVue(Hero heroModel, Boss bossModel) {
		this.heroModel = heroModel;
		this.bossModel = bossModel;
		heroModel.addObserver(this);
		bossModel.addObserver(this);
		
	}
	
	public abstract void enableWarning();
	
	public abstract void disableWarning();

}
