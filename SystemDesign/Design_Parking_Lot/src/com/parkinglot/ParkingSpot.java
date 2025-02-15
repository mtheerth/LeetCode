package com.parkinglot;

public class ParkingSpot {
    private String id;
    private VehicleType type;
    private SpotStatus status;

    public ParkingSpot(String id, VehicleType type) {
        this.id = id;
        this.type = type;
        this.status = SpotStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void occupy() {
        this.status = SpotStatus.OCCUPIED;
    }

    public void free() {
        this.status = SpotStatus.AVAILABLE;
    }
}