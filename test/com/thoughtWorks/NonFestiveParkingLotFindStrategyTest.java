package com.thoughtWorks;

import com.thoughtWorks.parkingLot.ParkingLot;
import com.thoughtWorks.parkingLot.parkingAttendant.FestiveParkingLotFindStrategy;
import com.thoughtWorks.parkingLot.parkingAttendant.NonFestiveParkingLotFindStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 4/23/2015.
 */
public class NonFestiveParkingLotFindStrategyTest {

    @Test
    public void testFindParkingLot() throws Exception {

        NonFestiveParkingLotFindStrategy  nonFestiveParkingLotFindStrategy = new NonFestiveParkingLotFindStrategy();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingLot thirdParkingLot = new ParkingLot(3);
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        parkingLotList.add(thirdParkingLot);
        ParkingLot parkingLot = nonFestiveParkingLotFindStrategy.findParkingLot(parkingLotList);
        assertNotNull(parkingLot);
    }
}