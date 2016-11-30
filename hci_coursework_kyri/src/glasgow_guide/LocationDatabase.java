package glasgow_guide;
/* 
 * Class representing a location database
 * Generates random data to be used by the rest of the application
 */
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;

public class LocationDatabase {
	public static final LocationDatabase DATABASE = new LocationDatabase();
    public static final String[] CATEGORIES = {"Parks", "Monuments", "Museums",
    		"Shopping", "Nightlife", "Bars",
    		"Cafes", "Restaurants", "Fast Food",
    		"Hotels"};
    
    private Map<String, Location[]> locations;
    
    // Lists of random names for each category 
	private String[] park_names = {"Crescent Plaza", "Crescent Garden", "Crystal Cove Meadows", "Solstice Plaza",
			"Prospect Meadows", "Trillium Grounds", "Plaoms Gardens", "Vroxad Park",
			"Ydort Garden", "Blyek Gardens", "Blossom Park", "Bronze Arch Garden",
			"Grand Avenue Plaza", "Maple Grove Plaza", "Twilight Gardens", "Sunrise Garden"};
	private String[] monument_names = {"The Nameless Temple", "The Bare Lands", "The Nightmare Borough", "Labyrinth of Necrosis",
			"Clearbrace Sanctuary", "The Visage Nest", "The Warden Cover", "Wildhowl Base",
			"The August Enclave", "The Oracle Burials", "House of Confidence"};
	private String[] museum_names = {"Museum of Ancestry", "National Institution of Culture", "Gallery of Winter", "Lingmell",
			"Exhibition of Movement", "Nightmare Institute", "Exploration Museum", "International Water Treasury",
			"Grand Hall of Play", "Hall of Sightings", "Toy Centre", "Royal Center of the Underground",
			"Central Gadget Institution"};
	private String[] shopping_names = {"The Flimsy Cloak", "The Humble Tusk Sport Store", "The Big Kite Cars", "Bean Me Up",
			"Teacoon", "The Racing Note	", "Optim-Eyes", "The Merry Duck",
			"The Blue Guard Butcher Shop", "The Blank Dish", "Julious Scissor", "The Hairy Ship Garage",
			"Brews Brothers", "Goodfillas", "The Dazzling Mask Tearoom", "The Shaving Quarry",
			"The Shady Bee", "The Young Furnace"};
	private String[] nightlife_names = {"Phoenix", "Justice", "Fortune", "Club Mirth",
			"Club Crimson", "The Crobar", "The Galaxy", "The Bridge",
			"The Aurora", "The Inferno", "Elegance", "Deviant",
			"Triumph", "The Escape", "Entity", "The Rhythm",
			"The Bridge", "Club Bazaar", "The Agenda", "The Answer",
			"Silver"};
	private String[] bar_names = {"The Long Cats Pub", "Ye Olde Vanilla Bean", "The Opposite Tree Inn", "The Golden Cucumber",
			"The Limping Loch", "The Juicy Snow Bar", "The Broad Mango Inn", "The Free Beard",
			"Hops and Robbers Brewers", "Hairy Turtle Brewing Company", "Nordic Brewing", "The Speakeasy Brewing Company",
			"Ferocious Brewery", "Seafront Brewing Co.", "Phoenix Fermentary", "Dragonmead Brewing",
			"Futuristic Twig Bar", "Efficient Gang Bar", "Obnoxious Coin Bar", "Molten Panther",
			"Dangerous Meat Bar", "Right Fowl", "Magical Curry", "Giant Lychee",
			"Itchy Donkey Bar", "Nice Dragonfruit", "The Depot"};
	private String[] cafe_names = {"Lettuce Retreat Cafe", "Steamy Indulgences Cafeteria", "Sugar & Spice Tearoom", "Grinders Coffee",
			"Q & A Room", "Havana Shrine Coffee Bar", "Hava Pearl Barista", "Melting Boulder Diner",
			"Havana Fest Espresso Bar", "Hidden Heaven Diner", "Hot Shots Cafe", "This & That Coffee Bar",
			"Thinking Cup Cafe", "Ground Up Coffee Bar", "Trembling Cup Cafeteria", "Gentle Teapot Room",
			"PLACEHOLDER", "PLACEHOLDER", "Broad Drum"};
	private String[] restaurant_names = {"The Vintage Duke", "The Village Door", "Bambino", "Beehive",
			"The Northern After Dark", "The Cool Cat Shrimp", "The Malt Lily", "Retro",
			"The Goat", "The Lion", "The Coriander Lion", "The Streetwise Crown",
			"The Savory Chicken", "Chapter", "Whisperwind", "Kingsize",
			"The Fresh Leaf", "The Sour Walk", "Butlers", "Intermezzo"};
	private String[] ff_names = {"Papa Murphy's", "Carl's Jr.", "Baskin-Robbins", "Culver's",
			"Steak 'n Shake", "Dairy Queen", "Boston Market", "Little Caesars",
			"Hardee's", "Dunkin' Donuts", "Roy Rogers Restaurants", "Domino's Pizza",
			"White Castle", "Jack in the Box", "In-N-Out Burger", "Chick-fil-A",
			"Vista", "The Royal Fiddler"};
	private String[] hotel_names = {"Saffron Peaks Hotel", "Supreme Citadel Hotel", "Mellow Cove Hotel", "Noble Cloud Resort",
			"Lord's Monarch Hotel", "Triple Plaza Hotel", "Monsoon Hotel", "Apex Hotel",
			"Solar Hotel", "Prophecy Resort", "Twin Grove Resort", "Golden Treasure Hotel & Spa",
			"Rose Shore Hotel", "Atlantis Keep Hotel", "Stardust Hotel", "Traveller Resort"};
	
