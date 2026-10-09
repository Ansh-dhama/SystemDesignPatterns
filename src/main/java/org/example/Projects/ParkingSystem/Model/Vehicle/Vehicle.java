package org.example.Projects.ParkingSystem.Model.Vehicle;

import org.example.Projects.ParkingSystem.enums.VehicleType;

public abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType vehicleType;

    protected Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() { return licensePlate; }
    public VehicleType getVehicleType() { return vehicleType; }
}