package ui;

import java.awt.*;
import java.awt.event.*;
//import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import entries.*;

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
	private ArrayList<Entry> entries;
	public static Service[] servicesList;
	
	JScrollPane scrollPetName = new JScrollPane();
	

	public MainUIPage () {
//		MainUIPage.entries but not this.entries because entries is static variable
//		MainUIPage.entries = entries;
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
        
        entries = new ArrayList<>();
       
    	servicesList = new Service[]{
				new Service(10, 0.24, "Washing", "Animal", "washing for all pets"),
				new Service(20, 0.24, "grooming", "Dog", "grooming for dogs only"),
				new Service(10, 0.24, "nail_clipping", "Animal", "making the shots to the pet"),
				new Service(20, 0.24, "shot", "Animal", "making the shots to the pet") 	
		};
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
	 
	
	 
	private void showEntries() {
		
		
		JFrame entriesFrame = new JFrame("Current Entries");
		entriesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
		entriesFrame.setSize(400,200);
		entriesFrame.setLayout(new GridLayout(entries.size(), 1));
		
		for (Entry entry : entries) {
			EntryPanel entryPanel = new EntryPanel(entry, servicesList);
			entriesFrame.add(entryPanel);
		}
		entriesFrame.setVisible(true);
	
	}
	
	
			
	public void addEntry (Entry entry) {
		entries.add(entry);
	}
	
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == showEntriesButton) {
			
			showEntries();
			
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
