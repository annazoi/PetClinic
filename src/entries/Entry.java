package entries;	

import java.util.*;

import javax.swing.*;

import ui.MainUIPage;

public class Entry {
	
	JLabel name = new JLabel();
	JLabel entryDate = new JLabel();
	
	JButton serviceButton = new JButton("Services");
	JButton checkoutButton = new JButton("Checkout");

	
	Pet pet;
	
	public Entry (Pet pet) {
		this.pet = pet;
		
//		add(totalPriceLabel);
		
		
	}
	
	public String getName() {
		return pet.getName();
	}
	
	public Date getIntroDate() {
		return pet.getIntroDate();
	}


	 

	





	
	
	
}	