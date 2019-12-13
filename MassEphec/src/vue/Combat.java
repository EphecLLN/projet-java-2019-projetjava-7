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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.*;
import model.Boss;
import model.Hero;

public class Combat extends CombatVue {

	private CombatControllerGUI combat;
	
	private JFrame window;
	private Container con;
	private JPanel buttonPanel, textPanel, bossHealth, heroHealth;
	private JButton atkButton, atkSpeButton, consomButton;
	private JLabel imageHero, imageBoss, attaque;
	private JScrollPane scroller;
	private JProgressBar heroHealthBar, bossHealthBar;
	private JTextArea msgAtk, msgAtkSpe;
	
	private Font policeBoutton = new Font ("Times New Roman", Font.PLAIN,30);
	private Font policeNormale = new Font ("Times New Roman", Font.PLAIN,20);
	
	
	private ImageIcon heros = new ImageIcon("res/heros.png");
	private ImageIcon boss = new ImageIcon("res/monstre.jpg");
	private Icon imgIcon = new ImageIcon("res/attaque.gif");
	


	
	public Combat(Hero heroModel, Boss bossModel, CombatControllerGUI combat) {
		super(heroModel, bossModel);
		this.combat = combat;
		combat.addView(this);
		window =new JFrame("TestCombat"); 
		window.setSize(1280,720);    
		window.setLayout(null);
		window.setVisible(true);
		window.setBackground(Color.white);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screenSetup();
	
	}

	public void screenSetup() {         
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(410, 460, 320, 200);
		buttonPanel.setBackground(Color.blue);
		buttonPanel.setLayout(new GridLayout(3,1));
		window.add(buttonPanel);
		
		textPanel = new JPanel();
		textPanel.setBounds(1000, 100, 200, 500);
		//textPanel.setBackground(Color.blue);
		window.add(textPanel);
		
		
		msgAtk = new JTextArea();
		msgAtk.setBounds(80, 450, 320, 200);
		msgAtk.setLineWrap(true);
		msgAtk.setEditable(false);
		//msgAtk.setFont(policeNormale);
		
		scroller = new JScrollPane(msgAtk);
		scroller.setPreferredSize(new Dimension(200,320));
		textPanel.add(scroller);
		
		attaque = new JLabel(imgIcon);
		attaque.setBounds(410, 150, 90, 200); 
		
		atkButton = new JButton("Attaque basique");
		atkButton.setBackground(Color.white);
		atkButton.setForeground(Color.black);
		atkButton.setFont(policeBoutton);
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
		atkSpeButton.setFont(policeBoutton);
		atkSpeButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
		             click(e);
			}  
		});  
		atkSpeButton.setActionCommand("atkSpe");
		buttonPanel.add(atkSpeButton);
		
		consomButton = new JButton("Consommable");
		consomButton.setBackground(Color.black);
		consomButton.setForeground(Color.white);
		consomButton.setFont(policeBoutton);
		consomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		consomButton.setActionCommand("Consommable");
		buttonPanel.add(consomButton);
		
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
		bossHealth.setBounds(680, 410, 300, 20);
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
			msgAtk.append("Vous venez d'attaquer " + bossModel.getNom() + " pour un total de " + heroModel.getArme().getDegat() +" dégats!\n");
			window.setVisible(false);
			
			refresh();
			break;
		case "atkSpe" :
			combat.attaqueSpe();
			msgAtk.append("Vous venez de faire votre attaque spéciale sur " + bossModel.getNom() + " pour un total de " + heroModel.getArme().getDegat() +" dégats!\n");
			refresh();
			break;
		case "Consommable":
			combat.consommable();
			break;
		}	
		
	}
	
	public void refresh() {
		heroHealthBar.setValue(heroModel.getVie());
		bossHealthBar.setValue(bossModel.getVie());
	}
	public void bossMort() {
		unclickable();
	}
	
	public void heroMort() {
		unclickable();
	}
	
	public void unclickable() {
		atkButton.setEnabled(false);
		atkSpeButton.setEnabled(false);
		consomButton.setEnabled(false);
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
