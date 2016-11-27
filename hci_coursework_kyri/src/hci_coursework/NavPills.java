package hci_coursework;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class NavPills {
	private JFrame frame;
	private String category;
	private String name;
	private Color primary = new Color (16, 146, 0);
	private Color highlight = new Color (223, 97, 12);
	private Border border = new LineBorder(Color.BLACK, 1);
	
	public NavPills(JFrame frame, String category, String name) {
		this.frame = frame;
		// Make sure null category and not null name aren't possible
		if (category == null && name != null) {
			this.category = name;
			this.name = null;
		} else {
			this.category = category;
			this.name = name;
		}
	}
	
	public void buildNavPills() {
		int home_width = 100;
		int cat_width = 150;
		int name_width = 250;
		int height = 35;
		int icon_size = 25;
		
		// Home button, highlighted
        JButton btnHome = new JButton("Home");
        try {
        	Image icon = new ImageIcon(this.getClass().getResource("/icons/Home.png")).getImage();
        	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_DEFAULT);
        	btnHome.setIcon(new ImageIcon(icon));
        } catch (Exception e) {
        	Image icon = new ImageIcon(this.getClass().getResource("/icons/Unknown.png")).getImage();
        	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_DEFAULT);
        	btnHome.setIcon(new ImageIcon(icon));
        }
        btnHome.setBounds(0, 0, home_width, height);
        btnHome.setBackground(this.highlight);
        btnHome.setForeground(Color.WHITE);
        btnHome.setBorder(border);
        btnHome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

        
        // If category exists, add it and highlight it instead of home button
        if (this.category != null) {
        	btnHome.setFont(new Font("Tahoma", Font.BOLD, 14));
        	btnHome.setBackground(this.primary);
    		btnHome.addActionListener(new ActionListener() {			
    			public void actionPerformed(ActionEvent e) {
    				MainMenu menu = new MainMenu();
    				menu.getFrame().setVisible(true);
    				NavPills.this.frame.dispose();
    			}
            });
    		
    		
    		// Category button
            JButton btnCat = new JButton(this.category);
            try {
            	Image icon = new ImageIcon(this.getClass().getResource("/icons/" + this.category + ".png")).getImage();
            	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_DEFAULT);
            	btnCat.setIcon(new ImageIcon(icon));
            } catch (Exception e) {
            	Image icon = new ImageIcon(this.getClass().getResource("/icons/Unknown.png")).getImage();
            	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_DEFAULT);
            	btnCat.setIcon(new ImageIcon(icon));
            }
            btnCat.setBounds(home_width, 0, cat_width, height);
            btnCat.setBackground(this.highlight);
            btnCat.setForeground(Color.WHITE);
            btnCat.setBorder(border);
            btnCat.setFont(new Font("Tahoma", Font.ITALIC, 14));
            
            // If name exists, add it and highlight it instead of category button
            if (this.name != null) {
            	btnCat.setFont(new Font("Tahoma", Font.PLAIN, 14));
            	btnCat.setBackground(this.primary);
            	btnCat.addActionListener(new ActionListener() {			
        			public void actionPerformed(ActionEvent e) {
        				CategoryMenu menu = new CategoryMenu(NavPills.this.category);
        				menu.getFrame().setVisible(true);
        				NavPills.this.frame.dispose();
        			}
                });
            	
                JButton btnName = new JButton(this.name);
        		//Image icon = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
                //btnName.setIcon(new ImageIcon(icon));
                btnName.setBounds(home_width + cat_width, 0, name_width, height);
                btnName.setBackground(this.highlight);
                btnName.setForeground(Color.WHITE);
                btnName.setBorder(border);
                btnName.setFont(new Font("Tahoma", Font.ITALIC, 14));
                
                this.frame.getContentPane().add(btnHome);
                this.frame.getContentPane().add(btnCat);
                this.frame.getContentPane().add(btnName);
            } else {
                this.frame.getContentPane().add(btnHome);
                this.frame.getContentPane().add(btnCat);
            }
        } else {
        	this.frame.getContentPane().add(btnHome);
        }
	}
}
