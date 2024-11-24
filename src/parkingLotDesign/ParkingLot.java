package parkingLotDesign;

import parkingLotDesign.velicleType.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot parkingLot;
    List<Level> levels;

    private ParkingLot() {
        levels = new ArrayList<>();
        if (parkingLot != null) {
            throw new RuntimeException("You are trying to access private constructor");
        }
    }

    public static ParkingLot getInstance() {
        synchronized (ParkingLot.class) {
            if (parkingLot == null) {
                parkingLot = new ParkingLot();
            }
        }
        return parkingLot;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }
}
