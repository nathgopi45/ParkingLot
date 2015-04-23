package com.thoughtWorks;

import com.thoughtWorks.Traveller.Traveller;
import com.thoughtWorks.Traveller.Vehicle;
import com.thoughtWorks.parkingLot.ParkingLot;
import com.thoughtWorks.parkingLot.parkingAttendant.ParkingLotOwner;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 4/22/2015.
 */
public class ParkingLotOwnerTest {

    @Test
    public void testIsParkingLotNotFull() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner(parkingLot);
        assertTrue(!parkingLotOwner.isParkingLotFull());

    }

    @Test(expected = Exception.class)
    public void testIsParkingLotFullWithEmptyParkingLot() throws Exception {

        ParkingLot parkingLot = null;
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner(parkingLot);

    }

    @Test
    public void testIsParkingLotFull() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner(parkingLot);
        Vehicle car = new Vehicle();
        double parkingId = parkingLot.park(car);
        assertTrue(parkingLotOwner.isParkingLotFull());
    }

    @Test
    public void testIsParkingLotFullMessagePrinting() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner(parkingLot);
        Vehicle car = new Vehicle();
        double parkingId = parkingLot.park(car);
        assertTrue(parkingLotOwner.isParkingLotFull());
    }


    @Test
    public void testIsParkingLotHasSpaceAfterUnParking() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle car = new Vehicle();
        Traveller traveller = new Traveller(car);
        double parkingId = parkingLot.park(car);
        parkingLot.unPark(parkingId);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner(parkingLot);
        assertTrue(!parkingLotOwner.isParkingLotFull());
    }



}