package vue;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Observable;

import javax.swing.BoxLayout;
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
import model.*;
import Main.*;

public class Combat extends CombatVue implements KeyListener {
	
	private boolean gagne;

	private CombatControllerGUI combat;
	
	private JFrame window;
	private Container con;
	private JPanel mainPanel, buttonPanel, textPanel, bossHealth, heroHealth, lastMsgPanel, victoryFrame;
	private JButton atkButton, atkSpeButton, consomButton;
	private JLabel imageHero, imageBoss, attaque, msgEnd, titreVictoire, imageVictoire;
	private JScrollPane scroller;
	private JProgressBar heroHealthBar, bossHealthBar;
	private JTextArea msgAtk;
	
	private KeyListener kListener;
	
	private Font policeBoutton = new Font ("Times New Roman", Font.PLAIN,30);
	private Font policeNormale = new Font ("Times New Roman", Font.PLAIN,20);
	
	private ImageIcon heros = new ImageIcon(new ImageIcon(heroModel.getPath()).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	private ImageIcon boss = new ImageIcon(bossModel.getPath());
	private ImageIcon victoryImage = new ImageIcon("res/VictoireScreen.png");
	private Icon imgIcon = new ImageIcon("res/attaque.gif");
	
	private JFrame oldFrame;
	
	public Combat(Hero heroModel, Boss bossModel, CombatControllerGUI combat, JFrame frame) {
		super(heroModel, bossModel);
		this.combat = combat;
		combat.addView(this);
		this.oldFrame = frame;
		
		window = new JFrame("Combat");
		window.setSize(1280,720);    
		window.setLayout(null);
		window.setVisible(true);
		window.setBackground(Color.white);
		window.setFocusable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel =new JPanel(); 
		mainPanel.setSize(1280,830);    
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		mainPanel.setBackground(Color.white);
		this.window.add(mainPanel);
		
		screenSetup();
	
	}

	public void screenSetup() {         
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(410, 460, 320, 200);
		buttonPanel.setBackground(Color.blue);
		buttonPanel.setLayout(new GridLayout(3,1));
		mainPanel.add(buttonPanel);
		
		textPanel = new JPanel();
		textPanel.setBounds(1000, 100, 200, 500);
		//textPanel.setBackground(Color.blue);
		mainPanel.add(textPanel);
		textPanel.setBackground(Color.white);
		
		
		msgAtk = new JTextArea();
		msgAtk.setBounds(80, 450, 320, 200);
		msgAtk.setLineWrap(true);
		msgAtk.setEditable(false);
		//msgAtk.setFont(policeNormale);
		msgAtk.append(bossModel.getNom() + " : \""+bossModel.getSpeech() + "\"\n");
		
		scroller = new JScrollPane(msgAtk);
		scroller.setPreferredSize(new Dimension(200,320));
		scroller.setBackground(Color.gray);
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
		
		atkSpeButton = new JButton("Attaque Sp�ciale");
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
		mainPanel.add(heroHealth); 
		heroHealthBar = new JProgressBar(0, heroModel.getVieMax());
		heroHealthBar.setPreferredSize(new Dimension (300, 20));
		heroHealthBar.setBackground(Color.red);
		heroHealthBar.setForeground(Color.green);
		heroHealthBar.setValue(heroModel.getVie());
		heroHealth.add(heroHealthBar);
		
		bossHealth = new JPanel();
		bossHealth.setBounds(680, 410, 300, 20);
		bossHealth.setBackground(Color.white);
		mainPanel.add(bossHealth); 
		bossHealthBar = new JProgressBar(0, bossModel.getVie());
		bossHealthBar.setPreferredSize(new Dimension (300, 20));
		bossHealthBar.setBackground(Color.red);
		bossHealthBar.setForeground(Color.green);
		bossHealthBar.setValue(bossModel.getVie());
		bossHealth.add(bossHealthBar);
		
		lastMsgPanel = new JPanel();
		lastMsgPanel.setBounds(100, 200, 900, 200);
	//	lastMsgPanel.setBackground(Color.);
		lastMsgPanel.setVisible(false);
		mainPanel.add(lastMsgPanel);
		
		msgEnd = new JLabel();
		msgEnd.setPreferredSize(new Dimension(900,200));
		msgEnd.setVisible(true);
		msgEnd.setForeground(Color.black);
		msgEnd.setFont(policeBoutton);
		lastMsgPanel.add(msgEnd);
		
		imageHero = new JLabel (heros);
		imageHero.setBounds(100, 100, 300, 300);
		mainPanel.add(imageHero);
		
		imageBoss = new JLabel (boss);
		imageBoss.setBounds(700, 100, 300, 300);
		mainPanel.add(imageBoss);
		msgAtk.append(heroModel.getArme().msgAttSpe());
		
	}
	
	public void click(ActionEvent e) {
		String choix = e.getActionCommand();
		switch(choix) {
		case "atk":
			combat.attaqueHero();
			mainPanel.add(attaque);
			msgAtk.append("Vous venez d'attaquer " + bossModel.getNom() + " pour un total de " + heroModel.getArme().getDegat() +" d�gats!\n");
			break;
		case "atkSpe" :
			combat.attaqueSpe();
			msgAtk.append(heroModel.getArme().attSpeDegat());
			break;
		case "Consommable":
			combat.consommable();
			break;
		}
	}
	
	public void bossMort() {
		unclickable();
		msgEnd.setText("<html>Vous avez battu " + bossModel.getNom() + ", bien jou�! <br> Il vous a donn� " + bossModel.getCredit() + " cr�dits durements gagn�s.. <br>Appuyez sur une touche pour continuer.</h");
		lastMsgPanel.setVisible(true);
		gagne = true;
		window.addKeyListener(this);
		System.out.println("BossMort");
		
		 try {
	            // connection et préparation de la query
	            Connection con = getConnection();
	            String query = "UPDATE " + DATABASE + "." + TABLE + " SET `vie` = '"+ heroModel.getVie() + "' , `armeLevel` = '"+heroModel.getArme().getNiveau() + "' , `armeExperience` = '" + heroModel.getArme().getExperience() +"', `mapLevel` = '"+(heroModel.getMapNum()+1) + "' , `credit` = '" + heroModel.getCredit() + "' WHERE `nom` = '"+ heroModel.getNom() + "'; ";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public void heroMort() {
		unclickable();
		msgEnd.setText("<html>" + bossModel.getNom() + " vous a surmen�s de travail... <br>Appuyez sur une touche pour quitter.");
		lastMsgPanel.setVisible(true);
		gagne = false;
		window.addKeyListener(this);
		
	}
	
	public void unclickable() {
		atkButton.setEnabled(false);
		atkSpeButton.setEnabled(false);
		consomButton.setEnabled(false);
	}
	@Override
	public void update(Observable o, Object arg) {
		heroHealthBar.setValue(heroModel.getVie());
		bossHealthBar.setValue(bossModel.getVie());
	
	}
	
	public void setVictory() {
		victoryFrame = new JPanel();
		victoryFrame.setSize(new Dimension(1280, 720));
		victoryFrame .setLayout((new BoxLayout(victoryFrame, BoxLayout.PAGE_AXIS)));
		titreVictoire = new JLabel();
		titreVictoire.setSize(1280, 120);
		titreVictoire.setText("Vous avez eu les 60 cr�dits ! A l'ann�e prochaine !");
		titreVictoire.setPreferredSize(new Dimension(1280, 120));
		titreVictoire.setVisible(true);
		victoryFrame.add(titreVictoire);
		imageVictoire = new JLabel (victoryImage);
		imageVictoire.setSize(1280, 600);
		imageVictoire.setVisible(true);
		imageVictoire.setPreferredSize(new Dimension(1280, 600));
		victoryFrame.add(imageVictoire);
		victoryFrame.setVisible(true);
		window.setContentPane(victoryFrame);
		window.setTitle("Victoire");
	}

	@Override
	public void enableWarning() {
		
	}

	@Override
	public void disableWarning() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (heroModel.getCredit() < 60) {
			if (gagne) {
				window.setVisible(false);
				System.out.println("la");
				oldFrame.setVisible(true);
				
			}else {
				window.setVisible(false);
				 try {
			            // connection et préparation de la query
			            Connection con = getConnection();
			            String query = "DELETE FROM `massephec`.`heroes` WHERE `nom` = '"+ heroModel.getNom() + "';";
			            PreparedStatement ps = con.prepareStatement(query);
			            ps.executeUpdate();
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			}
		}
		else {
			setVictory();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
	}
	

	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	    static final String DATABASE = "massephec";
	    static final String URL = "jdbc:mysql://localhost/"+DATABASE+"?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	    static final String USERNAME = "root";
	    static final String PASSWORD = "";
	    static final String TABLE = "heroes";

		
	    public static Connection getConnection() throws Exception {
	        try {
	            Class.forName(DRIVER);
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/massephec?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", USERNAME, PASSWORD);
	            System.out.println("Connecté à la base de données");
	            return conn;
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	    }

}
