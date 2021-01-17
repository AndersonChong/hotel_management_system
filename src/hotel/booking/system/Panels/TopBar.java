package hotel.booking.system.Panels;
import hotel.booking.system.Functions.MyFonts;
import hotel.booking.system.HotelBookingSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TopBar extends JPanel implements MouseListener {
    String lala = "HACKER";
    
    public TopBar(String name) {
        this.lala = name;
        
        // create top bar for username and logout button
        setLayout(new FlowLayout(FlowLayout.TRAILING, 15, -3));
        setPreferredSize(new Dimension(23, 23));
        setBackground(MyFonts.getPrimaryColor());
        
        // create label for username
        JLabel username = new JLabel(lala);
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
        logoutBtn.addMouseListener(this);
        
        add(username);
        add(logoutBtn);
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "Confirm log out?", "System Notification", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            HotelBookingSystem.loggedOut();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    
    }
}
