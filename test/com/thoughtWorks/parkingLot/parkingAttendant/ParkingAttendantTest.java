package com.thoughtWorks.parkingLot.parkingAttendant;

import com.thoughtWorks.Traveller.Traveller;
import com.thoughtWorks.Traveller.Vehicle;
import com.thoughtWorks.parkingLot.ParkingLot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by user on 4/23/2015.
 */
public class ParkingAttendantTest {
    private static final String NO_PARKING_LOT_AVAILABLE = "No parking lot available";
    private static final String INVALID_PARKINGLOT_LIST = "Invalid Parking Lot List" ;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /*@Test
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
    }*/

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
        Double parkingId = parkingAttendant.parkVehicle(new Vehicle());

    }

    @Test
    public void testIfParkingLotListisNotValid() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage(INVALID_PARKINGLOT_LIST);
        List<ParkingLot> parkingLotList = null;
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLotList);
    }

    @Test
    public void testGetVehicleForRequestedParkingId() throws Exception {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        Vehicle vehicle = new Vehicle();
        ParkingLot parkingLot = mock(ParkingLot.class);
        parkingLotList.add(parkingLot);
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLotList);
        when(parkingLot.park((Vehicle)any())).thenReturn(9.0);
        Double parkingId = parkingAttendant.parkVehicle(vehicle);
        Vehicle returnedVehicle = parkingAttendant.unParkVehicle(parkingId);
        assertThat(returnedVehicle, is(vehicle));

    }

   /* @Test
    public void testIfVehicleParksInMaxParkingLotSize() throws Exception {
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingLot thirdParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        parkingLotList.add(thirdParkingLot);
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLotList);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner(parkingAttendant);
        parkingLotOwner.intimateParkingAttendantForFestiveseason();

        ParkingLotFindStrategy festiveParkingLotFindStrategy  = mock(FestiveParkingLotFindStrategy.class);
        parkingAttendant.parkVehicle(new Vehicle());
        verify(festiveParkingLotFindStrategy).findParkingLot((List) any());

    }*/

}