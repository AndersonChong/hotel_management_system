package hotel.booking.system.Functions;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class Receipts {
    private int index;
    private String startDate;
    private String endDate;
    private String roomNum;
    private String name;
    private String ICPass;
    private long sum;
    private long total;
    
    public Receipts(String startDate, String endDate, String roomNum, String name, String ICPass, long sum, long total) {
        this.index = getLastIndex() + 1;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNum = roomNum;
        this.name = name;
        this.ICPass = ICPass;
        this.sum = sum;
        this.total = total;
        
        try {
            FileWriter writer = new FileWriter("src/hotel/booking/system/Files/receipt.txt", true);
            writer.write(index + ", " + startDate + ", " + endDate + ", " + roomNum + ", " + name + ", " + ICPass + ", " + sum + ", " + total + "\n");
            writer.close();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Unable to create receipt", "System Notification", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Unable to create receipt");
            System.out.println("Error code: " + error);
        }
    }
    
    public static long calTotal(long diffInDays) {
        long total = (diffInDays * 350 * 110 / 100) + (diffInDays * 10);
        return total;
    }
    
    public static long getDateDiff(String startDateStr, String endDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date startDate = Records.getStartTime();
        Date endDate = Records.getEndTime();
        try {
            startDate = dateFormat.parse(startDateStr);
            endDate = dateFormat.parse(endDateStr);
        } catch (Exception e) {
            System.out.println("Unable to parse");
        }
        
        long difference = Math.abs(endDate.getTime() - startDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
        
        return diffInDays;
    }
    
    public static ArrayList<String[]> getList() {
        // multidimensional array list to store all record with it's respective properties
        ArrayList<String[]> receipts = new ArrayList<String[]>();
        // search for a specific file to read
        File file = new File("src/hotel/booking/system/Files/receipt.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String receiptProperties[] = new String[8];
                
                String receiptString = scanner.nextLine();
                receiptProperties = receiptString.split(", ");
                receipts.add(receiptProperties);
            }
            scanner.close();
        } catch (Exception error) {
            System.out.println("Unable to read file");
            System.out.println("Error code: " + error);
        }
        return receipts;
    }
    
    // get the last index number
    public static int getLastIndex() {
        File file = new File("src/hotel/booking/system/Files/receipt.txt");
        String lastReceipt = "";
        String receiptProperties[] = new String[8];
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lastReceipt = scanner.nextLine();
            }
            receiptProperties = lastReceipt.split(", ");
        } catch (Exception error) {
            System.out.println("Unable to read file");
            System.out.println("Error code: " + error);
        }
        try {
            return Integer.parseInt(receiptProperties[0]);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Unable to retrieve last receipt index", "System Notification", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Unable to retrieve last receipt index");
            System.out.println("Error code: " + error);
            return 1;
        }
    }
    
    public static void download(int index, String startDate, String endDate, String roomNum, String name, String ICPass, long sum, long total) {
        String home = System.getProperty("user.home");
        String fileName = "Hotel_Receipt.txt";
        try {
            File file = new File(home + "/Downloads/" + fileName);
            int counter = 1;
            while (file.exists()) {
                fileName = "Hotel_Receipt.txt";
                fileName = "Hotel_Receipt(" + counter + ").txt";
                file = new File(home + "/Downloads/" + fileName);
                counter++;
            }
            FileWriter writer = new FileWriter(home + "/Downloads/" + fileName);
            writer.write("RECEIPT ID N0. " + index + "\n\nStart Date: " + startDate + "\nEnd Date: " + endDate + "\nRoom Number: " + roomNum + "\nName: " + name + "\nIC/ Passport: " + ICPass + "\nSum: " + sum + "\nTotal: " + total + "\n\nThank you\nHope to enjoyed your vacation");
            
            JOptionPane.showMessageDialog(null, "Receipt downloaded to your Downloads folder", "System Notification", JOptionPane.PLAIN_MESSAGE);
            
            writer.close();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Unable to print receipt", "System Notification", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Unable to print receipt");
            System.out.println("Error code: " + error);
        }
    }
}
