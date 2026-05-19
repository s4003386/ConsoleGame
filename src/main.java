package src;

import java.util.Scanner;

public class main {
        private static boolean gameRunning = true;
        static Scanner input = new Scanner(System.in);
        private static location[][] map = new location[4][4]; 
        private static Character mainCharacter = new Character();
        private static String menuLocation;


    public static void setUpGame(){
        //'location' counts as one individual room. each is one object
        // to string in the class for location display
            map [3][0] = new location("Room 1 floor 1", "Foyer", false);
            map [3][1] = new location("Room 2 floor 1", "Elevator room", true);
            map [3][2] = new location("Room 3 floor 1", "Rec room", false);
            map [3][3] = new location("Room 4 floor 1", " ---innacessable", false);

            map [2][0] = new location("Room 1 floor 1", "n/a", false);
            map [2][1] = new location("Room 2 floor 1", "n/a", false);
            map [2][2] = new location("Room 3 floor 1", "n/a", false);
            map [2][3] = new location("Room 4 floor 1", "n/a", false);
    }

    public static void showMenu(){
        System.out.println("=====================");
        System.out.println("Test menu");
        System.out.println("=====================");
        System.out.println("1. Show current location");
        System.out.println("2. Move to a new location");
        //and then battles or something idk. change move to a new location for after battles when that happens
    }

    public static void showLocation(){
        //soon
    }

    public static void moveMenu(){

        System.out.println("\n");

        //boolean isElevatorPresent = location.getIsElevatorTile();
        if (location.getIsElevatorTile()) {
            System.out.println("1. north");
            System.out.println("2. east");
            System.out.println("2. west");
        } else {
            System.out.println("2. east");
            System.out.println("2. west");
        }

        menuLocation = input.nextLine();
        if (menuLocation.equals("2")){

        }

        /* 
        System.out.println("\n");
        System.out.println("1. north");
        System.out.println("2. east");
        System.out.println("3. south");
        System.out.println("2. west");
        */
    }
    

    
    public static void main(String[] args){
        System.out.println("main");
        
        setUpGame();

        System.out.println("New Game");

        
        do {
            //for testing
            showMenu();
            menuLocation = input.nextLine();

            if (menuLocation.equals("1")){
                System.out.println("You are currently in...");
                System.out.println(map[mainCharacter.getRow()][mainCharacter.getCol()]); 
                System.out.println("is elevator present? " + map[mainCharacter.getRow()][mainCharacter.getCol()].getIsElevatorTile());


            } else if (menuLocation.equals("2")){
                moveMenu();
                menuLocation = input.nextLine();
            }

        } while (gameRunning);
         

    } 
}
