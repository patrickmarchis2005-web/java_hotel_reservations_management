package com.gl.app.testAddHotel;

import com.gl.app.entity.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestHotelFunctionality {
    private Hotel hotel;

    @BeforeEach
    public void setup() {
        hotel = new Hotel("DoubleTree by Hilton", "Cluj-Napoca");
    }

    @Test
    void testAddHotelDetails() {
        assertNotNull(hotel);
        assertEquals("DoubleTree by Hilton", hotel.getName());
        assertEquals("Cluj-Napoca", hotel.getLocation());

        hotel.setName("TripleTree by Maven");
        hotel.setLocation("Gilau");

        assertEquals("TripleTree by Maven", hotel.getName());
        assertEquals("Gilau", hotel.getLocation());
    }
}
