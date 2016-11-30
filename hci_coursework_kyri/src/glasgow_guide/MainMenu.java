package glasgow_guide;
/* 
 * Class that implements the Main Menu functionality
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

class ChangeRec extends TimerTask {
	private Location[] loc_list;
	private JFrame frame;
	private JButton rec_clickable;
	private JLabel rec_img;
	private JTextPane rec_label;
	private int width;
	private int height;
	private static int counter = 0;
	private int size;
	private ActionListener listener;

	ChangeRec(Location[] loc_list, JFrame frame, JButton rec_clickable, JLabel rec_img, JTextPane rec_label){
		super();
		this.loc_list = loc_list;
		this.frame = frame;
		this.rec_clickable = rec_clickable;
		this.rec_img = rec_img;
		this.rec_label = rec_label;
		this.width = rec_img.getWidth();
		this.height = rec_img.getHeight();
		this.size = loc_list.length;
	}
	
    public void run() {
    	if (counter != size) {
    		Location loc = loc_list[counter];
    		
    		// Remove previous click event
    		if (listener != null) {
    			rec_clickable.removeActionListener(listener);
    		}
    		
    		listener = new ActionListener() {
    			public void actionPerformed(ActionEvent e) { //If the image is pressed.
    				new LocationMenu(frame, loc);
    			}
    		};
    		// Add new click event
    		rec_clickable.addActionListener(listener);
    		
    		// Change Image
    		try {
    			Image i = loc.getImage().getScaledInstance(width, height, Image.SCALE_FAST);
    			rec_img.setIcon(new ImageIcon(i));
    		} catch (Exception e) {
    			Image i =  new ImageIcon(this.getClass().getResource("/images/other/Unknown.jpg")).getImage();
    			i = i.getScaledInstance(width, height, Image.SCALE_FAST);
    			rec_img.setIcon(new ImageIcon(i));
    		}
    		
    		// Change text
    		rec_label.setText(loc.getName() + "\r\n" + loc.getCategory());
    		
    		frame.getContentPane().repaint();
    		counter++;
    	} else {
    		counter = 0;
    	}
    }
}

public class MainMenu {
	private JFrame frame;
	private int max_x = 1024;
	private int max_y = 768;
    
	private Image unknown = new ImageIcon(this.getClass().getResource("/images/other/Unknown.jpg")).getImage();
	Location[] rec_loc_list = LocationDatabase.DATABASE.getLocations("Recommendations"); //Recommended locations
	
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *  Create the menu
	 */
	public MainMenu() {
		this.frame = new JFrame();
		this.frame.setBounds(0, 0, max_x, max_y);
		this.frame.setUndecorated(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		initialize();
	}
	
	public MainMenu(JFrame frame) {
		this.frame = frame;
		this.max_x = frame.getWidth();
		this.max_y = frame.getHeight();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		
		// Top Navigation pills
		new NavPills(frame);
		
		// Help button
		JButton btnHelp = new JButton("Help");
		Image help = new ImageIcon(this.getClass().getResource("/images/icons/Unknown.png")).getImage();
		help = help.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btnHelp.setIcon(new ImageIcon(help));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JOptionPane.showMessageDialog(null, "Welcome to Glasgow, Please choose one of the options below");
			}
		});
		btnHelp.setBounds(max_x - 100, 0, 100, 35);
		frame.getContentPane().add(btnHelp);
		
		// Panel for each category
		int x = 20;
		int y = 50;
		int height = 140;
		int width = 150;
		int text_height = 40;
		int margin = 5;
		int max_show_row = 3;
		
		// Reused each loop iteration
		unknown = unknown.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		Image shadow_image = new ImageIcon(this.getClass().getResource("/images/other/shadow.png")).getImage();
		shadow_image = shadow_image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		for (String cat: LocationDatabase.CATEGORIES) {
			if (x > max_show_row * width) {
				x = 20;
				y += 150;
			}
			
			// Clickable part of the panel
			JButton clickable = new JButton();
			clickable.setBounds(x, y, width, height);
			clickable.setOpaque(false);
			clickable.setContentAreaFilled(false);
			clickable.setBorderPainted(false);
			clickable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //If the panel is pressed.
					new CategoryMenu(frame, cat);
				}
			});
			
			// Background image of the panel
			JLabel img = new JLabel();
			img.setBounds(x, y, width, height);
			img.setBackground(Style.PRIMARY);
			img.setOpaque(true);
            try {
            	Image i = new ImageIcon(this.getClass().getResource("/images/categories/" + cat + ".jpg")).getImage();
            	i = i.getScaledInstance(width, height, Image.SCALE_FAST);
            	img.setIcon(new ImageIcon(i));
            } catch (Exception e) {
            	img.setIcon(new ImageIcon(unknown));
            }
            
            // Border shadow of the panel
			JLabel shadow = new JLabel();
			shadow.setBounds(x, y, width, height);
			shadow.setBorder(Style.BORDER_THICK);
            shadow.setIcon(new ImageIcon(shadow_image));
          
            // Label for the panel
			JLabel label = new JLabel(cat);
			label.setForeground(Color.WHITE);
			label.setFont(Style.BOLD);
			label.setBounds(x + margin, y + margin, width - margin, text_height - margin);
			label.setVerticalAlignment(SwingConstants.NORTH);
			label.setHorizontalAlignment(SwingConstants.LEFT);
			
			frame.getContentPane().add(label);
			frame.getContentPane().add(shadow);
			frame.getContentPane().add(img);
			frame.getContentPane().add(clickable);
			x += width + 10;
		}
		
		// This is the Back button, which is grayed out in the main menu
		new NavBack(frame);
        
        // Weekly Recommendations label
		width = max_show_row * width;
		height = 35;
		JLabel lblRecommendations = new JLabel("Weekly Recommendations:");
		lblRecommendations.setFont(Style.BOLD);
		lblRecommendations.setBounds(max_x - 20 - width, 50, width, height);
		lblRecommendations.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecommendations.setVerticalAlignment(SwingConstants.CENTER);
		lblRecommendations.setBackground(Style.PRIMARY);
		lblRecommendations.setForeground(Color.WHITE);
		lblRecommendations.setBorder(Style.BORDER_THICK);
		lblRecommendations.setOpaque(true);
		frame.getContentPane().add(lblRecommendations);
		
		// Recommended Locations
		// Clickable part of the recommendation
		x = lblRecommendations.getBounds().x;
		y = lblRecommendations.getBounds().y + lblRecommendations.getHeight() - 3;
		height = 300;
		JButton rec_clickable = new JButton();
		rec_clickable.setBounds(x, y, width, height);
		rec_clickable.setOpaque(false);
		rec_clickable.setContentAreaFilled(false);
		rec_clickable.setBorderPainted(false);
		
		// Background image of the recommendation
		JLabel rec_img = new JLabel();
		rec_img.setBounds(x, y, width, height);
		rec_img.setBackground(Style.PRIMARY);
		rec_img.setOpaque(true);
		rec_img.setBorder(Style.BORDER_THICK);

		// Border shadow of the recommendation
		Image i = new ImageIcon(this.getClass().getResource("/images/other/shadow_bottom.png")).getImage();
		i = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		JLabel rec_shadow = new JLabel();
		rec_shadow.setBounds(x, y + height - text_height, width, text_height);
		rec_shadow.setIcon(new ImageIcon(i));

		// Label for the recommendation
		JTextPane rec_label = new JTextPane();
		rec_label.setEditable(false);
		rec_label.setForeground(Color.WHITE);
		rec_label.setOpaque(false);
		rec_label.setFont(Style.BOLD);
		rec_label.setBounds(x + margin, rec_shadow.getBounds().y, width - margin, text_height);

		Timer timer = new Timer();
		timer.schedule(new ChangeRec(rec_loc_list, frame, rec_clickable, rec_img, rec_label), 0, 3000);
		
		frame.getContentPane().add(rec_label);
		frame.getContentPane().add(rec_shadow);
		frame.getContentPane().add(rec_img);
		frame.getContentPane().add(rec_clickable);
		
        // Upcoming Events label
		JLabel lblEvents = new JLabel("Upcoming Events:");
		lblEvents.setFont(Style.BOLD);
		lblEvents.setBounds(lblRecommendations.getBounds().x, 
				rec_clickable.getBounds().y + rec_clickable.getHeight(),
				lblRecommendations.getWidth(), lblRecommendations.getHeight());
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setVerticalAlignment(SwingConstants.CENTER);
		lblEvents.setBackground(Style.PRIMARY);
		lblEvents.setForeground(Color.WHITE);
		lblEvents.setBorder(Style.BORDER_THICK);
		lblEvents.setOpaque(true);
		frame.getContentPane().add(lblEvents);
		
		// Events text
		JTextPane txtEvents = new JTextPane();
		txtEvents.setBounds(lblEvents.getBounds().x, lblEvents.getBounds().y + lblEvents.getHeight() - 3,
				lblEvents.getWidth(), 200);
		txtEvents.setBorder(Style.BORDER_THIN_EMPTY);
		txtEvents.setEditable(false);
		txtEvents.setFont(Style.BOLD);
		txtEvents.setText("\r\n  01/12 — A Day in the Basement \r\n" +
				"  01/12 — Kraftkelder \r\n" +
				"  01/12 — TechnoBatterie \r\n" +
				"  02/12 — Dancing Cowboys \r\n" +
				"  03/12 — We are the Streets \r\n" +
				"  05/12 — Daft Punk in the Park \r\n" + 
				"  05/12 — Screaming Cows \r\n" +
				"  06/12 — Heated Monkeys \r\n" +
				"  07/12 — Screaming Monkeys \r\n");
		frame.getContentPane().add(txtEvents);
		
		// History button
		width = 125;
		height = 35;
		int icon_size = 25;
		JButton btnHistory = new JButton("History");
		btnHistory.setBounds(max_x - width - 20, max_y - 55, width, height);
		btnHistory.setFont(Style.BOLD);
		btnHistory.setBackground(Style.PRIMARY);
		btnHistory.setForeground(Color.WHITE);
		btnHistory.setBorder(Style.BORDER_THIN);
        try {
        	Image icon = new ImageIcon(this.getClass().getResource("/images/icons/History.png")).getImage();
        	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_SMOOTH);
        	btnHistory.setIcon(new ImageIcon(icon));
        } catch (Exception e) {
        	Image icon = new ImageIcon(this.getClass().getResource("/images/icons/Unknown.png")).getImage();
        	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_SMOOTH);
        	btnHistory.setIcon(new ImageIcon(icon));
        }
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HistoryMenu(frame);
			}
		});
		frame.getContentPane().add(btnHistory);
	}
}
