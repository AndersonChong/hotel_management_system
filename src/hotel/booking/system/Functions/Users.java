package hotel.booking.system.Functions;
import hotel.booking.system.HotelBookingSystem;
import hotel.booking.system.Panels.*;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Users {
    public static void login(String email, String pass) {
        File file = new File("src/hotel/booking/system/Files/user.txt");
        try {
            Scanner scanner = new Scanner(file);
            boolean isCorrect = false;
            while (scanner.hasNextLine()) {
                String userString = scanner.nextLine();
                String userProperties[] = userString.split(", ");
                if (userProperties[2].equals(email) && userProperties[3].equals(pass)) {
                    String name = userProperties[1].toUpperCase();
                    HotelBookingSystem.loggedIn(name);
                    isCorrect = true;
                }
            }
            if (!isCorrect) {
                JOptionPane.showMessageDialog(null, "Incorrect credentials", "System Notification", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Unable to read user file", "System Notification", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Unable to read user file");
            System.out.println("Error code: " + error);
        }
    }
}
