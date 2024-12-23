package uber_olaDesign;

public class DefaultPricingStrategy implements PriceStrategy {

    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        double price = 100;
        System.out.println("Based on Default Price is " + price);
        return price;
    }
}
