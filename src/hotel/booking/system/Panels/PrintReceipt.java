package hotel.booking.system.Panels;
import hotel.booking.system.Functions.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.EmptyBorder;
import hotel.booking.system.HotelBookingSystem;
import java.text.DateFormat;
import java.io.*;
import java.text.SimpleDateFormat;

public class PrintReceipt extends JPanel implements MouseListener {
    int index;
    String startDateStr;
    String endDateStr;
    
    // initialize labels
    JLabel startDate = new JLabel("Start Date:");
    JLabel endDate = new JLabel("End Date:");
    JLabel roomNum = new JLabel("Room No:");
    JLabel name = new JLabel("Name:");
    JLabel ICPass = new JLabel("IC/Pass:");
    JLabel sum = new JLabel("Sum:");
    JLabel total = new JLabel("Total:");
    
    // initialize date text fields
    JSpinner startdateSpinner = new JSpinner(new SpinnerDateModel());
    JSpinner endDateSpinner = new JSpinner(new SpinnerDateModel());
    // initialize normal text fields
    JTextField roomNumTF = new JTextField("", 16);
    JTextField nameTF = new JTextField("", 16);
    JTextField ICPassTF = new JTextField("", 16);
    JTextField sumTF = new JTextField("", 16);
    JTextField totalTF = new JTextField("", 16);
    
    // initialize buttons
    JButton printBtn = new JButton("Download");
    JButton cancelBtn = new JButton("Cancel");
    
    // initialize containers used for custom buttons decoration
    JPanel printBtnContainer = new JPanel();
    JPanel cancelBtnContainer = new JPanel();
    
    // create rows of panels to place elements inside
    JPanel panels[] = new JPanel[11];
    
    // constructor used to initialize text fields value based on specific record
    public PrintReceipt(int index) {
        this.index = index;
        
        for (String[] receipt : Receipts.getList()) {
            if (Integer.parseInt(receipt[0]) == index) {
                roomNumTF.setText(receipt[3]);
                nameTF.setText(receipt[4]);
                ICPassTF.setText(receipt[5]);
                sumTF.setText(receipt[6]);
                totalTF.setText(receipt[7]);
                
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                
                Date startDateParsed;
                try {
                    this.startDateStr = receipt[1];
                    startDateParsed = dateFormat.parse(this.startDateStr);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "Unable to parse end date string", "System Notification", JOptionPane.PLAIN_MESSAGE);
                    System.out.println("Unable to parse string");
                    System.out.println("Error code: " + error);
                    startDateParsed = Records.getStartTime();
                }
                JSpinner.DateEditor startDateEditor = new JSpinner.DateEditor(startdateSpinner, "yyyy/MM/dd");
                startdateSpinner.setEditor(startDateEditor);
                startdateSpinner.setPreferredSize(new Dimension(218, 24));
                startdateSpinner.setValue(startDateParsed);
                startdateSpinner.setEnabled(false);
                
                Date endDateParsed;
                try {
                    this.endDateStr = receipt[2];
                    endDateParsed = dateFormat.parse(this.endDateStr);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "Unable to parse end date string", "System Notification", JOptionPane.PLAIN_MESSAGE);
                    System.out.println("Unable to parse string");
                    System.out.println("Error code: " + error);
                    endDateParsed = Records.getEndTime();
                }
                JSpinner.DateEditor endDateEditor = new JSpinner.DateEditor(endDateSpinner, "yyyy/MM/dd");
                endDateSpinner.setEditor(endDateEditor);
                endDateSpinner.setPreferredSize(new Dimension(218, 24));
                endDateSpinner.setValue(endDateParsed);
                endDateSpinner.setEnabled(false);
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
        month.setText("PRINT RECORD");
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
                    
                    panels[i].add(endDate);
                    panels[i].add(endDateSpinner);
                    break;
                case 2:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for name label and text field
                    roomNum.setBorder(new EmptyBorder(0, 0, 0, 15));
                    panels[i].add(roomNum);
                    panels[i].add(roomNumTF);
                    break;
                case 3:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for name label and text field
                    name.setBorder(new EmptyBorder(0, 0, 0, 38));
                    panels[i].add(name);
                    panels[i].add(nameTF);
                    break;
                case 4:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for ic label and text field
                    ICPass.setBorder(new EmptyBorder(0, 0, 0, 26));
                    panels[i].add(ICPass);
                    panels[i].add(ICPassTF);
                    break;
                case 5:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for contac label and text field
                    sum.setBorder(new EmptyBorder(0, 0, 0, 47));
                    panels[i].add(sum);
                    panels[i].add(sumTF);
                    break;
                case 6:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for email label and text field
                    total.setBorder(new EmptyBorder(0, 0, 0, 43));
                    panels[i].add(total);
                    panels[i].add(totalTF);
                    break;
                case 7:
                    panels[i].setLayout(new FlowLayout(FlowLayout.LEADING, 0, 5));
                    
                    // decoration for save button
                    printBtn.setBorderPainted(false);
                    printBtn.setForeground(MyFonts.getQuaternaryColor());
                    printBtn.addMouseListener(this);
                    // container to create custom decoration for search button
                    printBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    printBtnContainer.add(printBtn);
                    printBtnContainer.setBackground(MyFonts.getPrimaryColor());
                    
                    // decoration for cancel button
                    cancelBtn.setBorderPainted(false);
                    cancelBtn.setForeground(MyFonts.getQuaternaryColor());
                    cancelBtn.addMouseListener(this);
                    // container to create custom decoration for cancel button
                    cancelBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    cancelBtnContainer.add(cancelBtn);
                    cancelBtnContainer.setBackground(MyFonts.getPrimaryColor());
                    
                    // container that act as a left margin for cancel button
                    JPanel cancelMarginContainer = new JPanel();
                    cancelMarginContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                    cancelMarginContainer.add(cancelBtnContainer);
                    cancelMarginContainer.setBorder(new EmptyBorder(0, 30, 0, 0));
                    
                    panels[i].add(printBtnContainer);
                    panels[i].add(cancelMarginContainer);
            }
        }
        
        roomNumTF.setEnabled(false);
        nameTF.setEnabled(false);
        ICPassTF.setEnabled(false);
        sumTF.setEnabled(false);
        totalTF.setEnabled(false);
        
        mainContainer.add(mainContext);
        
        add(headPanel, BorderLayout.NORTH);
        add(mainContainer, BorderLayout.CENTER);
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == printBtn) {
            printBtnContainer.setBackground(MyFonts.getSecondaryHoverColor());
        } else if (e.getSource() == cancelBtn) {
            cancelBtnContainer.setBackground(MyFonts.getSecondaryHoverColor());
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == printBtn) {
            printBtnContainer.setBackground(MyFonts.getPrimaryColor());
        } else if (e.getSource() == cancelBtn) {
            cancelBtnContainer.setBackground(MyFonts.getPrimaryColor());
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == printBtn) {
            Receipts.download(index, this.startDateStr, this.endDateStr, roomNumTF.getText(), nameTF.getText(), ICPassTF.getText(), Integer.parseInt(sumTF.getText()), Integer.parseInt(totalTF.getText()));
        } else if (e.getSource() == cancelBtn) {
            HotelBookingSystem.setNav(2, 0);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    
    }
}
