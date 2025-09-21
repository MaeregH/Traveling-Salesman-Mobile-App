package com.tco.misc;

public class Geo implements GeographicCoordinate {
    private double latRadians;
    private double lonRadians;

    public Geo(double latDegrees, double lonDegrees) {
        // Convert latitude and longitude from degrees to radians
        this.latRadians = Math.toRadians(latDegrees);
        this.lonRadians = Math.toRadians(lonDegrees);
    }

    @Override
    public double latRadians() {
        return this.latRadians;
    }

    @Override
    public double lonRadians() {
        return this.lonRadians;
    }
}
