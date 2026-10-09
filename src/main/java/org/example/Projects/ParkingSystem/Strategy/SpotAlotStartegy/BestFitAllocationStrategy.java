package org.example.Projects.ParkingSystem.Strategy.SpotAlotStartegy;

import org.example.Projects.ParkingSystem.Interface.SpotAllocationStrategy;
import org.example.Projects.ParkingSystem.Model.ParkingLot.Floor;
import org.example.Projects.ParkingSystem.Model.ParkingSpot.ParkingSpot;
import org.example.Projects.ParkingSystem.Model.Vehicle.Vehicle;
import org.example.Projects.ParkingSystem.enums.ParkingSpotType;
import org.example.Projects.ParkingSystem.enums.VehicleType;

import java.util.List;
import java.util.Optional;

public class BestFitAllocationStrategy implements SpotAllocationStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(List<Floor> floors, Vehicle vehicle) {
        ParkingSpot candidate = null;

        for (Floor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (!spot.isAvailable() || !spot.canFitVehicle(vehicle)) continue;

                // Exact match takes priority
                if (vehicle.getVehicleType() == VehicleType.CAR ) {
                    return Optional.of(spot);
                }
                if (vehicle.getVehicleType() == VehicleType.TRUCK ) {
                    return Optional.of(spot);
                }

                if (candidate == null) {
                    candidate = spot;
                }
            }
        }
        return Optional.ofNullable(candidate);
    }
}