package swiggy_zomato_design;

public class Common {
    public enum RATING {
        UNASSIGNED,
        ONE_STAR,
        TWO_STAR,
        THREE_STAR,
        FOUR_STAR,
        FIVE_STAR,
    }

    public enum CUISINE {
        NORTH_INDIAN,
        SOUTH_INDIAN,
        CHINESE,
        STREET_FOOD,
        SWEETS,
        ITALIAN,
    };

    public enum ORDER_STATUS {
        PLACED,
        ORDERED,
        ACCEPTED,
        ON_THE_WAY,
        REACHED,
        DELIVERED,
        CANCELLED
    };

    public static void addDelay() {
        try {
            Thread.sleep(3000);  // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            // Handle the interruption (optional)
            e.printStackTrace();
        }
    }
}
