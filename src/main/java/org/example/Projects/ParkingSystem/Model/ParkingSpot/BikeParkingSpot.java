package org.example.Projects.ParkingSystem.Model.ParkingSpot;

import org.example.Projects.ParkingSystem.Model.Vehicle.Vehicle;
import org.example.Projects.ParkingSystem.enums.ParkingSpotType;
import org.example.Projects.ParkingSystem.enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class BikeParkingSpot extends ParkingSpot {

    public BikeParkingSpot(int floorNumber , String spotId) {
        super( floorNumber, spotId );
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
         if(vehicle.getVehicleType() == VehicleType.MOTORCYCLE){
             return true;
         }
         return false;
    }
}
