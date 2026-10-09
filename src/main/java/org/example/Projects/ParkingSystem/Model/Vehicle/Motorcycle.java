package org.example.Projects.ParkingSystem.Model.Vehicle;

import org.example.Projects.ParkingSystem.enums.VehicleType;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, VehicleType.MOTORCYCLE);
    }
}