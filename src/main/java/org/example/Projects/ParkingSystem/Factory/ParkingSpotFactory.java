package org.example.Projects.ParkingSystem.Factory;

import org.example.Projects.ParkingSystem.Model.ParkingSpot.BikeParkingSpot;
import org.example.Projects.ParkingSystem.Model.ParkingSpot.CompactParkingSpot;
import org.example.Projects.ParkingSystem.Model.ParkingSpot.ParkingSpot;
import org.example.Projects.ParkingSystem.enums.ParkingSpotType;

public class ParkingSpotFactory {

    public ParkingSpot create(ParkingSpotType type , String spotId, int floorNumber) {
      return   switch(type) {
          case  MOTORCYCLE ->  new BikeParkingSpot(floorNumber, spotId);
          case CAR ->   new CompactParkingSpot(floorNumber, spotId);
        };
    }
}
