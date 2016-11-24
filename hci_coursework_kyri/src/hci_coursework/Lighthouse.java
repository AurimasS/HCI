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
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Lighthouse {

	private JFrame frame;
	private MainMenu main;
	private Monument monument;

	/**
	 * Create the application.
	 */
	public Lighthouse(Monument monument) {
		this.monument = monument;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        JButton btnBack = new JButton("Back");
		Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		btnBack.setIcon(new ImageIcon(back));
		frame.getContentPane().add(btnBack);
        btnBack.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Lighthouse.this.getFrame().setVisible(false);
			}	
        });
		btnBack.setBounds(147, 290, 91, 33);
		frame.getContentPane().add(btnBack);
        
        
		JLabel lblNewLabel = new JLabel("Home > Monuments > Lighthouse");
		Image museum = new ImageIcon(this.getClass().getResource("/monument.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(museum));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 344, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblHistoryOfThe = new JLabel("Description:");
		lblHistoryOfThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHistoryOfThe.setBounds(31, 68, 167, 14);
		frame.getContentPane().add(lblHistoryOfThe);
		
		JTextPane txtpnTheKelvingroveArt = new JTextPane();
		txtpnTheKelvingroveArt.setEditable(false);
		txtpnTheKelvingroveArt.setText("The Lighthouse functions as the centre for architecture in Scotland. This important structure was actually adapted from an original Mackintosh design in the late 1990s. It was opened in 1999 by Queen Elizabeth II, when Glasgow was awarded the prestigious title of UK City of Architecture and Design.");
		txtpnTheKelvingroveArt.setBounds(31, 93, 238, 162);
		frame.getContentPane().add(txtpnTheKelvingroveArt);
		
		JButton btnHome = new JButton("Home");  
		Image img = new ImageIcon(this.getClass().getResource("/Homes.png")).getImage();
		btnHome.setIcon(new ImageIcon(img));
		btnHome.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Lighthouse.this.main= new MainMenu(Lighthouse.this);
				Lighthouse.this.main.getFrame().setVisible(true);
			
			}	
        });
		btnHome.setBounds(32, 290, 105, 33);
		frame.getContentPane().add(btnHome);
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
