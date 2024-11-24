package parkingLotDesign;

import parkingLotDesign.velicleType.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Level {
    int floor;
    List<ParkingSpot> parkingSpots;

    public Level(int floor, int totalSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>();
        for (int spot = 1; spot <= totalSpots; spot++) {
            parkingSpots.add(new ParkingSpot(spot));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicle.getVehicleType()) {
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (!parkingSpot.isAvailable() && parkingSpot.getParkedVehicle().equals(vehicle)) {
                parkingSpot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability:");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpot() + ": " + (spot.isAvailable() ? "Available" : "Occupied"));
        }
        System.out.println();
    }
}
