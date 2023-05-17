package ui;

import java.awt.BorderLayout;
//import ui.EntryPanel;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CurrentEntriesPage extends JFrame {
	
	private static final long serialVersionUID = 1L;

	Color light = new Color(169, 204, 227);
	
	JFrame frame = new JFrame();
	
	BorderLayout borderLayout = new BorderLayout();
	
	JScrollPane scroll = new JScrollPane();
	
	JPanel panel = new JPanel();


	public CurrentEntriesPage () {
		this.init();
	}
	
	public void init () {
		frame.setTitle("PetClinic");
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setResizable(false);
	    frame.setFocusable(true);
	    frame.setLayout(borderLayout);
	    frame.getContentPane().setBackground(light);
	    frame.add(scroll);
	    frame.add(new EntryPanel(null));
	    
//	    mesa edo 8a mpei to panel apo tin entryPanel
	    scroll.getViewport().add(new EntryPanel(null));
	    
	}
}
