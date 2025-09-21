package com.tco.misc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OptimizerFactoryTest {

    
    @Test
    @DisplayName("cortega2: Test few places with average response time")
    void testFewPlaces() {
        TourConstruction optimizer = OptimizerFactory.get(50, 0.3);
        assertTrue(optimizer instanceof TwoOptimizer, "Expected TwoOptimizer based on benchmarking");
    }

    @Test
    @DisplayName("cortega2: Test NoOpt")
    void testGetWithResponseZeroOrLess() {
        TourConstruction optimizer = OptimizerFactory.get(10, 0.0);
        assertTrue(optimizer instanceof NoOptimizer, "Expected NoOpt");

        optimizer = OptimizerFactory.get(10, -1.0);
        assertTrue(optimizer instanceof NoOptimizer, "Expected NoOpt");
    }
    
    @Test
    @DisplayName(" c836195417: Test with expected values to get twoOpt based on benchmarking")
    void testGetTwoOpt() {
        TourConstruction optimizer = OptimizerFactory.get(500, 2.25);
        assertTrue(optimizer instanceof TwoOptimizer, "Expected TwoOptimizer for 500 places and response 2");
    }
    @Test
    @DisplayName(" c836195417: Test with expected values to get oneOpt based on benchmarking")
    void testGetWithResponseGreaterThanOrEqualToTwoThirds() {
        TourConstruction optimizer = OptimizerFactory.get(500, 0.6);
        assertTrue(optimizer instanceof OneOptimizer, "Expected oneOptimizer for 500 places and response 0.6");
    }
}
