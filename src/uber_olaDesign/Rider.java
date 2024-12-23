package uber_olaDesign;

import uber_olaDesign.common.*;

public class Rider {
    String name;
    RATING rating;

    public Rider(String name, RATING rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public RATING getRating() {
        return rating;
    }
}
