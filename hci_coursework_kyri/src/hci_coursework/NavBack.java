package hci_coursework;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class NavBack {
	private JFrame frame;
	private String category;
	
	private int max_y;
	
	public NavBack(JFrame frame, String category) {
		this.frame = frame;
		this.max_y = frame.getHeight();
		this.category = category;
		buildButton();
	}
	
	private void buildButton() {
		int width = 100;
		int height = 35;
		int icon_size = 25;
		
		//Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(20, max_y - 55, width, height);
        try {
        	Image icon = new ImageIcon(this.getClass().getResource("/icons/Back.png")).getImage();
        	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_SMOOTH);
        	btnBack.setIcon(new ImageIcon(icon));
        } catch (Exception e) {
        	Image icon = new ImageIcon(this.getClass().getResource("/icons/Unknown.png")).getImage();
        	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_SMOOTH);
        	btnBack.setIcon(new ImageIcon(icon));
        }
		btnBack.setForeground(Color.WHITE);
		btnBack.setBorder(Style.BORDER_LIGHT);
		btnBack.setFont(Style.BOLD);
		
		if (category == null) {
			btnBack.setBackground(Style.INACTIVE);
		} else {
			btnBack.setBackground(Style.PRIMARY);
	        btnBack.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					if (category == "Home") {
						new MainMenu(frame);
					} else {
						new CategoryMenu(frame, category);
					}
				}	
	        });
		}
		frame.getContentPane().add(btnBack);
	}
}
