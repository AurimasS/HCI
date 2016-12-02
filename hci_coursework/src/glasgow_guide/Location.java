package glasgow_guide;
/* 
 * Class representing a location
 */
import java.awt.Image;

public class Location {
	private String name;
	private String category;
	private String description;
	private String street;
	private String city;
	private String postcode;
	private Image image;
	
	public Location(String name, String category) {
		this.name = name;
		this.category = category;
	}

	// Getters
	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}	
	
	public String getPostcode() {
		return postcode;
	}
	
	public Image getImage() {
		return image;
	}
	
	// Setters
	public void setDescription(String description) {
		this.description = description;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
