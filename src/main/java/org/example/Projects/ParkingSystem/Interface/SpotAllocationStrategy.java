package org.example.Projects.ParkingSystem.Interface;

import org.example.Projects.ParkingSystem.Model.ParkingLot.Floor;
import org.example.Projects.ParkingSystem.Model.ParkingSpot.ParkingSpot;
import org.example.Projects.ParkingSystem.Model.Vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface SpotAllocationStrategy {
    Optional<ParkingSpot> findSpot(List<Floor> floors, Vehicle vehicle);
}