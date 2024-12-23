package uber_olaDesign;

public class Driver {
    String name;
    boolean available;
    common.RATING rating;

    public Driver(String name, common.RATING rating) {
        this.name = name;
        this.rating = rating;
        this.available = false;
    }

    public String getName() {
        return name;
    }

    public common.RATING getRating() {
        return rating;
    }

    public void updateAvailable(boolean available) {
        this.available = available;
    }
}
