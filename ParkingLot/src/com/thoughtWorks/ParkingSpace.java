package com.thoughtWorks;

/**
 * Created by user on 4/21/2015.
 */
public class ParkingSpace {
    private boolean isAvailable;
public ParkingSpace(boolean isAvailable){
    this.isAvailable=isAvailable;
}

    public boolean isAvailable() {
        return isAvailable;
    }

    public void engage(){
        this.isAvailable=false;
    }
}
