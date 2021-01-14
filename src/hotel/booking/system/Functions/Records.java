package hotel.booking.system.Functions;
import java.io.*;
import java.util.*;
import java.text.*;

public class Records {
    private int index;
    private Date startDate;
    private Date endDate;
    private String roomNum;
    private String name;
    private String ICPass;
    private String contact;
    private String email;
    private static ArrayList<Records> list = new ArrayList<Records>();
    
    // constructor to create a new record
    public Records(Date startDate, Date endDate, String roomNum, String name, String ICPass, String contact, String email, boolean save) {
        // initialize records properties during instantiation
        this.index = getLastIndex() + 1;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNum = roomNum;
        this.name = name;
        this.ICPass = ICPass;
        this.contact = contact;
        this.email = email;
        
        // save data into text file if true
        if (save) {
            try {
                FileWriter writer = new FileWriter("src/hotel/booking/system/Files/record.txt", true);
                writer.write(index + ", " + startDate + ", " + endDate + ", " + roomNum + ", " + name + ", " + ICPass + ", " + contact + ", " + email + "\n");
                writer.close();
            } catch (Exception error) {
                System.out.println("Unable to create record");
                System.out.println("Error code: " + error);
            }
            
        }
        
        System.out.println("Record created");
    }
    
    // overloading constructor to create record with index
    public Records(int index, Date startDate, Date endDate, String roomNum, String name, String ICPass, String contact, String email, boolean save) {
        // initialize records properties during instantiation
        this.index = index;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNum = roomNum;
        this.name = name;
        this.ICPass = ICPass;
        this.contact = contact;
        this.email = email;
        
        // save data into text file if true
        if (save) {
            try {
                FileWriter writer = new FileWriter("src/hotel/booking/system/Files/record.txt", true);
                writer.write(index + ", " + startDate + ", " + endDate + ", " + roomNum + ", " + name + ", " + ICPass + ", " + contact + ", " + email + "\n");
                writer.close();
            } catch (Exception error) {
                System.out.println("Unable to create record");
                System.out.println("Error code: " + error);
            }
            
        }
        
        System.out.println("Record created");
    }
    
    // static method to get current date
    public static Date getStartTime() {
        return new Date();
    }
    
    // static method to get tmr's date
    public static Date getEndTime() {
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, 1);
        
        return cal.getTime();
    }
    
    // Add new record into the list
    public static void addList(Records record) {
        list.add(record);
        int counter = 0;
        for (Records element : list) {
            System.out.println(element.startDate + ", " + element.endDate + ", " + element.roomNum + ", " + element.name + ", " + element.ICPass + ", " + element.contact + ", " + element.email);
            counter++;
        }
        System.out.println("Number of records in list: " + list.size());
    }
    
    // return list of records to display
    public static ArrayList<String[]> getList() {
        // multidimensional array list to store all record with it's respective properties
        ArrayList<String[]> records = new ArrayList<String[]>();
        // search for a specific file to read
        File file = new File("src/hotel/booking/system/Files/record.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String recordProperties[] = new String[8];
                
                String recordString = scanner.nextLine();
                recordProperties = recordString.split(", ");
                records.add(recordProperties);
            }
        } catch (Exception error) {
            System.out.println("Unable to read file");
            System.out.println("Error code: " + error);
        }
        return records;
    }
    
    // get the last index number
    public static int getLastIndex() {
        File file = new File("src/hotel/booking/system/Files/record.txt");
        String lastRecord = "";
        String recordProperties[] = new String[7];
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lastRecord = scanner.nextLine();
            }
            recordProperties = lastRecord.split(", ");
        } catch (Exception error) {
            System.out.println("Unable to read file");
            System.out.println("Error code: " + error);
        }
        try {
            return Integer.parseInt(recordProperties[0]);
        } catch (Exception e) {
            return 1;
        }
    }
}
