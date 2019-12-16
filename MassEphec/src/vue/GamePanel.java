package vue;

import javax.swing.*;


import model.BoostArme;
import model.BoostVie;
import model.Boss;
import model.Consommables;
import model.Hero;
import model.Monstre;
import model.PetitMonstre;
import model.Personnage;
import controller.CombatControllerGUI;
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
	Image grass, mur, heroImage, bossImage, monstreImage, redbullImage, monsterEnergyImage;
	
	Hero heroModel;
	Boss boss;
	Monstre [] monstres = new Monstre[2];
	BoostArme redbull;
	BoostVie monsterEnergy;
	MouvementController controller;
	
	
	protected int [][] tileMap;

	public GamePanel(int width, int height, Hero hero, MouvementController controller) {
		
		this.heroModel = hero;
		this.controller = controller;
		boss = new Boss(20, "res/BossMap.jpg","Delvigne", 100, 6, 14, 10, "Pc arrive");
		monstres[0] = new PetitMonstre(20, "","Os", 100, 6, 10, 5, 20);
		monstres[1] = new PetitMonstre(20, "", "Java", 100, 14, 7, 5, 20);
		redbull = new BoostArme(2 , 5);
		monsterEnergy = new BoostVie(11 , 1);
		hero.addObserver(this);
		
		map = new Map("map.txt");
		grass = Toolkit.getDefaultToolkit().createImage("res/grass.jpg");
		mur = Toolkit.getDefaultToolkit().createImage("res/mur.jpg");
		heroImage = Toolkit.getDefaultToolkit().createImage(hero.getPath());
		bossImage = Toolkit.getDefaultToolkit().createImage(boss.getPath());
		monstreImage = Toolkit.getDefaultToolkit().createImage("res/MonstreMap.jpg");
		redbullImage = Toolkit.getDefaultToolkit().createImage("res/RedBullMap.jpg");
		monsterEnergyImage = Toolkit.getDefaultToolkit().createImage("res/monsterEnergyMap.jpg");
		
		
		this.setSize(new Dimension(width, height));
		this.setTitle("MassEphec");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new drawMap());
		this.setVisible(true);
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
		// Placer héro
		if (tileMap[hero.getCoordY()][hero.getCoordX()] != 1) {
			g.drawImage(heroImage, hero.getCoordX() * 50, hero.getCoordY() * 50, this);
		}
		// Placer Montres
		for (int i = 0; i < monstres.length; i++) {
			if (tileMap[monstres[i].getCoordY()][monstres[i].getCoordX()] != 1 && monstres[i].enVie()) {
				g.drawImage(monstreImage, monstres[i].getCoordX() * 50, monstres[i].getCoordY() * 50, this);
			}
		}
		// Placer boss
		if (tileMap[boss.getCoordY()][boss.getCoordX()] != 1 && boss.enVie()) {
			g.drawImage(bossImage, boss.getCoordX() * 50, boss.getCoordY() * 50, this);
		}
		// Placer redbull
		if (redbull != null && tileMap[redbull.getCoordY()][redbull.getCoordX()] !=1) {
			g.drawImage(redbullImage, redbull.getCoordX() * 50, redbull.getCoordY() * 50, this);
		}
		// Placer monster
		if (monsterEnergy != null && tileMap[monsterEnergy.getCoordY()][monsterEnergy.getCoordX()] != 1) {
			g.drawImage(monsterEnergyImage, monsterEnergy.getCoordX() * 50, monsterEnergy.getCoordY() * 50, this);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// Si hero rencontre boss
		int x, y;
		x = heroModel.getCoordX();
		y = heroModel.getCoordY();
		if(x == boss.getCoordX() && y == boss.getCoordY()) {
			//JFrame tester = new JFrame(this);
			setVisible(false);
			new Combat(heroModel, boss, new CombatControllerGUI(heroModel, boss));
			//boss.setVie(0);
			repaint();
			return;
		}
		// Si hero rencontre Monstre
		for (int i = 0; i < monstres.length; i++) {
			if (x == monstres[i].getCoordX() && y == monstres[i].getCoordY()) {
				monstres[i].setVie(0);
				repaint();
				return;
			}
		}
		// Si hero rencontre rebull
		if (x == redbull.getCoordX() && y == redbull.getCoordY()) {
			//redbull.donneExp(heroModel);
			redbull = null;
			repaint();
			return;
		}
		if (x == monsterEnergy.getCoordX() && y == monsterEnergy.getCoordY()) {
			//monsterEnergy = null;
			repaint();
			return;
		}
		repaint();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
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
