package automation.TechVerit;

public class Products {
	
	public  String Title ;
	public  String Sku ;
	public  String Description ;
	
	
	public Products (String title, String sku, String description) {
		
		Title = title;
		Sku = sku;
		Description = description;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getSku() {
		return Sku;
	}

	public void setSku(String sku) {
		Sku = sku;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
}
