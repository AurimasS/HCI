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
import javax.swing.Timer;
import javax.swing.JTextArea;

public class KelvingroveMuseum {
    JLabel pic;
    Timer tm;
    int x = 0;
	private JFrame frame;
	private MainMenu main;
	private MuseumList museumlist;
	private Mgallery mgallery;

	/**
	 * Create the application.
	 */
	public KelvingroveMuseum(MuseumList museumlist) {
		this.museumlist = museumlist;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	    pic = new JLabel();
		pic.setBounds(35, 201, 262, 78);
		frame.getContentPane().add(pic);
        //Call The Function SetImageSize
        SetImageSize(4);
        
        
       //set a timer
        tm = new Timer(1000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
       // Starts the timer 
       tm.start();
        
        JButton btnBack = new JButton("Back");
		Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		btnBack.setIcon(new ImageIcon(back));
		frame.getContentPane().add(btnBack);
        btnBack.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				KelvingroveMuseum.this.getFrame().setVisible(false);
			}	
        });
		btnBack.setBounds(143, 290, 91, 33);
		frame.getContentPane().add(btnBack);
        
        
		JLabel lblNewLabel = new JLabel("Home > Museums > Kelvingrove Museum");
		Image museum = new ImageIcon(this.getClass().getResource("/Museums.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(museum));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 344, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblHistoryOfThe = new JLabel("History of the Museum");
		lblHistoryOfThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHistoryOfThe.setBounds(86, 55, 167, 14);
		frame.getContentPane().add(lblHistoryOfThe);
		
		JTextPane txtpnTheKelvingroveArt = new JTextPane();
		txtpnTheKelvingroveArt.setEditable(false);
		txtpnTheKelvingroveArt.setText("The Kelvingrove Art Gallery and Museum is a museum and art gallery in Glasgow, Scotland. It reopened in 2006 after a three-year refurbishment and since then has been one of Scotland's most popular visitor attractions.");
		txtpnTheKelvingroveArt.setBounds(32, 80, 265, 86);
		frame.getContentPane().add(txtpnTheKelvingroveArt);
	//	Image kelv = new ImageIcon(this.getClass().getResource("/kelv.jpg")).getImage();
	//	Image kelv1 = new ImageIcon(this.getClass().getResource("/kelv1.jpg")).getImage();
		
		JButton btnHome = new JButton("Home");  
		Image img = new ImageIcon(this.getClass().getResource("/Homes.png")).getImage();
		btnHome.setIcon(new ImageIcon(img));
		btnHome.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				KelvingroveMuseum.this.main= new MainMenu();
				KelvingroveMuseum.this.main.getFrame().setVisible(true);
			
			}	
        });
		btnHome.setBounds(32, 290, 105, 33);
		frame.getContentPane().add(btnHome);
		
		JLabel lblGallery = new JLabel("Gallery");
		lblGallery.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGallery.setBounds(142, 177, 60, 14);
		frame.getContentPane().add(lblGallery);
		
		JLabel lblDirections = new JLabel("Directions");
		lblDirections.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDirections.setBounds(424, 55, 85, 14);
		frame.getContentPane().add(lblDirections);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image eleph = new ImageIcon(this.getClass().getResource("/loc.gif")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(eleph));
		lblNewLabel_1.setBounds(326, 80, 262, 121);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane txtpnAddressArgyleSt = new JTextPane();
		txtpnAddressArgyleSt.setEditable(false);
		txtpnAddressArgyleSt.setText("Address: Argyle St, Glasgow G3 8AG ");
		txtpnAddressArgyleSt.setBounds(326, 233, 262, 46);
		frame.getContentPane().add(txtpnAddressArgyleSt);
		
		
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
