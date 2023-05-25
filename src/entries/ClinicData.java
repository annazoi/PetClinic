package entries;

import java.util.*;
import javax.swing.*;

public class ClinicData {
	private static ArrayList<Pet> pets = new ArrayList<Pet>();
	private static ArrayList<Service> services = new ArrayList<Service>();
	private static ArrayList<Service> servicesFromTxt = new ArrayList<Service>();
	
	
	JPanel productsPanel = new JPanel();
	
	
	
	public ClinicData () {
		

	}

	public static ArrayList<Pet> getPets() {
		return pets;
	}

	public static void setPets(ArrayList<Pet> pets) {
		ClinicData.pets = pets;
	}

	public static ArrayList<Service> getServices() {
		return services;
	}

	public static void setServices(ArrayList<Service> services) {
		ClinicData.services = services;
	}

	public static ArrayList<Service> getServicesFromTxt() {
		return servicesFromTxt;
	}

	public static void setServicesFromTxt(ArrayList<Service> servicesFromTxt) {
		ClinicData.servicesFromTxt = servicesFromTxt;
	}
	
}


