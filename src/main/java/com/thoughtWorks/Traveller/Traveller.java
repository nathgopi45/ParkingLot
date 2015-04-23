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
        this.parkingId = parkingAttendant.parkVehicle(this.car);
       return this.parkingId;
    }

    public Vehicle unParkMyCar(ParkingAttendant parkingAttendant,double parkingId) throws Exception
    {
        return  parkingAttendant.unParkVehicle(parkingId);

    }

}
