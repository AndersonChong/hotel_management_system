package hotel.booking.system.Panels;
import hotel.booking.system.Functions.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.EmptyBorder;
import hotel.booking.system.HotelBookingSystem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EditRecord extends JPanel implements MouseListener {
    int index;
    
    // initialize labels
    JLabel startDate = new JLabel("Start Date:");
    JLabel endDate = new JLabel("End Date:");
    JLabel name = new JLabel("Name:");
    JLabel ICPass = new JLabel("IC/Pass:");
    JLabel contact = new JLabel("Contact:");
    JLabel email = new JLabel("Email:");
    
    // initialize date text fields
    JSpinner startdateSpinner = new JSpinner(new SpinnerDateModel());
    JSpinner endDateSpinner = new JSpinner(new SpinnerDateModel());
    // initialize normal text fields
    JTextField nameTF = new JTextField("", 16);
    JTextField ICPassTF = new JTextField("", 16);
    JTextField contactTF = new JTextField("", 16);
    JTextField emailTF = new JTextField("", 16);
    
    // initialize buttons
    JButton searchBtn = new JButton("Search");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton deleteBtn = new JButton("Delete");
    JButton cancelBtn = new JButton("Cancel");
    
    // initialize containers used for custom buttons decoration
    JPanel searchBtnContainer = new JPanel();
    JPanel saveBtnContainer = new JPanel();
    JPanel resetBtnContainer = new JPanel();
    JPanel deleteBtnContainer = new JPanel();
    JPanel cancelBtnContainer = new JPanel();
    
    // create rows of panels to place elements inside
    JPanel panels[] = new JPanel[11];
    JRadioButton[] radioBtns = new JRadioButton[20];
    ButtonGroup roomBtns = new ButtonGroup();
    
    // constructor used to initialize text fields value based on specific record
    public EditRecord(int index) {
        this.index = index;
        System.out.println(index);
        
        for (int i = 0; i < 20; i++) {
            radioBtns[i] = new JRadioButton();
            radioBtns[i].setText(Rooms.getList()[i]);
            radioBtns[i].setEnabled(false);
            radioBtns[i].addMouseListener(this);
        }
        
        for (String[] record : Records.getList()) {
            if (Integer.parseInt(record[0]) == index) {
                nameTF.setText(record[4]);
                ICPassTF.setText(record[5]);
                contactTF.setText(record[6]);
                emailTF.setText(record[7]);
                switch (record[3]) {
                    case "A101":
                        radioBtns[0].setSelected(true);
                    case "A102":
                        radioBtns[1].setSelected(true);
                    case "A103":
                        radioBtns[2].setSelected(true);
                    case "A104":
                        radioBtns[3].setSelected(true);
                    case "A105":
                        radioBtns[4].setSelected(true);
                    case "A106":
                        radioBtns[5].setSelected(true);
                    case "A107":
                        radioBtns[6].setSelected(true);
                    case "A108":
                        radioBtns[7].setSelected(true);
                    case "A109":
                        radioBtns[8].setSelected(true);
                    case "A110":
                        radioBtns[9].setSelected(true);
                    case "A201":
                        radioBtns[10].setSelected(true);
                    case "A202":
                        radioBtns[11].setSelected(true);
                    case "A203":
                        radioBtns[12].setSelected(true);
                    case "A204":
                        radioBtns[13].setSelected(true);
                    case "A205":
                        radioBtns[14].setSelected(true);
                    case "A206":
                        radioBtns[15].setSelected(true);
                    case "A207":
                        radioBtns[16].setSelected(true);
                    case "A208":
                        radioBtns[17].setSelected(true);
                    case "A209":
                        radioBtns[18].setSelected(true);
                    case "A210":
                        radioBtns[19].setSelected(true);
                }
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                
                Date startDateParsed;
                try {
                    startDateParsed = dateFormat.parse(record[1]);
                } catch (Exception e) {
                    System.out.println("Unable to parse string");
                    startDateParsed = Records.getStartTime();
                }
                JSpinner.DateEditor startDateEditor = new JSpinner.DateEditor(startdateSpinner, "yyyy/MM/dd");
                startdateSpinner.setEditor(startDateEditor);
                startdateSpinner.setPreferredSize(new Dimension(218, 24));
                startdateSpinner.setValue(startDateParsed);
                startdateSpinner.setEnabled(false);
                
                Date endDateParsed;
                try {
                    endDateParsed = dateFormat.parse(record[2]);
                } catch (Exception e) {
                    System.out.println("Unable to parse string");
                    endDateParsed = Records.getEndTime();
                }
                JSpinner.DateEditor endDateEditor = new JSpinner.DateEditor(endDateSpinner, "yyyy/MM/dd");
                endDateSpinner.setEditor(endDateEditor);
                endDateSpinner.setPreferredSize(new Dimension(218, 24));
                endDateSpinner.setValue(endDateParsed);
                endDateSpinner.setEnabled(false);
                
                searchBtn.setEnabled(false);
            }
        }
        
        // set border layout for dashboard panel
        setLayout(new BorderLayout(0, 30));
        setBorder(new EmptyBorder(30, 30, 30, 30));
        
        // head panel for date selection and display
        JPanel headPanel = new JPanel();
        headPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        headPanel.setPreferredSize(new Dimension(24, 24));
        
        // label for month display
        JLabel month = new JLabel();
        month.setText("EDIT RECORD");
        month.setFont(MyFonts.getHeader2());
        month.setForeground(MyFonts.getPrimaryColor());
        
        headPanel.add(month);
        
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(null);
        JPanel mainContext = new JPanel();
        mainContext.setLayout(new GridLayout(11, 1));
        mainContext.setBounds(0, 0, 560, 435);
        
        for (int i = 0; i < 11; i++) {
            panels[i] = new JPanel();
            mainContext.add(panels[i]);
            
            switch (i) {
                case 0:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for start date label
                    startDate.setBorder(new EmptyBorder(0, 0, 0, 10));
                    
                    panels[i].add(startDate);
                    panels[i].add(startdateSpinner);
                    break;
                case 1:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for end date label
                    endDate.setBorder(new EmptyBorder(0, 0, 0, 16));
                    
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
                    
                    // decoration for delete button
                    deleteBtn.setBorderPainted(false);
                    deleteBtn.setForeground(MyFonts.getQuaternaryColor());
                    deleteBtn.addMouseListener(this);
                    // container to delete custom decoration for delete button
                    deleteBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    deleteBtnContainer.add(deleteBtn);
                    deleteBtnContainer.setBackground(MyFonts.getPrimaryColor());
                    
                    // decoration for cancel button
                    cancelBtn.setBorderPainted(false);
                    cancelBtn.setForeground(MyFonts.getQuaternaryColor());
                    cancelBtn.addMouseListener(this);
                    // container to create custom decoration for cancel button
                    cancelBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    cancelBtnContainer.add(cancelBtn);
                    cancelBtnContainer.setBackground(MyFonts.getPrimaryColor());
                    
                    // container that act as a left margin for reset button
                    JPanel resetMarginContainer = new JPanel();
                    resetMarginContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    resetMarginContainer.add(resetBtnContainer);
                    resetMarginContainer.setBorder(new EmptyBorder(0, 30, 0, 0));
                    
                    // container that act as a left margin for delete button
                    JPanel deleteMarginContainer = new JPanel();
                    deleteMarginContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    deleteMarginContainer.add(deleteBtnContainer);
                    deleteMarginContainer.setBorder(new EmptyBorder(0, 30, 0, 0));
                    
                    // container that act as a left margin for cancel button
                    JPanel cancelMarginContainer = new JPanel();
                    cancelMarginContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    cancelMarginContainer.add(cancelBtnContainer);
                    cancelMarginContainer.setBorder(new EmptyBorder(0, 30, 0, 0));
                    
                    panels[i].add(saveBtnContainer);
                    panels[i].add(resetMarginContainer);
                    panels[i].add(deleteMarginContainer);
                    panels[i].add(cancelMarginContainer);
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
        } else if (e.getSource() == deleteBtn) {
            deleteBtnContainer.setBackground(MyFonts.getSecondaryHoverColor());
        } else if (e.getSource() == cancelBtn) {
            cancelBtnContainer.setBackground(MyFonts.getSecondaryHoverColor());
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
        } else if (e.getSource() == deleteBtn) {
            deleteBtnContainer.setBackground(MyFonts.getPrimaryColor());
        } else if (e.getSource() == cancelBtn) {
            cancelBtnContainer.setBackground(MyFonts.getPrimaryColor());
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
            updateRecord();
        } else if (e.getSource() == resetBtn) {
            reset();
        } else if (e.getSource() == deleteBtn) {
            int result = JOptionPane.showConfirmDialog(null, "Confirm delete selected record?", "System Notification", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                Records.delete(index);
                HotelBookingSystem.setNav(0, 0);
            }
        } else if (e.getSource() == cancelBtn) {
            HotelBookingSystem.setNav(0, 0);
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
        String availableRooms[] = Records.searchRooms(startDate,  endDate);
        for (String room : availableRooms) {
            int index = 0;
            for (JRadioButton radioBtn : radioBtns) {
                if (room.equalsIgnoreCase(radioBtn.getText())) {
                    System.out.println(room);
                    radioBtns[index].setEnabled(true);
                }
                index++;
            }
        }
        startdateSpinner.setEnabled(false);
        endDateSpinner.setEnabled(false);
        searchBtn.setEnabled(false);
    }
    
    public void updateRecord() {
        if (nameTF.getText().isEmpty() || ICPassTF.getText().isEmpty() || contactTF.getText().isEmpty() || emailTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please filled all required fields", "System Notification", JOptionPane.PLAIN_MESSAGE);
        } else {
            String selectedRoom = "Invalid";
            for (int i = 0; i < 20; i++) {
                if (radioBtns[i].isSelected()) {
                    selectedRoom = radioBtns[i].getText();
                }
            }
            try {
                Records.update(index, (Date) startdateSpinner.getValue(), (Date) endDateSpinner.getValue(), selectedRoom, nameTF.getText(), ICPassTF.getText(), contactTF.getText(), emailTF.getText());
                for (int i = 0; i < 20; i++) {
                    radioBtns[i].setEnabled(false);
                }
            } catch (Exception error) {
                System.out.println("Unable to create record");
                System.out.println("Error code: " + error);
            }
        }
    }
}
