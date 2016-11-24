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

public class Shopping {

	private JFrame frame;
	private MainMenu main;

	/**
	 * Create the application.
	 */
	public Shopping(MainMenu main) {
		this.main = main;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(120, 120, 423, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shopping > Shopping centres");
		Image monument = new ImageIcon(this.getClass().getResource("/shop.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(monument));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 273, 31);
		frame.getContentPane().add(lblNewLabel);
				
		JLabel lblNewLabel_1 = new JLabel("");
		Image eleph = new ImageIcon(this.getClass().getResource("/buchanan.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(eleph));
		lblNewLabel_1.setBounds(10, 53, 205, 158);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnBuchanan = new JButton("Buchanan Galleries");
		btnBuchanan.setBounds(239, 53, 159, 23);
		frame.getContentPane().add(btnBuchanan);
		frame.getContentPane().add(btnBuchanan);
		btnBuchanan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//If the  button is pressed.
//				ParkList.this.kelvingrovepark = new KelvingrovePark(ParkList.this);
//				ParkList.this.kelvingrovepark.getFrame().setVisible(true);
		}
		});
		
		JButton btnEnoch = new JButton("St Enoch Centre");
		btnEnoch.setBounds(239, 87, 159, 23);
		frame.getContentPane().add(btnEnoch);
		
		JButton btnPrince = new JButton("Prince's Square");
		btnPrince.setBounds(239, 121, 159, 23);
		frame.getContentPane().add(btnPrince);
		
		JButton btnArgyl = new JButton("Argyll Arcade");
		btnArgyl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnArgyl.setBounds(239, 155, 159, 23);
		frame.getContentPane().add(btnArgyl);
		
		JButton btnMerchant = new JButton("Merchant Square ");
		btnMerchant.setBounds(239, 188, 159, 23);
		frame.getContentPane().add(btnMerchant);
		
		JButton btnHelp = new JButton("Help");
		Image help = new ImageIcon(this.getClass().getResource("/Help.png")).getImage();
		btnHelp.setIcon(new ImageIcon(help));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JOptionPane.showMessageDialog(null, "this is a pop up message");
			}
		});
		btnHelp.setBounds(309, 12, 89, 31);
		frame.getContentPane().add(btnHelp);
		
		JButton btnBack = new JButton("Back");
		Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		btnBack.setIcon(new ImageIcon(back));
		frame.getContentPane().add(btnBack);
        btnBack.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Shopping.this.getFrame().setVisible(false);
			}	
        });
		btnBack.setBounds(10, 222, 91, 33);
		frame.getContentPane().add(btnBack);
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
