package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Map {

	private int [][] tileMap;
	private int height;
	private int width;
	private Image textureGrass, textureMur;
	
	public Map (String mapFile){
		
		textureGrass = new ImageIcon("res/Grass.jpg").getImage();
		textureMur = new ImageIcon("res/Mur.jpg").getImage();
		try {
			BufferedReader br = new BufferedReader(new FileReader(mapFile));
			tileMap = new int[16][16];
			
			for (int row = 0; row < 16; row++) {
				String line = br.readLine();
				for (int col = 0; col < 16; col++) {
					tileMap[row][col] = line.charAt(col) - 48; // Renvoit du code Ascii dû à charAt 0 = 48
				}
			}
		}
		catch (Exception e) {
			System.out.println("erreur");
			System.out.println(tileMap);
		}
		
	}
	
	public void draw(Graphics g) {
		int x = 0;
		int y = 0;
		for (int row = 0; row < 16; row++) {
			x = 0;
			for (int col = 0; col < 16; col++) {
				switch(tileMap[row][col]) {
				case 0 :
					g.drawImage(textureGrass, x, y,null);
					x += 50;
					break;
				case 1 : 
					g.drawImage(textureMur, x, y, null);
					x += 50;
					break;
				}
			}
			y += 40;
		}
		
	}
}
