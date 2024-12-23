package uber_olaDesign;

import java.util.HashMap;

public class RiderMgr {
    private static RiderMgr riderMgrInstance;
    HashMap<String, Rider> ridersMap;

    private RiderMgr() {
        ridersMap = new HashMap<>();
    }

    public static RiderMgr getRiderMgrInstance() {
        if (riderMgrInstance == null) {
            synchronized (RiderMgr.class) {
                if (riderMgrInstance == null) {
                    riderMgrInstance = new RiderMgr();
                }
            }
        }
        return riderMgrInstance;
    }

    public void addRider(String riderName, Rider rider) {
        ridersMap.put(riderName, rider);
    }

    public Rider getRider(String riderName) {
        return ridersMap.get(riderName);
    }

}
