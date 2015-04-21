package com.thoughtWorks.test;

import com.thoughtWorks.ParkingLot;
import com.thoughtWorks.ParkingSpace;
/*import com.thoughtWorks.Vehicle;*/
import com.thoughtWorks.Vehicle;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 4/21/2015.
 */
public class ParkingLotTest {


    @Test
    public void shouldCreateParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2);
        assertTrue(parkingLot.getParkingSpaces()>0);
    }

    @Test
    public void testIfParkingSpaceIsAvailable() {

        ParkingLot parkingLot = new ParkingLot(2);
        assertTrue(parkingLot.isParkingSpaceAvailable());
    }

    @Test
    public void testIfVehicleCanPark() throws Exception{
        ParkingLot parkingLot = new ParkingLot(2);
        assertTrue(parkingLot.park(new Vehicle()).equalsIgnoreCase("SUCCESS"));
    }

    @Test(expected = Exception.class)
    public void testIfParkSpaceIsFull() throws Exception{
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Vehicle());
        parkingLot.park(new Vehicle());
    }


}
