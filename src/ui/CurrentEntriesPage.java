package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class CurrentEntriesPage extends JFrame {
	
	Color light = new Color(169, 204, 227);
	
	JFrame frame = new JFrame();


	public CurrentEntriesPage () {
		this.init();
	}
	
	public void init () {
		frame.setTitle("PetClinic");
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setResizable(false);
	    frame.setFocusable(true);
	    frame.setLayout(new BorderLayout());
	    frame.getContentPane().setBackground(light);
	}
}
