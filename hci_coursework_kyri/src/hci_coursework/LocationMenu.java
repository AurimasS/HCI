package hci_coursework;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
		pic.setBounds(20, 50, 500, 300);
		pic.setBorder(Style.BORDER_THICK);
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
		
		// Generate random description
		String descr = "";
		for (int i = 1; i <= 20; i++){
			int rnd = new Random().nextInt(this.description.length);
			descr += description[rnd];
		}
		
		// Description text
		JTextPane txtDescription = new JTextPane();
		txtDescription.setBounds(20, 350, 500, 310);
		txtDescription.setBorder(Style.BORDER_THIN_EMPTY);

		txtDescription.setEditable(false);
		txtDescription.setText(descr);
		frame.getContentPane().add(txtDescription);
		
		// Generate random address
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String address = "Address:\r\n";
		int street = new Random().nextInt(1445) + 1;
		address += street + " Argyle Street,\r\nGlasgow,\r\nG";
		int rnd = new Random().nextInt(98) + 1;
		address += rnd + " ";
		rnd = new Random().nextInt(8) + 1;
		address += rnd;
		rnd = new Random().nextInt(alphabet.length());
		address += alphabet.charAt(rnd);
		rnd = new Random().nextInt(alphabet.length());
		address += alphabet.charAt(rnd);
		
		// Directions map
		int width = 420;
		int height = 330;
		JLabel map = new JLabel("");
		map.setBounds(max_x - 440, 50, width, height);
		map.setBorder(Style.BORDER_THICK);
		try {
			String path = "https://maps.googleapis.com/maps/api/staticmap?center="
					+ street + "+Argyle+St,+Glasgow&zoom=17&size=" + width + "x" + height + "&maptype=roadmap&"
					+ "markers=color:red|" + street + "+Argyle+St,+Glasgow";
			URL url = new URL(path);
			Image image = ImageIO.read(url);
			map.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			Image image = new ImageIcon(this.getClass().getResource("/loc.gif")).getImage();
			map.setIcon(new ImageIcon(image));
		} 
		frame.getContentPane().add(map);
		
		// Address text
		JTextPane txtAddress = new JTextPane();
		txtAddress.setEditable(false);
		txtAddress.setText(address);
		txtAddress.setBackground(Style.PRIMARY);
		txtAddress.setForeground(Color.WHITE);
		txtAddress.setBorder(Style.BORDER_THICK_EMPTY);
		txtAddress.setFont(Style.BOLD);
		txtAddress.setBounds(max_x - 320, 400, 170, 80);
		frame.getContentPane().add(txtAddress);
		
		
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
