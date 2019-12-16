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
import Main.*;

public class Combat extends CombatVue implements KeyListener {
	
	private boolean gagne;

	private CombatControllerGUI combat;
	
	private JFrame window ;
	private Container con;
	private JPanel mainPanel, buttonPanel, textPanel, bossHealth, heroHealth, lastMsgPanel;
	private JButton atkButton, atkSpeButton, consomButton;
	private JLabel imageHero, imageBoss, attaque, msgEnd;
	private JScrollPane scroller;
	private JProgressBar heroHealthBar, bossHealthBar;
	private JTextArea msgAtk;
	
	private KeyListener kListener;
	
	private Font policeBoutton = new Font ("Times New Roman", Font.PLAIN,30);
	private Font policeNormale = new Font ("Times New Roman", Font.PLAIN,20);
	
	private ImageIcon heros = new ImageIcon(heroModel.getPath());
	private ImageIcon boss = new ImageIcon(bossModel.getPath());
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
		
		
	}
	
	public void click(ActionEvent e) {
		String choix = e.getActionCommand();
		switch(choix) {
		case "atk":
			combat.attaqueHero();
			mainPanel.add(attaque);
			msgAtk.append("Vous venez d'attaquer " + bossModel.getNom() + " pour un total de " + heroModel.getArme().getDegat() +" dégats!\n");
			break;
		case "atkSpe" :
			combat.attaqueSpe();
			msgAtk.append("Vous venez de faire votre attaque spéciale sur " + bossModel.getNom() + " pour un total de " + heroModel.getArme().getDegat() +" dégats!\n");
			break;
		case "Consommable":
			combat.consommable();
			break;
		}
	}
	
	public void bossMort() {
		unclickable();
		msgEnd.setText("<html>Vous avez battu " + bossModel.getNom() + ", bien joué! <br> Il vous a donné " + bossModel.getCredit() + " crédits durements gagnés.. <br>Appuyez sur une touche pour continuer.</h");
		lastMsgPanel.setVisible(true);
		gagne = true;
		window.addKeyListener(this);
		System.out.println("BossMort");
		
		 try {
	            // connection et prÃ©paration de la query
	            Connection con = getConnection();
	            String query = "UPDATE " + DATABASE + "." + TABLE + " SET `vie` = '"+ heroModel.getVie() + "' , `x` = '" +heroModel.getCoordX() + "' , `y` = '"+ heroModel.getCoordY() + "' , `armeLevel` = '"+heroModel.getArme().getNiveau() + "' , `armeExperience` = '" + heroModel.getArme().getExperience() +"', `mapLevel` = '"+heroModel.getMapNum() + "' WHERE `nom` = '"+ heroModel.getNom() + "'; ";
	            PreparedStatement ps = con.prepareStatement(query);
                ps.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
        
	}
	
	public void heroMort() {
		unclickable();
		msgEnd.setText("<html>" + bossModel.getNom() + " vous a surmenés de travail... <br>Appuyez sur une touche pour quitter.");
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

	@Override
	public void enableWarning() {
		
	}

	@Override
	public void disableWarning() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (gagne) {
			window.setVisible(false);
			System.out.println("la");
		
			// new GamePanel(1280,720, heroModel, new MouvementController(heroModel));
			oldFrame.setVisible(true);
		}else {
			window.setVisible(false);
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
            System.out.println("ConnectÃ© Ã  la base de donnÃ©es");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


}
