package org.example.Projects.ParkingSystem.Model.ParkingLot;

import org.example.Projects.ParkingSystem.Model.ParkingSpot.ParkingSpot;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Floor {
    private final int floorNumber;
    private final List<ParkingSpot> spots = new CopyOnWriteArrayList<>();

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getSpots() {
        return Collections.unmodifiableList(spots);
    }
}