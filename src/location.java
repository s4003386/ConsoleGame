package src;

import java.util.Scanner;

public class location {
    
    static Scanner input = new Scanner(System.in);

    static Character player;

    static Location[][] map = new Location [4][4];




    //create player
    public static void createPlayer(){
        System.out.println("\n ======== Character creation");

        System.out.print("Enter character name");
        String name = input.nextLine();

        //create the player object
        player new Character(name);

    }

    public static void show

    public static void showLocation(){
        //current location
        Location currentLocation - map[player.getRow()]
    }
}
