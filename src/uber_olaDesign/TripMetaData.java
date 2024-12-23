package uber_olaDesign;

public class TripMetaData {
    common.RATING riderRating;
    common.RATING driverRating;
    Location srcLocation;
    Location destLocation;

    public common.RATING getRiderRating() {
        return riderRating;
    }

    public common.RATING getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(common.RATING driverRating) {
        this.driverRating = driverRating;
    }

    public TripMetaData(common.RATING riderRating, Location srcLocation, Location destLocation) {
        this.riderRating = riderRating;
        this.srcLocation = srcLocation;
        this.destLocation = destLocation;
    }
}
