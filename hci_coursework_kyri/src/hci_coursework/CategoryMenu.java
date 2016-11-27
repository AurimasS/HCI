package hci_coursework;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class CategoryMenu {

	private JFrame frame;
	private String category;
    private String[] names;
	int max_x = 1024;
	int max_y = 768;
	
	private String[] park_names = {"Crescent Plaza", "Crescent Garden", "Crystal Cove Meadows", "Solstice Plaza",
			"Prospect Meadows", "Trillium Grounds", "plaoms Gardens", "vroxad Park",
			"ydort Garden", "blyek Gardens", "Blossom Park", "Bronze Arch Garden",
			"Grand Avenue Plaza", "Maple Grove Plaza", "Twilight Gardens", "Sunrise Garden"};
	private String[] monument_names = {"The Nameless Temple", "The Bare Lands", "The Nightmare Borough", "Labyrinth of Necrosis",
			"Clearbrace Sanctuary", "The Visage Nest", "The Warden Cover", "wildhowl Base",
			"The August Enclave", "The Oracle Burials", "House of Confidence", "Sanctum of tuxnia",
			"Epoch Lookout", "Sentience Pillar", "Bronze Creek Obelisk", "Silver Brook Spire"};
	private String[] museum_names = {"Museum of Ancestry", "National Institution of Culture", "Gallery of Winter", "Lingmell",
			"Exhibition of Movement", "Nightmare Institute", "Exploration Museum", "International Water Treasury",
			"Grand Hall of Play", "Hall of Sightings", "Toy Centre", "Royal Center of the Underground",
			"Central Gadget Institution", "Reconnaissance Institute", "Treasury of Revelations", "Treasury of Games"};
	private String[] shopping_names = {"The Flimsy Cloak", "The Humble Tusk Sport Store", "The Big Kite Cars", "Bean Me Up",
			"Teacoon", "The Racing Note	", "Optim-Eyes", "The Merry Duck",
			"The Blue Guard Butcher Shop", "The Blank Dish", "Julious Scissor", "The Hairy Ship Garage",
			"Brews Brothers", "Goodfillas", "The Dazzling Mask Tearoom", "The Shaving Quarry"};
	private String[] nightlife_names = {"Phoenix", "Justice", "Fortune", "Club Mirth",
			"Club Crimson", "The Crobar", "The Galaxy", "The Bridge",
			"The Aurora", "The Inferno", "Elegance", "Deviant",
			"Triumph", "The Escape", "Entity", "The Rhythm"};
	private String[] bar_names = {"The Long Cats Pub", "Ye Olde Vanilla Bean", "The Opposite Tree Inn", "The Golden Cucumber",
			"The Limping Loch", "The Juicy Snow Bar", "The Broad Mango Inn", "The Free Beard",
			"Hops and Robbers Brewers", "Hairy Turtle Brewing Company", "Nordic Brewing", "The Speakeasy Brewing Company",
			"Ferocious Brewery", "Seafront Brewing Co.", "Phoenix Fermentary", "Dragonmead Brewing"};
	private String[] cafe_names = {"Lettuce Retreat Cafe", "Steamy Indulgences Cafeteria", "Sugar & Spice Tearoom", "Grinders Coffee",
			"Q & A Room", "Havana Shrine Coffee Bar", "Hava Pearl Barista", "Melting Boulder Diner",
			"Havana Fest Espresso Bar", "Hidden Heaven Diner", "Hot Shots Cafe", "This & That Coffee Bar",
			"Thinking Cup Cafe", "Ground Up Coffee Bar", "Trembling Cup Cafeteria", "Gentle Teapot Room"};
	private String[] retaurant_names = {"The Vintage Duke", "The Village Door", "Bambino", "Beehive",
			"The Northern After Dark", "The Cool Cat Shrimp", "The Malt Lily", "Retro",
			"The Goat", "The Lion", "The Coriander Lion", "The Streetwise Crown",
			"The Savory Chicken", "Chapter", "Whisperwind", "Kingsize"};
	private String[] ff_names = {"Papa Murphy's", "Carl's Jr.", "Baskin-Robbins", "Culver's",
			"Steak 'n Shake", "Dairy Queen", "Boston Market", "Little Caesars",
			"Hardee's", "Dunkin' Donuts", "Roy Rogers Restaurants", "Domino's Pizza",
			"White Castle", "Jack in the Box", "In-N-Out Burger", "Chick-fil-A"};
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
	public CategoryMenu(String category) {
		this.category = category;
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
			case "cafes":
				this.names = cafe_names;
				break;
			case "Retaurants":
				this.names = retaurant_names;
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
		frame = new JFrame();
		frame.setBounds(0, 0, max_x, max_y);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(this.category + " > Select a location");
		Image icon;
		try {
			icon = new ImageIcon(this.getClass().getResource("/" + this.category + ".png")).getImage();
		} catch (Exception e) {
			icon = new ImageIcon(this.getClass().getResource("/Unknown.png")).getImage();
		}
		lblNewLabel.setIcon(new ImageIcon(icon));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(0, 0, 273, 31);
		frame.getContentPane().add(lblNewLabel);
		
		// Button for each location
		int x = 20;
		int y = 50;
		int width = 200;
		int height = 140;
		for (String name: names) {
			if (x > 4 * width) {
				x = 20;
				y += 150;
			}
			
			JButton btn = new JButton(name);
			btn.setBounds(x, y, width, height);
			btn.setVerticalAlignment(SwingConstants.NORTH);
			btn.setHorizontalAlignment(SwingConstants.LEFT);
			frame.getContentPane().add(btn);
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {//If the  button is pressed.
					Necropolis necropolis = new Necropolis(null);
					necropolis.getFrame().setVisible(true);
					frame.dispose();
			}
			});
			x += width + 10;
		}
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
		
		JButton btnBack = new JButton("Back");
		Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		btnBack.setIcon(new ImageIcon(back));
		frame.getContentPane().add(btnBack);
        btnBack.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				MainMenu menu = new MainMenu();
				menu.getFrame().setVisible(true);
				frame.dispose();
			}	
        });
		btnBack.setBounds(20, max_y - 55, 100, 35);
		frame.getContentPane().add(btnBack);
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
