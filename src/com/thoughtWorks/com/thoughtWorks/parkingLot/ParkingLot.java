package com.thoughtWorks.com.thoughtWorks.parkingLot;

import com.thoughtWorks.Traveller.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by user on 4/21/2015.
 */
public class ParkingLot extends Observable{



    private final int maximumParkingSize ;
    private  int currentParkingLotSize = 0;
    private static Map<Double, Vehicle> parkedVehicleDetail = new HashMap<Double,Vehicle>();

     public ParkingLot(int maximumParkingSize) throws  Exception{
        if(maximumParkingSize <=0) throw new Exception();
         this.maximumParkingSize = maximumParkingSize;
     }

    boolean isParkingLotFull()
    {
        if(maximumParkingSize ==  currentParkingLotSize )
            return true;
        return false;
    }

    private void notifyParkingLotOwnerIfParkingLotFull()
    {
        if(isParkingLotFull()){
            setChanged();
            notifyObservers(new Boolean(true));
        }
    }

    public double park(Vehicle vehicle) throws Exception{

        if(null == vehicle) throw new Exception();

        if (!isParkingLotFull()) {
            currentParkingLotSize++;
            double parkingId = Math.random();
            parkedVehicleDetail.put(parkingId,vehicle);
            notifyParkingLotOwnerIfParkingLotFull();
            return parkingId;
        }
        throw new Exception("");
    }

    public Vehicle unPark(double parkingId) throws Exception

    {
        Vehicle vehicle =parkedVehicleDetail.get(parkingId);
        if(vehicle == null) throw new Exception();

        if(currentParkingLotSize==maximumParkingSize)
        {
            setChanged();
            notifyObservers(new Boolean(false));
        }
        currentParkingLotSize--;
        return vehicle;

    }



}
