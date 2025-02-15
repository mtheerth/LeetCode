package com.parkinglot;

import java.util.List;

public class ParkingLot {
    private String id;
    private String name;
    private String location;
    private List<ParkingSpot> spots;

    public ParkingLot(String id, String name, String location, List<ParkingSpot> spots) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.spots = spots;
    }

    public ParkingSpot assignSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.getType() == vehicle.getType() && spot.getStatus() == SpotStatus.AVAILABLE) {
                spot.occupy();
                vehicle.assignSpot(spot);
                return spot;
            }
        }
        return null; // No available spot
    }

    public void freeSpot(ParkingSpot spot) {
        spot.free();
    }
}