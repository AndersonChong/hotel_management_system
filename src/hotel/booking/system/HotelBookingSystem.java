package hotel.booking.system;
import hotel.booking.system.Functions.*;
import hotel.booking.system.Panels.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

public class HotelBookingSystem {
    static JFrame mainFrame;
    static JPanel mainContext;
    
    static JPanel sideBar = new SideBar();
    static JPanel dashboard = new Dashboard();
    static JPanel addRecord = new AddRecord();
    static JPanel viewReceipt = new ViewReceipt();
    static JPanel editRecord = new EditRecord(0);
    static JPanel printReceipt = new PrintReceipt(0);
    static JPanel searchRecord = new SearchRecord();
    static JPanel topBar = new TopBar("HACKER");
    static JPanel login = new Login();
    
    static JLabel email = new JLabel("Email: ");
    static JTextField emailTF = new JTextField("", 16);
    static JTextField passTF = new JTextField("", 16);
    static JLabel pass = new JLabel("Password: ");
    static JButton loginBtn = new JButton("Login");
    
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
        
        mainFrame.getContentPane().setLayout(null);
        mainFrame.add(login);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(100, 100));
        panel1.setBackground(Color.red);
        
        panel.add(panel1, BorderLayout.NORTH);
        
        // add sidebar to the left side of main context panel
        mainContext.add(sideBar, BorderLayout.WEST);
        mainContext.add(dashboard, BorderLayout.CENTER);
        
        mainFrame.setVisible(true);
    }
    
    public static void setNav(int index, int editIndex) {
        switch (index) {
            case 0:
                Dashboard.refreshTable();
                mainContext.remove(addRecord);
                mainContext.remove(editRecord);
                mainContext.remove(viewReceipt);
                mainContext.remove(printReceipt);
                mainContext.remove(searchRecord);
                mainContext.add(dashboard, BorderLayout.CENTER);
                break;
            case 1:
                mainContext.remove(dashboard);
                mainContext.remove(editRecord);
                mainContext.remove(viewReceipt);
                mainContext.remove(printReceipt);
                mainContext.remove(searchRecord);
                mainContext.add(addRecord, BorderLayout.CENTER);
                break;
            case 2:
                ViewReceipt.refreshTable();
                mainContext.remove(dashboard);
                mainContext.remove(addRecord);
                mainContext.remove(editRecord);
                mainContext.remove(printReceipt);
                mainContext.remove(searchRecord);
                mainContext.add(viewReceipt, BorderLayout.CENTER);
                break;
            case 3:
                editRecord = new EditRecord(editIndex);
                mainContext.remove(dashboard);
                mainContext.add(editRecord, BorderLayout.CENTER);
                break;
            case 4:
                printReceipt = new PrintReceipt(editIndex);
                mainContext.remove(viewReceipt);
                mainContext.add(printReceipt, BorderLayout.CENTER);
                break;
            case 5:
                mainContext.remove(dashboard);
                mainContext.remove(addRecord);
                mainContext.remove(editRecord);
                mainContext.remove(viewReceipt);
                mainContext.remove(printReceipt);
                mainContext.add(searchRecord, BorderLayout.CENTER);
                break;
        }
        mainContext.revalidate();
        mainContext.repaint();
    }

    public static void loggedIn(String name) {
        // add top bar and main context area to the frame
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.remove(login);
        
        topBar = new TopBar(name);
        
        mainFrame.add(topBar, BorderLayout.NORTH);
        mainFrame.add(mainContext, BorderLayout.CENTER);
        
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    
    public static void loggedOut() {
        mainFrame.getContentPane().setLayout(null);
        mainFrame.remove(topBar);
        mainFrame.remove(mainContext);
        
        mainFrame.add(login);
        
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
