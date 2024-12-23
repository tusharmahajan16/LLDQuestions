package uber_olaDesign;

import java.util.HashMap;

public class DriverMgr {
    private static DriverMgr DriverMgrInstance;
    private HashMap<String, Driver> driversMap;

    private DriverMgr() {
        driversMap = new HashMap<>();
    }

    public static DriverMgr getDriverMgrInstance() {
        if (DriverMgrInstance == null) {
            synchronized (DriverMgr.class) {
                if (DriverMgrInstance == null) {
                    DriverMgrInstance = new DriverMgr();
                }
            }
        }
        return DriverMgrInstance;
    }

    public void addDriver(String driverName, Driver driver) {
        driversMap.put(driverName, driver);
    }

    public Driver getDriver(String driverName) {
        return driversMap.get(driverName);
    }

    public HashMap<String, Driver> getDriversMap() {
        return driversMap;
    }
}
