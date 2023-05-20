package entries;	

import java.util.*;

import javax.swing.*;

public class Entry {
	
	JLabel name = new JLabel();
	JLabel entryDate = new JLabel();
	JLabel totalPriceLabel = new JLabel();
	
	JButton serviceButton = new JButton("Services");
	JButton checkoutButton = new JButton("Checkout");

	private ArrayList<Service> selectedServices = new ArrayList<Service>();
	
	Pet pet;
	
	public Entry (Pet pet) {
		this.pet = pet;
		selectedServices = new ArrayList<>();
	}
	
	public String getName() {
		return pet.getName();
	}
	
	public Date getIntroDate() {
		return pet.getIntroDate();
	}

	public ArrayList<Service> getSelectedServices() {
		return selectedServices;
	}

	public void setSelectedServices(ArrayList<Service> selectedServices) {
		this.selectedServices = selectedServices;
	}
	
	public void addSelectedService(Service service) {
	        selectedServices.add(service);
	}
	 
	

	
	
//	public double getTotalPrice () {
//
//	}
	
	
	
}	
