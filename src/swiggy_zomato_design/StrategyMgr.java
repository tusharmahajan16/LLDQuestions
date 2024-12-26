package swiggy_zomato_design;

public class StrategyMgr {
    private static StrategyMgr instance;

    private StrategyMgr() {
    }

    public static StrategyMgr getInstance() {
        if (instance == null) {
            synchronized (UserMgr.class) {
                if (instance == null) {
                    instance = new StrategyMgr();
                }
            }
        }
        return instance;
    }

    public DeliveryChargeCalculationStrategy determineDeliveryChargeStrategy(DeliveryMetaData deliveryMetaData) {
        return new LocBasedDeliveryChargeCalculation();
    }

    public DeliveryPartnerMatchingStrategy determineDeliveryPartnerMatchingStrategy(DeliveryMetaData deliveryMetaData) {
        return new LocationBasedDeliveryPartnerMatching();
    }
}
