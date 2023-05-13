package entries;

public class Service {
	private float price;
	private float tax;
	private String title;
	private String category;
	private String description;
	
	public Service (float price, float tax, String title, String category, String description) {
		this.setPrice(price);
		this.setTax(tax);
		this.setTitle(title);
		this.setCategory(category);
		this.setDescription(description);
	}

	public float getPrice() {
		return price+tax;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
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
