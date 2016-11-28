package hci_coursework;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.Timer;

public class LocationMenu {
    JLabel pic;
    Timer tm;
    int x = 0;
    
	private JFrame frame;
	private int max_x;
	private int max_y;
	
	private String category;
	private String name;
	private String[] description = {" Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
			" Curabitur in nunc bibendum, aliquam metus sit amet, aliquam arcu.",
			" Phasellus faucibus orci eget tellus commodo dapibus.",
			" Etiam bibendum urna ex, lacinia sollicitudin erat aliquet in.",
			" Suspendisse nulla augue, hendrerit ac nibh eu, lobortis accumsan velit.",
			" Vivamus egestas non tellus eget porttitor, nullam malesuada mi eu.",
			" Corsus convallis nisi felis non felis - proin bibendum lorem a neque.",
			" Sodales sagittis  maecenas enim purus, vulputate vel maximus.",
			" Fusce luctus lacus et malesuada commodo maecenas dui lacus.",
			" Fringilla sed metus ut, luctus posuere tortor nullam tincidunt.",
			"\r\n Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
			"\r\n Nam cursus dui ac velit dictum, vitae blandit ligula venenatis.",
			"\r\n Maecenas vel sapien non nibh mollis aliquam maximus id dolor."};

	/**
	 * Create the application.
	 */
	public LocationMenu(JFrame frame, String category, String name) {
		this.frame = frame;
		this.max_x = frame.getWidth();
		this.max_y = frame.getHeight();
		this.category = category;
		this.name = name;
		initialize();
	}

	String[] list = {
            "img/a.jpg",//0
            "img/b.jpg",//1
            "img/c.jpg",//2
            "img/d.jpg",//3
            "img/e.jpg",//4

          };
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		
	    pic = new JLabel();
		pic.setBounds(20, 50, 500, 275);
		frame.getContentPane().add(pic);
        //Call The Function SetImageSize
        SetImageSize(4);
        
       //set a timer
        tm = new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if (x >= list.length) {
                    x = 0; 
                }
            }
        });
        
        // Starts the timer 
        tm.start();
        
		// Top Navigation pills
		new NavPills(frame, category, name);
        
        // Back button
		new NavBack(frame, category);
		
		// Description label
		JLabel lblHistoryOfThe = new JLabel("Description");
		lblHistoryOfThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHistoryOfThe.setBounds(225, 335, 165, 15);
		frame.getContentPane().add(lblHistoryOfThe);
		
		// Generate random description
		String descr = "";
		for (int i = 1; i <= 20; i++){
			int rnd = new Random().nextInt(this.description.length);
			descr += description[rnd];
		}
		
		// Description text
		JTextPane txtpnTheKelvingroveArt = new JTextPane();
		txtpnTheKelvingroveArt.setEditable(false);
		txtpnTheKelvingroveArt.setText(descr);
		txtpnTheKelvingroveArt.setBounds(20, 355, 500, 300);
		frame.getContentPane().add(txtpnTheKelvingroveArt);
		
		// Directions label
		JLabel lblDirections = new JLabel("Directions");
		lblDirections.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDirections.setBounds(max_x - 275, 50, 85, 15);
		frame.getContentPane().add(lblDirections);
		
		// Directions map
		JLabel lblNewLabel_1 = new JLabel("");
		Image eleph = new ImageIcon(this.getClass().getResource("/loc.gif")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(eleph));
		lblNewLabel_1.setBounds(max_x - 440, 80, 420, 300);
		frame.getContentPane().add(lblNewLabel_1);
		
		// Address label
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(max_x - 275, 400, 85, 15);
		frame.getContentPane().add(lblAddress);
		
		// Generate random address
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String address = "";
		int rnd = new Random().nextInt(256) + 1;
		address += rnd + " Argyle Street,\r\nGlasgow,\r\nG";
		rnd = new Random().nextInt(98) + 1;
		address += rnd + " ";
		rnd = new Random().nextInt(8) + 1;
		address += rnd;
		rnd = new Random().nextInt(alphabet.length());
		address += alphabet.charAt(rnd);
		rnd = new Random().nextInt(alphabet.length());
		address += alphabet.charAt(rnd);
		
		// Address text
		JTextPane txtpnAddress = new JTextPane();
		txtpnAddress.setEditable(false);
		txtpnAddress.setText(address);
		txtpnAddress.setBounds(max_x - 280, 420, 120, 50);
		frame.getContentPane().add(txtpnAddress);
		
		
	}
	public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }
	public JFrame getFrame() {
		return this.frame;
	}
}
