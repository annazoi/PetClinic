package ui;

import java.awt.*;

import java.awt.event.*;
//import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;

import entries.*;
import ui.*;

public class MainUIPage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	static Color light = new Color(148, 180, 108);
    static Color dark = new Color(98, 129, 58);
    static Color veryDark = new Color(78, 96, 55);
   
	JFrame frame = new JFrame();
	
	JLabel clinicLabel = new JLabel("Clinic");
	JLabel servicesLabel = new JLabel("Services");
	JLabel nameLabel = new JLabel();
	
	JPanel services = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JPanel petListPanel = new JPanel();
	
	static JPanel servicesPanel = new JPanel();
	
	JButton addPetButton = new JButton("Add Pet");
//	JButton addServiceButton = new JButton("<html>Add Service to Pet</html>");
	JButton showEntriesButton = new JButton("<html>Show entries</html>");
	
	Border border = BorderFactory.createLineBorder(Color.black);
	
	GridLayout grid = new GridLayout(3, 3);
	
	DataHandler handler = new DataHandler();
	
	private AddPetPage addPetPage;
	
	ArrayList<Entry> entries;
	
	
	JScrollPane scrollPetName = new JScrollPane();
	

	public MainUIPage () {
		this.init();
	}
	public void init () {
		frame.setTitle("PetClinic");
		frame.setVisible(true);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
//        frame.setFocusable(true);
        frame.getContentPane().setBackground(light);
        
        
        
//        frame.add(servicesPanel);
        
        clinicLabel.setBounds(0, 0, 400, 30);
        clinicLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
        frame.add(clinicLabel);
        
        
        services.setBounds(200, 0, 300, 30);
        services.setBackground(veryDark);
        services.add(servicesLabel);
        services.setBorder(border);
        frame.add(services);
             
        servicesLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
        servicesLabel.setBounds(100, 0, 200, 40);
        
        buttonsPanel.setBounds(0, 30, 120, 400);
        buttonsPanel.setBackground(dark);
        buttonsPanel.setBorder(border);
        buttonsPanel.add(addPetButton);
//        buttonsPanel.add(addServiceButton);
        buttonsPanel.add(showEntriesButton);
        buttonsPanel.setLayout(null);
        buttonsPanel.add(petListPanel);
        frame.add(buttonsPanel);
        
        servicesPanel.setBounds(120, 30, 480, 370);
        servicesPanel.setBackground(dark);
        servicesPanel.setBorder(border); 
        servicesPanel.setLayout(new BoxLayout(servicesPanel, BoxLayout.Y_AXIS));
      
		frame.add(servicesPanel);
        
        
        addPetButton.setBackground(light);
        addPetButton.setFocusable(false);
//        addPetButton.setBounds(10, 150, 100, 30);
        addPetButton.setBounds(10, 200, 100, 30);
        addPetButton.addActionListener(this);
        
//        addServiceButton.setBackground(light);
//        addServiceButton.setFocusable(false);
//        addServiceButton.setBounds(10, 190, 100, 60);
//        addServiceButton.addActionListener(this);
        
        showEntriesButton.setBackground(light);
        showEntriesButton.setFocusable(false);
//        showEntriesButton.setBounds(10, 260, 100, 60);
        showEntriesButton.setBounds(10, 240, 100, 60);
        showEntriesButton.addActionListener(this);
                    
            
        petListPanel.add(scrollPetName);
        petListPanel.setBackground(veryDark);	
        petListPanel.setBounds(10, 10, 100, 100);
        petListPanel.add(nameLabel);
        
        
        addPetPage = new AddPetPage(this);
        
        entries = new ArrayList<Entry>();
   
	}
	
	 public void updateData () {
		 nameLabel.setText("<html>" +handler.getData().replaceAll("\n", "<br>") + "</html>");
	 }
	
	 
	 public void addData(String newData) {
		 handler.addData(newData);
		 updateData();
	 }
	 
	 private class DataHandler {
	        private String data;

	        public DataHandler() {
	            data = "";   
	        }
	        
	        public void addData(String newData) {
	        	
	        	if (!data.isEmpty()) {
	        		data += "\n";	
	        	}
		        data += newData;	
	        }
	        
	        public String getData() {
	            return data; 
	        }
	    }

	 
	 public ArrayList<Entry> getEntries() {
		 return entries;
	 }
	 
	 
	 private void currentEntries() {
		 
			JFrame entriesFrame = new JFrame("Current Entries");

			entriesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
			entriesFrame.setSize(400,200);
			entriesFrame.setVisible(true);
			entriesFrame.setLayout(new GridLayout());

			JPanel entriesPanel = new JPanel();
		    entriesPanel.setLayout(new BoxLayout(entriesPanel, BoxLayout.Y_AXIS));
			
			for (Entry entry : entries) {
				EntryPanel entryPanel = new EntryPanel(entry, EntryPanel.servicesList);
				entriesFrame.add(entryPanel);
				entryPanel.setBackground(dark);
				
				entryPanel.displayTotalPrice();
				
				entriesPanel.add(entryPanel);
				
			    

			}
			entriesFrame.add(entriesPanel);
			
			JScrollPane scrollPane = new JScrollPane();
			JViewport viewport = new JViewport();
			
			viewport.setView(entriesPanel);
			
			scrollPane.setViewport(viewport);
			
			entriesFrame.getContentPane().add(scrollPane);
			
    }
	 	 
	public void addEntry (Entry entry) {

		entries.add(entry);
	}
	 
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == showEntriesButton) {
			
			currentEntries();
			
			
			
		} else if (e.getSource() == addPetButton) {
			
			addPetPage.showFrame();
			

		}
	
	}
}