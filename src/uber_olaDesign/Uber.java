package uber_olaDesign;

public class Uber {
    public static void main(String[] args){
        Rider tusharRider = new Rider("Tushar", common.RATING.FOUR_STAR);
        Rider ayushRider = new Rider("Ayush", common.RATING.TWO_STAR);
        RiderMgr riderMgr = RiderMgr.getRiderMgrInstance();
        riderMgr.addRider("tushar",tusharRider);
        riderMgr.addRider("ayush",ayushRider);

        Driver firstDriver = new Driver("Aman", common.RATING.FIVE_STAR);
        Driver secondDriver = new Driver("Bob", common.RATING.THREE_STAR);
        DriverMgr driverMgr = DriverMgr.getDriverMgrInstance();
        driverMgr.addDriver("aman", firstDriver);
        driverMgr.addDriver("bob", secondDriver);

        TripMgr tripMgr = TripMgr.getTripMgrInstance();
        Trip trip1 = tripMgr.createTrip(tusharRider,new Location(50,50),new Location(100,100));
        System.out.println();
        Trip trip2 = tripMgr.createTrip(ayushRider,new Location(30,30),new Location(120,120));
        System.out.println();
        trip1.displayTrip();
        System.out.println();
        trip2.displayTrip();
    }
}
