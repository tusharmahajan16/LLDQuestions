package parkingLotDesign;

import parkingLotDesign.velicleType.Car;
import parkingLotDesign.velicleType.Motorcycle;
import parkingLotDesign.velicleType.Truck;
import parkingLotDesign.velicleType.Vehicle;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1,30));
        parkingLot.addLevel(new Level(2,20));
        Vehicle car = new Car("PB123");
        Vehicle Truck = new Truck("PB567");
        Vehicle bike = new Motorcycle("PB666");
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(Truck);
        parkingLot.parkVehicle(bike);

        parkingLot.displayAvailability();
        parkingLot.unparkVehicle(car);
        parkingLot.displayAvailability();
    }

}
