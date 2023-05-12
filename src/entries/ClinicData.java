package entries;

import java.util.*;

import entries.Pet;

import ui.AddPetPage;

public class ClinicData {
	private static ArrayList<Pet> pets = new ArrayList<Pet>();
	
	public ClinicData () {
	
	}

	public static ArrayList<Pet> getPets() {
		return pets;
	}

	public static void setPets(ArrayList<Pet> pets) {
		ClinicData.pets = pets;
	}
	
}

// Για την προσθήκη αντικειμένων στην λίστα: 
// EshopData.getPets().add(αντικείμενο τύπου Pet);  

