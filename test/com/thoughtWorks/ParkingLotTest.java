package com.thoughtWorks;

/*import com.thoughtWorks.Traveller.Vehicle;*/
import com.thoughtWorks.Traveller.Traveller;
import com.thoughtWorks.Traveller.Vehicle;

import com.thoughtWorks.parkingLot.FBIAgent.FBIAgent;
import com.thoughtWorks.parkingLot.ParkingLot;
import com.thoughtWorks.parkingLot.ParkingLotOwner;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Observable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

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


    @Test
    public void testParkingLotOwnerShouldGetNotifiedWhenFull() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle vehicle = new Vehicle();
        ParkingLotOwner parkingLotOwner = mock(ParkingLotOwner.class);
        doNothing().when(parkingLotOwner).update(any(Observable.class),any());
        parkingLot.addObserverFor100PercentFull(parkingLotOwner);

        Traveller traveller = new Traveller(vehicle);
        traveller.parkMyCar(parkingLot);

        verify(parkingLotOwner).update(any(Observable.class), any());

    }

    @Test
    public void testNotifyParkingLotOwnerWhenUnparkedAndParkingLotWasFull() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle vehicle = new Vehicle();
        ParkingLotOwner parkingLotOwner = mock(ParkingLotOwner.class);
        doNothing().when(parkingLotOwner).update(any(Observable.class), any());
        Traveller traveller = new Traveller(vehicle);
        traveller.parkMyCar(parkingLot);
        parkingLot.addObserverFor100PercentFull(parkingLotOwner);
        traveller.unParkMyCar(parkingLot);
        verify(parkingLotOwner).update(any(Observable.class), any());
    }

    @Test
    public void testIfFbiAgentGetsNotifiedIfParkingLotIs80PercentFull() throws Exception {

        FBIAgent fbiAgent = mock(FBIAgent.class);
        ParkingLot parkingLot = new ParkingLot(5);
        Vehicle firstVehicle = new Vehicle();
        Vehicle secondVehicle = new Vehicle();
        Vehicle thirdVehicle = new Vehicle();
        Vehicle fourthVehicle = new Vehicle();
        parkingLot.addObserverFor80PercentFull(fbiAgent);
        parkingLot.park(firstVehicle);
        parkingLot.park(secondVehicle);
        parkingLot.park(thirdVehicle);
        parkingLot.park(fourthVehicle);

        verify(fbiAgent,times(1)).update((ParkingLot) any(), anyObject());
    }

    @Test
    public void testIfSubscriberIsAddedFor100PercentFullParking() throws Exception {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner(parkingLot);
        parkingLot.addObserverFor100PercentFull(parkingLotOwner);

        assertTrue(parkingLot.getSubscriberFor100PercentFull().contains(parkingLotOwner));
    }

    @Test
    public void testIfSubscriberIsAddedFor80PercentFullParking() throws Exception {
        ParkingLot parkingLot = new ParkingLot(2);
        FBIAgent fbiagent = new FBIAgent(parkingLot);
        parkingLot.addObserverFor80PercentFull(fbiagent);

        assertTrue(parkingLot.getSubscriberFor80PercentFull().contains(fbiagent));
    }


}
