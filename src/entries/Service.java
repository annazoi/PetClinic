package entries;

public class Service {
	private double price;
	private double tax;
	private String title;
	private String category;
	private String description;
	
	public Service (double price, double tax, String title, String category, String description) {
		this.setPrice(price);
		this.setTax(tax);
		this.setTitle(title);
		this.setCategory(category);
		this.setDescription(description);
	}

	public double getPrice() {
		return price+tax;
	}

	public void setPrice(double price2) {
		this.price = price2;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax2) {
		this.tax = tax2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
    
	
}
