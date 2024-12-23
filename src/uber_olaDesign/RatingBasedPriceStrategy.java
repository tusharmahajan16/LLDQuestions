package uber_olaDesign;

import static uber_olaDesign.common.isHighRating;

public class RatingBasedPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        double price = isHighRating(tripMetaData.getRiderRating()) ? 55 : 75;
        System.out.println("Based on " + tripMetaData.getDriverRating().name() + " rider rating price of trip is " + price);
        return price;
    }
}
