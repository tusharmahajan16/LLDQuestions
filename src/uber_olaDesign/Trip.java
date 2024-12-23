package uber_olaDesign;

import static uber_olaDesign.common.nextTripID;

public class Trip {
    private int tripID;
    private Rider rider;
    private Driver driver;
    private Location srcLocation;
    private Location destLocation;
    double price;
    PriceStrategy priceStrategy;
    DriverMatchingStrategy driverMatchingStrategy;
    common.TRIP_STATUS status;

    public Trip(Rider rider, Driver driver, Location srcLocation, Location destLocation, double price, PriceStrategy priceStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        this.rider = rider;
        this.driver = driver;
        this.srcLocation = srcLocation;
        this.destLocation = destLocation;
        this.price = price;
        this.priceStrategy = priceStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
        status = common.TRIP_STATUS.DRIVER_ON_THE_WAY;
        tripID = nextTripID;
        nextTripID++;
    }

    public void displayTrip() {
        System.out.println("Trip ID: " + tripID);
        System.out.println("Rider: " + rider.getName());
        System.out.println("Driver: " + driver.getName());
        System.out.println("Location: " + srcLocation.longitude+" "+srcLocation.latitude);
        System.out.println("Destination: " + destLocation.longitude+" "+destLocation.latitude);
        System.out.println("Price: " + price);
    }

    public int getTripID() {
        return tripID;
    }
}
