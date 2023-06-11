package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import entries.*;
import javax.swing.*;

public class AddPetPage extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	Color light = new Color(148, 180, 108);
    Color dark = new Color(98, 129, 58);
    
	JFrame frame = new JFrame();
	
	ArrayList<Pet> eShopData = new ArrayList<Pet>();
	
	JPanel textFieldPanel = new JPanel();
	JPanel radioButtonPanel = new JPanel();
	
	JTextField nameText = new JTextField(40);
    JTextField ownerText = new JTextField(40);
    JTextField ageText = new JTextField(40);
    JTextField addressText = new JTextField(40);
    
//    JRadio
    JRadioButton maleRadioButton = new JRadioButton(); 
    JRadioButton femaleRadioButton = new JRadioButton();
    JRadioButton catRadioButton = new JRadioButton(); 
    JRadioButton dogRadioButton = new JRadioButton();
    JRadioButton otherRadioButton = new JRadioButton();
    JRadioButton needHaircatTrue = new JRadioButton();
    JRadioButton needHaircatFalse = new JRadioButton();
    
   
    ButtonGroup genderGroup  = new ButtonGroup();
    ButtonGroup typeGroup = new ButtonGroup();
    ButtonGroup needHaircatGroup = new ButtonGroup();
    
    JButton addPetButton = new JButton("Add");
    
    JLabel addPetLabel = new JLabel();
    JLabel petNameLabel = new JLabel("Name");
    JLabel ownerLabel = new JLabel("Owner");
    JLabel ageLabel = new JLabel("Age");
    JLabel addressLabel = new JLabel("Address");
    JLabel gender = new JLabel("Gender");
    JLabel maleLabel = new JLabel("Male");
    JLabel femaleLabel = new JLabel("Female");
    JLabel type = new JLabel("Type");
    JLabel catLabel = new JLabel("Cat");
    JLabel dogLabel = new JLabel("Dog");
    JLabel otherLabel = new JLabel("Other");
    
    private MainUIPage main;
	
	AddPetPage (MainUIPage main) {
		this.main = main;
		this.init();
	}
	public void init () {
		frame.setTitle("PetClinic");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setFocusable(true);
//        frame.setVisible(true);
        frame.getContentPane().setBackground(light);
        frame.add(addPetLabel);
        frame.add(textFieldPanel);
        frame.add(radioButtonPanel);
        
        addPetLabel.setText("AddPet");
        addPetLabel.setBounds(1, 1, 100, 30);
        addPetLabel.setFont(new Font("MV Boli", Font.BOLD, 16));
        
        textFieldPanel.setBounds(0, 30, 600, 210);
        textFieldPanel.setBackground(dark);
        textFieldPanel.setLayout(null);
        textFieldPanel.add(nameText);
        textFieldPanel.add(ownerText);
        textFieldPanel.add(petNameLabel);
        textFieldPanel.add(ownerLabel);
        textFieldPanel.add(ageText);
        textFieldPanel.add(addressText);
        textFieldPanel.add(ageLabel);
        textFieldPanel.add(addressLabel);
        
        nameText.setBounds(200, 40, 300, 30);
        nameText.setBackground(light);
        petNameLabel.setBounds(80,40,120,30);
        
        ownerText.setBounds(200, 80, 300, 30);
        ownerText.setBackground(light);
        ownerLabel.setBounds(80,80,120,30);
        
        ageText.setBounds(200, 120, 300, 30);
        ageText.setBackground(light);
        ageLabel.setBounds(80,120,120,30);
        
        addressText.setBounds(200, 160, 300, 30);
        addressText.setBackground(light);
        addressLabel.setBounds(80,160,120,30);
        
        radioButtonPanel.setBounds(0, 240, 600, 770);
        radioButtonPanel.setBackground(dark);
        radioButtonPanel.setLayout(null);
        radioButtonPanel.add(maleRadioButton);
        radioButtonPanel.add(maleLabel);
        radioButtonPanel.add(femaleRadioButton);
        radioButtonPanel.add(femaleLabel);
        radioButtonPanel.add(gender);
        radioButtonPanel.add(type);
        radioButtonPanel.add(catRadioButton);
        radioButtonPanel.add(catLabel);
        radioButtonPanel.add(dogRadioButton);
        radioButtonPanel.add(dogLabel);
        radioButtonPanel.add(otherRadioButton);
        radioButtonPanel.add(otherLabel);
        
        radioButtonPanel.add(addPetButton);
        
        gender.setBounds(80, 0, 100, 30);
        
        maleLabel.setBounds(200, 0, 50, 30);
        maleRadioButton.setBounds(240, 0, 30, 30);
        maleRadioButton.setBackground(dark);
        maleRadioButton.addActionListener(this);
       
        femaleLabel.setBounds(300, 0, 80, 30);
        femaleRadioButton.setBounds(357, 0, 30, 30);
        femaleRadioButton.setBackground(dark);
        femaleRadioButton.addActionListener(this);
        
        type.setBounds(80, 40, 100, 30);
        
        catLabel.setBounds(200, 40, 50, 30);
        catRadioButton.setBounds(240, 40, 30, 30);
        catRadioButton.setBackground(dark);
        catRadioButton.addActionListener(this);
        
        dogLabel.setBounds(300, 40, 80, 30);
        dogRadioButton.setBounds(357, 40, 30, 30);
        dogRadioButton.setBackground(dark);
        dogRadioButton.addActionListener(this);
        
        otherLabel.setBounds(410, 40, 80, 30);
        otherRadioButton.setBounds(460, 40, 30, 30);
        otherRadioButton.setBackground(dark);
        otherRadioButton.addActionListener(this);
        
        addPetButton.setBounds(320, 160, 100, 30);
        addPetButton.setBackground(light);
        addPetButton.setFocusable(false);
        addPetButton.addActionListener(this);
        
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        typeGroup.add(otherRadioButton);
        typeGroup.add(catRadioButton);
        typeGroup.add(dogRadioButton);
        
	}
	
	public void showFrame() {
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name	= nameText.getText();
		String owner = ownerText.getText();
		int age = Integer.parseInt(ageText.getText());
		Date introDate = new Date();
		String address = addressText.getText();
		
		boolean isMale = maleRadioButton.isSelected();
		
		
		if (isMale) {
			maleRadioButton.setSelected(true);
			maleRadioButton.setEnabled(isMale);
//			gender.add(maleRadioButton);
		} else {
			femaleRadioButton.setSelected(true);
			
		}
		
		boolean isCat = catRadioButton.isSelected();
		boolean isDog = dogRadioButton.isSelected();
		boolean isOther = otherRadioButton.isSelected();
		
		if (e.getSource() == addPetButton) {
			
			if (isCat) {
				Pet cat = new Cat (name, owner, address, age, introDate, isMale);
				
				eShopData.add(cat);		
				
				ClinicData.setPets(eShopData);				
				
				System.out.print(cat + "\n");
				
				main.addData(name);
				frame.setVisible(false);
				
				Entry entry = new Entry(cat);
				main.addEntry(entry);
				
				
			} else if (isDog) {
                            
				int a = JOptionPane.showConfirmDialog(textFieldPanel,"Dog needs Haircat?" , "For Dog", JOptionPane.YES_NO_OPTION);

                boolean isNeedHaircat = needHaircatTrue.isSelected();

                if (a == JOptionPane.YES_OPTION) {
                	
                    needHaircatTrue.setSelected(true);
//                    System.out.print("Yes needs Haircat");
                                                    
                } else if (a == JOptionPane.NO_OPTION){
                    needHaircatTrue.setSelected(false);
//                    System.out.print("Doesn't need Haircat");
                }

                                
				Pet dog = new Dog (name, owner, address, age, introDate, isMale, isNeedHaircat);
				
				eShopData.add(dog);
				
				ClinicData.setPets(eShopData);	
				
				System.out.print(dog + "\n");
					
				main.addData(name);
				frame.setVisible(false);
				Entry entry = new Entry(dog);
				main.addEntry(entry);
				
			} else if (isOther) {
				
				Pet other = new Other (name, owner, address, age, introDate, isMale);
				
				eShopData.add(other);
				
				ClinicData.setPets(eShopData);
				
				System.out.print(other + "\n");
				
				main.addData(name);
				frame.setVisible(false);
				Entry entry = new Entry(other);
				main.addEntry(entry);
				
			}
			nameText.setText("");
			ownerText.setText("");
			ageText.setText("");
			addressText.setText("");
			genderGroup.clearSelection();
			typeGroup.clearSelection();
		}
	}
	
	public ArrayList<Pet> getPets() {
        return eShopData;
    }
        
}