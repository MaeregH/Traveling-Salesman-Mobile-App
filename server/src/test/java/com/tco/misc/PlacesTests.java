package com.tco.misc;

import com.tco.misc.Places;
import com.tco.misc.Place;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PlacesTests {
    
    Places places;

    @BeforeEach
    public void createPlaces(){
        places = new Places();
    }

    @Test
    @DisplayName("llewark: successfully add place")
    public void addPlace(){
        places.add(new Place("30", "40"));
        assertEquals(places.size(), 1);
    }

    @Test
    @DisplayName("llewark: successfully remove place")
    public void removePlace(){
        Place place = new Place("70", "20");
        places.add(place);
        places.remove(place);
        assertEquals(places.size(), 0);
    }

    @Test
    @DisplayName("aidanmih: add a lot of places with random coordinates")
    public void addManyPlaces(){
        for(int i = 0; i < 1000; i++){
            places.add(new Place(String.valueOf(Math.random() * 100), String.valueOf(Math.random() * 100)));
        }
        assertEquals(places.size(), 1000);
    }
}
