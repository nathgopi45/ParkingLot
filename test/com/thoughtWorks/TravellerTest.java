package com.thoughtWorks;

import com.thoughtWorks.Traveller.Traveller;
import com.thoughtWorks.Traveller.Vehicle;
import com.thoughtWorks.parkingLot.ParkingLot;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by user on 4/22/2015.
 */
public class TravellerTest {


    @Test
    public void testParkMyCar() throws Exception {
        Traveller traveller = new Traveller(new Vehicle());
        ParkingLot parkingLot = new ParkingLot(2);
        Double parkingId = traveller.parkMyCar(parkingLot);
        Assert.assertNotNull(parkingId);

    }

    @Test
    public void testUnParkMyCar() throws Exception {
        Vehicle vehicle = new Vehicle();
        Traveller traveller = new Traveller(vehicle);
        ParkingLot parkingLot = new ParkingLot(2);
        Double parkingId = traveller.parkMyCar(parkingLot);
        Vehicle returnedCar = traveller.unParkMyCar(parkingLot);
        Assert.assertTrue(returnedCar==vehicle);
    }
}