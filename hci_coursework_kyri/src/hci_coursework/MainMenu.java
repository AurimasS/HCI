package hci_coursework;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MainMenu {

	private JFrame frame;
	private int max_x = 1024;
	private int max_y = 768;
    
    private String[] categories = {"Parks", "Monuments", "Museums",
    		"Shopping", "Nightlife", "Bars",
    		"Cafes", "Restaurants", "Fast Food",
    		"Hotels"};
    
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
	 * Create the application.
	 */
	public MainMenu() {
		this.frame = new JFrame();
		this.frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
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
		new NavPills(frame, null, null);
		
		// Help button
		JButton btnHelp = new JButton("Help");
		Image help = new ImageIcon(this.getClass().getResource("/Help.png")).getImage();
		btnHelp.setIcon(new ImageIcon(help));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JOptionPane.showMessageDialog(null, "Welcome to Glasgow, Please choose one of the options below");
			}
		});
		btnHelp.setBounds(max_x - 100, 0, 100, 35);
		frame.getContentPane().add(btnHelp);
		
		// Button for each category
		int x = 20;
		int y = 50;
		int width = 150;
		int height = 140;
		for (String cat: categories) {
			if (x > 3 * width) {
				x = 20;
				y += 150;
			}
			
			JButton btn = new JButton(cat);
			try {
				Image image = new ImageIcon(this.getClass().getResource("/" + cat + ".png")).getImage();
				btn.setIcon(new ImageIcon(image));
			} catch (Exception e) {
				Image image = new ImageIcon(this.getClass().getResource("/Unknown.png")).getImage();
				btn.setIcon(new ImageIcon(image));
			} finally {
				btn.setForeground(Color.BLACK);
				btn.setFont(new Font("Calibri", Font.BOLD, 14));
				btn.setBounds(x, y, width, height);
				btn.setVerticalAlignment(SwingConstants.NORTH);
				btn.setHorizontalAlignment(SwingConstants.LEFT);
				frame.getContentPane().add(btn);
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {//If the  button is pressed.
						new CategoryMenu(frame, cat);
				}
				});
				x += width + 10;
			}
		}
		
		// This is the Back button, which is grayed out in the main menu
		new NavBack(frame, null);
        
        // Weekly Recommendations label
		JLabel lblTopThingsTo = new JLabel("Weekly Recommendations:");
		lblTopThingsTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTopThingsTo.setBounds(max_x - 360, 60, 200, 20);
		frame.getContentPane().add(lblTopThingsTo);
		
		// History button
		JButton btnNewButton = new JButton("History");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(max_x - 120, max_y - 55, 100, 35);
		frame.getContentPane().add(btnNewButton);
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
