package hci_coursework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MuseumList {

	private JFrame frame;
	private MainMenu main;
	private KelvingroveMuseum kelvingrove;
	/**
	 * Launch the application.
	 */
	public MuseumList(MainMenu main) {
		this.main = main;
		initialize();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MuseumList window = new MuseumList();
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
	public MuseumList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 423, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Museums > Select a Museum");
		Image museum = new ImageIcon(this.getClass().getResource("/Museums.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(museum));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 247, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Kelvingrove Museum");
		btnNewButton.setBounds(239, 53, 159, 23);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//If the  button is pressed.
				MuseumList.this.kelvingrove = new KelvingroveMuseum(MuseumList.this);
				MuseumList.this.kelvingrove.getFrame().setVisible(true);
			}
		});
		
		JButton btnRiversideMuseum = new JButton("Riverside Museum");
		btnRiversideMuseum.setBounds(239, 87, 159, 23);
		frame.getContentPane().add(btnRiversideMuseum);
		
		JButton btnTheBurellCollection = new JButton("The Burell Collection");
		btnTheBurellCollection.setBounds(239, 121, 159, 23);
		frame.getContentPane().add(btnTheBurellCollection);
		
		JButton btnHunterianMuseum = new JButton("Hunterian Museum");
		btnHunterianMuseum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHunterianMuseum.setBounds(239, 155, 159, 23);
		frame.getContentPane().add(btnHunterianMuseum);
		
		JButton btnGalleryOfModern = new JButton("Gallery of Modern Art");
		btnGalleryOfModern.setBounds(239, 188, 159, 23);
		frame.getContentPane().add(btnGalleryOfModern);
		
		JButton btnBack = new JButton("Back");
		Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		btnBack.setIcon(new ImageIcon(back));
		frame.getContentPane().add(btnBack);
        btnBack.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				MuseumList.this.getFrame().setVisible(false);
			}	
        });
		btnBack.setBounds(10, 220, 91, 33);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image eleph = new ImageIcon(this.getClass().getResource("/Museum1.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(eleph));
		lblNewLabel_1.setBounds(10, 53, 205, 167);
		frame.getContentPane().add(lblNewLabel_1);
		
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
	}
	 
	
	
	
	public JFrame getFrame() {
		return this.frame;
	}
}
