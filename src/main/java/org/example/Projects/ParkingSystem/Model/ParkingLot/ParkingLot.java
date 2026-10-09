package org.example.Projects.ParkingSystem.Model.ParkingLot;

import java.util.Collections;
import java.util.List;

public class ParkingLot {
    private final String lotId;
    private final List<Floor> floors;

    public ParkingLot(String lotId, List<Floor> floors) {
        this.lotId = lotId;
        this.floors = floors;
    }

    public String getLotId() { return lotId; }
    public List<Floor> getFloors() { return Collections.unmodifiableList(floors); }
}