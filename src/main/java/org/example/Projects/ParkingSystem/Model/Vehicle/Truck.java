package org.example.Projects.ParkingSystem.Model.Vehicle;

import org.example.Projects.ParkingSystem.enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }
}