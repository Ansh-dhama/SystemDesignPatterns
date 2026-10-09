package org.example.Projects.ParkingSystem.Model.ParkingLot;

import org.example.Projects.ParkingSystem.Model.ParkingSpot.ParkingSpot;
import org.example.Projects.ParkingSystem.Model.Vehicle.Vehicle;

import java.time.Instant;

public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot assignedSpot;
    private final Instant entryTime;
    private Instant exitTime;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot assignedSpot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.assignedSpot = assignedSpot;
        this.entryTime = Instant.now();
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getAssignedSpot() { return assignedSpot; }
    public Instant getEntryTime() { return entryTime; }
    public Instant getExitTime() { return exitTime; }
}