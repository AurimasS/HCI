package glasgow_guide;
/* 
 * Class puts a navigation bar on top of a given frame
 * Used by all menu classes
 */
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NavPills {
	private JFrame frame;
	private String category;
	private String name;
	private int start;
	private int max_x;
	
	public NavPills(JFrame frame) {
		this(frame, null, null, 0);
	}
	
	public NavPills(JFrame frame, String category) {
		this(frame, category, null, 0);
	}
	
	public NavPills(JFrame frame, String category, String name) {
		this(frame, category, name, 0);
	}
	
	public NavPills(JFrame frame, String category, String name, int start) {
		this.frame = frame;
		this.max_x = frame.getWidth();
		// Make sure null category and not null name aren't possible
		if (category == null && name != null) {
			this.category = name;
			this.name = null;
		} else {
			this.category = category;
			this.name = name;
		}
		this.start = start;
		buildNavPills();
	}
	
	private void buildNavPills() {
		int home_width = 100;
		int cat_width = 150;
		int name_width = 250;
		int height = 35;
		int icon_size = 25;
		
		// Home button, highlighted
        JButton btnHome = new JButton("Home");
        try {
        	Image icon = new ImageIcon(this.getClass().getResource("/images/icons/Home.png")).getImage();
        	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_SMOOTH);
        	btnHome.setIcon(new ImageIcon(icon));
        } catch (Exception e) {
        	Image icon = new ImageIcon(this.getClass().getResource("/images/icons/Unknown.png")).getImage();
        	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_SMOOTH);
        	btnHome.setIcon(new ImageIcon(icon));
        }
        btnHome.setBounds(0, 0, home_width, height);
        btnHome.setBackground(Style.HIGHLIGHT);
        btnHome.setForeground(Color.WHITE);
        btnHome.setBorder(Style.BORDER_THIN);
        btnHome.setFont(Style.BOLD_ITALIC);

        
        // If category exists, add it and highlight it instead of home button
        if (this.category != null) {
        	btnHome.setFont(Style.BOLD);
        	btnHome.setBackground(Style.PRIMARY);
    		btnHome.addActionListener(new ActionListener() {			
    			public void actionPerformed(ActionEvent e) {
    				@SuppressWarnings("unused")
					MainMenu menu = new MainMenu(frame);
    			}
            });
    		
    		
    		// Category button
            JButton btnCat = new JButton(this.category);
            try {
            	Image icon = new ImageIcon(this.getClass().getResource("/images/icons/" + this.category + ".png")).getImage();
            	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_SMOOTH);
            	btnCat.setIcon(new ImageIcon(icon));
            } catch (Exception e) {
            	Image icon = new ImageIcon(this.getClass().getResource("/images/icons/Unknown.png")).getImage();
            	icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_SMOOTH);
            	btnCat.setIcon(new ImageIcon(icon));
            }
            btnCat.setBounds(home_width, 0, cat_width, height);
            btnCat.setBackground(Style.HIGHLIGHT);
            btnCat.setForeground(Color.WHITE);
            btnCat.setBorder(Style.BORDER_THIN);
            btnCat.setFont(Style.ITALIC);
            
            // If name exists, add it and highlight it instead of category button
            if (this.name != null) {
            	btnCat.setFont(Style.PLAIN);
            	btnCat.setBackground(Style.PRIMARY);
            	btnCat.addActionListener(new ActionListener() {			
        			public void actionPerformed(ActionEvent e) {
        				@SuppressWarnings("unused")
						CategoryMenu menu = new CategoryMenu(frame, category, start);
        			}
                });
            	
                JButton btnName = new JButton(this.name);
                btnName.setBounds(home_width + cat_width, 0, name_width, height);
                btnName.setBackground(Style.HIGHLIGHT);
                btnName.setForeground(Color.WHITE);
                btnName.setBorder(Style.BORDER_THIN);
                btnName.setFont(Style.ITALIC);
                
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
        
		// Help button
		JButton btnHelp = new JButton("Help");
		Image help = new ImageIcon(this.getClass().getResource("/images/icons/Unknown.png")).getImage();
		help = help.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btnHelp.setIcon(new ImageIcon(help));
		btnHelp.setBackground(Style.PRIMARY);
		btnHelp.setBorder(Style.BORDER_THIN);
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setFont(Style.BOLD);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JOptionPane.showMessageDialog(null, "Welcome to Glasgow, Please choose one of the options below");
			}
		});
		btnHelp.setBounds(max_x - 80, 0, 80, 35);
		frame.getContentPane().add(btnHelp);
	}
}
