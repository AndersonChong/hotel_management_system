package hotel.booking.system.Functions;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Receipts {
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
}
