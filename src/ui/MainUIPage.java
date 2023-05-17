package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import entries.ClinicData;
import entries.Pet;
import entries.Service;

public class MainUIPage extends JFrame implements ActionListener {
//	auto mpike epeidi valame extends JFrame
	private static final long serialVersionUID = 1L;
	Color light = new Color(148, 180, 108);
    Color dark = new Color(98, 129, 58);
    Color veryDark = new Color(78, 96, 55);
   
	JFrame frame = new JFrame();
	
	JLabel clinicLabel = new JLabel("Clinic");
	JLabel servicesLabel = new JLabel("Services");
	JLabel nameLabel = new JLabel();
	
	JPanel services = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JPanel petListPanel = new JPanel();
	JPanel servicesPanel = new JPanel();
	
	JButton addPetButton = new JButton("Add Pet");
//	Vazoume agkiles <html> gia na kanei new line kai na fainetai olo to text stis mikres diastaseis tou button
//	An 8elame na to kopsoume se sugkekrimeno simeio 8a legame (<html>Add Service<br> </br>to Pet</html>")
	JButton addServiceButton = new JButton("<html>Add Service to Pet</html>");
	JButton showEntriesButton = new JButton("<html>Show entries</html>");
	
	Border border = BorderFactory.createLineBorder(Color.black);
	
	GridLayout grid = new GridLayout(3, 3);
	
	DataHandler handler = new DataHandler();
	
	private AddPetPage addPetPage;
	
	JScrollPane scrollPetName = new JScrollPane();
	
//	JScrollPane scrollPane = new JScrollPane();
	
	static CurrentEntriesPage entries;
	

	public MainUIPage (CurrentEntriesPage entries) {
//		MainUIPage.entries but not this.entries because entries is static variable
		MainUIPage.entries = entries;
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
        frame.add(clinicLabel);
        frame.add(services);
        frame.add(buttonsPanel);
        frame.add(servicesPanel);
        
        clinicLabel.setBounds(0, 0, 400, 30);
        clinicLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
        
        
        services.setBounds(200, 0, 300, 40);
        services.setBackground(veryDark);
        services.add(servicesLabel);
        services.setBorder(border);
        
        servicesLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
        servicesLabel.setBounds(100, 0, 200, 40);
        
        buttonsPanel.setBounds(0, 30, 120, 400);
        buttonsPanel.setBackground(dark);
        buttonsPanel.setBorder(border);
        buttonsPanel.add(addPetButton);
        buttonsPanel.add(addServiceButton);
        buttonsPanel.add(showEntriesButton);
        buttonsPanel.setLayout(null);
        buttonsPanel.add(petListPanel);
        
        servicesPanel.setBounds(120, 30, 480, 370);
        servicesPanel.setBackground(dark);
        servicesPanel.setBorder(border);
//      grid -> GridLayout 3X3  
        servicesPanel.setLayout(grid);
        
//        set buttons
        
        addPetButton.setBackground(light);
        addPetButton.setFocusable(false);
        addPetButton.setBounds(10, 150, 100, 30);
        addPetButton.addActionListener(this);
        
        addServiceButton.setBackground(light);
        addServiceButton.setFocusable(false);
        addServiceButton.setBounds(10, 190, 100, 60);
        addServiceButton.addActionListener(this);
        
        showEntriesButton.setBackground(light);
        showEntriesButton.setFocusable(false);
        showEntriesButton.setBounds(10, 260, 100, 60);
        showEntriesButton.addActionListener(this);
        
        addPetPage = new AddPetPage(this);
              
        petListPanel.add(scrollPetName);
        petListPanel.setBackground(veryDark);
        petListPanel.setBounds(10, 10, 100, 100);
        petListPanel.add(nameLabel);
       
	}
	
	
//	 public void generateViewWithServices () {
//		 for (Service s : ClinicData.getServices()) {
//			 JPanel panel = new JPanel();
//			 
//			 
//			 JLabel label1 = new JLabel(); 
//			 JLabel label2 = new JLabel(); 
//			 
//			 servicesPanel.add(panel);
//			 servicesPanel.add(label1);
//			 servicesPanel.add(label2);
//			 
//			 panel.setBackground(light);
//			 panel.add(label1);
//			 panel.add(label2);
//			 
//			 label1.setText(s.getTitle());
//			 label2.setText(s.getPrice()+"");
//		 }
//     }
	 
	 public void dataFromTxt () {
			for (Service washing : ClinicData.getServicesFromTxt()) {
			washing.setTitle("washing");
			washing.setPrice(10);
			washing.setTax(0.24);
			washing.setCategory("Animal");
			washing.setDescription("washing for all pets");
		}
		
		for (Service grooming : ClinicData.getServicesFromTxt()) {
			grooming.setTitle("grooming");
			grooming.setPrice(20);
			grooming.setTax(0.24);
			grooming.setCategory("Dog");
			grooming.setDescription("grooming for dogs only");
		}
		
		for (Service nailClipping : ClinicData.getServicesFromTxt()) {
			nailClipping.setTitle("nail_clipping");
			nailClipping.setPrice(10);
			nailClipping.setTax(0.24);
			nailClipping.setCategory("Aminal");
			nailClipping.setDescription("taking care of the pet nails/talons");
		}
		
		for (Service shot : ClinicData.getServicesFromTxt()) {
			shot.setTitle("shot");
			shot.setPrice(20);
			shot.setTax(0.24);
			shot.setCategory("Animal");
			shot.setDescription("making the shots to the pet");
		}
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
	 
	 	
//	    public void updateOutputArea() {
//	        nameLabel.setText(handler.getDataAsString());
//	    }
//
//	    public void addData(String newData) {
//	    	handler.addData(newData);
//
//	        // Update the output area
//	        updateOutputArea();
//	    }
//
//	    private class DataHandler {
//	        private StringBuilder data;
//
//	        public DataHandler() {
//	            data = new StringBuilder();
//	        }
//
//	        public void addData(String newData) {
//	        	for (Pet p : ClinicData.getPets()) {
//	        		data.append(p.getName()).append("\n");
//	        	}
//	            
//	        }
//
//	        public String getDataAsString() {
//	            return data.toString();
//	        }
//	    }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == showEntriesButton) {
		
			CurrentEntriesPage currentEntries = new CurrentEntriesPage();
			currentEntries.setVisible(true);
			
		} else if (e.getSource() == addPetButton) {
			
			addPetPage.showFrame();
			
			
//		} else if (e.getSource() == addServiceButton) {
//			
//			
//			
//		}
		
		}
	
	}
}
