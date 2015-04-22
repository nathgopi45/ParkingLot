package com.thoughtWorks.com.thoughtWorks.parkingLot;

/**
 * Created by user on 4/22/2015.
 */
public class ParkingLotOwner {

    private ParkingLot parkingLot;

    public ParkingLotOwner(ParkingLot parkingLot) throws Exception
    {
        if(null == parkingLot) throw new Exception();
        this.parkingLot = parkingLot;
    }

    private boolean isParkingLotFull()
    {
        return parkingLot.isParkingLotFull();
    }

    public String checkParkingLotisFULL(){

        if(isParkingLotFull()){
            return "FULL";
        }
        return "NOT FULL";
    }

}
