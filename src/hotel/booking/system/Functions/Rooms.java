package hotel.booking.system.Functions;

public class Rooms {
    private static String list[] = {
        "A101", "A102", "A103", "A104", "A105", "A106", "A107", "A108", "A109", "A110", "A201", "A202", "A203", "A204", "A205", "A206", "A207", "A208", "A209", "A210"
    };
    private static int price = 350;
    
    public static String[] getList() {
        return list;
    }
    
    public static int getPrice() {
        return price;
    }
}
