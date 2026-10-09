package org.example.Projects.ParkingSystem.Strategy.SpotAlotStartegy;

import org.example.Projects.ParkingSystem.Interface.SpotAllocationStrategy;
import org.example.Projects.ParkingSystem.Model.ParkingLot.Floor;
import org.example.Projects.ParkingSystem.Model.ParkingSpot.ParkingSpot;
import org.example.Projects.ParkingSystem.Model.Vehicle.Vehicle;
import org.example.Projects.ParkingSystem.enums.VehicleType;

import java.util.List;
import java.util.Optional;

public   class firstFindStrategy implements SpotAllocationStrategy {

    @Override
    public Optional<ParkingSpot> findSpot(List<Floor> floors, Vehicle vehicle) {
         for(Floor floor : floors) {
             for(ParkingSpot next : floor.getSpots()){
                 if(next.getSpotType().equals(vehicle.getVehicleType())){
                     return Optional.of(next);
                 }
             }
         }
         return Optional.empty();
    }
}