	// Constructor
    private LocationDatabase() {
    	initialize();
    }
    
    // Getter
    public Location[] getLocations(String category) {
		return locations.get(category);
    }
    
    // Initialize the database with random data
	private void initialize() {
		// Construct a hashmap with all the categories and names
		locations = new HashMap<String, Location[]>();
		Map<String, String[]> names = new HashMap<String, String[]>();
		names.put("Parks", park_names);
		names.put("Monuments", monument_names);
		names.put("Museums", museum_names);
		names.put("Shopping", shopping_names);
		names.put("Nightlife", nightlife_names);
		names.put("Bars", bar_names);
		names.put("Cafes", cafe_names);
		names.put("Restaurants", restaurant_names);
		names.put("Fast Food", ff_names);
		names.put("Hotels", hotel_names);
		
		// Generate random locations for each name
		for (Map.Entry<String, String[]> entry : names.entrySet()) {
			String category = entry.getKey();
			String[] name_list = entry.getValue();
			Location[] loc_list = new Location[name_list.length];
			int n = 0;
			
			for (String name : name_list) {
				Location loc = new Location(name, category);
				loc.setDescription(generateRandomDescription(20));
				loc.setStreet(generateRandomStreet());
				loc.setCity("Glasgow");
				loc.setPostcode(generateRandomPostcode());
				try {
					String path = "/images/categories/" + category + "/" + n + ".jpg";
					Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
					loc.setImage(image);
				} catch (Exception e) { }
				loc_list[n++] = loc;
			}
			
			this.locations.put(category, loc_list);
		}
	}

	// Utility methods
	public static String generateRandomDescription(int sentence_count) {
		String[] lorem_ipsum = {" Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
				" Curabitur in nunc bibendum, aliquam metus sit amet, aliquam arcu.",
				" Phasellus faucibus orci eget tellus commodo dapibus.",
				" Etiam bibendum urna ex, lacinia sollicitudin erat aliquet in.",
				" Suspendisse nulla augue, hendrerit ac nibh eu, lobortis accumsan velit.",
				" Vivamus egestas non tellus eget porttitor, nullam malesuada mi eu.",
				" Corsus convallis nisi felis non felis - proin bibendum lorem a neque.",
				" Sodales sagittis  maecenas enim purus, vulputate vel maximus.",
				" Fusce luctus lacus et malesuada commodo maecenas dui lacus.",
				" Fringilla sed metus ut, luctus posuere tortor nullam tincidunt.\r\n",
				" Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n",
				" Nam cursus dui ac velit dictum, vitae blandit ligula venenatis.\r\n",
				" Maecenas vel sapien non nibh mollis aliquam maximus id dolor.\r\n"};
		
		String description = "";
		for (int i = 1; i <= sentence_count; i++){
			int rnd = new Random().nextInt(lorem_ipsum.length);
			description += lorem_ipsum[rnd];
		}
		return description;
	}
	
	private String generateRandomStreet() {
		return (new Random().nextInt(1445) + 1) + " Argyle Street";
	}
	
	private String generateRandomPostcode() {
		String postcode = "G";
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int rnd = new Random().nextInt(98) + 1;
		postcode += rnd + " ";
		rnd = new Random().nextInt(8) + 1;
		postcode += rnd;
		rnd = new Random().nextInt(alphabet.length());
		postcode += alphabet.charAt(rnd);
		rnd = new Random().nextInt(alphabet.length());
		postcode += alphabet.charAt(rnd);
		
		return postcode;
	}
}
