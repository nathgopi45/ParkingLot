package com.thoughtWorks.parkingLot.parkingAttendant;

import com.thoughtWorks.parkingLot.ParkingLot;

import java.util.List;

/**
 * Created by user on 4/23/2015.
 */
public class FestiveParkingLotFindStrategy implements ParkingLotFindStrategy {
    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLotList) throws Exception {
        ParkingLot returnParkingLot = parkingLotList.get(0);
        for(ParkingLot parkingLot : parkingLotList){
            if( ! (parkingLot.isParkingLotFull()) && (returnParkingLot.getMaximumParkingSize() < parkingLot.getMaximumParkingSize())){
                returnParkingLot = parkingLot;
            }
        }
        if(returnParkingLot.isParkingLotFull()) {
            throw new Exception("Parking Lot is Full");
        }
        return returnParkingLot;
    }
}
