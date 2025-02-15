package com.parkinglot;

public class EntryGate {
    private ParkingLot parkingLot;

    public EntryGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpot processEntry(Vehicle vehicle) {
        return parkingLot.assignSpot(vehicle);
    }
}