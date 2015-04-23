package com.thoughtWorks;

import com.thoughtWorks.Traveller.Traveller;
import com.thoughtWorks.Traveller.Vehicle;
import com.thoughtWorks.parkingLot.ParkingLot;
import com.thoughtWorks.parkingLot.parkingAttendant.ParkingAttendant;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by user on 4/22/2015.
 */
public class TravellerTest {
    @Rule
   public ExpectedException expectedException = ExpectedException.none();

    private static final String NO_PARKING_LOT_AVILBLE = "no parking lot available";
    ParkingAttendant parkingAttendant;

    @Test
    public void testParkMyCar() throws Exception {
        parkingAttendant=mock(ParkingAttendant.class);
        ParkingLot parkingLot = new ParkingLot(1);
        when(parkingAttendant.getAvailbleParkingLot()).thenReturn(parkingLot);
        Traveller traveller = new Traveller(new Vehicle());
        Double parkingId = traveller.parkMyCar(parkingAttendant);
        Assert.assertNotNull(parkingId);

    }

    @Test
    public void testUnParkMyCar() throws Exception {
        parkingAttendant=mock(ParkingAttendant.class);
        Vehicle vehicle = new Vehicle();
        Traveller traveller = new Traveller(vehicle);
        ParkingLot parkingLot = new ParkingLot(2);
        when(parkingAttendant.getAvailbleParkingLot()).thenReturn(parkingLot);
        Double parkingId = traveller.parkMyCar(parkingAttendant);
        Vehicle returnedCar = traveller.unParkMyCar(parkingLot);
        Assert.assertTrue(returnedCar == vehicle);
    }

    @Test
    public void testIfNoSpaceAvailableMessageIfNoParkingLotAvailable() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage(NO_PARKING_LOT_AVILBLE);
        parkingAttendant = mock(ParkingAttendant.class);
        Exception exception = new Exception(NO_PARKING_LOT_AVILBLE);
        when(parkingAttendant.getAvailbleParkingLot()).thenThrow(exception);
        Vehicle vehicle = new Vehicle();
        Traveller traveller = new Traveller(vehicle);/*
        ParkingLot firstParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(firstParkingLot);
        ParkingAttendant parkingAttendantToPark = new ParkingAttendant(parkingLotList);*/
        traveller.parkMyCar(parkingAttendant);
    }


}