package glasgow_guide;
/* 
 * Class that implements the Category Menu functionality
 */
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
	private Location[] locations;
    private int start;
    private int max_show = 16;
    private int max_show_row = 4;
	
    private Image unknown = new ImageIcon(this.getClass().getResource("/images/icons/Unknown.png")).getImage();
	
    /**
	 *  Create the menu
	 */
	public CategoryMenu(JFrame frame, String category) {
		this(frame, category, 0);
	}
	
	public CategoryMenu(JFrame frame, String category, int start) {
		this(frame, category, LocationDatabase.DATABASE.getLocations(category), 0);
	}
	public CategoryMenu(JFrame frame, String category, Location[] locations, int start) {
		this.frame = frame;
		this.max_x = frame.getWidth();
		this.max_y = frame.getHeight();
		this.category = category;
		this.locations = locations;
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
		new NavPills(frame, this.category);
		
		// Help button
		JButton btnHelp = new JButton("Help");
		Image help = new ImageIcon(this.getClass().getResource("/images/icons/Unknown.png")).getImage();
		help = help.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
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
		
		// Reused each loop iteration
		unknown = unknown.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		Image shadow_image = new ImageIcon(this.getClass().getResource("/images/other/Shadow.png")).getImage();
		shadow_image = shadow_image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		for (int n = start; n < locations.length; n++) {
			if ((n - start) == max_show) {
				last = false;
				break;
			}
			if (x > max_show_row * width) {
				x = 20;
				y += 150;
			}
			
			Location loc = locations[n];
			String name = loc.getName();
			Image image = loc.getImage();
			
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
			try {
				Image i = image.getScaledInstance(width, height, Image.SCALE_FAST);
				img.setIcon(new ImageIcon(i));
			} catch (Exception e) {
				img.setIcon(new ImageIcon(unknown));
			}
			
			clickable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //If the panel is pressed.
					new LocationMenu(frame, loc, start);
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
					new CategoryMenu(frame, category, locations, start - max_show_row);
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
					new CategoryMenu(frame, category, locations, start + max_show_row);
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
