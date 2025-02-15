package com.parkinglot;

import java.time.Duration;
import java.time.Instant;

public class FeeCalculator {
    private static final double HOURLY_RATE = 10.0;

    public double calculateFee(Instant entryTime, Instant exitTime) {
        Duration duration = Duration.between(entryTime, exitTime);
        long hours = duration.toHours();
        return hours * HOURLY_RATE;
    }
}