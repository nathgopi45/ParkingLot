package com.thoughtWorks.parkingLot.parkingAttendant;

import com.thoughtWorks.Traveller.Traveller;
import com.thoughtWorks.Traveller.Vehicle;
import com.thoughtWorks.parkingLot.ParkingLot;
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
public class ParkingAttendantTest {
    private static final String NO_PARKING_LOT_AVAILABLE = "No parking lot available";
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testIfParkingAttendantRetursAvilableParkingLot() throws Exception {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot seconParkingLot = new ParkingLot(1);
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(seconParkingLot);

        Vehicle firstVehicle = new Vehicle();
        Vehicle secondVehicle = new Vehicle();
        firstParkingLot.park(firstVehicle);

        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLotList);

        Traveller traveller = new Traveller(secondVehicle);
        ParkingLot parkingLot = parkingAttendant.getAvailbleParkingLot();

        assertThat(parkingLot, is(seconParkingLot));
    }

    @Test
    public void testIfParkingAttendantShowsNoAvailableParkingLotWhenAllParkingLotIsFull() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage(NO_PARKING_LOT_AVAILABLE);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot seconParkingLot = new ParkingLot(1);
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(seconParkingLot);

        Vehicle firstVehicle = new Vehicle();
        Vehicle secondVehicle = new Vehicle();
        firstParkingLot.park(firstVehicle);
        seconParkingLot.park(secondVehicle);

        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLotList);

        Traveller traveller = new Traveller(secondVehicle);
        ParkingLot parkingLot = parkingAttendant.getAvailbleParkingLot();

    }

    @Test
    public void testIfParkingLotListisNotValid(){
        List<ParkingLot> parkingLotList = null;
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLotList);
    }

}