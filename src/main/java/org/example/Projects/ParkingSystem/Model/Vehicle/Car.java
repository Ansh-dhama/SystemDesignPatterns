package org.example.Projects.ParkingSystem.Model.Vehicle;

import org.example.Projects.ParkingSystem.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}