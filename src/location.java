package src;

import java.util.Scanner;


//for location data on specific tiles or whatever

public class location {

    private String locationName;
    private String locationDescription;
    private static boolean isElevatorTile;


    //map
    public location(String locationName, String locationDescription, boolean isElevatorTile){
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.isElevatorTile = isElevatorTile;
    }

    public static boolean getIsElevatorTile(){
        return isElevatorTile;
    }




    
    //create player
    /* 
    public static void createPlayer(){
        System.out.println("\n ======== Character creation");

        System.out.print("Enter character name");
        String name = input.nextLine();

        //create the player object
        player new Character(name);

    }*/

        
    @Override
    public String toString() {
        return locationName + " - " + locationDescription;
    }


}
