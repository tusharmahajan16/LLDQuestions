package uber_olaDesign;

public class common {
    public static int nextTripID = 1;
    public enum RATING {
        UNASSIGNED,
        ONE_STAR,
        TWO_STAR,
        THREE_STAR,
        FOUR_STAR,
        FIVE_STAR,
    }

    public enum TRIP_STATUS
    {
        UNASSIGNED,
        DRIVER_ON_THE_WAY,
        DRIVER_ARRIVED,
        STARTED,
        PAUSED,
        ENDED
    }


    public static boolean isHighRating(common.RATING rating) {
        return rating.equals(common.RATING.FOUR_STAR) || rating.equals(common.RATING.FIVE_STAR);
    }
}
