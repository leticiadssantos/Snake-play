package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class View extends JFrame{
	
	public View () {
		setTitle("Play Snake");
		setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setIconImage(new ImageIcon("res/img/icon.png").getImage());
	}

}
