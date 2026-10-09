package org.example.Projects.ParkingSystem.Model.ParkingSpot;

import org.example.Projects.ParkingSystem.Model.Vehicle.Vehicle;
import org.example.Projects.ParkingSystem.enums.ParkingSpotType;
import org.example.Projects.ParkingSystem.enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class CompactParkingSpot extends ParkingSpot {

    public CompactParkingSpot(  int floorNumber, String spotId) {
        super(floorNumber, spotId     );
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.CAR
                || vehicle.getVehicleType() == VehicleType.MOTORCYCLE;
    }

}
