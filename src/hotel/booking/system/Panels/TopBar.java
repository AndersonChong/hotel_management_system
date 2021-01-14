package hotel.booking.system.Panels;
import hotel.booking.system.Functions.MyFonts;
import java.awt.*;
import javax.swing.*;

public class TopBar extends JPanel {
    public TopBar() {
        // create top bar for username and logout button
        setLayout(new FlowLayout(FlowLayout.TRAILING, 15, -3));
        setPreferredSize(new Dimension(23, 23));
        setBackground(MyFonts.getPrimaryColor());
        
        // create label for username
        JLabel username = new JLabel("ANDERSON");
        username.setFont(MyFonts.getSecondaryFont());
        username.setForeground(MyFonts.getQuaternaryColor());

        // create logout button
        // button decoration
        JButton logoutBtn = new JButton("LOG OUT");
        logoutBtn.setFont(MyFonts.getSecondaryFont());
        logoutBtn.setBackground(MyFonts.getPrimaryColor());
        logoutBtn.setForeground(MyFonts.getQuaternaryColor());
        logoutBtn.setOpaque(true);
        logoutBtn.setBorderPainted(false);
        // button functionality
        logoutBtn.addActionListener(e -> System.out.println("Logout Button Pressed"));
        
        add(username);
        add(logoutBtn);
    }
}
