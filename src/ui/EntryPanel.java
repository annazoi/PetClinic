package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import entries.*;
import ui.*;

public class EntryPanel extends JPanel {
	
	Entry entry;
	private JButton servicesButton;
//	private Service[] services;
	
	public EntryPanel (Entry entry, Service[] services) {
		this.entry = entry;
		MainUIPage.servicesList = services;
		setLayout(new FlowLayout());
	
		JLabel nameLabel = new JLabel(entry.getName());
//	Epeidi einai tupou Date to metatrepoume se string
		JLabel introdateLabel = new JLabel(entry.getIntroDate()+"");
		
		add(nameLabel);
		add(introdateLabel);
		
	
		
		
		
		servicesButton = new JButton("Services");
		
		 servicesButton = new JButton("Services");
	     servicesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	servicesDialog();
	            	
	            }
	        });
		add(servicesButton);	
	
		
	}

		
	
	private void servicesDialog() {
		StringBuilder message = new StringBuilder();
		message.append("Add Services").append(":\n");
		
		for (Service service : MainUIPage.servicesList) {
			message.append(service.getTitle()).append(" - ").append(service.getPrice()).append("$ - Only for: ").append(service.getCategory()).append(" \n");
		}
		Object[] choices = {"Select", "Cancel"};
		int choice = JOptionPane.showOptionDialog(this, message.toString(), "Services", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
	
		if (choice == JOptionPane.YES_OPTION ) {
            JOptionPane.showMessageDialog(this, "Services selected!");

		}
	}
	
	
	
}	
