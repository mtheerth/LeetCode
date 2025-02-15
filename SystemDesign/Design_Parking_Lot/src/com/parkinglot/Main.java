package com.parkinglot;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create parking spots
        ParkingSpot spot1 = new ParkingSpot("1", VehicleType.CAR);
        ParkingSpot spot2 = new ParkingSpot("2", VehicleType.BIKE);
        ParkingSpot spot3 = new ParkingSpot("3", VehicleType.TRUCK);
        List<ParkingSpot> spots = Arrays.asList(spot1, spot2, spot3);

        // Create parking lot
        ParkingLot parkingLot = new ParkingLot("PL1", "Main Parking Lot", "123 Main St", spots);

        // Create entry and exit gates
        EntryGate entryGate = new EntryGate(parkingLot);
        ExitGate exitGate = new ExitGate(parkingLot, new FeeCalculator());

        // Create a vehicle
        Vehicle car = new Vehicle("V1", VehicleType.CAR, "ABC123");
        Vehicle car2 = new Vehicle("V2", VehicleType.BIKE, "ABCbike");
        Vehicle car3 = new Vehicle("V3", VehicleType.TRUCK, "TRUCK");
        
        Vehicle car4 = new Vehicle("V4", VehicleType.CAR, "Car4");
        Vehicle car5 = new Vehicle("V5", VehicleType.CAR, "car5");

        // Process entry
        ParkingSpot assignedSpot = entryGate.processEntry(car);
        ParkingSpot assignedSpot2 = entryGate.processEntry(car2);
        ParkingSpot assignedSpot3 = entryGate.processEntry(car3);
        ParkingSpot assignedSpot4 = entryGate.processEntry(car4);
        ParkingSpot assignedSpot5 = entryGate.processEntry(car5);
        
        if (assignedSpot != null) {
            System.out.println("Vehicle " + car.getLicensePlate() + " assigned to spot " + assignedSpot.getId());
        } else {
            System.out.println("No available spot for vehicle " + car.getLicensePlate());
        }
        if (assignedSpot2 != null) {
            System.out.println("Vehicle " + car2.getLicensePlate() + " assigned to spot " + assignedSpot2.getId());

        } else {
            System.out.println("No available spot for vehicle " + car2.getLicensePlate());
        }
        if (assignedSpot3 != null) {
            System.out.println("Vehicle " + car3.getLicensePlate() + " assigned to spot " + assignedSpot3.getId());

        } else {
            System.out.println("No available spot for vehicle " + car3.getLicensePlate());
        }
        if (assignedSpot4 != null) {
            System.out.println("Vehicle " + car4.getLicensePlate() + " assigned to spot " + assignedSpot4.getId());
        } else {
            System.out.println("No available spot for vehicle " + car4.getLicensePlate());
        }
        if (assignedSpot5 != null) {
            System.out.println("Vehicle " + car5.getLicensePlate() + " assigned to spot " + assignedSpot5.getId());

        } else {
            System.out.println("No available spot for vehicle " + car5.getLicensePlate());
        }

        // Simulate parking duration
        try {
            Thread.sleep(5000); // Simulate 5 seconds of parking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Process exit
        double fee = exitGate.processExit(car, Instant.now());
        System.out.println("Vehicle " + car.getLicensePlate() + " exited. Fee: $" + fee);
    }
}