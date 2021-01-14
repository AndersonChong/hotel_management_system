package hotel.booking.system.Functions;
import java.awt.*;

public class MyFonts {
    // custom colors
    static Color primaryColor = new Color(0x07575B);
    static Color secondaryColor = new Color(0xC4DFE6);
    static Color tertiaryColor = new Color(0xFFFFFF);
    
    // custom fonts
    static Font primaryFont = new Font("Roboto", Font.PLAIN, 12);
    static Font secondaryFont = new Font("Roboto", Font.PLAIN, 11);
    static Font header1 = new Font("PT Mono", Font.PLAIN, 36);
    static Font header2 = new Font("PT Mono", Font.PLAIN, 24);
    
    // getters custom colors
    public static Color getPrimaryColor() {
        return primaryColor;
    }
    
    public static Color getSecondaryColor() {
        return secondaryColor;
    }
    
    public static Color getTertiaryColor() {
        return tertiaryColor;
    }
    
    public static Font getPrimaryFont() {
        return primaryFont;
    }
    
    // getters for custom fonts
    public static Font getSecondaryFont() {
        return secondaryFont;
    }
    
    public static Font getHeader1() {
        return header1;
    }
    
    public static Font getHeader2() {
        return header2;
    }
}
