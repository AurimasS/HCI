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
import javax.swing.JTextPane;

public class KelvingrovePark {

	private JFrame frame;
	private MainMenu main;
	private ParkList parklist;

	/**
	 * Create the application.
	 */
	public KelvingrovePark(ParkList parklist) {
		this.parklist = parklist;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 581, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        JButton btnBack = new JButton("Back");
		Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		btnBack.setIcon(new ImageIcon(back));
		frame.getContentPane().add(btnBack);
        btnBack.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				KelvingrovePark.this.getFrame().setVisible(false);
			}	
        });
		btnBack.setBounds(125, 290, 91, 33);
		frame.getContentPane().add(btnBack);
        
       
		JLabel lblNewLabel = new JLabel("Home > Parks > Kelvingrove Park");
		Image museum = new ImageIcon(this.getClass().getResource("/Park.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(museum));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 344, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblHistoryOfThe = new JLabel("Information of the Park");
		lblHistoryOfThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHistoryOfThe.setBounds(49, 68, 167, 14);
		frame.getContentPane().add(lblHistoryOfThe);
		
		JTextPane txtpnTheKelvingroveArt = new JTextPane();
		txtpnTheKelvingroveArt.setEditable(false);
		txtpnTheKelvingroveArt.setText("Kelvingrove Park is a public park located on the River Kelvin in the West End of the city of Glasgow, Scotland, containing the famous Kelvingrove Art Gallery and Museum.");
		txtpnTheKelvingroveArt.setBounds(27, 175, 238, 71);
		frame.getContentPane().add(txtpnTheKelvingroveArt);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image kelv = new ImageIcon(this.getClass().getResource("/ael.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(kelv));
		lblNewLabel_1.setBounds(10, 88, 556, 201);
		frame.getContentPane().add(lblNewLabel_1);
		Image kelv1 = new ImageIcon(this.getClass().getResource("/founy.jpg")).getImage();
		
		JButton btnHome = new JButton("Home");  
		Image img = new ImageIcon(this.getClass().getResource("/Homes.png")).getImage();
		btnHome.setIcon(new ImageIcon(img));
		btnHome.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				KelvingrovePark.this.main= new MainMenu();
				KelvingrovePark.this.main.getFrame().setVisible(true);
			
			}	
        });
		btnHome.setBounds(10, 290, 105, 33);
		frame.getContentPane().add(btnHome);
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
