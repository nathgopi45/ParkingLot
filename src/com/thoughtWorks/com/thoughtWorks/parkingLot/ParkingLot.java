package com.thoughtWorks.com.thoughtWorks.parkingLot;

import com.thoughtWorks.Traveller.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 4/21/2015.
 */
public class ParkingLot {

    private final int maximumParkingSize ;
    private static int currentParkingLotSize = 0;
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

    private boolean isParkingSpaceAvailable() {
        if(maximumParkingSize >= ( currentParkingLotSize+1) )
            return true;
        return false;
    }

    public double park(Vehicle vehicle) throws Exception{

        if (isParkingSpaceAvailable()) {
            currentParkingLotSize++;
            double parkingId = Math.random();
            parkedVehicleDetail.put(parkingId,vehicle);
            return parkingId;
        }
        throw new Exception("");
    }

    public Vehicle unPark(double parkingId) throws Exception

    {
        Vehicle vehicle =parkedVehicleDetail.get(parkingId);
        if(vehicle == null) throw new Exception();

        return vehicle;

    }



}
