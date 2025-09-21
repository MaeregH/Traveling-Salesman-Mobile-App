package com.tco.misc;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class NearestNeighborTests {
    
    Places places;
   OneOptimizer optimizer = new OneOptimizer();
    @BeforeEach
    public void initializeTests(){
        places = new Places();
    }

    @Test
    @DisplayName("llewark: test NearestNeighbor with one place")
    public void testOnePlace(){
        double earthRadius = 6378;
        places.add(new Place("0", "0"));
        assertEquals(1, optimizer.construct(places, earthRadius, "Vincenty", 1.0).size());
    }
    

    @Test
    @DisplayName("llewark: test NearestNeighbor with two places")
    public void testTwoPlaces(){
        double earthRadius = 1200;
        places.add(new Place("10.0", "-30.0"));
        places.add(new Place("10.0", "0.0"));
        assertEquals(places.get(0), optimizer.construct(places, earthRadius, "Vincenty", 1.0).get(0));
    }

    @Test
    @DisplayName("maereg: test identical places")
    public void testIdenticalPlaces(){
        double earthRadius = 6371;
        places.add(new Place("34.0", "10.0"));
        places.add(new Place("34.0", "10.0"));
        assertEquals(2, optimizer.construct(places, earthRadius, "Vincenty", 1.0).size());
    }
  
    @Test
    @DisplayName("llewark: average list of places")
    public void averagePlaces(){
        places.add(new Place("10.0", "30.0"));
        places.add(new Place("-30.0", "20.0"));
        places.add(new Place("40.0", "-20.0"));
        places.add(new Place("15.0", "-10.0"));
        places.add(new Place("15.0", "26.0"));
        Places tour = optimizer.construct(places, 20.0, "vincenty", 1.0);
        assertTrue(optimizer.bestTourDistance < optimizer.originalTourDistance);
    }

    @Test
    @DisplayName("llewark: test square")
    public void testSquare() {
        double earthRadius = 200.0;
        places.add(new Place("45.228244", "-110.425781"));
        places.add(new Place("41.687812", "-101.531250"));
        places.add(new Place("41.820035", "-110.496093"));
        places.add(new Place("45.0693671", "-101.882812"));
        Places tour = optimizer.construct(places, earthRadius, "vincenty", 1.0);
        assertTrue(optimizer.bestTourDistance < optimizer.originalTourDistance);
    }

    
    @Test
    @DisplayName("c836195417: test with no places")
    public void testNoPlaces() {
        double earthRadius = 6371;
    
        assertTrue(places.isEmpty(), "Places should be empty when none are added.");
    }

    @Test
    @DisplayName("c836195417: test Nearest Neighbor with duplicates")
    public void testNearestNeighborWithDuplicates() {
        double earthRadius = 6371;
        places.add(new Place("34.0", "10.0"));
        places.add(new Place("34.0", "10.0")); // Duplicate place

        // Assuming construct returns both identical places
        assertEquals(2, optimizer.construct(places, earthRadius, "Vincenty", 1.0).size());
    }

    @Test
    @DisplayName("maereg: Test nearest neighbor logic with identical places")
    public void testIdenticalPlaces2() {
        Place placeA = new Place("34.0", "10.0");
        places.add(placeA);
        places.add(placeA); 

        assertEquals(2, places.size(), "Places collection should contain two entries.");

        double earthRadius = 6371.0;
        DistanceCalculator calculator = CalculatorFactory.get("Vincenty");

        double distance = calculator.between(places.get(0), places.get(1), earthRadius);
        assertEquals(0.0, distance, "Distance between identical places should be zero.");
    }

    @Test
    @DisplayName("llewark: long list of places")
    public void manyPlaces(){
        places.add(new Place("34.0", "10.0"));
        places.add(new Place("-47.0", "-10.0"));
        places.add(new Place("84.0", "15.0"));
        places.add(new Place("-34.0", "20.0"));
        places.add(new Place("57.0", "68.0"));
        places.add(new Place("20.0", "20.0"));
        places.add(new Place("-24.0", "-10.0"));
        places.add(new Place("78.0", "-20.0"));
        places.add(new Place("34.0", "20.0"));
        places.add(new Place("-89.0", "1.0"));
        places.add(new Place("7.0", "7.0"));
        places.add(new Place("26.0", "7.0"));
        places.add(new Place("11.0", "15.0"));
        places.add(new Place("7.0", "8.0"));
        places.add(new Place("16.0", "-10.0"));

        double earthRadius = 6371.0;
        Places tour = optimizer.construct(places, earthRadius, "haversine", 1.0);
        assertTrue(optimizer.bestTourDistance < optimizer.originalTourDistance);
    }
}

