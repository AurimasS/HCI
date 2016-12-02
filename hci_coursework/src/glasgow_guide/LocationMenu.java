package glasgow_guide;
/* 
 * Class that implements the Location Menu functionality
 */
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class LocationMenu {
	private JFrame frame;
	private int max_x;
	private Location location;
	private int start;

	private Image unknown = new ImageIcon(this.getClass().getResource("/images/other/Unknown.jpg")).getImage();
		
	/**
	 * Create the menu
	 */
	public LocationMenu(JFrame frame, Location location) {
		this(frame, location, 0);
	}
	public LocationMenu(JFrame frame, Location location, int start) {
		this.frame = frame;
		this.max_x = frame.getWidth();
		this.location = location;
		this.start = start;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
        
		// Top Navigation pills
		new NavPills(frame, location.getCategory(), location.getName(), start);
		
		// Location picture
		int width = 500;
		int height = 300;
	    JLabel picture = new JLabel();
		picture.setBounds(20, 50, width, height);
		picture.setBorder(Style.BORDER_THICK);
		try {
			Image i = location.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			picture.setIcon(new ImageIcon(i));
		} catch (Exception e) {
			Image i = unknown.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			picture.setIcon(new ImageIcon(i));
		} 
		frame.getContentPane().add(picture);
		
		// Description text
		JTextPane txtDescription = new JTextPane();
		txtDescription.setBounds(20, 350, 500, 310);
		txtDescription.setBorder(Style.BORDER_THIN_EMPTY);
		txtDescription.setEditable(false);
		txtDescription.setText(location.getDescription());
		frame.getContentPane().add(txtDescription);
		
		// Generate address field
		String street = location.getStreet();
		String city = location.getCity();
		String address = "Address:\r\n";
		address += street + ",\r\n";
		address += city + ",\r\n";
		address += location.getPostcode();
		
		
		// Directions map
		String nav_loc = street.replace(" ", "+") + ",+" + city;
		width = 420;
		height = 330;
		JLabel map = new JLabel("");
		map.setBounds(max_x - 440, 50, width, height);
		map.setBorder(Style.BORDER_THICK);
		try {
			String path = "https://maps.googleapis.com/maps/api/staticmap?center="
					+ nav_loc + "&zoom=17&size=" + width + "x" + height + "&maptype=roadmap&"
					+ "markers=color:red|" + nav_loc;
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
		
        // Back button
		new NavBack(frame, location.getCategory(), start);
	}
}
