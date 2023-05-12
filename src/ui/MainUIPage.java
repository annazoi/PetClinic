package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import ui.AddPetPage;
import entries.ClinicData;
import entries.Pet;

public class MainUIPage implements ActionListener {
	
	Color light = new Color(148, 180, 108);
    Color dark = new Color(98, 129, 58);
    Color veryDark = new Color(78, 96, 55);
    
	JFrame frame = new JFrame();
	
	JLabel clinicLabel = new JLabel("Clinic");
	JLabel servicesLabel = new JLabel("Services");
	
	JPanel services = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JPanel petListPanel = new JPanel();
	JPanel servicesPanel = new JPanel();
	
	JButton addPetButton = new JButton("Add Pet");
	JButton addServiceButton = new JButton("Add Service to Pet");
	JButton showEntriesButton = new JButton("Show entries");
	
	Border border = BorderFactory.createLineBorder(Color.black);
	
//	JScrollPane scrollPane = new JScrollPane();
	
//	private Pet[] eShopData;

	public MainUIPage () {
		this.init();
	}
	public void init () {
		frame.setTitle("PetClinic");
		frame.setVisible(true);
		frame.setSize(1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
//        frame.setFocusable(true);
        frame.getContentPane().setBackground(light);
        frame.add(clinicLabel);
        frame.add(services);
        frame.add(buttonsPanel);
        frame.add(servicesPanel);
        
        clinicLabel.setBounds(0, 0, 800, 30);
        clinicLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
        
        
        services.setBounds(300, 0, 750, 40);
        services.setBackground(veryDark);
        services.add(servicesLabel);
        services.setBorder(border);
        
        servicesLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
        servicesLabel.setBounds(400, 0, 750, 40);
        
        buttonsPanel.setBounds(0, 30, 250, 970);
        buttonsPanel.setBackground(dark);
        buttonsPanel.setBorder(border);
        buttonsPanel.add(addPetButton);
        buttonsPanel.add(addServiceButton);
        buttonsPanel.add(showEntriesButton);
        buttonsPanel.setLayout(null);
//        buttonsPanel.add(scrollPane);
        
        servicesPanel.setBounds(250, 30, 950, 970);
        servicesPanel.setBackground(dark);
        servicesPanel.setBorder(border);
        servicesPanel.setLayout(null);
        
//        set buttons
        
        addPetButton.setBackground(light);
        addPetButton.setFocusable(false);
        addPetButton.setBounds(75, 600, 100, 30);
        addPetButton.addActionListener(this);
        
        addServiceButton.setBackground(light);
        addServiceButton.setFocusable(false);
        addServiceButton.setBounds(30, 640, 190, 30);
        addServiceButton.addActionListener(this);
        
        showEntriesButton.setBackground(light);
        showEntriesButton.setFocusable(false);
        showEntriesButton.setBounds(50, 680, 150, 30);
        showEntriesButton.addActionListener(this);
        
//        for (Pet p : eShopData) {
//        	buttonsPanel.add(petListPanel);
//        	petListPanel.setBounds(0, 30, 250, 700);
//        	petListPanel.setLayout(null);
//        	petListPanel.setBackground(dark);
//        	
//        	JLabel dt = new JLabel(p.toString());
//        	dt.setBounds(10, 50, 300, 25);
//			dt.setVisible(true);
//        	
//        	petListPanel.add(dt);
        
        JTextArea lists = new JTextArea();
        
        DefaultListModel listModel = new DefaultListModel<>();
       
        JList<Pet> list = new JList<Pet>(listModel);
        
        list.setBounds(5, 50, 240, 400);
        list.setBackground(veryDark);
        	
        JScrollPane scrollPane = new JScrollPane(list);
        
        
//        lists.add(list);
//        lists.setBounds(5, 50, 240, 400);
//        lists.setBackground(veryDark);
        
        
        
        buttonsPanel.add(scrollPane);
        buttonsPanel.add(list);
        buttonsPanel.add(lists);
        
        for (Pet p : ClinicData.getPets()) {
			listModel.addElement(p);
        	
		}
        
      
        
        
        
        	
        
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == showEntriesButton) {
			CurrentEntriesPage currentEntriesPage = new CurrentEntriesPage();
		}
		else if (e.getSource() == addPetButton) {
			
		        
			
			
			AddPetPage addPetPage = new AddPetPage();
			
		}
	}
	
}

