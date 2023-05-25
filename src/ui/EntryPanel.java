package ui;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import entries.*;
import ui.*;

public class EntryPanel extends JPanel {
	
	private Entry entry;
	private JButton servicesButton;
	public static Service[] servicesList;
	private JButton checkoutButton;
	
	private static JLabel totalPriceLabel;
	
	JCheckBox checkBox = new JCheckBox();
	
	public EntryPanel (Entry entry, Service[] services) {
		this.entry = entry;
//		Vazoume EntryPanel anti gia this dioti einai static 
		EntryPanel.servicesList = services;
		setLayout(new FlowLayout());
	
		JLabel nameLabel = new JLabel(entry.getName());
//	Epeidi einai tupou Date to metatrepoume se string
		JLabel introdateLabel = new JLabel(entry.getIntroDate()+"");
		
		add(nameLabel);
		add(introdateLabel);
		
		
		
		servicesList = new Service[]{
				new Service(10, 0.24, "Washing", "Animals", "washing for all pets"),
				new Service(20, 0.24, "grooming", "Dogs", "grooming for dogs only"),
				new Service(10, 0.24, "nail_clipping", "Animals", "making the shots to the pet"),
				new Service(20, 0.24, "shot", "Animals", "making the shots to the pet") 	
		};
		
		
		 servicesButton = new JButton("Services");
		 servicesButton.setFocusable(false);
		 servicesButton.setBackground(MainUIPage.light);
	     servicesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	servicesDialog();
	            	
	            }
	        });
		add(servicesButton);
		
		totalPriceLabel = new JLabel();
		add(totalPriceLabel);
		
		checkoutButton = new JButton("Checkout");
		servicesButton.setFocusable(false);
		servicesButton.setBackground(MainUIPage.light);
		add(checkoutButton);
		
	}
	
	public static void displayTotalPrice() {
		double totalPrice = 0.0;
		for (Service s: Entry.getSelectedServices()) {
			totalPrice += s.getPrice();
		}
		totalPriceLabel.setText(" "+totalPrice);
	}

	
	
    private void servicesDialog() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(servicesList.length, 1));

        JCheckBox[] checkboxes = new JCheckBox[servicesList.length];
        for (int i = 0; i < servicesList.length; i++) {
            checkboxes[i] = new JCheckBox(servicesList[i].getTitle() + " - $" + servicesList[i].getPrice() + " For all: " +servicesList[i].getCategory());
            panel.add(checkboxes[i]);
        }

        int result = JOptionPane.showConfirmDialog(this, panel, "Services", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            ArrayList<Service> selectedServices = new ArrayList<>();
            for (int i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].isSelected()) {
                    selectedServices.add(servicesList[i]);
                    entry.addSelectedService(servicesList[i]);
                    
                }
            }

            
            MainUIPage.generateViewWithServices(entry);
            JOptionPane.showMessageDialog(this, "Services selected!");
            
            
        }
    }
	
    
	
	
}	
