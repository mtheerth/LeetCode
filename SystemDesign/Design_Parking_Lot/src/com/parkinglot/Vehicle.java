package com.parkinglot;

import java.time.Instant;

public class Vehicle {
    private String id;
    private VehicleType type;
    private String licensePlate;
    private ParkingSpot spot;
    private Instant entryTime;

    public Vehicle(String id, VehicleType type, String licensePlate) {
        this.id = id;
        this.type = type;
        this.licensePlate = licensePlate;
    }

    public String getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public void assignSpot(ParkingSpot spot) {
        this.spot = spot;
        this.entryTime = Instant.now();
    }
}