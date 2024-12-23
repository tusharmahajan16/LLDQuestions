package uber_olaDesign;

import java.util.HashMap;

public class TripMgr {
    private static TripMgr tripMgrInstance;
    RiderMgr riderMgr;
    DriverMgr driverMgr;
    HashMap<Integer, Trip> tripInfoMap;
    HashMap<Integer, TripMetaData> tripMetaDataMap;

    private TripMgr() {
        riderMgr = RiderMgr.getRiderMgrInstance();
        driverMgr = DriverMgr.getDriverMgrInstance();
        tripInfoMap = new HashMap<>();
        tripMetaDataMap = new HashMap<>();
    }

    public static TripMgr getTripMgrInstance() {
        if (tripMgrInstance == null) {
            synchronized (TripMgr.class) {
                if (tripMgrInstance == null) {
                    tripMgrInstance = new TripMgr();
                }
            }
        }
        return tripMgrInstance;
    }

    public Trip createTrip(Rider rider, Location srcLocation, Location destLocation) {
        System.out.println("Creating new trip for " + rider.getName()
                + " from location (" + srcLocation.longitude + "," + srcLocation.latitude + ")"
                + " to Location (" + destLocation.longitude + "," + destLocation.latitude + ")");
        TripMetaData tripMetaData = new TripMetaData(rider.getRating(), srcLocation, destLocation);
        StrategyMgr strategyMgr = StrategyMgr.getInstance();
        PriceStrategy priceStrategy = strategyMgr.determinePriceStrategy(tripMetaData);
        DriverMatchingStrategy driverMatchingStrategy = strategyMgr.determineDriverMatchingStrategy(tripMetaData);
        Driver driver = driverMatchingStrategy.matchDriver(tripMetaData);
        tripMetaData.setDriverRating(driver.getRating());
        double price = priceStrategy.calculatePrice(tripMetaData);
        Trip trip = new Trip(rider, driver, srcLocation, destLocation, price, priceStrategy, driverMatchingStrategy);
        int tripId = trip.getTripID();
        tripInfoMap.put(tripId, trip);
        tripMetaDataMap.put(tripId, tripMetaData);
        return trip;
    }

    public HashMap<Integer, Trip> getTripInfoMap() {
        return tripInfoMap;
    }
}
