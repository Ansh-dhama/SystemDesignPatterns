package org.example.Projects.ParkingSystem.Model.ParkingSpot;

import org.example.Projects.ParkingSystem.Model.Vehicle.Vehicle;
import org.example.Projects.ParkingSystem.enums.ParkingSpotType;
import org.example.Projects.ParkingSystem.enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class carParkingSpot extends ParkingSpot {

    public carParkingSpot(Vehicle currentVehicle, int floorNumber, AtomicBoolean isOccupied, String spotId, ParkingSpotType type) {
        super(currentVehicle, floorNumber, isOccupied, spotId, type);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        if(vehicle.getVehicleType() == VehicleType.CAR) return true;
        else return false;
    }
}
