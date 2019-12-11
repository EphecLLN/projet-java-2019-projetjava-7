package vue;

import javax.swing.*;
import java.awt.Dimension;

public class GamePanel extends JPanel{
	
	private static int width, height; 

	public GamePanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
	}
}
