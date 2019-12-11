package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.*;
import model.Boss;
import model.Hero;

public class Combat extends CombatVue {
	
	private CombatControllerGUI combat;
	
	public Combat(Hero heroModel, Boss bossModel, CombatControllerGUI combat) {
		super(heroModel, bossModel);
		this.combat = combat;
		screenSetup();
	
	}

	public void screenSetup() {
		JFrame f=new JFrame("Button Example");            
		JButton atk=new JButton("Attaque"); 
		JButton atkSpe = new JButton ("Attaque spéciale");
		atk.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				combat.attaquerBoss(f);
			}
		});
		atkSpe.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				combat.attaqueSpecialeBoss(f);
			}
		});
		atk.setBounds(320, 550 ,140, 40);   
		atkSpe.setBounds(320, 600, 140, 40);
		f.add(atk);
		f.add(atkSpe);
		f.setSize(1280,720);    
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
	public void enableWarning() {
		
	}

	@Override
	public void disableWarning() {
		
	}

}
