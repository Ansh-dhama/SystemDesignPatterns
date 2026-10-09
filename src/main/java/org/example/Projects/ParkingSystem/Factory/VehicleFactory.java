package org.example.Projects.ParkingSystem.Factory;

import org.example.Projects.ParkingSystem.Model.Vehicle.Car;
import org.example.Projects.ParkingSystem.Model.Vehicle.Motorcycle;
import org.example.Projects.ParkingSystem.Model.Vehicle.Truck;
import org.example.Projects.ParkingSystem.Model.Vehicle.Vehicle;
import org.example.Projects.ParkingSystem.enums.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String licensePlate) {
        return switch (type) {
            case MOTORCYCLE -> new Motorcycle(licensePlate);
            case CAR -> new Car(licensePlate);
            case TRUCK -> new Truck(licensePlate);
            case Bike -> null;
        };
    }
}