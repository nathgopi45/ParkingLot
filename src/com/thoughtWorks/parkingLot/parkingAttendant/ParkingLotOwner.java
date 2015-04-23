package com.thoughtWorks.parkingLot.parkingAttendant;

import com.thoughtWorks.parkingLot.ParkingLot;
import com.thoughtWorks.parkingLot.parkingAttendant.ParkingAttendant;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by user on 4/22/2015.
 */
public class ParkingLotOwner implements Observer{

    private ParkingAttendant parkingAttendant;

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
        parkingLot.addObserverFor100PercentFull(this);
    }

    public ParkingLotOwner(ParkingAttendant parkingAttendant) throws Exception
    {
        this.parkingAttendant = parkingAttendant;
    }

    public boolean isParkingLotFull()
    {
        return this.isParkingLotFull;
    }

    public void intimateParkingAttendantForFestiveseason() {

    }

}
