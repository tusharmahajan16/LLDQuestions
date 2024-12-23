package uber_olaDesign;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {
    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
        DriverMgr driverMgr = DriverMgr.getDriverMgrInstance();
        if (driverMgr.getDriversMap().isEmpty()) {
            System.out.println("No drivers found");
            return null;
        }
        System.out.println("finding nearest cabs, using driver manager to get details of drivers and send notifications");
        Driver driver = driverMgr.getDriversMap().values().iterator().next();
        System.out.println("Setting " + driver.getName() + " as driver");
        return driver;
    }
}
