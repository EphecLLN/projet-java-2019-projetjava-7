package vue;

import javax.swing.*;

public class Window extends JFrame{

	
	public Window() {
		setTitle("MassEphec");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel(1200, 900));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
