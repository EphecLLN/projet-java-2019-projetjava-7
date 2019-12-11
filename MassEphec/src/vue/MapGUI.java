package vue;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.MapController;
import model.*;
import controller.*;
import Main.MassEphec;

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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int heigth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
}
