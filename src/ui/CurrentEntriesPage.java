package ui;

import java.awt.*;
import javax.swing.*;

public class CurrentEntriesPage extends JFrame {
	
	private static final long serialVersionUID = 1L;

	Color light = new Color(169, 204, 227);
	
	JFrame frame = new JFrame();
	
	BorderLayout borderLayout = new BorderLayout();
	
	JScrollPane scroll = new JScrollPane();
	
	JPanel panel = new JPanel();

	private EntryPanel entryPanel;

	public CurrentEntriesPage (EntryPanel entryPanel) {
		this.init();
		this.entryPanel = entryPanel;
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
	    frame.add(entryPanel);
	    
//	    mesa edo 8a mpei to panel apo tin entryPanel
//	    scroll.getViewport().add(new EntryPanel());
	    
	}
}
