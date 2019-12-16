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
	
	Map map1, map2;
	Image grass, mur, heroImage, bossImage, monstreImage, redbullImage, monsterEnergyImage;
	JPanel statsPanel, mapPanel, mainPanel;
	
	Hero heroModel;
	Boss boss;
	Monstre [] monstres = new Monstre[2];
	BoostArme redbull;
	boolean redbullPicked;
	BoostVie monsterEnergy;
	boolean monsterEnergyPicked;
	MouvementController controller;
	
	protected int [][] tileMap;

	public GamePanel(int width, int height, Hero hero, MouvementController controller) {
		
		this.heroModel = hero;
		this.controller = controller;
		
		//heroModel.setMapNum(2);
		hero.addObserver(this);
		map1 = new Map("map1.txt");
		map2 = new Map("map2.txt");
		
		newMap(heroModel.getMapNum());
		
		grass = Toolkit.getDefaultToolkit().createImage("res/grass.jpg");
		mur = Toolkit.getDefaultToolkit().createImage("res/mur.jpg");
		heroImage = Toolkit.getDefaultToolkit().createImage(hero.getPath());
		monstreImage = Toolkit.getDefaultToolkit().createImage("res/MonstreMap.jpg");
		redbullImage = Toolkit.getDefaultToolkit().createImage("res/RedBullMap.jpg");
		monsterEnergyImage = Toolkit.getDefaultToolkit().createImage("res/monsterEnergyMap.jpg");
		
		
		
		this.setTitle("MassEphec");
		this.setSize(width, height);
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(0,0,width, height);
		this.setVisible(true);
		this.addKeyListener(this);
		
		mainPanel = new JPanel();
		mainPanel.setSize(800,800);
		mainPanel.setBounds(0, 0, width, height);
		mainPanel.setVisible(true);
		this.add(mainPanel);
		
		
		mapPanel = new JPanel();
		mapPanel.setSize(800, 800);
		mapPanel.setPreferredSize(new Dimension(800,800));
		mapPanel.setVisible(true);
		mapPanel.add(new drawMap());
		mainPanel.add(mapPanel);
		
		statsPanel = new JPanel();
		statsPanel.setSize(300, 300);
		statsPanel.setPreferredSize(new Dimension(300,300));
		statsPanel.setBounds(900,0, 300,300);
		statsPanel.setBackground(Color.black);
		statsPanel.setVisible(true);
		mainPanel.add(statsPanel);
	}
	
	public void newMap(int mapNum) {
		switch (mapNum) {
		case 1 :
			boss = new Boss(20, "res/BossMap.jpg","Delvigne", 100, 6, 14, 10, "Pc arrive");
			setImageBoss(boss.getPath());
			monstres[0] = new PetitMonstre(20, "","Os", 100, 6, 10, 5, 20);
			monstres[1] = new PetitMonstre(20, "", "Java", 100, 14, 7, 5, 20);
			redbull = new BoostArme(2 , 5);
			monsterEnergy = new BoostVie(11 , 1);
			bossImage = Toolkit.getDefaultToolkit().createImage(boss.getPath());
			monsterEnergyPicked = false;
			redbullPicked = false;
			break;
		case 2 :
			boss = new Boss(20, "res/BossMap.jpg","Delvigne", 100, 15, 15, 10, "Pc arrive");
			monstres[0] = new PetitMonstre(20, "","Os", 100, 2, 4, 5, 20);
			monstres[1] = new PetitMonstre(20, "", "Java", 100, 14, 7, 5, 20);
			redbull = new BoostArme(5 , 5);
			monsterEnergy = new BoostVie(14 , 4);
			bossImage = Toolkit.getDefaultToolkit().createImage(boss.getPath());
			monsterEnergyPicked = false;
			redbullPicked = false;
			break;
		}
	}

	
	protected class drawMap extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			this.setBounds(0, 0, 800, 800);
			
			Graphics g2d = (Graphics2D) g;
			switch(heroModel.getMapNum()) {
			case 1 : 
				drawMap(g , map1);
				break;
			case 2 : 
				drawMap(g , map2);
				break;
			}
			
			drawCharacters(g, heroModel);
		}
	}

	
	public void drawMap(Graphics g, Map map){
		
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
		// Placer h�ro
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
		if (redbullPicked != true && tileMap[redbull.getCoordY()][redbull.getCoordX()] !=1) {
			g.drawImage(redbullImage, redbull.getCoordX() * 50, redbull.getCoordY() * 50, this);
		}
		// Placer monster
		if (monsterEnergyPicked != true && tileMap[monsterEnergy.getCoordY()][monsterEnergy.getCoordX()] != 1) {
			g.drawImage(monsterEnergyImage, monsterEnergy.getCoordX() * 50, monsterEnergy.getCoordY() * 50, this);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!isFinished()) {
			int x, y;
			x = heroModel.getCoordX();
			y = heroModel.getCoordY();
			if(x == boss.getCoordX() && y == boss.getCoordY()) {
				//boss.setVie(0);
				//JFrame tester = new JFrame(this);
				mainPanel.setVisible(false);
				new Combat(heroModel, boss, new CombatControllerGUI(heroModel, boss), this);
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
			// Si hero rencontre Monstre
			for (int i = 0; i < monstres.length; i++) {
				if (x == monstres[i].getCoordX() && y == monstres[i].getCoordY()) {
					monstres[i].setVie(0);
					repaint();
					return;
				}
			}
			// Si hero rencontre rebull
			if (!redbullPicked) {
				if (x == redbull.getCoordX() && y == redbull.getCoordY()) {
					redbull.donneExp(heroModel);
					redbullPicked = true;
					repaint();
					return;
				}
			}
			if (!monsterEnergyPicked) {
				if (x == monsterEnergy.getCoordX() && y == monsterEnergy.getCoordY()) {
					monsterEnergyPicked = true;
					repaint();
					return;
				}
			}
			repaint();
		}
		else {
			controller.changeMap();
			newMap(heroModel.getMapNum());
		}
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
	
	public boolean isFinished () {
		return (!boss.enVie() && redbullPicked && monsterEnergyPicked && !monstres[0].enVie() && !monstres[1].enVie());
	}
	
	public void setImageBoss(String path) {
		bossImage = Toolkit.getDefaultToolkit().createImage(path);
	}
}
