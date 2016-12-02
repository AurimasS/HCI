package glasgow_guide;
/* 
 * Class that puts a back button at the bottom of a given frame
 * Link depends on the arguments, used in all menu classes
 */
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
	private int start;
	
	private int max_y;

	public NavBack(JFrame frame) {
		this(frame, null, 0);
	}
	
	public NavBack(JFrame frame, String category) {
		this(frame, category, 0);
	}
	
	public NavBack(JFrame frame, String category, int start) {
		this.frame = frame;
		this.max_y = frame.getHeight();
		this.category = category;
		this.start = start;
		buildButton();
	}
	
	private void buildButton() {
		int width = 100;
		int height = 35;
		int icon_size = 25;
		
		//Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(20, max_y - 55, width, height);
        Image icon = new ImageIcon(this.getClass().getResource("/images/icons/Back.png")).getImage();
        icon = icon.getScaledInstance(icon_size, icon_size, Image.SCALE_SMOOTH);
        btnBack.setIcon(new ImageIcon(icon));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBorder(Style.BORDER_THIN);
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
						new CategoryMenu(frame, category, start);
					}
				}	
	        });
		}
		frame.getContentPane().add(btnBack);
	}
}
