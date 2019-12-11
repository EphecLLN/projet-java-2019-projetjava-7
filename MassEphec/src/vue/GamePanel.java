package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements Runnable{
	
	private static int width, height; 
	
	private Thread thread;
	private boolean running = false;
	
	private BufferedImage img;
	private Graphics2D g;

	public GamePanel(int width, int height) {
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
	 super.addNotify();
	 
	 if (thread == null) {
		 thread = new Thread(this, "MassEphecThread");
		 thread.start();
	 }
	}
	
	public void init() {
		running = true;
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) img.getGraphics();
	}
	
	public void update() {
	}
	
	public void render() {
		if (g != null) {
			g.setColor(Color.red);
			g.fillRect(0, 0, width, height);
		}
	}
	
	public void draw() {
		Graphics g2 = (Graphics) this.getGraphics();
		g2.drawImage(img, 0, 0, width, height, null );
		g2.dispose();
	}
	
	public void run() {
		init();
		
		while (running) {
			update();
			render();
			draw();
		}
	}
	
	
}
