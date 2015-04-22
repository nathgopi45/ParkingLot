package com.thoughtWorks;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here

        Traveller traveller = new Traveller(new Vehicle());
        ParkingLot parkingLot = ParkingLot.getParkingLotInstance(3);
        traveller.parkMyCar(parkingLot);
    }
}
