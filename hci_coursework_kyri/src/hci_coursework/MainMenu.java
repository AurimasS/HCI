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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

public class MainMenu {

	private JFrame frame;
	private MuseumList museumlist;
	private ParkList parklist;
	private Monument monument;
    private Topthings topthings;
    private KelvingroveMuseum kelvingrove;
    private KelvingrovePark kelvingrovepark;
    private Shopping shopping;
    private Necropolis necropolis;
    private GeorgeSquare gsquare;
    private Lighthouse lighthouse;
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

	public MainMenu(KelvingroveMuseum kelvingrovre) {
		this.kelvingrove = kelvingrove;
		initialize();
	}

	public MainMenu(KelvingrovePark kelvingrovrepark) {
		this.kelvingrovepark = kelvingrovepark;
		initialize();
	}
	
	public MainMenu(Necropolis necropolis) {
		this.necropolis = necropolis;
		initialize();
	}
	
	public MainMenu(Lighthouse lighthouse) {
		this.lighthouse = lighthouse;
		initialize();
	}
	
	public MainMenu(GeorgeSquare gsquare) {
		this.gsquare = gsquare;
		initialize();
	}
	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.setBounds(100, 100, 640, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// This is the Museum button
		JButton btnMuseum = new JButton("Museums");
		Image museum = new ImageIcon(this.getClass().getResource("/Museum.png")).getImage();
		btnMuseum.setIcon(new ImageIcon(museum));
		btnMuseum.setForeground(Color.BLACK);
		btnMuseum.setFont(new Font("Calibri", Font.BOLD, 14));
		btnMuseum.setBounds(25, 75, 148, 37);
		frame.getContentPane().add(btnMuseum);
		btnMuseum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//If the  button is pressed.
				MainMenu.this.museumlist = new MuseumList(MainMenu.this);
				MainMenu.this.museumlist.getFrame().setVisible(true);
			}
		});
		
		// This is the Parks button
		JButton btnPark = new JButton("Parks");
		Image park = new ImageIcon(this.getClass().getResource("/Park.png")).getImage();
		btnPark.setIcon(new ImageIcon(park));
		btnPark.setForeground(Color.BLACK);
		btnPark.setFont(new Font("Calibri", Font.BOLD, 14));
		btnPark.setBounds(183, 75, 148, 37);
		frame.getContentPane().add(btnPark);
		btnPark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//If the  button is pressed.
				MainMenu.this.parklist = new ParkList(MainMenu.this);
				MainMenu.this.parklist.getFrame().setVisible(true);
			
			}
		});
		
		// This is the Monument button
		JButton btnMonument = new JButton("Monuments");
		Image mon = new ImageIcon(this.getClass().getResource("/monument.png")).getImage();
		btnMonument.setIcon(new ImageIcon(mon));
		btnMonument.setForeground(Color.BLACK);
		btnMonument.setFont(new Font("Calibri", Font.BOLD, 14));
		btnMonument.setBounds(183, 123, 148, 37);
		frame.getContentPane().add(btnMonument);
		btnMonument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//If the  button is pressed.
				MainMenu.this.monument = new Monument(MainMenu.this);
				MainMenu.this.monument.getFrame().setVisible(true);
			
			}
		});
		// This is the Exit button, which contains a method to exit the main page.
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Calibri", Font.BOLD, 14));
		btnExit.setBounds(25, 235, 65, 37);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//If the Exit button is pressed.
				System.exit(0);
			}
		});
		
		JLabel lblWelcomeToGlasgow = new JLabel("Welcome to Glasgow");
		lblWelcomeToGlasgow.setForeground(Color.YELLOW);
		lblWelcomeToGlasgow.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcomeToGlasgow.setBounds(231, 11, 175, 49);
		frame.getContentPane().add(lblWelcomeToGlasgow);
		
		JLabel lblTopThingsTo = new JLabel("Top Things to Do:");
		lblTopThingsTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTopThingsTo.setBounds(454, 59, 120, 19);
		frame.getContentPane().add(lblTopThingsTo);
		
		JButton button = new JButton("Shopping");
		Image img = new ImageIcon(this.getClass().getResource("/shop.png")).getImage();
		button.setIcon(new ImageIcon(img));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.this.shopping = new Shopping(MainMenu.this);
				MainMenu.this.shopping.getFrame().setVisible(true);
			
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Calibri", Font.BOLD, 14));
		button.setBounds(25, 123, 148, 37);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Home");
		Image imga = new ImageIcon(this.getClass().getResource("/Home.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imga));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 91, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnHelp = new JButton("Help");
		Image help = new ImageIcon(this.getClass().getResource("/Help.png")).getImage();
		btnHelp.setIcon(new ImageIcon(help));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JOptionPane.showMessageDialog(null, "Welcome to Glasgow, Please choose one of the options below");
			}
		});
		btnHelp.setBounds(523, 11, 91, 37);
		frame.getContentPane().add(btnHelp);
		
		JButton btnNewButton = new JButton("Staff Reccommendations");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(414, 235, 200, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Restaurant");
		Image res = new ImageIcon(this.getClass().getResource("/food.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(res));
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton_1.setBounds(25, 171, 148, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNightlife = new JButton("Nightlife");
		Image res1 = new ImageIcon(this.getClass().getResource("/drink.png")).getImage();
		btnNightlife.setIcon(new ImageIcon(res1));
		btnNightlife.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNightlife.setBounds(183, 171, 148, 37);
		frame.getContentPane().add(btnNightlife);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image view = new ImageIcon(this.getClass().getResource("/view.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(view));
		lblNewLabel_1.setBounds(0, 0, 624, 358);
		frame.getContentPane().add(lblNewLabel_1);
		
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
