package entries;	

import java.util.*;

import javax.swing.*;

import ui.MainUIPage;

public class Entry {
	
	JLabel name = new JLabel();
	JLabel entryDate = new JLabel();
	
	private static JLabel totalPriceLabel;
	JButton serviceButton = new JButton("Services");
	JButton checkoutButton = new JButton("Checkout");

	private static ArrayList<Service> selectedServices = new ArrayList<Service>();
	
	Pet pet;
	
	public Entry (Pet pet) {
		this.pet = pet;
		selectedServices = new ArrayList<>();
//		totalPrice = 0;
		totalPriceLabel = new JLabel();
//		add(totalPriceLabel);
		
		
	}
	
	public String getName() {
		return pet.getName();
	}
	
	public Date getIntroDate() {
		return pet.getIntroDate();
	}

	public static ArrayList<Service> getSelectedServices() {
		return selectedServices;
	}

	public void setSelectedServices(ArrayList<Service> selectedServices) {
		this.selectedServices = selectedServices;
	}
	
	public void addSelectedService(Service service) {
	        selectedServices.add(service);
	}
	 
//	public static void displayTotalPrice() {
//		double totalPrice = 0.0;
//		for (Service s: selectedServices) {
//			totalPrice += s.getPrice();
//		}
//		totalPriceLabel.setText(" "+totalPrice);
//	}
	
//	
//	public void getTotalPrice () {
//
//		MainUIPage.generateViewWithServices();
//	}
	





	
	
	
}	
