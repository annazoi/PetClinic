package entries;	

import java.util.ArrayList;

import javax.swing.JLabel;

public class Entry {
	
	JLabel name = new JLabel();
	JLabel entryDate = new JLabel();

	private ArrayList<Service> services = new ArrayList<Service>();
	
	Pet pet;
	
	public Entry () {
		this.init();
	}
	
	public void init () {
		for (Pet pet : ClinicData.getPets()) {
			name.setText(pet.getName());
			entryDate.setText(pet.getIntroDate()+"");
			
		}
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
