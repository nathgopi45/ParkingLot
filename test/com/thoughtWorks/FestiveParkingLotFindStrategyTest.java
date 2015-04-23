package com.thoughtWorks;

import com.thoughtWorks.Traveller.Vehicle;
import com.thoughtWorks.parkingLot.ParkingLot;
import com.thoughtWorks.parkingLot.parkingAttendant.FestiveParkingLotFindStrategy;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 4/23/2015.
 */
public class FestiveParkingLotFindStrategyTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFindParkingLot() throws Exception {

        FestiveParkingLotFindStrategy festiveParkingLotFindStrategy = new FestiveParkingLotFindStrategy();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingLot thirdParkingLot = new ParkingLot(3);
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        parkingLotList.add(thirdParkingLot);
        ParkingLot parkingLot = festiveParkingLotFindStrategy.findParkingLot(parkingLotList);
        assertThat(thirdParkingLot,is(parkingLot));

    }

    @Test
    public void testFindParkingLotIfAllParkingLotIsFull() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Parking Lot is Full");
        FestiveParkingLotFindStrategy festiveParkingLotFindStrategy = new FestiveParkingLotFindStrategy();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(1);
        parkingLotList.add(firstParkingLot);
        firstParkingLot.park(new Vehicle());
        ParkingLot parkingLot = festiveParkingLotFindStrategy.findParkingLot(parkingLotList);
    }


}