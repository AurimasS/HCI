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

public class Monument {

	private JFrame frame;
	private MainMenu main;
	private Necropolis necropolis;
	private GeorgeSquare gsquare;
	private Lighthouse lighthouse;
	
	/**
	 * Create the application.
	 */
	public Monument(MainMenu main) {
		this.main = main;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(120, 120, 428, 306);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Monuments > Select a Monument");
		Image monument = new ImageIcon(this.getClass().getResource("/monument.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(monument));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 273, 31);
		frame.getContentPane().add(lblNewLabel);
				
		JLabel lblNewLabel_1 = new JLabel("");
		Image eleph = new ImageIcon(this.getClass().getResource("/monuments.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(eleph));
		lblNewLabel_1.setBounds(10, 43, 205, 168);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNecropolis = new JButton("Necropolis");
		btnNecropolis.setBounds(239, 53, 159, 23);
		frame.getContentPane().add(btnNecropolis);
		frame.getContentPane().add(btnNecropolis);
		btnNecropolis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//If the  button is pressed.
				Monument.this.necropolis = new Necropolis(Monument.this);
				Monument.this.necropolis.getFrame().setVisible(true);
		}
		});
		
		JButton btnGSquare = new JButton("George Square");
		btnGSquare.setBounds(239, 87, 159, 23);
		frame.getContentPane().add(btnGSquare);
		btnGSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//If the  button is pressed.
				Monument.this.gsquare = new GeorgeSquare(Monument.this);
				Monument.this.gsquare.getFrame().setVisible(true);
		}
		});
		JButton btnCathedral = new JButton("Glasgow Cathedral");
		btnCathedral.setBounds(239, 121, 159, 23);
		frame.getContentPane().add(btnCathedral);
		
		JButton btnShip = new JButton("The Tall Ship");
		btnShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShip.setBounds(239, 155, 159, 23);
		frame.getContentPane().add(btnShip);
		
		JButton btnLighthouse = new JButton("The Lighthouse");
		btnLighthouse.setBounds(239, 188, 159, 23);
		frame.getContentPane().add(btnLighthouse);
		btnLighthouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//If the  button is pressed.
				Monument.this.lighthouse = new Lighthouse(Monument.this);
				Monument.this.lighthouse.getFrame().setVisible(true);
		}
		});
		
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
				Monument.this.getFrame().setVisible(false);
			}	
        });
		btnBack.setBounds(10, 222, 91, 33);
		frame.getContentPane().add(btnBack);
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
