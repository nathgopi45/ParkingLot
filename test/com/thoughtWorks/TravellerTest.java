package com.thoughtWorks;

import org.junit.Test;

/**
 * Created by user on 4/22/2015.
 */
public class TravellerTest {

    @Test
    public void testParkMyCar() throws Exception {
        Traveller traveller = new Traveller(new Vehicle());
        traveller.parkMyCar();

    }

    @Test
    public void testUnParkMyCar() throws Exception {
        Traveller traveller = new Traveller(new Vehicle());
        traveller.unParkMyCar();
    }
}