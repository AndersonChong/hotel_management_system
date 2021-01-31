package hotel.booking.system.Panels;
import hotel.booking.system.Functions.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;
import javax.swing.border.EmptyBorder;
import hotel.booking.system.HotelBookingSystem;

public class ViewReceipt extends JPanel{
    DefaultTableModel model = new DefaultTableModel();
    static JTable table;
    
    public ViewReceipt() {
        // set border layout for dashboard panel
        setLayout(new BorderLayout(0, 30));
        setBorder(new EmptyBorder(30, 30, 30, 30));
        
        // head panel for date selection and display
        JPanel headPanel = new JPanel();
        headPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        headPanel.setPreferredSize(new Dimension(24, 24));
        
        // label for month display
        JLabel title = new JLabel();
        title.setText("VIEW RECEIPTS");
        title.setFont(MyFonts.getHeader2());
        title.setForeground(MyFonts.getPrimaryColor());
        
        headPanel.add(title);
        
        // setup model for table
        model.addColumn("No");
        model.addColumn("Start Date");
        model.addColumn("End Date");
        model.addColumn("Name");
        model.addColumn("Room No");
        model.addColumn("Total");
        model.addColumn("Total(w.Tax)");
        ArrayList<String[]> receipts = Receipts.getList();
        
        // add data into table
        if (receipts.size() != 0) {
            for (String[] outerArray : receipts) {
                String[] receiptPlaceholder = new String[7];
                receiptPlaceholder[0] = outerArray[0];
                receiptPlaceholder[1] = outerArray[1];
                receiptPlaceholder[2] = outerArray[2];
                receiptPlaceholder[3] = outerArray[4];
                receiptPlaceholder[4] = outerArray[3];
                receiptPlaceholder[5] = outerArray[6];
                receiptPlaceholder[6] = outerArray[7];
                model.addRow(receiptPlaceholder);
            }
        }
        
        // create a table with the predefine model
        table = new JTable(model);
        // set size for first column since it doesn't require much space
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int row = table.getSelectedRow();
                row++;
                HotelBookingSystem.setNav(4, row);
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
        model.addColumn("Total");
        model.addColumn("Total(w.Tax)");
        ArrayList<String[]> receipts = Receipts.getList();
        
        // add data into table
        for (String[] outerArray : receipts) {
            String[] receiptPlaceholder = new String[7];
            receiptPlaceholder[0] = outerArray[0];
            receiptPlaceholder[1] = outerArray[1];
            receiptPlaceholder[2] = outerArray[2];
            receiptPlaceholder[3] = outerArray[4];
            receiptPlaceholder[4] = outerArray[3];
            receiptPlaceholder[5] = outerArray[6];
            receiptPlaceholder[6] = outerArray[7];
            model.addRow(receiptPlaceholder);
        }
        
        table.setModel(model);
        
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
    }
}
