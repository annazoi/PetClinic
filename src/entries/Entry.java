package entries;

import java.util.ArrayList;

public class Entry {

	private ArrayList<Service> services = new ArrayList<Service>();
	
	Pet pet;

	public ArrayList<Service> getServices() {
		return services;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}
	
	public float getTotalPrice () {
		for(Service service : services)  {
			return getTotalPrice();
		};
		return 0;
	}
	
	
}	
