package com.thoughtWorks.parkingLot;

import com.thoughtWorks.Traveller.Vehicle;
import com.thoughtWorks.parkingLot.FBIAgent.FBIAgent;
import com.thoughtWorks.parkingLot.parkingAttendant.ParkingLotOwner;

import java.util.*;

/**
 * Created by user on 4/21/2015.
 */
public class ParkingLot extends Observable {



    private final int maximumParkingSize ;

    public int getMaximumParkingSize() {
        return maximumParkingSize;
    }

    private  int currentParkingLotSize = 0;
    private static Map<Double, Vehicle> parkedVehicleDetail = new HashMap<Double,Vehicle>();

    private List<Observer> subscriberFor100PercentFull =  new ArrayList<Observer>();

    private List<Observer> subscriberFor80PercentFull =  new ArrayList<Observer>();

    public List<Observer> getSubscriberFor80PercentFull() {
        return subscriberFor80PercentFull;
    }

    public List<Observer> getSubscriberFor100PercentFull() {
        return subscriberFor100PercentFull;
    }

     public ParkingLot(int maximumParkingSize) throws  Exception{
        if(maximumParkingSize <=0) throw new Exception();
         this.maximumParkingSize = maximumParkingSize;
     }

   public boolean isParkingLotFull()
    {
        if(maximumParkingSize ==  currentParkingLotSize )
            return true;
        return false;
    }

    private void notifyParkingLotOwnerIfParkingLotFull()
    {
        if(isParkingLotFull()){

           for(Observer observer : subscriberFor100PercentFull)
           {
               observer.update(this,true);
           }
        }
    }

    private void notifyFBIAgentIfParkingLotIs80PercentFull(){

        if(isParkingLotIs80PercentFull()){
            for(Observer observer : subscriberFor80PercentFull)
            {
                observer.update(this,true);
            }
        }
    }
    private boolean isParkingLotIs80PercentFull(){

        int eightyPercentSize = (int) (maximumParkingSize*0.8);
        if(currentParkingLotSize>=eightyPercentSize){
            return true;
        }
        return false;
    }
    public double park(Vehicle vehicle) throws Exception{

        if(null == vehicle) throw new Exception();

        if (!isParkingLotFull()) {
            currentParkingLotSize++;
            double parkingId = Math.random();
            parkedVehicleDetail.put(parkingId,vehicle);
            notifyParkingLotOwnerIfParkingLotFull();
            notifyFBIAgentIfParkingLotIs80PercentFull();
            return parkingId;
        }
        throw new Exception("");
    }

    public Vehicle unPark(double parkingId) throws Exception

    {
        Vehicle vehicle =parkedVehicleDetail.get(parkingId);
        if(vehicle == null) throw new Exception();

        if(currentParkingLotSize==maximumParkingSize)
        {
            for(Observer observer : subscriberFor100PercentFull)
            {
                observer.update(this,false);
            }
        }
        currentParkingLotSize--;
        return vehicle;

    }


    public void addObserverFor100PercentFull(ParkingLotOwner parkingLotOwner) {
        subscriberFor100PercentFull.add(parkingLotOwner);
    }

    public void addObserverFor80PercentFull(FBIAgent fbiAgent) {
        subscriberFor80PercentFull.add(fbiAgent);
    }
}
