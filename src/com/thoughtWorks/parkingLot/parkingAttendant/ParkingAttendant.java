package com.thoughtWorks.parkingLot.parkingAttendant;

import com.thoughtWorks.parkingLot.ParkingLot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 4/23/2015.
 */
public class ParkingAttendant {

    private List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingAttendant(List<ParkingLot> parkingLotList){
        //if(parkingLotList == null) throw new Exception();

        this.parkingLotList = parkingLotList;
    }


    public ParkingLot getAvailbleParkingLot() throws Exception {
        for(ParkingLot parkingLot : parkingLotList){
            if( ! (parkingLot.isParkingLotFull())) return parkingLot;
        }
        throw new Exception("No parking lot available");
    }
}
