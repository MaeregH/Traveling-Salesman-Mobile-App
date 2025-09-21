package com.tco.misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorFactoryTest {
    
    @Test
    @DisplayName("aidanmih: Test getHaversineCalculator")
    public void testGetHaversineCalculator() {
        DistanceCalculator calculator = CalculatorFactory.get("haversine");
        assertTrue(calculator instanceof HaversineCalculator);
    }

    @Test
    @DisplayName("cortega2: Test vincentyCalc")
    public void testVincentyCalculator() {
        DistanceCalculator calculator = CalculatorFactory.get("vincenty");
        assertTrue(calculator instanceof VincentyCalculator);
    }
    @Test
    @DisplayName("cortega2: Test cosineCalc")
    public void testCosineCalculator() {
        DistanceCalculator calculator = CalculatorFactory.get("cosines");
        assertTrue(calculator instanceof CosinesCalculator);
    }

    @Test
    @DisplayName("cortega2: Test unknown formula to return Vincenty as default")
    void testVincentyFormulaDefault() {
        DistanceCalculator calculator = CalculatorFactory.get("unknownFormula");
        assertTrue(calculator instanceof VincentyCalculator, "Expected VincentyCalculator instance by default");
    }

    @Test
    @DisplayName("cortega2: Test empty formula should defauly to vincenty")
    void testEmptyFormulaReturnsVincentyCalculator() {
        DistanceCalculator calculator = CalculatorFactory.get("");
        assertTrue(calculator instanceof VincentyCalculator, "Expected VincentyCalculator instance for empty formula");
    }
}