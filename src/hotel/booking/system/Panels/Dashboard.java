package hotel.booking.system.Panels;
import hotel.booking.system.Functions.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.util.*;
import hotel.booking.system.HotelBookingSystem;

public class Dashboard extends JPanel implements MouseListener {
    DefaultTableModel model = new DefaultTableModel();
    static JTable table;
    
    // buttons for date navigation
    JPanel prevBtnContainer = new JPanel();
    JButton prevBtn = new JButton("Prev");
    JPanel nextBtnContainer = new JPanel();
    JButton nextBtn = new JButton("Next");
    
    public Dashboard() {
        // set border layout for dashboard panel
        setLayout(new BorderLayout(0, 30));
        setBorder(new EmptyBorder(30, 30, 30, 30));
        setBackground(new Color(238, 238, 238));
        
        // head panel for date selection and display
        JPanel headPanel = new JPanel();
        headPanel.setLayout(new GridLayout(0, 2));
        headPanel.setPreferredSize(new Dimension(24, 24));
        headPanel.setBackground(new Color(238, 238, 238));
        
        // decoration for prev button
        prevBtn.setBorderPainted(false);
        prevBtn.setForeground(MyFonts.getQuaternaryColor());
        prevBtn.setFont(MyFonts.getPrimaryFont());
        prevBtn.addMouseListener(this);
        // container to create custom decoration for prev button
        prevBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        prevBtnContainer.add(prevBtn);
        prevBtnContainer.setBackground(MyFonts.getPrimaryColor());
        
        // decoration for prev button
        nextBtn.setBorderPainted(false);
        nextBtn.setForeground(MyFonts.getQuaternaryColor());
        nextBtn.setFont(MyFonts.getPrimaryFont());
        nextBtn.addMouseListener(this);
        // container to create custom decoration for prev button
        nextBtnContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        nextBtnContainer.add(nextBtn);
        nextBtnContainer.setBackground(MyFonts.getPrimaryColor());
        
        // container that act as a left margin
        JPanel nextMarginContainer = new JPanel();
        nextMarginContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        nextMarginContainer.add(nextBtnContainer);
        nextMarginContainer.setBorder(new EmptyBorder(0, 15, 0, 0));
        
        // panel to contain buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, -2));
        buttonPanel.setBackground(new Color(238, 238, 238));
        buttonPanel.add(prevBtnContainer);
        buttonPanel.add(nextMarginContainer);
        
        // label for month display
        JLabel month = new JLabel();
        month.setText("JAN");
        month.setFont(MyFonts.getHeader2());
        month.setForeground(MyFonts.getPrimaryColor());
        month.setBackground(new Color(238, 238, 238));
        
        // add month label to the left and button panel that contains date navigation buttons to the left
        headPanel.add(month);
        headPanel.add(buttonPanel);
        
        // setup model for table
        model.addColumn("No");
        model.addColumn("Start Date");
        model.addColumn("End Date");
        model.addColumn("Name");
        model.addColumn("Room No");
        model.addColumn("Contact");
        ArrayList<String[]> records = Records.getList();
        
        // add data into table
        for (String[] outerArray : records) {
            String[] recordPlaceholder = new String[6];
            recordPlaceholder[0] = outerArray[0];
            recordPlaceholder[1] = outerArray[1];
            recordPlaceholder[2] = outerArray[2];
            recordPlaceholder[3] = outerArray[4];
            recordPlaceholder[4] = outerArray[3];
            recordPlaceholder[5] = outerArray[6];
            model.addRow(recordPlaceholder);
        }
        
        // create a table with the predefine model
        table = new JTable(model);
        // set size for first column since it doesn't require much space
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int row = table.getSelectedRow();
                row++;
                HotelBookingSystem.setNav(3, row);
            }
        });
        
        // contain the table inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        
        add(headPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    // method to refresh table after manipulating the data
    public static void refreshTable() {
        DefaultTableModel model = new DefaultTableModel();
        
        // setup model for table
        model.addColumn("No");
        model.addColumn("Start Date");
        model.addColumn("End Date");
        model.addColumn("Name");
        model.addColumn("Room No");
        model.addColumn("Contact");
        ArrayList<String[]> records = Records.getList();
        
        // add data into table
        for (String[] outerArray : records) {
            String[] recordPlaceholder = new String[6];
            recordPlaceholder[0] = outerArray[0];
            recordPlaceholder[1] = outerArray[1];
            recordPlaceholder[2] = outerArray[2];
            recordPlaceholder[3] = outerArray[4];
            recordPlaceholder[4] = outerArray[3];
            recordPlaceholder[5] = outerArray[6];
            model.addRow(recordPlaceholder);
        }
        
        table.setModel(model);
        
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == prevBtn) {
            prevBtnContainer.setBackground(MyFonts.getSecondaryHoverColor());
        } else if (e.getSource() == nextBtn) {
            nextBtnContainer.setBackground(MyFonts.getSecondaryHoverColor());
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == prevBtn) {
            prevBtnContainer.setBackground(MyFonts.getPrimaryColor());
        } else if (e.getSource() == nextBtn) {
            nextBtnContainer.setBackground(MyFonts.getPrimaryColor());
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    
    }
}
