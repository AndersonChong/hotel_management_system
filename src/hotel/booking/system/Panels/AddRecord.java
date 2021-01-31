package hotel.booking.system.Panels;
import hotel.booking.system.Functions.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import javax.swing.border.EmptyBorder;

public class AddRecord extends JPanel implements MouseListener {
    JLabel startDate = new JLabel("Start Date:");
    JLabel endDate = new JLabel("End Date:");
    JLabel name = new JLabel("Name:");
    JLabel ICPass = new JLabel("IC/Pass:");
    JLabel contact = new JLabel("Contact:");
    JLabel email = new JLabel("Email:");
    
    JSpinner startdateSpinner = new JSpinner(new SpinnerDateModel());
    JSpinner endDateSpinner = new JSpinner(new SpinnerDateModel());
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
        
        nameTF.setEnabled(false);
        ICPassTF.setEnabled(false);
        contactTF.setEnabled(false);
        emailTF.setEnabled(false);
        
        for (int i = 0; i < 20; i++) {
            radioBtns[i] = new JRadioButton();
            radioBtns[i].setText(Rooms.getList()[i]);
            radioBtns[i].setEnabled(false);
            radioBtns[i].addMouseListener(this);
        }
        
        for (int i = 0; i < 11; i++) {
            panels[i] = new JPanel();
            mainContext.add(panels[i]);
            
            switch (i) {
                case 0:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for start date label
                    startDate.setBorder(new EmptyBorder(0, 0, 0, 10));
                    
                    JSpinner.DateEditor startDateEditor = new JSpinner.DateEditor(startdateSpinner, "yyyy/MM/dd");
                    startdateSpinner.setEditor(startDateEditor);
                    startdateSpinner.setPreferredSize(new Dimension(218, 24));
                    startdateSpinner.setValue(Records.getStartTime()); // will only show the current time
                    
                    panels[i].add(startDate);
                    panels[i].add(startdateSpinner);
                    break;
                case 1:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for end date label
                    endDate.setBorder(new EmptyBorder(0, 0, 0, 16));
                    
                    JSpinner.DateEditor endDateEditor = new JSpinner.DateEditor(endDateSpinner, "yyyy/MM/dd");
                    endDateSpinner.setEditor(endDateEditor);
                    endDateSpinner.setPreferredSize(new Dimension(218, 24));
                    endDateSpinner.setValue(Records.getEndTime()); // will only show the current time
                    
                    // decoration for search button
                    searchBtn.setBorderPainted(false);
                    searchBtn.setForeground(MyFonts.getQuaternaryColor());
                    searchBtn.addMouseListener(this);
                    // container to create custom decoration for search button
                    searchBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    searchBtnContainer.add(searchBtn);
                    searchBtnContainer.setBackground(MyFonts.getPrimaryColor());
                    
                    // container that act as a left margin
                    JPanel searchMarginContainer = new JPanel();
                    searchMarginContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    searchMarginContainer.add(searchBtnContainer);
                    searchMarginContainer.setBorder(new EmptyBorder(0, 30, 0, 0));
                    
                    panels[i].add(endDate);
                    panels[i].add(endDateSpinner);
                    panels[i].add(searchMarginContainer);
                    break;
                case 2:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, -5, 5));
                    
