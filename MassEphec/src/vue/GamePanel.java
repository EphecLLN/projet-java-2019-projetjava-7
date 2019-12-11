package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	private static int width, height; 
	
	private Thread thread;
	private boolean running = false;
	
	private BufferedImage img;
	private Graphics2D g;
	
	Map map;

	public GamePanel(int width, int height) {
		map = new Map("map.txt");
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
	
	}
	
	
	public void init() {
		running = true;
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) img.getGraphics();
	}
	
	public void update() { 
	}
		
		

	public void keyPressed(KeyEvent key) {
		System.out.println("lol");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!running) {
			init();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		map.draw(g);
		g.setColor(Color.WHITE);
		g.fillRect(800, 0, 400, 900);
		g.fillRect(0, 640, 800,260 );
		
	}
	
}
