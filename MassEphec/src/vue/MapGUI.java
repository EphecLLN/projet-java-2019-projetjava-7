package vue;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.MapController;
import model.*;
import controller.*;

public class MapGUI implements Observer {
	
	protected Scanner sc;
	private Hero heroModel;
	private MapController controller;
	
	
	public MapGUI(Hero heroModel, MapController controller) {
		this.heroModel = heroModel;
		this.controller = controller;
	}
	
	public void affiche(String s) {
		System.out.println(s);
	}
	
	public void disableWarning() {
	}
	
	public void enableWarning() {
		affiche("Erreur");
	}
	
	public void update(Observable o, Object arg) {
		
	}
}
