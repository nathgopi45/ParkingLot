package com.thoughtWorks;

import com.thoughtWorks.com.thoughtWorks.parkingLot.ParkingLot;
import com.thoughtWorks.com.thoughtWorks.parkingLot.ParkingLotOwner;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 4/22/2015.
 */
public class ParkingLotOwnerTest {

    @Test
    public void testIsParkingLotFull() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner(parkingLot);
        boolean isParkingLotFull = parkingLotOwner.isParkingLotFull();
        assertTrue(!isParkingLotFull);

    }
}