package uber_olaDesign;

public class StrategyMgr {
    private static StrategyMgr strategyMgrInstance;

    private StrategyMgr() {

    }

    public static StrategyMgr getInstance() {
        if (strategyMgrInstance == null) {
            synchronized (StrategyMgr.class) {
                if (strategyMgrInstance == null) {
                    strategyMgrInstance = new StrategyMgr();
                }
            }
        }
        return strategyMgrInstance;
    }

    public PriceStrategy determinePriceStrategy(TripMetaData tripMetaData) {
        System.out.println("Based on location and other factors, setting pricing strategy");
        return new RatingBasedPriceStrategy();
    }

    public DriverMatchingStrategy determineDriverMatchingStrategy(TripMetaData tripMetaData) {
        System.out.println("Based on location and other factors, setting driver matching strategy");
        return new LeastTimeBasedMatchingStrategy();
    }

}
