package com.tco.misc;

import com.tco.misc.Distances;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class DistancesTests {
    
    Distances distances;
    @BeforeEach
    public void createDistances(){
        distances = new Distances();
    }

    @Test
    @DisplayName("llewark: successfully add Distance")
    public void testAddDistance(){
        distances.add(1L);
        assertEquals(distances.size(), 1);
    }

    @Test
    @DisplayName("llewark: successfully remove Distance")
    public void testRemoveDistance(){
        distances.add(2L);
        distances.remove(2L);
        assertEquals(distances.size(), 0);
    }

    @Test
    @DisplayName("llewark: successfully calculate total distance")
    public void testDistancesTotal(){
        distances.add(10L);
        distances.add(12L);
        assertEquals(distances.total(), 22);
    }
}
