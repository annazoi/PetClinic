package ui;

import java.awt.Color;
import java.awt.Desktop.Action;
import java.util.*;
import entries.Pet;
import entries.Pet;
import entries.Cat;
import entries.ClinicData;
import entries.Dog;
import entries.Other;
//import entries.ClinicData;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddPetPage extends JFrame implements ActionListener{
	
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
    
   
    
//    Xrisimopoioume ButtonGroup gia na exoyme mono mia epilogi se ka8e omada apo RadioButton
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
	
	AddPetPage () {
		this.init();
	}
	public void init () {
		frame.setTitle("PetClinic");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setVisible(true);
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
        
        addPetButton.setBounds(320, 180, 100, 30);
        addPetButton.setBackground(light);
        addPetButton.setFocusable(false);
//      this->implements
        addPetButton.addActionListener(this);
        
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        typeGroup.add(otherRadioButton);
        typeGroup.add(catRadioButton);;
        typeGroup.add(dogRadioButton);
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name	= nameText.getText();
		String owner = ownerText.getText();
		int age = Integer.parseInt(ageText.getText());
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
				Pet cat = new Cat (name, owner, address, age, isMale);
				
				eShopData.add(cat);		
				
				ClinicData.setPets(eShopData);				
				
				System.out.print(cat);
				
				MainUIPage main = new MainUIPage();
				
				
			} else if (isDog) {
			    JLabel needHaircatLabel = new JLabel("Dog needs Haircat?");
			    JLabel yes = new JLabel("Yes");
			    JLabel no = new JLabel("No");
			    radioButtonPanel.add(needHaircatLabel);
			    needHaircatLabel.setBounds(20, 80, 150, 30);
			    
			    radioButtonPanel.add(yes);
			    yes.setBounds(200, 80, 50, 30);
			    radioButtonPanel.add(no);
			    no.setBounds(300, 80, 80, 30);
			    
				radioButtonPanel.add(needHaircatTrue);
				needHaircatTrue.setBounds(240, 80, 30, 30);
				needHaircatTrue.setBackground(dark);
				needHaircatGroup.add(needHaircatTrue);
				
				radioButtonPanel.add(needHaircatFalse);
				needHaircatFalse.setBounds(357, 80, 30, 30);
				needHaircatFalse.setBackground(dark);
				needHaircatGroup.add(needHaircatFalse);
				
				boolean isNeedHaircat = needHaircatTrue.isSelected();
				
				if (isNeedHaircat) {
					needHaircatTrue.isEnabled();
//					needHaircatTrue.setVisible(isNeedHaircat);
				} else {
					needHaircatFalse.isEnabled();
//					needHaircatFalse.setVisible(isNeedHaircat);
				}
				Pet dog = new Dog (name, owner, address, age, isMale, isNeedHaircat);
				
				eShopData.add(dog);
				
				ClinicData.setPets(eShopData);	
				
				System.out.print(dog);
				
				MainUIPage main = new MainUIPage();
				
				
			} else if (isOther) {
				
				Pet other = new Other (name, owner, address, age, isMale);
				
				eShopData.add(other);
				
				ClinicData.setPets(eShopData);
				
				System.out.print(other);
				
				MainUIPage main = new MainUIPage();
			}
			
		}
		
	}
	
	public ArrayList<Pet> getPets() {
        return eShopData;
    }
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == addPetButton) {
//			MainUIPage mainUIPage = new MainUIPage();
//		}	
//	}
}
