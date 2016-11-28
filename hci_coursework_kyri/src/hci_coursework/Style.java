package hci_coursework;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Style {
	public static final Color PRIMARY = (new Color (16, 146, 0));
	public static final Color HIGHLIGHT = new Color (223, 97, 12);
	public static final Color INACTIVE = new Color (148, 148, 148);
	
	public static final Border BORDER_LIGHT = new LineBorder(Color.BLACK, 1);
	
	public static final Font BOLD_ITALIC = new Font("Tahoma", Font.BOLD | Font.ITALIC, 14);
	public static final Font BOLD = new Font("Tahoma", Font.BOLD, 14);
	public static final Font ITALIC = new Font("Tahoma", Font.ITALIC, 14);
	public static final Font PLAIN = new Font("Tahoma", Font.PLAIN | Font.ITALIC, 14);
}
