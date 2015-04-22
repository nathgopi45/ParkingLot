package com.thoughtWorks.parkingLot;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by user on 4/22/2015.
 */
public class ParkingLotOwner implements Observer{

    private ParkingLot parkingLot;
    private Boolean isParkingLotFull = false;

    @Override
    public void update(Observable observable,Object object)
    {
        this.isParkingLotFull = (Boolean)object;
    }
    public ParkingLotOwner(ParkingLot parkingLot) throws Exception
    {

        if(null == parkingLot) throw new Exception();
        this.parkingLot = parkingLot;
        parkingLot.addObserver(this);
    }

    public boolean isParkingLotFull()
    {
        return this.isParkingLotFull;
    }
}
