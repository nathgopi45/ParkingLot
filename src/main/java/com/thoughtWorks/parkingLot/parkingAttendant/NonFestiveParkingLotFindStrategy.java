package com.thoughtWorks.parkingLot.parkingAttendant;

import com.thoughtWorks.parkingLot.ParkingLot;

import java.util.List;

/**
 * Created by user on 4/23/2015.
 */
public class NonFestiveParkingLotFindStrategy implements ParkingLotFindStrategy {

    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLotList) throws Exception {
        for(ParkingLot parkingLot : parkingLotList){
            if( ! (parkingLot.isParkingLotFull())) return parkingLot;
        }
        throw new Exception("No parking lot available");
    }

}
