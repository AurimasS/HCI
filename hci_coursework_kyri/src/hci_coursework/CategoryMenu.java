package hci_coursework;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class CategoryMenu {
	private JFrame frame;
	private int max_x;
	private int max_y;
	private String category;
    private String[] names;
    private int start;
    private int max_show = 16;
    private int max_show_row = 4;
	
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
	private String[] default_names = {"Sarton", "Stratford", "Zalfari", "Lingmell",
			"Aberdeen", "Furness", "Skystead", "Perthlochry",
			"Blackridgepool", "Tregaron", "Cardend", "Gormsey",
			"Accrington", "Hartlepool", "Fanfoss", "Perthlochry"};
	
	/**
	 * Create the application.
	 */
	public CategoryMenu(JFrame frame, String category) {
		this(frame, category, 0);
	}
	
	public CategoryMenu(JFrame frame, String category, int start) {
		this.frame = frame;
		this.max_x = frame.getWidth();
		this.max_y = frame.getHeight();
		this.category = category;
		this.start = start;
		switch (category) {
			case "Parks":
				this.names = park_names;
				break;
			case "Monuments":
				this.names = monument_names;
				break;
			case "Museums":
				this.names = museum_names;
				break;
			case "Shopping":
				this.names = shopping_names;
				break;
			case "Nightlife":
				this.names = nightlife_names;
				break;
			case "Bars":
				this.names = bar_names;
				break;
			case "Cafes":
				this.names = cafe_names;
				break;
			case "Restaurants":
				this.names = restaurant_names;
				break;
			case "Fast Food":
				this.names = ff_names;
				break;
			case "Hotels":
				this.names = hotel_names;
				break;
			default:
				this.names = default_names;
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		
		// Top Navigation pills
		new NavPills(frame, this.category);
		
		// Help button
		JButton btnHelp = new JButton("Help");
		Image help = new ImageIcon(this.getClass().getResource("/Help.png")).getImage();
		btnHelp.setBounds(max_x - 100, 0, 100, 35);
		btnHelp.setIcon(new ImageIcon(help));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JOptionPane.showMessageDialog(null, "this is a pop up message");
			}
		});
		frame.getContentPane().add(btnHelp);
		
		// Button for each location
		int x = 20;
		int y = 50;
		int width = 200;
		int height = 140;
		int text_height = 40;
		int margin = 2;
		boolean last = true; // Has the last category been shown?
		
		Image shadow_image = new ImageIcon(this.getClass().getResource("/images/other/Shadow.png")).getImage();
		shadow_image = shadow_image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		for (int n = start; n < names.length; n++) {
			if ((n - start) == max_show) {
				last = false;
				break;
			}
			if (x > max_show_row * width) {
				x = 20;
				y += 150;
			}
			
			String name = names[n];
			
			// Clickable part of the panel
			JButton clickable = new JButton();
			clickable.setBounds(x, y, width, height);
			clickable.setOpaque(false);
			clickable.setContentAreaFilled(false);
			clickable.setBorderPainted(false);

			// Background image of the panel
			JLabel img = new JLabel();
			img.setBounds(x, y, width, height);
			img.setBackground(Style.PRIMARY);
			img.setOpaque(true);
			String path;
			try {
				path = "/images/categories/" + category + "/" + n + ".jpg";
				Image i = new ImageIcon(this.getClass().getResource(path)).getImage();
				i = i.getScaledInstance(width, height, Image.SCALE_FAST);
				img.setIcon(new ImageIcon(i));
			} catch (Exception e) {
				path = "/images/other/Unknown.jpg";
				Image i = new ImageIcon(this.getClass().getResource(path)).getImage();
				i = i.getScaledInstance(width, height, Image.SCALE_FAST);
				img.setIcon(new ImageIcon(i));
			}
			String p = path;
			clickable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //If the panel is pressed.
					new LocationMenu(frame, category, name, p, start);
				}
			});
			
			// Border shadow of the panel
			JLabel shadow = new JLabel();
			shadow.setBounds(x, y, width, height);
			shadow.setBorder(Style.BORDER_THICK);
			shadow.setIcon(new ImageIcon(shadow_image));

			// Label for the panel
			JTextPane label = new JTextPane();
			label.setEditable(false);
			label.setText(name);
			label.setForeground(Color.WHITE);
			label.setOpaque(false);
			label.setFont(Style.BOLD);
			label.setBounds(x + margin, y + margin, width - margin, text_height - margin);

			frame.getContentPane().add(label);
			frame.getContentPane().add(shadow);
			frame.getContentPane().add(img);
			frame.getContentPane().add(clickable);
			x += width + 10;
		}
		
		// Up Arrow Button
		width = 100;
		height = 100;
		margin = 40;
		int spacing = 175;
		JButton up = new JButton();
		up.setBounds(max_x - width - margin, spacing, width, height);
		up.setOpaque(false);
		up.setContentAreaFilled(false);
		up.setBorderPainted(false);
		Image i = new ImageIcon(this.getClass().getResource("/images/other/up_arrow.png")).getImage();
		if (start == 0) {
			i = new ImageIcon(this.getClass().getResource("/images/other/up_arrow_inactive.png")).getImage();
		} else {
			up.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //If the arrow is pressed.
					new CategoryMenu(frame, category, start - max_show_row);
				}
			});
		}
		i = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		up.setIcon(new ImageIcon(i));	
		frame.getContentPane().add(up);
		
		// Down Arrow Button
		JButton down = new JButton();
		down.setOpaque(false);
		down.setContentAreaFilled(false);
		down.setBorderPainted(false);
		down.setBounds(max_x - width - margin, max_y - height - spacing, width, height);
		down.setBackground(Style.PRIMARY);
		i = new ImageIcon(this.getClass().getResource("/images/other/down_arrow.png")).getImage();
		if (last) {
			i = new ImageIcon(this.getClass().getResource("/images/other/down_arrow_inactive.png")).getImage();
		} else {
			down.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //If the arrow is pressed.
					new CategoryMenu(frame, category, start + max_show_row);
				}
			});
		}
		i = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		down.setIcon(new ImageIcon(i));	
		frame.getContentPane().add(down);
		
		// Back button
		new NavBack(frame, "Home");
	}

}
