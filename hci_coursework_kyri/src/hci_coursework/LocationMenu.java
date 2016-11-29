package hci_coursework;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class LocationMenu {
	private JFrame frame;
	private int max_x;
	
	private String category;
	private String name;
	private String path;
	private int start;
	
	private String[] description = {" Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
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

	/**
	 * Create the application.
	 */
	public LocationMenu(JFrame frame, String category, String name, String path) {
		this(frame, category, name, path, 0);
	}
	public LocationMenu(JFrame frame, String category, String name, String path, int start) {
		this.frame = frame;
		this.max_x = frame.getWidth();
		this.category = category;
		this.name = name;
		this.path = path;
		this.start = start;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		
		// Location picture
		int width = 500;
		int height = 300;
	    JLabel picture = new JLabel();
		picture.setBounds(20, 50, width, height);
		picture.setBorder(Style.BORDER_THICK);
		try {
			Image i = new ImageIcon(this.getClass().getResource(path)).getImage();
			i = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			picture.setIcon(new ImageIcon(i));
		} catch (Exception e) {
			path = "/images/other/Unknown.jpg";
			Image i = new ImageIcon(this.getClass().getResource(path)).getImage();
			i = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			picture.setIcon(new ImageIcon(i));
		} 
		frame.getContentPane().add(picture);
        
		// Top Navigation pills
		new NavPills(frame, category, name, start);
        
        // Back button
		new NavBack(frame, category, start);
		
		// Generate random description
		String descr = "";
		for (int i = 1; i <= 20; i++){
			int rnd = new Random().nextInt(this.description.length);
			descr += description[rnd];
		}
		
		// Description text
		JTextPane txtDescription = new JTextPane();
		txtDescription.setBounds(20, 350, 500, 310);
		txtDescription.setBorder(Style.BORDER_THIN_EMPTY);
		txtDescription.setEditable(false);
		txtDescription.setText(descr);
		frame.getContentPane().add(txtDescription);
		
		// Generate random address
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String address = "Address:\r\n";
		int street = new Random().nextInt(1445) + 1;
		address += street + " Argyle Street,\r\nGlasgow,\r\nG";
		int rnd = new Random().nextInt(98) + 1;
		address += rnd + " ";
		rnd = new Random().nextInt(8) + 1;
		address += rnd;
		rnd = new Random().nextInt(alphabet.length());
		address += alphabet.charAt(rnd);
		rnd = new Random().nextInt(alphabet.length());
		address += alphabet.charAt(rnd);
		
		// Directions map
		width = 420;
		height = 330;
		JLabel map = new JLabel("");
		map.setBounds(max_x - 440, 50, width, height);
		map.setBorder(Style.BORDER_THICK);
		try {
			String path = "https://maps.googleapis.com/maps/api/staticmap?center="
					+ street + "+Argyle+St,+Glasgow&zoom=17&size=" + width + "x" + height + "&maptype=roadmap&"
					+ "markers=color:red|" + street + "+Argyle+St,+Glasgow";
			URL url = new URL(path);
			Image image = ImageIO.read(url);
			map.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			Image image = new ImageIcon(this.getClass().getResource("/images/other/loc.gif")).getImage();
			map.setIcon(new ImageIcon(image));
		} 
		frame.getContentPane().add(map);
		
		// Address text
		JTextPane txtAddress = new JTextPane();
		txtAddress.setEditable(false);
		txtAddress.setText(address);
		txtAddress.setBackground(Style.PRIMARY);
		txtAddress.setForeground(Color.WHITE);
		txtAddress.setBorder(Style.BORDER_THICK_EMPTY);
		txtAddress.setFont(Style.BOLD);
		txtAddress.setBounds(max_x - 330, 400, 180, 80);
		frame.getContentPane().add(txtAddress);
	}
}
