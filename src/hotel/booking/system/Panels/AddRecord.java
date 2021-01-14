package hotel.booking.system.Panels;
import hotel.booking.system.Functions.MyFonts;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class AddRecord extends JPanel {
    JLabel startDate = new JLabel("Start Date:");
    JLabel endDate = new JLabel("End Date:");
    JLabel name = new JLabel("Name:");
    JLabel ICPass = new JLabel("IC/Pass:");
    JLabel contact = new JLabel("Contact:");
    JLabel email = new JLabel("Email:");
    
    JTextField startDateTF = new JTextField("", 16);
    JTextField endDateTF = new JTextField("", 16);
    JTextField nameTF = new JTextField("", 16);
    JTextField ICPassTF = new JTextField("", 16);
    JTextField contactTF = new JTextField("", 16);
    JTextField emailTF = new JTextField("", 16);
    
    JButton searchBtn = new JButton("Search");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    
    JPanel searchBtnContainer = new JPanel();
    JPanel saveBtnContainer = new JPanel();
    JPanel resetBtnContainer = new JPanel();
    
    JPanel panels[] = new JPanel[11];
    JRadioButton[] radioBtns = new JRadioButton[20];
    ButtonGroup roomBtns = new ButtonGroup();
    
    public AddRecord() {
        // set border layout for dashboard panel
        setLayout(new BorderLayout(0, 30));
        setBorder(new EmptyBorder(30, 30, 30, 30));
        
        // head panel for date selection and display
        JPanel headPanel = new JPanel();
        headPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        headPanel.setPreferredSize(new Dimension(24, 24));
        
        // label for month display
        JLabel month = new JLabel();
        month.setText("ADD RECORD");
        month.setFont(MyFonts.getHeader2());
        month.setForeground(MyFonts.getPrimaryColor());
        
        headPanel.add(month);
        
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(null);
        JPanel mainContext = new JPanel();
        mainContext.setLayout(new GridLayout(11, 1));
        mainContext.setBounds(0, 0, 560, 435);
        
        for (int i = 0; i < 20; i++) {
            radioBtns[i] = new JRadioButton();
            radioBtns[i].setText(String.valueOf(i));
        }
        
        for (int i = 0; i < 11; i++) {
            panels[i] = new JPanel();
            mainContext.add(panels[i]);
            
            switch (i) {
                case 0:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    startDate.setBorder(new EmptyBorder(0, 0, 0, 10));
                    panels[i].add(startDate);
                    panels[i].add(startDateTF);
                    break;
                case 1:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    endDate.setBorder(new EmptyBorder(0, 0, 0, 16));
                    searchBtn.setBorderPainted(false);
                    searchBtn.setForeground(MyFonts.getTertiaryColor());
                    searchBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    searchBtnContainer.add(searchBtn);
                    searchBtnContainer.setBackground(MyFonts.getPrimaryColor());
                    panels[i].add(endDate);
                    panels[i].add(endDateTF);
                    panels[i].add(searchBtnContainer);
                    break;
                case 2:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, -5, 5));
                    for (int j = 0; j < 5; j++) {
                        roomBtns.add(radioBtns[j]);
                        panels[i].add(radioBtns[j]);
                    }
                    break;
                case 3:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, -5, 5));
                    for (int j = 5; j < 10; j++) {
                        roomBtns.add(radioBtns[j]);
                        panels[i].add(radioBtns[j]);
                    }
                    break;
                case 4:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, -5, 5));
                    for (int j = 10; j < 15; j++) {
                        roomBtns.add(radioBtns[j]);
                        panels[i].add(radioBtns[j]);
                    }
                    break;
                case 5:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, -5, 5));
                    for (int j = 15; j < 20; j++) {
                        roomBtns.add(radioBtns[j]);
                        panels[i].add(radioBtns[j]);
                    }
                    break;
                case 6:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    name.setBorder(new EmptyBorder(0, 0, 0, 38));
                    panels[i].add(name);
                    panels[i].add(nameTF);
                    break;
                case 7:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    ICPass.setBorder(new EmptyBorder(0, 0, 0, 26));
                    panels[i].add(ICPass);
                    panels[i].add(ICPassTF);
                    break;
                case 8:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    contact.setBorder(new EmptyBorder(0, 0, 0, 26));
                    panels[i].add(contact);
                    panels[i].add(contactTF);
                    break;
                case 9:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    email.setBorder(new EmptyBorder(0, 0, 0, 41));
                    panels[i].add(email);
                    panels[i].add(emailTF);
                    break;
                case 10:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    saveBtn.setBorderPainted(false);
                    saveBtn.setForeground(MyFonts.getTertiaryColor());
                    saveBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    saveBtnContainer.add(saveBtn);
                    saveBtnContainer.setBackground(MyFonts.getPrimaryColor());
                    
                    resetBtn.setBorderPainted(false);
                    resetBtn.setForeground(MyFonts.getTertiaryColor());
                    resetBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    resetBtnContainer.add(resetBtn);
                    resetBtnContainer.setBackground(MyFonts.getPrimaryColor());
                    
                    panels[i].add(saveBtnContainer);
                    panels[i].add(resetBtnContainer);
            }
        }
        
        mainContainer.add(mainContext);
        
        add(headPanel, BorderLayout.NORTH);
        add(mainContainer, BorderLayout.CENTER);
    }
}
