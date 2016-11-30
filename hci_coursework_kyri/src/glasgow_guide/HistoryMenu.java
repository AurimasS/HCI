package glasgow_guide;
/* 
 * Class that implements the History Menu functionality
 */
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class HistoryMenu {
	private JFrame frame;
	private int max_x;
	private int max_y;
	
	private static final String textLeftPicture = LocationDatabase.generateRandomDescription(5);
	private static final String textRightPicture = LocationDatabase.generateRandomDescription(5);
	private static final String textLeft = LocationDatabase.generateRandomDescription(25);
	private static final String textRight = LocationDatabase.generateRandomDescription(25);

	private Image unknown = new ImageIcon(this.getClass().getResource("/images/other/Unknown.jpg")).getImage();
	
	public HistoryMenu(JFrame frame) {
		this.frame = frame;
		this.max_x = frame.getWidth();
		this.max_y = frame.getHeight();
		initialize();
	}

	private void initialize() {
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		
		// Top Navigation pills
		new NavPills(frame, "History");
		
		// Left text panel
		int x = 20;
		int y = 50;
		int margin_bottom = 150;
		int panel_width = max_x / 2 - 2 * x;
		int panel_height = max_y - margin_bottom;
		JLabel txtPanelLeft = new JLabel();
		txtPanelLeft.setBounds(x, y, panel_width, panel_height);
		txtPanelLeft.setBorder(Style.BORDER_THIN_EMPTY);
		txtPanelLeft.setBackground(Color.WHITE);
		txtPanelLeft.setOpaque(true);
		
		// Right text panel
		JLabel txtPanelRight = new JLabel();
		txtPanelRight.setBounds(max_x - x - panel_width, y, panel_width, panel_height);
		txtPanelRight.setBorder(Style.BORDER_THIN_EMPTY);
		txtPanelRight.setBackground(Color.WHITE);
		txtPanelRight.setOpaque(true);
		
		// Picture on the left panel
		int width = 280;
		int height = 210;
	    JLabel pic_left = new JLabel();
		pic_left.setBounds(txtPanelLeft.getBounds().x, txtPanelLeft.getBounds().y, width, height);
		pic_left.setBorder(Style.BORDER_THIN);
		pic_left.setOpaque(true);
		try {
			Image i = new ImageIcon(this.getClass().getResource("/images/history/0.jpg")).getImage();
			i = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			pic_left.setIcon(new ImageIcon(i));
		} catch (Exception e) {
			Image i = unknown.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			pic_left.setIcon(new ImageIcon(i));
		} 
		
		// Picture on the right panel
	    JLabel pic_rigth = new JLabel();
		pic_rigth.setBounds(txtPanelRight.getBounds().x + panel_width - width,
				max_y + txtPanelRight.getBounds().y - margin_bottom - height, width, height);
		pic_rigth.setBorder(Style.BORDER_THIN);
		try {
			Image i = new ImageIcon(this.getClass().getResource("/images/history/1.jpg")).getImage();
			i = i.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			pic_rigth.setIcon(new ImageIcon(i));
		} catch (Exception e) {
			Image i = unknown.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			pic_rigth.setIcon(new ImageIcon(i));
		}
		
		// Text next to the left picture
		JTextPane txtLeftPicture = new JTextPane();
		txtLeftPicture.setBounds(txtPanelLeft.getBounds().x + width, txtPanelLeft.getBounds().y,
				panel_width - width, height);
		txtLeftPicture.setBorder(Style.BORDER_EMPTY);
		txtLeftPicture.setOpaque(false);
		txtLeftPicture.setEditable(false);
		txtLeftPicture.setText(textLeftPicture);
		
		// Text below the left picture
		JTextPane txtLeft = new JTextPane();
		txtLeft.setBounds(txtPanelLeft.getBounds().x, txtPanelLeft.getBounds().y + height,
				panel_width, panel_height - height);
		txtLeft.setBorder(Style.BORDER_EMPTY);
		txtLeft.setOpaque(false);
		txtLeft.setEditable(false);
		txtLeft.setText(textLeft);
		
		// Text above the right picture
		JTextPane txtRight = new JTextPane();
		txtRight.setBounds(txtPanelRight.getBounds().x, txtPanelRight.getBounds().y,
				panel_width, panel_height - height);
		txtRight.setBorder(Style.BORDER_EMPTY);
		txtRight.setOpaque(false);
		txtRight.setEditable(false);
		txtRight.setText(textRight);
		
		// Text next to the right picture
		JTextPane txtRightPicture = new JTextPane();
		txtRightPicture.setBounds(txtPanelRight.getBounds().x,
				txtPanelRight.getBounds().y + panel_height - height,
				panel_width - width, height);
		txtRightPicture.setBorder(Style.BORDER_EMPTY);
		txtRightPicture.setOpaque(false);
		txtRightPicture.setEditable(false);
		txtRightPicture.setText(textRightPicture);
		
		// Add all components to the frame (order is important)
		frame.getContentPane().add(pic_left);
		frame.getContentPane().add(pic_rigth);
		frame.getContentPane().add(txtLeft);
		frame.getContentPane().add(txtLeftPicture);
		frame.getContentPane().add(txtRightPicture);
		frame.getContentPane().add(txtRight);
		frame.getContentPane().add(txtPanelLeft);	
		frame.getContentPane().add(txtPanelRight);
		
		// Back button
		new NavBack(frame, "Home");
		
	}
}
