package com.thoughtWorks;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 4/21/2015.
 */
public class ParkingLot {

    private final int maximumParkingSize ;
    private static ParkingLot parkingLotInstance;
    private static int currentParkingLotSize = 0;
    private static Map<Double, Vehicle> parkedVehicleDetail = new HashMap<Double,Vehicle>();

     private ParkingLot(int maximumParkingSize){

         this.maximumParkingSize = maximumParkingSize;
     }

    public static ParkingLot getParkingLotInstance(int maximumParkingSize) throws Exception{
        if (maximumParkingSize <=0) throw new Exception();
        if(null == parkingLotInstance){
            parkingLotInstance = new ParkingLot(maximumParkingSize);
        }
       return parkingLotInstance;
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



}
