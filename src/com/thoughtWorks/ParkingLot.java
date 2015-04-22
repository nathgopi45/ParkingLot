package com.thoughtWorks;

import java.util.Arrays;

/**
 * Created by user on 4/21/2015.
 */
public class ParkingLot {
    private ParkingSpace parkingSpaces[];
     public ParkingLot(int lenghtOfparkingLot){
         parkingSpaces=new ParkingSpace[lenghtOfparkingLot];
         ParkingSpace parkingSpace=new ParkingSpace(true);
         Arrays.fill(parkingSpaces,parkingSpace);
     }

    public int getParkingSpaces() {
        return parkingSpaces.length;
    }

    public boolean isParkingSpaceAvailable() {
        for(int i=0;i<parkingSpaces.length;i++){
                if(parkingSpaces[i].isAvailable())
                    return true;
            }
        return false;
    }

    public String park(Vehicle veh) throws Exception{
        for(int i=0;i<parkingSpaces.length;i++){
            if(parkingSpaces[i].isAvailable()) {
                parkingSpaces[i].engage();
                return "SUCCESS";
            }
        }
        throw new Exception("");
    }



}
