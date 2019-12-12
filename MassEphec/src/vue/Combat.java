package vue;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import controller.*;
import model.Boss;
import model.Hero;

public class Combat extends CombatVue {

	private CombatControllerConsole combat;
	
	private JFrame window;
	private Container con;
	private JPanel buttonPanel, textPanel, bossHealth, heroHealth;
	private JButton atkButton, atkSpeButton;
	private JLabel imageHero, imageBoss, attaque;
	private Font policeNormale = new Font ("Times New Roman", Font.PLAIN,30);
	private JProgressBar heroHealthBar, bossHealthBar;
	
	
	private ImageIcon heros = new ImageIcon("res/heros.png");
	private ImageIcon boss = new ImageIcon("res/monstre.jpg");
	private Icon imgIcon = new ImageIcon("res/attaque.gif");
	


	
	public Combat(Hero heroModel, Boss bossModel, CombatControllerConsole combat) {
		super(heroModel, bossModel);
		this.combat = combat;
		window =new JFrame("TestCombat"); 
		window.setSize(1280,720);    
		window.setLayout(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screenSetup();
	
	}

	public void screenSetup() {         
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(410, 460, 320, 200);
		buttonPanel.setBackground(Color.blue);
		buttonPanel.setLayout(new GridLayout(2,1));
		window.add(buttonPanel);
		
		textPanel = new JPanel();
		//textPanel.setBounds(410, )
		
		attaque = new JLabel(imgIcon);
		attaque.setBounds(410, 150, 90, 200); 
		
		atkButton = new JButton("Attaque basique");
		atkButton.setBackground(Color.white);
		atkButton.setForeground(Color.black);
		atkButton.setFont(policeNormale);
		atkButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
		             click(e);
			}
		});  
		atkButton.setActionCommand("atk");
		buttonPanel.add(atkButton);
		
		atkSpeButton = new JButton("Attaque Spéciale");
		atkSpeButton.setBackground(Color.white);
		atkSpeButton.setForeground(Color.black);
		atkSpeButton.setFont(policeNormale);
		atkSpeButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
		             click(e);
			}  
		});  
		atkSpeButton.setActionCommand("atkSpe");
		buttonPanel.add(atkSpeButton);
		
		heroHealth = new JPanel();
		heroHealth.setBounds(100, 410, 300, 20);
		heroHealth.setBackground(Color.white);
		window.add(heroHealth); 
		heroHealthBar = new JProgressBar(0, heroModel.getVieMax());
		heroHealthBar.setPreferredSize(new Dimension (300, 20));
		heroHealthBar.setBackground(Color.red);
		heroHealthBar.setForeground(Color.green);
		heroHealthBar.setValue(heroModel.getVie());
		heroHealth.add(heroHealthBar);
		
		bossHealth = new JPanel();
		bossHealth.setBounds(700, 410, 300, 20);
		bossHealth.setBackground(Color.white);
		window.add(bossHealth); 
		bossHealthBar = new JProgressBar(0, bossModel.getVie());
		bossHealthBar.setPreferredSize(new Dimension (300, 20));
		bossHealthBar.setBackground(Color.red);
		bossHealthBar.setForeground(Color.green);
		bossHealthBar.setValue(bossModel.getVie());
		bossHealth.add(bossHealthBar);
		
		
		imageHero = new JLabel (heros);
		imageHero.setBounds(100, 100, 300, 300);
		window.add(imageHero);
		
		imageBoss = new JLabel (boss);
		imageBoss.setBounds(700, 100, 300, 300);
		window.add(imageBoss);
		
		
	}
	
	public void click(ActionEvent e) {
		String choix = e.getActionCommand();
		switch(choix) {
		case "atk":
			combat.attaqueHero();
			window.add(attaque);
			refresh();
		case "atkSpe" :
			combat.attaqueSpe();
			refresh();
			
		}	
		
	}
	
	public void refresh() {
		heroHealthBar.setValue(heroModel.getVie());
		bossHealthBar.setValue(bossModel.getVie());
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);
	}

	@Override
	public void enableWarning() {
		
	}

	@Override
	public void disableWarning() {
		
	}

}
