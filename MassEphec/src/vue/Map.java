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
	
	
	public Map (String mapFile){
		
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
	
	public int [][] getTileMap() {
		return this.tileMap;
	}
	
}
