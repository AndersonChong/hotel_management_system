package hotel.booking.system.Panels;
import hotel.booking.system.Functions.MyFonts;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends JPanel {
    public Dashboard() {
        // set border layout for dashboard panel
        setLayout(new BorderLayout(0, 30));
        setBorder(new EmptyBorder(30, 30, 30, 30));
        setBackground(new Color(238, 238, 238));
        
        // head panel for date selection and display
        JPanel headPanel = new JPanel();
        headPanel.setLayout(new GridLayout(0, 2));
        headPanel.setPreferredSize(new Dimension(36, 36));
        headPanel.setBackground(new Color(238, 238, 238));
        
        // buttons for date navigation
        JButton prevBtn = new JButton("P");
        prevBtn.setPreferredSize(new Dimension(24, 24));
        // TODO Can put button into panel to set gap between buttons
//        prevBtn.setBorder(new EmptyBorder(0, 0, 0, 15));
        JButton nextBtn = new JButton("N");
        nextBtn.setPreferredSize(new Dimension(24, 24));
        // TODO set hover and click decoration
        
        // panel to contain buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        buttonPanel.setBackground(new Color(238, 238, 238));
        buttonPanel.add(prevBtn);
        buttonPanel.add(nextBtn);
        
        // label for month display
        JLabel month = new JLabel();
        month.setText("JAN");
        month.setFont(MyFonts.getHeader1());
        month.setForeground(MyFonts.getPrimaryColor());
        month.setBackground(new Color(238, 238, 238));
        
        // add month label to the left and button panel that contains date navigation buttons to the left
        headPanel.add(month);
        headPanel.add(buttonPanel);
        
        // setup model for table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Start");
        model.addColumn("End");
        model.addColumn("Name");
        model.addColumn("Name");
        model.addColumn("Name");
        String data1[] = {"2020/12/12", "2020/12/14", "Anderson", "Anderson", "Anderson"};
        String data2[] = {"2020/12/15", "2020/12/16", "Wayne", "Wayne", "Wayne"};
        for (int i = 0; i < 100; i++) {
            model.addRow(data1);
            model.addRow(data2);
        }
        
        // create a table with the predefine model
        JTable table = new JTable(model);
        
        // contain the table inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        
        add(headPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}
