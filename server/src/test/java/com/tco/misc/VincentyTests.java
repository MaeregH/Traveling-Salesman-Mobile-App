
package com.tco.misc;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class VincentyTests {

    @Test
    @DisplayName("cortega2: vincenty distances with zero return")
    public void testVincentyCalc_withZeroReturn(){
        VincentyCalculator calculation= new VincentyCalculator();

        GeographicCoordinate from =  new Geo(0, 0);
        GeographicCoordinate to = new Geo(0, 0);
        double earthRadius = 3958;

        long distance = calculation.between(from, to, earthRadius);

        assertEquals(0, distance);
    }

    @Test
    @DisplayName("llewark: vincenty distance of points equal distances from prime meridian")
    public void testVincentyEqualDistancesLat(){
        VincentyCalculator calculation = new VincentyCalculator();
        GeographicCoordinate from = new Geo(0, 0);
        GeographicCoordinate to1 = new Geo(50, 0);
        GeographicCoordinate to2 = new Geo(-50, 0);
        double earthRadius = 1251;

        long distance1 = calculation.between(from, to1, earthRadius);
        long distance2 = calculation.between(from, to2, earthRadius);

        assertEquals(distance1, distance2);
    }
    
    @Test
    @DisplayName("llewark: vincenty distance of points equal distances from equator")
    public void testVincentyEqualDistancesLong(){
        VincentyCalculator calculation = new VincentyCalculator();
        GeographicCoordinate from = new Geo(0, 0);
        GeographicCoordinate to1 = new Geo(0, 20);
        GeographicCoordinate to2 = new Geo(0, -20);
        double earthRadius = 7000;

        long distance1 = calculation.between(from, to1, earthRadius);
        long distance2 = calculation.between(from, to2, earthRadius);

        assertEquals(distance1, distance2);
    }

    @Test
    @DisplayName("maereg: small vincenty distance")
    public void testVincentySmallDistance() {
    VincentyCalculator calculation = new VincentyCalculator();
    
    GeographicCoordinate from = new Geo(39.633559, -106.357211); // Reference point
    GeographicCoordinate to = new Geo(39.633560, -106.357211);   // 1 meter to the north
    
    double earthRadius = 3958; // radius in miles

    long distance = calculation.between(from, to, earthRadius);

    assertEquals(1, distance, 1); //tolerance of 1 
    }

    @Test
    @DisplayName("aidanmih: Large vincenty distance")
    public void testVincentyLargeDistance() {
        VincentyCalculator calculation = new VincentyCalculator();

        GeographicCoordinate from = new Geo(39.633559, -106.357211);
        GeographicCoordinate to = new Geo(-12.0665, -77.0393);

        double earthRadius = 3958; // radius in miles

        long distance = calculation.between(from, to, earthRadius);

        assertEquals(4025, distance, 15); //tolerance of 15
    }
}
