package hotel.booking.system.Panels;
import hotel.booking.system.Functions.*;
import hotel.booking.system.HotelBookingSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SideBar extends JPanel implements MouseListener {
    JPanel navPanels[] = new JPanel[4];
    JButton navBtns[] = new JButton[3];
    
    boolean[] navBtnsEnabled = {true, false, false};
    
    public SideBar() {
        // create side bar for navigation
        setPreferredSize(new Dimension(180, 180));
        setBackground(new Color(0xC4DFE6));
        setLayout(new BorderLayout());
        
        // container at the upper part of the side bar to set static size for buttons
        JPanel navContainer = new JPanel();
        navContainer.setPreferredSize(new Dimension(220, 220));
        navContainer.setLayout(new GridLayout(0, 1));
        
        JTextField searchBox = new JTextField();
        searchBox.setPreferredSize(new Dimension(150, 20));
        searchBox.setHorizontalAlignment(JTextField.CENTER);
        
        // array to store all navigation buttons top to bottom
        for (int i = 0; i < 3; i++) {
            navBtns[i] = new JButton();
            // default decoration for navigation buttons label and icon
            switch (i) {
                case  0:
                    navBtns[i].setText("Dashboard");
                    navBtns[i].setIcon(new ImageIcon("src/hotel/booking/system/Images/home-white.png"));
                    break;
                case  1:
                    navBtns[i].setText("Bookings");
                    navBtns[i].setIcon(new ImageIcon("src/hotel/booking/system/Images/plus.png"));
                    break;
                case  2:
                    navBtns[i].setText("Receipts");
                    navBtns[i].setIcon(new ImageIcon("src/hotel/booking/system/Images/dollar.png"));
                    break;
            }
            
            // navigation buttons decoration
            if (i == 0) {
                navBtns[i].setForeground(MyFonts.getQuaternaryColor());
            } else {
                navBtns[i].setForeground(MyFonts.getPrimaryColor());
            }
            navBtns[i].setFont(MyFonts.getPrimaryFont());
            navBtns[i].setBorderPainted(false);
            navBtns[i].setHorizontalAlignment(JButton.LEFT);
            navBtns[i].setMargin(new Insets(0, 15, 0, 0));
            navBtns[i].setIconTextGap(15);
            navBtns[i].addMouseListener(this);
        }
        
        // array to store navigation panels that each contains a navigation button
        for (int i = 0; i < 4; i++) {
            navPanels[i] = new JPanel();
            if (i == 0) {
                navPanels[i].setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
                navPanels[i].add(searchBox);
                navPanels[i].setBackground(MyFonts.getTertiaryColor());
            } else {
                navPanels[i].setLayout(new BorderLayout());
                navPanels[i].add(navBtns[i - 1]);
                if (i == 1) {
                    navPanels[i].setBackground(MyFonts.getPrimaryColor());
                } else {
                    navPanels[i].setBackground(MyFonts.getTertiaryColor());
                }
            }
        }
        
        // add all navigation panels (that each contains a button) into navigation container
        navContainer.add(navPanels[0]);
        navContainer.add(navPanels[1]);
        navContainer.add(navPanels[2]);
        navContainer.add(navPanels[3]);
        
        // add container that contains buttons panels at the top
        add(navContainer, BorderLayout.NORTH);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == navBtns[0] && navBtnsEnabled[0] == false) {
            navPanels[1].setBackground(MyFonts.getPrimaryHoverColor());
        } else if (e.getSource() == navBtns[1] && navBtnsEnabled[1] == false) {
            navPanels[2].setBackground(MyFonts.getPrimaryHoverColor());
        } else if (e.getSource() == navBtns[2] && navBtnsEnabled[2] == false) {
            navPanels[3].setBackground(MyFonts.getPrimaryHoverColor());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == navBtns[0] && navBtnsEnabled[0] == false) {
            navPanels[1].setBackground(MyFonts.getTertiaryColor());
        } else if (e.getSource() == navBtns[1] && navBtnsEnabled[1] == false) {
            navPanels[2].setBackground(MyFonts.getTertiaryColor());
        } else if (e.getSource() == navBtns[2] && navBtnsEnabled[2] == false) {
            navPanels[3].setBackground(MyFonts.getTertiaryColor());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (int i = 0; i < 3; i++) {
            if (e.getSource() == navBtns[i] && navBtnsEnabled[i] == false) {
                navBtnsEnabled[i] = true;
                navPanels[i + 1].setBackground(MyFonts.getPrimaryColor());
                navBtns[i].setForeground(MyFonts.getQuaternaryColor());
                if (i == 0) {
                    navBtns[i].setIcon(new ImageIcon("src/hotel/booking/system/Images/home-white.png"));
                } else if (i == 1) {
                    navBtns[i].setIcon(new ImageIcon("src/hotel/booking/system/Images/plus-white.png"));
                } else if (i == 2) {
                    navBtns[i].setIcon(new ImageIcon("src/hotel/booking/system/Images/dollar-white.png"));
                }
                HotelBookingSystem.setNav(i, 0);
            }
            if (e.getSource() != navBtns[i]) {
                navBtnsEnabled[i] = false;
                navPanels[i + 1].setBackground(MyFonts.getTertiaryColor());
                navBtns[i].setForeground(MyFonts.getPrimaryColor());
                if (i == 0) {
                    navBtns[i].setIcon(new ImageIcon("src/hotel/booking/system/Images/home.png"));
                } else if (i == 1) {
                    navBtns[i].setIcon(new ImageIcon("src/hotel/booking/system/Images/plus.png"));
                } else if (i == 2) {
                    navBtns[i].setIcon(new ImageIcon("src/hotel/booking/system/Images/dollar.png"));
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
}
