package com.thoughtWorks;

/*import com.thoughtWorks.Traveller.Vehicle;*/
import com.thoughtWorks.Traveller.Vehicle;

import com.thoughtWorks.com.thoughtWorks.parkingLot.ParkingLot;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 4/21/2015.
 */
public class ParkingLotTest {


    @Test
    public void shouldCreateParkingLot() throws Exception{
        ParkingLot parkingLot = new ParkingLot(2);
        assertNotNull(parkingLot);
    }

    @Test(expected = Exception.class)
    public void shouldNotCreateParkingLotWithEmptySize() throws Exception{
        ParkingLot parkingLot = new ParkingLot(0);
    }

    @Test
    public void testIfVehicleCanPark() throws Exception{
        ParkingLot parkingLot = new ParkingLot(2);
        Vehicle vehicle = new Vehicle();
        Double parkingId = parkingLot.park(vehicle);
        assertNotNull(parkingId);
    }

    @Test(expected = Exception.class)
    public void testIfParkSpaceIsFull() throws Exception{
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Vehicle());
        parkingLot.park(new Vehicle());
    }


@Test(expected = Exception.class)
public void testParkingIfVehicleIsEmpty () throws Exception
{
    ParkingLot parkingLot = new ParkingLot(1);
    Vehicle vehicle = null;
    parkingLot.park(vehicle);
}

}
