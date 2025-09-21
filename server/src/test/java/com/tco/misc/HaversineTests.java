
package com.tco.misc;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class HaversineTests {
    @Test
    @DisplayName("llewark: haversine distance between identical points")
    public void testHaversineZeroDistance() {
        HaversineCalculator calculation= new HaversineCalculator();

        GeographicCoordinate coordinate =  new Geo(23.21, 10.95);
        double earthRadius = 1251;

        long distance = calculation.between(coordinate, coordinate, earthRadius);

        assertEquals(0, distance);
    }

    @Test
    @DisplayName("maereg: haversine distance between two points with differing latitudes but same longitude")
    public void testHaversineDifferentLatSameLon() {
        HaversineCalculator calculation = new HaversineCalculator();

        GeographicCoordinate from = new Geo(0, 0); // Equator
        GeographicCoordinate to = new Geo(90, 0); // North Pole
        double earthRadius = 6371; // Earth's radius in km

        long distance = calculation.between(from, to, earthRadius);

        assertEquals(10008, distance, "Distance from the Equator to North Pole should be about 10,008 km.");
    }

    @Test
    @DisplayName("aidanmih: haversine distance between two entirely differing points")
    public void testHaversineDifferentLatLon() {
        HaversineCalculator calculation = new HaversineCalculator();

        GeographicCoordinate from = new Geo(32.1222, -118.678); // Random point
        GeographicCoordinate to = new Geo(43.2228, -76.5483); // Random point 2
        double earthRadius = 6371; // Radius in km

        long distance = calculation.between(from, to, earthRadius);

        assertEquals(3862, distance, "Distance from the points should be about 3,862 km.");
    }    
    
    @Test
    @DisplayName("llewark: haversine distance between positive and negative latitudes")
    public void testHaversineEqualDistancesLat(){
        HaversineCalculator calculation = new HaversineCalculator();
        GeographicCoordinate from = new Geo(0, 0);
        GeographicCoordinate to1 = new Geo(-30, 0);
        GeographicCoordinate to2 = new Geo(30, 0);
        double earthRadius = 427;

        long distance1 = calculation.between(from, to1, earthRadius);
        long distance2 = calculation.between(from, to2, earthRadius);

        assertEquals(distance1, distance2);
    }

    @Test
    @DisplayName("llewark: haversine distance between positive and negative longitudes")
    public void testHaversineEqualDistancesLong(){
        HaversineCalculator calculation = new HaversineCalculator();
        GeographicCoordinate from = new Geo(0, 0);
        GeographicCoordinate to1 = new Geo(0, -30);
        GeographicCoordinate to2 = new Geo(0, 30);
        double earthRadius = 1901;

        long distance1 = calculation.between(from, to1, earthRadius);
        long distance2 = calculation.between(from, to2, earthRadius);

        assertEquals(distance1, distance2);
    }
}
