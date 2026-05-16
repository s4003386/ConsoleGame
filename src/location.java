package src;

import java.util.Scanner;

public class location {

    private String locationName;
    private String locationDescription;


    //map
    public location(String locationName, String locationDescription){
        this.locationName = locationName;
        this.locationDescription = locationDescription;
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
