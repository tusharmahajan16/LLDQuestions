package parkingLotDesign;

import parkingLotDesign.velicleType.Vehicle;
import parkingLotDesign.velicleType.VehicleType;

public class ParkingSpot {
    private final int spot;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spot) {
        this.spot = spot;
        vehicleType = VehicleType.CAR;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicleType == vehicle.getVehicleType()) {
            parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
        }
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getSpot() {
        return spot;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
