package hotel.booking.system.Functions;
import hotel.booking.system.HotelBookingSystem;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class Records {
    // privte instance properties
    private int index;
    private Date startDate;
    private Date endDate;
    private String roomNum;
    private String name;
    private String ICPass;
    private String contact;
    private String email;
    
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
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String startDateStr = dateFormat.format(startDate);
        String endDateStr = dateFormat.format(endDate);
        
        // save data into text file if true
        if (save) {
            try {
                FileWriter writer = new FileWriter("src/hotel/booking/system/Files/record.txt", true);
                writer.write(index + ", " + startDateStr + ", " + endDateStr + ", " + roomNum + ", " + name + ", " + ICPass + ", " + contact + ", " + email + "\n");
                writer.close();
                
                long diffInDays = Receipts.getDateDiff(startDateStr, endDateStr);
                System.out.println(diffInDays);
                long total = Receipts.calTotal(diffInDays);
                System.out.println(total);
                
                JOptionPane.showMessageDialog(null, "Record added successfully", "System Notification", JOptionPane.PLAIN_MESSAGE);
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
    
    // update properties of selected record
    public static void update(int index, Date startDate, Date endDate, String roomNum, String name, String ICPass, String contact, String email) {
        File file = new File("src/hotel/booking/system/Files/record.txt");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String startDateStr = dateFormat.format(startDate);
        String endDateStr = dateFormat.format(endDate);
        
        try {
            FileWriter writer = new FileWriter("src/hotel/booking/system/Files/temp.txt", true);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String recordString = scanner.nextLine();
                String recordProperties[] = recordString.split(", ");
                
                if (Integer.parseInt(recordProperties[0]) == index) {
                    writer.write(index + ", " + startDateStr + ", " + endDateStr + ", " + roomNum + ", " + name + ", " + ICPass + ", " + contact + ", " + email + "\n");
                } else {
                    writer.write(recordString + "\n");
                }
            }
            writer.close();
            
            JOptionPane.showMessageDialog(null, "Record updated successfully", "System Notification", JOptionPane.PLAIN_MESSAGE);
            
            file.delete();
            File temp = new File("src/hotel/booking/system/Files/temp.txt");
            temp.renameTo(new File("src/hotel/booking/system/Files/record.txt"));
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Unable to update record", "System Notification", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Unable to update record");
            System.out.println("Error code: " + error);
        }
        
    }
    
    // method to delete record based on selected index
    public static void delete(int index) {
        File file = new File("src/hotel/booking/system/Files/record.txt");
        
        try {
            FileWriter writer = new FileWriter("src/hotel/booking/system/Files/temp.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String recordString = scanner.nextLine();
                String recordProperties[] = recordString.split(", ");
                
                if (Integer.parseInt(recordProperties[0]) == index) {
                    // ignore record if the index is identical
                } else {
                    // write record into temparary file if index is not identical
                    writer.write(recordString + "\n");
                }
            }
            writer.close();
            
            JOptionPane.showMessageDialog(null, "Record delete successfully", "System Notification", JOptionPane.PLAIN_MESSAGE);
            
            file.delete();
            File temp = new File("src/hotel/booking/system/Files/temp.txt");
            temp.renameTo(new File("src/hotel/booking/system/Files/record.txt"));
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Unable to delete record", "System Notification", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Unable to update record");
            System.out.println("Error code: " + error);
        }
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
            scanner.close();
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
    
    public static String[] searchRooms(Date startDate, Date endDate) {
        String roomList[] = Rooms.getList();
        String returnRoomList[] = Rooms.getList();
        for (String record[] : getList()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date fileStartDate;
            Date fileEndDate;
            try {
                fileStartDate = dateFormat.parse(record[1]);
                fileEndDate = dateFormat.parse(record[2]);
            } catch (Exception error) {
                System.out.println("Unable to parse date string");
                System.out.println("Error code: " + error);
                JOptionPane.showMessageDialog(null, "Unable to parse data string", "System Notification", JOptionPane.PLAIN_MESSAGE);
                return null;
            }
            if ((fileStartDate.compareTo(startDate) >= 0 && fileStartDate.compareTo(endDate) <= 0) || (fileEndDate.compareTo(startDate) >= 0 && fileStartDate.compareTo(endDate) <= 0)) {
                System.out.println("within range loop");
                int index = 0;
                for (String room : roomList) {
                    if (room.equalsIgnoreCase(record[3])) {
                        returnRoomList[index] = "none";
                    } else {
                        returnRoomList[index] = roomList[index];
                    }
                    index++;
                }
                roomList = returnRoomList;
            }
        }
        return returnRoomList;
    }
}
