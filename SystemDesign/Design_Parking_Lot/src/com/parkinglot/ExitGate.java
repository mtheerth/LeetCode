package com.parkinglot;

import java.time.Instant;

public class ExitGate {
    private ParkingLot parkingLot;
    private FeeCalculator feeCalculator;

    public ExitGate(ParkingLot parkingLot, FeeCalculator feeCalculator) {
        this.parkingLot = parkingLot;
        this.feeCalculator = feeCalculator;
    }

    public double processExit(Vehicle vehicle, Instant exitTime) {
        ParkingSpot spot = vehicle.getSpot();
        parkingLot.freeSpot(spot);
        return feeCalculator.calculateFee(vehicle.getEntryTime(), exitTime);
    }
}