                    // display first 5 room selections
                    for (int j = 0; j < 5; j++) {
                        roomBtns.add(radioBtns[j]);
                        panels[i].add(radioBtns[j]);
                    }
                    break;
                case 3:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, -5, 5));
                    
                    // display next 5 room selections
                    for (int j = 5; j < 10; j++) {
                        roomBtns.add(radioBtns[j]);
                        panels[i].add(radioBtns[j]);
                    }
                    break;
                case 4:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, -5, 5));
                    
                    // display next 5 room selections
                    for (int j = 10; j < 15; j++) {
                        roomBtns.add(radioBtns[j]);
                        panels[i].add(radioBtns[j]);
                    }
                    break;
                case 5:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, -5, 5));
                    
                    // display last 5 room selections
                    for (int j = 15; j < 20; j++) {
                        roomBtns.add(radioBtns[j]);
                        panels[i].add(radioBtns[j]);
                    }
                    break;
                case 6:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for name label and text field
                    name.setBorder(new EmptyBorder(0, 0, 0, 38));
                    panels[i].add(name);
                    panels[i].add(nameTF);
                    break;
                case 7:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for ic label and text field
                    ICPass.setBorder(new EmptyBorder(0, 0, 0, 26));
                    panels[i].add(ICPass);
                    panels[i].add(ICPassTF);
                    break;
                case 8:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for contac label and text field
                    contact.setBorder(new EmptyBorder(0, 0, 0, 26));
                    panels[i].add(contact);
                    panels[i].add(contactTF);
                    break;
                case 9:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for email label and text field
                    email.setBorder(new EmptyBorder(0, 0, 0, 41));
                    panels[i].add(email);
                    panels[i].add(emailTF);
                    break;
                case 10:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for save button
                    saveBtn.setBorderPainted(false);
                    saveBtn.setForeground(MyFonts.getQuaternaryColor());
                    saveBtn.addMouseListener(this);
                    // container to create custom decoration for search button
                    saveBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    saveBtnContainer.add(saveBtn);
                    saveBtnContainer.setBackground(MyFonts.getPrimaryColor());
                    
                    // decoration for reset button
                    resetBtn.setBorderPainted(false);
                    resetBtn.setForeground(MyFonts.getQuaternaryColor());
                    resetBtn.addMouseListener(this);
                    // container to create custom decoration for reset button
                    resetBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    resetBtnContainer.add(resetBtn);
                    resetBtnContainer.setBackground(MyFonts.getPrimaryColor());
                    
                    // container that act as a left margin
                    JPanel resetMarginContainer = new JPanel();
                    resetMarginContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    resetMarginContainer.add(resetBtnContainer);
                    resetMarginContainer.setBorder(new EmptyBorder(0, 30, 0, 0));
                    
                    panels[i].add(saveBtnContainer);
                    panels[i].add(resetMarginContainer);
            }
        }
        
        mainContainer.add(mainContext);
        
        add(headPanel, BorderLayout.NORTH);
        add(mainContainer, BorderLayout.CENTER);
    }
    
    public void reset() {
        startdateSpinner.setValue(Records.getStartTime());
        endDateSpinner.setValue(Records.getEndTime());
        nameTF.setText("");
        ICPassTF.setText("");
        contactTF.setText("");
        emailTF.setText("");
        roomBtns.clearSelection();
        for(int i = 0; i < radioBtns.length; i++) {
            radioBtns[i].setEnabled(false);
        }
        startdateSpinner.setEnabled(true);
        endDateSpinner.setEnabled(true);
        searchBtn.setEnabled(true);
        nameTF.setEnabled(false);
        ICPassTF.setEnabled(false);
        contactTF.setEnabled(false);
        emailTF.setEnabled(false);
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == searchBtn) {
            searchBtnContainer.setBackground(MyFonts.getSecondaryHoverColor());
        } else if (e.getSource() == saveBtn) {
            saveBtnContainer.setBackground(MyFonts.getSecondaryHoverColor());
        } else if (e.getSource() == resetBtn) {
            resetBtnContainer.setBackground(MyFonts.getSecondaryHoverColor());
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == searchBtn) {
            searchBtnContainer.setBackground(MyFonts.getPrimaryColor());
        } else if (e.getSource() == saveBtn) {
            saveBtnContainer.setBackground(MyFonts.getPrimaryColor());
        } else if (e.getSource() == resetBtn) {
            resetBtnContainer.setBackground(MyFonts.getPrimaryColor());
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == searchBtn && searchBtn.isEnabled()) {
            searchRoom();
        } else if (e.getSource() == saveBtn) {
            addRecord();
        } else if (e.getSource() == resetBtn) {
            reset();
        }
        
        for (JRadioButton radioBtn : radioBtns) {
            if (e.getSource() == radioBtn && radioBtn.isEnabled()) {
                nameTF.setEnabled(true);
                ICPassTF.setEnabled(true);
                contactTF.setEnabled(true);
                emailTF.setEnabled(true);
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    
    }
    
    public void searchRoom() {
        Date startDate = (Date) startdateSpinner.getValue();
        Date endDate = (Date) endDateSpinner.getValue();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            startDate = format.parse(format.format(startDate));
            endDate = format.parse(format.format(endDate));
        } catch (Exception e) {
            System.out.println("Unable to parse date");
        }
        
        
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String startDateYear = yearFormat.format(startDate);
        String endDateYear = yearFormat.format(endDate);
        
        System.out.println(startDate);
        System.out.println(endDate);
        
        if (startDate.after(endDate) || endDate.before(startDate) || startDate.equals(endDate)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid date", "System Notification", JOptionPane.PLAIN_MESSAGE);
        } else if (!startDateYear.equals("2021") || !endDateYear.equals("2021")) {
            JOptionPane.showMessageDialog(null, "Record outside of year 2021 is not available", "System Notification", JOptionPane.PLAIN_MESSAGE);
        } else {
            String availableRooms[] = Records.searchRooms(startDate,  endDate);
            for (String room : availableRooms) {
                int index = 0;
//                System.out.println(room);
                for (JRadioButton radioBtn : radioBtns) {
                    if (room.equalsIgnoreCase(radioBtn.getText())) {
                        radioBtns[index].setEnabled(true);
                    }
                    index++;
                }
            }
            startdateSpinner.setEnabled(false);
            endDateSpinner.setEnabled(false);
            searchBtn.setEnabled(false);
        }
    }
    
    public void addRecord() {
        if (nameTF.getText().isEmpty() || ICPassTF.getText().isEmpty() || contactTF.getText().isEmpty() || emailTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please filled all required fields", "System Notification", JOptionPane.PLAIN_MESSAGE);
        } else if (!emailTF.getText().contains("@") || !emailTF.getText().contains(".")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address", "System Notification", JOptionPane.PLAIN_MESSAGE);
        } else {
            String selectedRoom = "Invalid";
            for (int i = 0; i < 20; i++) {
                if (radioBtns[i].isSelected()) {
                    selectedRoom = radioBtns[i].getText();
                }
            }
            try {
                new Records((Date) startdateSpinner.getValue(), (Date) endDateSpinner.getValue(), selectedRoom, nameTF.getText(), ICPassTF.getText(), contactTF.getText(), emailTF.getText(), true);
            } catch (Exception error) {
                System.out.println("Unable to create record");
                System.out.println("Error code: " + error);
            }
            reset();
        }
    }
}
