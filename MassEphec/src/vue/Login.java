package vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Main.*;
import model.Hero;

import java.awt.Graphics;
import java.awt.Image;
  
public class Login extends JFrame implements ActionListener
 {
  
	
	
	private JPanel panel, buttonPanel, textPanel;
	private JButton commencer, reprendre, it, compta, market;
	private JLabel label1, label2,label3;
	private Font police = new Font ("Times New Roman", Font.PLAIN,20);
	private Font policeIn = new Font ("Times New Roman", Font.PLAIN,50);
	private JTextField  text1;
	public String nom, classe;
	
	private ImageIcon imgIt = new ImageIcon(new ImageIcon("res/IT.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
	private ImageIcon imCompta = new ImageIcon(new ImageIcon("res/Compta.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
	private ImageIcon imMarket = new ImageIcon(new ImageIcon("res/Market.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
	
	private CreationHero create = new CreationHero();
  	
  public Login()	{
	  	setSize(500,400);
		setVisible(true);
	  	panel =new JPanel();
		panel=new JPanel(new GridLayout(5,1));
		panel.setVisible(true);
		panel.setBackground(Color.black);
		setTitle("LOGIN");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	   label1 = new JLabel();
	   label1.setText("Votre nom:");
	   label1.setFont(police);
	   label1.setForeground(Color.orange);
	   text1 = new JTextField(15);
	   text1.setFont(policeIn);
	   panel.add(label1);
	   panel.add(text1);
	   add(panel,BorderLayout.CENTER);
	   
	   label2 = new JLabel();
	   label2.setText("Votre classe:");
	   label2.setFont(police);
	   label2.setForeground(Color.orange);
	   panel.add(label2);
	   add(panel,BorderLayout.CENTER);
	   
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		panel.add(buttonPanel);
		
		it = new JButton();
		it.setIcon(imgIt);
		it.setSize(4, 4);
		it.setForeground(Color.black);
		it.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
		             choixClasse(e);
			}
		});  
		it.setActionCommand("it");
		buttonPanel.add(it);
		
		compta = new JButton();
		compta.setIcon(imCompta);;
		compta.setForeground(Color.black);
		compta.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
		             choixClasse(e);
			}
		});  
		compta.setActionCommand("compta");
		buttonPanel.add(compta);
		
		market = new JButton();
		market.setIcon(imMarket);;
		market.setForeground(Color.black);
		market.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
		             choixClasse(e);
			}
		});  
		market.setActionCommand("market");
		buttonPanel.add(market);
		
		commencer = new JButton("Lancer");
		commencer.setForeground(Color.black);
		commencer.setFont(police);
		commencer.setEnabled(false);
		commencer.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
		             lancement(e);
			}
		});  
		panel.add(commencer);
		
		reprendre = new JButton("Reprendre");
		reprendre.setForeground(Color.black);
		reprendre.setFont(police);
		reprendre.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
		             chargerAncien(e);
			}
		});  
		panel.add(reprendre);
	   
	   
  }
  public void choixClasse(ActionEvent e) {
	  String choix = e.getActionCommand();
	  if(choix=="it") {
		  classe="IT";
	  }else if(choix=="market") {
		  classe="Marketing";
	  }else {
		  classe="Comptabilite";
	  }
	  commencer.setEnabled(true);
  }
  public void lancement(ActionEvent ae)
   {
   nom=text1.getText();
   setVisible(false);
   new GameLauncher(create.creationHero(nom, classe));
   create.linkDb(classe);
   
   
 }
  public void chargerAncien(ActionEvent ae) {
	  setVisible(false);
	  new GameLauncher(create.reloadHero(text1.getText()));
  }
@Override

	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

 }
