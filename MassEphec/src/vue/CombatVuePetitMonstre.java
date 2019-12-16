package vue;

import model.*;
import controller.*;
import java.util.Observer;

public abstract class CombatVuePetitMonstre implements Observer{

	protected Hero heroModel;
	protected PetitMonstre monstre;
	
	public CombatVuePetitMonstre(Hero heroModel, PetitMonstre monstre) {
		this.heroModel = heroModel;
		this.monstre = monstre;
		heroModel.addObserver(this);
		this.monstre.addObserver(this);
		
	}
	
	public abstract void enableWarning();
	
	public abstract void disableWarning();

}