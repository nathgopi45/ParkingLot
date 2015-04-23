package com.thoughtWorks.parkingLot.parkingAttendant;

import com.thoughtWorks.parkingLot.ParkingLot;

import java.util.List;

/**
 * Created by user on 4/23/2015.
 */
interface ParkingLotFindStrategy {

   public ParkingLot findParkingLot(List<ParkingLot> parkingLotList) throws Exception;
}
