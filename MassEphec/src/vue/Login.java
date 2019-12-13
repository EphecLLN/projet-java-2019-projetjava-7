package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Main.*;
  
public class Login extends JFrame implements ActionListener
 {
  
	JButton Soumission;
  JPanel panel;
  JLabel label1,label2;
  final JTextField  text1,text2;
  public String nom, classe;
  		
  		public Login()	{
   label1 = new JLabel();
   label1.setText("Votre nom:");
   text1 = new JTextField(15);
 
   label2 = new JLabel();
   label2.setText("Classe :");
   text2 = new JTextField(15);
  
   Soumission=new JButton("Commencer");
   
   panel=new JPanel(new GridLayout(3,1));
   panel.add(label1);
   panel.add(text1);
   panel.add(label2);
   panel.add(text2);
   panel.add(Soumission);
   add(panel,BorderLayout.CENTER);
   Soumission.addActionListener(this);
   setTitle("LOGIN");
   }
  public void actionPerformed(ActionEvent ae)
   {
   nom=text1.getText();
   classe=text2.getText();
   //setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
   panel.setVisible(false);
   new MainConsole(nom,classe);
 }
 }
