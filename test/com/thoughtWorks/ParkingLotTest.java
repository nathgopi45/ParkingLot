package com.thoughtWorks;

/*import com.thoughtWorks.Traveller.Vehicle;*/
import com.thoughtWorks.Traveller.Traveller;
import com.thoughtWorks.Traveller.Vehicle;

import com.thoughtWorks.parkingLot.ParkingLot;
import com.thoughtWorks.parkingLot.ParkingLotOwner;
import org.junit.Test;

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
        parkingLot.addObserver(parkingLotOwner);

        Traveller traveller = new Traveller(vehicle);
        traveller.parkMyCar(parkingLot);

        verify(parkingLotOwner).update(any(Observable.class),any());

    }

    @Test
    public void testNotifyParkingLotOwnerWhenUnparkedAndParkingLotWasFull() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle vehicle = new Vehicle();
        ParkingLotOwner parkingLotOwner = mock(ParkingLotOwner.class);
        doNothing().when(parkingLotOwner).update(any(Observable.class), any());
        Traveller traveller = new Traveller(vehicle);
        traveller.parkMyCar(parkingLot);
        parkingLot.addObserver(parkingLotOwner);
        traveller.unParkMyCar(parkingLot);
        verify(parkingLotOwner).update(any(Observable.class), any());
    }

}
