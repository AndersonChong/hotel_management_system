package hotel.booking.system.Panels;
import hotel.booking.system.HotelBookingSystem;
import hotel.booking.system.Functions.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JPanel implements MouseListener {
    static JLabel email = new JLabel("Email: ");
    static JTextField emailTF = new JTextField("", 16);
    static JPasswordField passTF = new JPasswordField("", 16);
    static JLabel pass = new JLabel("Password: ");
    static JButton loginBtn = new JButton("Login");
    static JPanel loginBtnContainer = new JPanel();
    
    public Login() {
        // login panel
        email.setBorder(new EmptyBorder(0, 0, 0, 23));
        
        JPanel emailFieldPanel = new JPanel();
        emailFieldPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        JPanel passFieldPanel = new JPanel();
        passFieldPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        JPanel btnFieldPanel = new JPanel();
        
        email.setForeground(MyFonts.getPrimaryColor());
        pass.setForeground(MyFonts.getPrimaryColor());
        
        // decoration for save button
        loginBtn.setBorderPainted(false);
        loginBtn.setForeground(MyFonts.getQuaternaryColor());
        loginBtn.addMouseListener(this);
        // container to create custom decoration for search button
        loginBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        loginBtnContainer.add(loginBtn);
        loginBtnContainer.setBackground(MyFonts.getPrimaryColor());
        
        emailFieldPanel.add(email);
        emailFieldPanel.add(emailTF);
//        emailFieldPanel.setBackground(MyFonts.getSecondaryColor());
        passFieldPanel.add(pass);
        passFieldPanel.add(passTF);
//        passFieldPanel.setBackground(MyFonts.getSecondaryColor());
        btnFieldPanel.add(loginBtnContainer);
//        btnFieldPanel.setBackground(MyFonts.getSecondaryColor());
        
        setLayout(new GridLayout(3, 1));
        setBounds(260, 215, 315, 130);
        add(emailFieldPanel);
        add(passFieldPanel);
        add(btnFieldPanel);
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == loginBtn) {
            loginBtnContainer.setBackground(MyFonts.getSecondaryHoverColor());
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == loginBtn) {
            loginBtnContainer.setBackground(MyFonts.getPrimaryColor());
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == loginBtn) {
            if (emailTF.getText().isEmpty() || passTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please filled all required fields", "System Notification", JOptionPane.PLAIN_MESSAGE);
            } else  {
                Users.login(emailTF.getText(), passTF.getText());
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    
    }
}
