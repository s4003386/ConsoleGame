//package src;

import java.util.Scanner;


//for location data on specific tiles or whatever

/**
 * This class simply holds the attributes for the location object
 * Each tile gets a name, description and title.
 * These objects are made in the Main class (setUpGame)
 */
public class location {

    private String locationName;
    private String locationDescription;
    private boolean isElevatorTile;


    //map
    public location(String locationName, String locationDescription, boolean isElevatorTile){
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.isElevatorTile = isElevatorTile; 
    }

    public boolean getIsElevatorTile(){
        return isElevatorTile;
    }


        
    @Override
    public String toString() {
        return locationName + " - " + locationDescription;
    }


}
