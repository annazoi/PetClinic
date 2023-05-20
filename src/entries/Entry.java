package entries;	

import java.util.*;

import javax.swing.*;

public class Entry {
	
	JLabel name = new JLabel();
	JLabel entryDate = new JLabel();
	JLabel totalPriceLabel = new JLabel();
	
	JButton serviceButton = new JButton("Services");
	JButton checkoutButton = new JButton("Checkout");

	private ArrayList<Service> services = new ArrayList<Service>();
	
	Pet pet;
	
	public Entry (Pet pet) {
		this.pet = pet;
	}
	
	public String getName() {
		return pet.getName();
	}
	
	public Date getIntroDate() {
		return pet.getIntroDate();
	}

	public ArrayList<Service> getServices() {
		return services;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}
	
//	public double getTotalPrice () {
//		for(Service service : services)  {
//			service.getPrice();
//			service.equals(getTotalPrice());
//			
//			return getTotalPrice;
//			
//		}
//	}
	
	
	
}	
