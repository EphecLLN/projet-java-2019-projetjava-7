	package vue;

import javax.swing.*;

import model.Hero;
import model.Personnage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;


public class GamePanel extends JFrame implements Observer, KeyListener{
	
	Map map;
	Image grass, mur, heroImage;
	
	Hero heroModel;
	
	
	protected int [][] tileMap;

	public GamePanel(int width, int height, Hero hero) {
		map = new Map("map.txt");
		grass = Toolkit.getDefaultToolkit().createImage("res/grass.jpg");
		mur = Toolkit.getDefaultToolkit().createImage("res/mur.jpg");
		heroImage = Toolkit.getDefaultToolkit().createImage("res/HelloKitty.jpg");
		
		this.setSize(new Dimension(width, height));
		this.setTitle("MassEphec");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new drawMap());
		this.setVisible(true);
		this.heroModel = hero;
		this.addKeyListener(this);
	}

	
	protected class drawMap extends JComponent {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics g2d = (Graphics2D) g;
			drawMap(g);
			drawCharacters(g, heroModel);
		}
	}

	
	public void drawMap(Graphics g) {
		
		System.out.println("Drawmap");
		this.tileMap = map.getTileMap();
		int x = 0;
		int y = 0;
		for (int row = 0; row < 16; row++) {
			x = 0;
			for (int col = 0; col < 16; col++) {
				switch(tileMap[row][col]) {
				case 0 :
					g.drawImage(grass, x, y,null);
					x += 50;
					break;
				case 1 : 
					g.drawImage(mur, x, y, null);
					x += 50;
					break;
				}
			}
			y += 50;
<<<<<<< HEAD
=======

>>>>>>> 222fc704f6410a118e3c761680f4e450ef54b5a4
		}
	}
	public void drawCharacters(Graphics g, Personnage hero) {
		int x;
		int y;
		x = hero.getCoordX();
		y = hero.getCoordY();
		if (tileMap[x][y] != 1) {
<<<<<<< HEAD
=======
			g.drawImage(heroImage, x, y, null);

>>>>>>> 222fc704f6410a118e3c761680f4e450ef54b5a4
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		System.out.println(code);
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
