package glasgow_guide;
/* 
 * Class containing global variables that dictate the style of the application
 */
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Style {
	public static final Color PRIMARY = (new Color (16, 146, 0));
	public static final Color HIGHLIGHT = new Color (223, 97, 12);
	public static final Color INACTIVE = new Color (148, 148, 148);
	
	public static final Border BORDER_THIN = new LineBorder(Color.BLACK, 1);
	public static final Border BORDER_THICK = new LineBorder(Color.BLACK, 3);
	public static final Border BORDER_EMPTY = new EmptyBorder(5, 5, 5, 5);
	public static final CompoundBorder BORDER_THIN_EMPTY = new CompoundBorder(BORDER_THIN, BORDER_EMPTY);
	public static final CompoundBorder BORDER_THICK_EMPTY = new CompoundBorder(BORDER_THICK, BORDER_EMPTY);
	
	public static final Font BOLD_ITALIC = new Font("Tahoma", Font.BOLD | Font.ITALIC, 14);
	public static final Font BOLD = new Font("Tahoma", Font.BOLD, 14);
	public static final Font ITALIC = new Font("Tahoma", Font.ITALIC, 14);
	public static final Font PLAIN = new Font("Tahoma", Font.PLAIN | Font.ITALIC, 14);
}
