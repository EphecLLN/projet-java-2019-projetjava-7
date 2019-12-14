	package vue;

import javax.swing.*;

import model.Hero;
import model.Personnage;
import controller.MouvementController;

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
	MouvementController controller;
	
	
	protected int [][] tileMap;

	public GamePanel(int width, int height, Hero hero, MouvementController controller) {
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
		this.controller = controller;
		hero.addObserver(this);
		
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
					g.drawImage(grass, x, y,this);
					x += 50;
					break;
				case 1 : 
					g.drawImage(mur, x, y, this);
					x += 50;
					break;
				}
			}
			y += 50;

		}
	}
	public void drawCharacters(Graphics g, Personnage hero) {
		int x;
		int y;
		x = hero.getCoordX();
		y = hero.getCoordY();
		if (tileMap[y][x] != 1) {
			g.drawImage(heroImage, x * 50, y * 50, this);

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		System.out.println(code);
		switch(code) {
			case 37 : 
				if (heroModel.getCoordX() > 0) {
					controller.gauche(tileMap[heroModel.getCoordY()][heroModel.getCoordX() -1]);
				}
				break;
			case 38 : 
				if(heroModel.getCoordY() > 0) {
					System.out.println(heroModel.getCoordX());
					controller.haut(tileMap[heroModel.getCoordY() - 1][heroModel.getCoordX()]);
				}
				break;
			case 39 :
				if (heroModel.getCoordX() < 15) {
					controller.droite(tileMap[heroModel.getCoordY()][heroModel.getCoordX() + 1]);
				}
				break;
			case 40 :
				if (heroModel.getCoordY() < 15) {
					controller.bas(tileMap[heroModel.getCoordY() + 1][heroModel.getCoordX()]);
				}
				break;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
