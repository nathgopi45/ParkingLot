package com.thoughtWorks;

/**
 * Created by user on 4/22/2015.
 */
public class Traveller {
    private Vehicle car;
    private double parkingId;

    public Traveller(Vehicle car)
    {
        this.car = car;
    }

    public void parkMyCar (ParkingLot parkingLot) throws Exception
    {
        this.parkingId = parkingLot.park(this.car);
    }

    public void unParkMyCar(ParkingLot parkingLot) throws Exception
    {
        parkingLot.unPark(this.parkingId);
    }

}
