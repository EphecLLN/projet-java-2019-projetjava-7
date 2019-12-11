package controller;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.*;
import vue.*;

public class CombatControllerGUI {

	public CombatControllerGUI() {
		//private Hero hero;
		//private Boss boss;
		//private Combat vue = null;
	}
	
	public void attaquerBoss(JFrame frame) {
		JLabel label = new JLabel();
		label.setText("Vous attaquez le boss");
		frame.add(label);
		label.setBounds(100, 100, 380, 20);
		frame.repaint();
	}
	
	public void attaqueSpecialeBoss(JFrame frame) {
		
	}
	
}
