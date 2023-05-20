package entries;

import java.util.*;
import javax.swing.*;

public class ClinicData {
	private static ArrayList<Pet> pets = new ArrayList<Pet>();
	private static ArrayList<Service> services = new ArrayList<Service>();
	private static ArrayList<Service> servicesFromTxt = new ArrayList<Service>();
	
//	JFileChooser fc = new JFileChooser();
	
	JPanel productsPanel = new JPanel();
	
	
	
	public ClinicData () {
		

		
		
//	
//		int choice = fc.showOpenDialog(productsPanel);
//		
//		if (choice == JFileChooser.OPEN_DIALOG) {
//			File products = fc.getSelectedFile();
//			
//			try {
//				BufferedReader reader = new BufferedReader(new FileReader(products));
//				
//				String line = reader.readLine();
//				
//				while (line != null) {
////					services.addAll((Collection<? extends Service>) products);
//					System.out.println(line);
//					line = reader.readLine();
//					for (Service s : services) {
//						services.add(s);
//						s.equals(line);
//						System.out.println(s);
//						
//					}
//				}
//				reader.close();
//				
//			} catch (FileNotFoundException exc) {
//				exc.printStackTrace();
//				
//			} catch (IOException exc) {
//				exc.printStackTrace();
//			}
//		}
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


