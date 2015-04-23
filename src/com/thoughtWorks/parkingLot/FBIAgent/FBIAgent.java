package com.thoughtWorks.parkingLot.FBIAgent;

import com.thoughtWorks.parkingLot.ParkingLot;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by user on 4/23/2015.
 */
public class FBIAgent implements Observer {

    private ParkingLot parkingLot;
    private String NO_PARKIN_LOT_ASSIGNED = "no parking lot assigned";
    private Boolean isParkingLot80PercentFull = false;

    public FBIAgent(ParkingLot parkingLot) throws Exception{
        if(null == parkingLot) throw new Exception(NO_PARKIN_LOT_ASSIGNED);
        this.parkingLot = parkingLot;
        parkingLot.addObserverFor80PercentFull(this);
    }

    @Override
    public void update(Observable observable, Object object) {
        this.isParkingLot80PercentFull = (Boolean)object;
    }



}
