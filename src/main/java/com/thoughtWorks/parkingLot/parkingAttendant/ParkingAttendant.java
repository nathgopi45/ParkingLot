package com.thoughtWorks.parkingLot.parkingAttendant;

import com.thoughtWorks.Traveller.Vehicle;
import com.thoughtWorks.parkingLot.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 4/23/2015.
 */
public class ParkingAttendant {

    private static final String INVALID_PARKINGLOT_LIST = "Invalid Parking Lot List" ;
    private boolean isFestiveSeason;
    private List<ParkingLot> parkingLotList = new ArrayList<>();

    private ParkingLotFindStrategy parkingLotFindStrategy = new NonFestiveParkingLotFindStrategy();

    private Map<Double,Vehicle> vehicleParkingMapDetails = new HashMap<>();

    public ParkingAttendant(List<ParkingLot> parkingLotList) throws Exception {
        if(parkingLotList == null) throw new Exception(INVALID_PARKINGLOT_LIST);

        this.parkingLotList = parkingLotList;
    }


    private ParkingLot getAvailbleParkingLot() throws Exception {
        for(ParkingLot parkingLot : parkingLotList){
            if( ! (parkingLot.isParkingLotFull())) return parkingLot;
        }
        throw new Exception("No parking lot available");
    }

    private ParkingLot getAvailbleParkingLotInFestiveSeason() throws Exception {
        ParkingLot returnParkingLot = parkingLotList.get(0);
        for(ParkingLot parkingLot : parkingLotList){
            if( ! (parkingLot.isParkingLotFull()) && (returnParkingLot.getMaximumParkingSize() < parkingLot.getMaximumParkingSize())){
                returnParkingLot = parkingLot;

            }
        }
        return returnParkingLot;
    }

    public double parkVehicle(Vehicle car) throws Exception {

        ParkingLot parkingLot ;

        if(isFestiveSeason){
            parkingLotFindStrategy = new FestiveParkingLotFindStrategy();

        }

        parkingLot = parkingLotFindStrategy.findParkingLot(parkingLotList);
        Double parkingId = parkingLot.park(car);
        vehicleParkingMapDetails.put(parkingId,car);
        return parkingId;
    }

    public Vehicle unParkVehicle(Double parkingId) {
        return vehicleParkingMapDetails.get(parkingId);
    }

    void setFestiveSeason() {
        this.isFestiveSeason = true;
    }
    void resetFestiveSeason() {
        this.isFestiveSeason = false;
    }

}
