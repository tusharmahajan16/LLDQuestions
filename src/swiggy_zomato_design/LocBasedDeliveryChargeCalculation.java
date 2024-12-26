package swiggy_zomato_design;

public class LocBasedDeliveryChargeCalculation implements DeliveryChargeCalculationStrategy{
    @Override
    public double calculateDeliveryCharge(DeliveryMetaData deliveryMetaData) {
        System.out.println("Delivery charge is decided based on location. Setting to 100 as default value for now");
        return 100;
    }
}
