package com.thoughtWorks.Traveller;

import com.thoughtWorks.parkingLot.ParkingLot;
import com.thoughtWorks.parkingLot.parkingAttendant.ParkingAttendant;

/**
 * Created by user on 4/22/2015.
 */
public class Traveller {
    private Vehicle car;
    private double parkingId;

    public Traveller(Vehicle car) throws Exception
    {
        if(null == car) throw new Exception();
        this.car = car;
    }

    public double parkMyCar (ParkingAttendant parkingAttendant) throws Exception
    {

       ParkingLot parkingLot = parkingAttendant.getAvailbleParkingLot();
       return this.parkingId = parkingLot.park(this.car);
    }

    public Vehicle unParkMyCar(ParkingLot parkingLot) throws Exception
    {
        return parkingLot.unPark(this.parkingId);
    }

}
