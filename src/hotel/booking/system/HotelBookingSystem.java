package hotel.booking.system;
import hotel.booking.system.Panels.*;
import java.awt.*;
import javax.swing.*;

public class HotelBookingSystem {
    static JFrame mainFrame;
    static JPanel mainContext;
    
    static JPanel dashboard = new Dashboard();
    static JPanel addRecord = new AddRecord();
    static JPanel editRecord = new EditRecord();
    
    public static void main(String[] args) {
        // Create main frame for all other components to display
        mainFrame = new JFrame();
        mainFrame.setSize(800, 600);
        mainFrame.setMinimumSize(new Dimension(800, 600));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        
        // Create main context area for all the contents
        mainContext = new JPanel();
        mainContext.setLayout(new BorderLayout());
        mainContext.setBackground(new Color(0xFFFFFF));
        
        // add top bar and main context area to the frame
        mainFrame.add(new TopBar(), BorderLayout.NORTH);
        mainFrame.add(mainContext, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(100, 100));
        panel1.setBackground(Color.red);
        
        panel.add(panel1, BorderLayout.NORTH);
        
        // add sidebar to the left side of main context panel
        mainContext.add(new SideBar(), BorderLayout.WEST);
        mainContext.add(dashboard, BorderLayout.CENTER);
        
        mainFrame.setVisible(true);
    }
    
    public static void setNav(int index) {
        switch (index) {
            case 0:
                mainContext.remove(addRecord);
                mainContext.remove(editRecord);
                mainContext.add(dashboard, BorderLayout.CENTER);
                break;
            case 1:
                mainContext.remove(dashboard);
                mainContext.remove(editRecord);
                mainContext.add(addRecord, BorderLayout.CENTER);
                break;
            case 2:
                mainContext.remove(dashboard);
                mainContext.remove(addRecord);
                mainContext.add(editRecord, BorderLayout.CENTER);
                break;
                
        }
        mainContext.revalidate();
        mainContext.repaint();
    }
}
