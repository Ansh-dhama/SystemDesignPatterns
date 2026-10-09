package org.example.Projects.ParkingSystem.Model.ParkingSpot;

import org.example.Projects.ParkingSystem.Model.Vehicle.Vehicle;
import org.example.Projects.ParkingSystem.enums.ParkingSpotType;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ParkingSpot {
    String spotId;
    ParkingSpotType type;
    AtomicBoolean isOccupied;
    int floorNumber;
    Vehicle currentVehicle;

    public abstract boolean canFitVehicle(Vehicle vehicle);

    public ParkingSpot (int floorNumber, String spotId, ParkingSpotType type) {
        this.floorNumber = floorNumber;
        this.spotId = spotId;
        this.type = type;
    }

    public boolean assignVehicle(Vehicle v){
        if(isOccupied.get() == false) return false;
        isOccupied .set(true);
        currentVehicle = v;
        return true;
    }
    public void vacate(){
        isOccupied.set(false);
        currentVehicle = null;
    }
    public boolean isAvailable() { return !isOccupied.get(); }
    public String getSpotId() { return spotId; }
    public int getFloorNumber() { return floorNumber; }
    public ParkingSpotType getSpotType() { return type; }
    public Vehicle getCurrentVehicle() { return currentVehicle; }
}
