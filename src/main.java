package src;

import java.util.Scanner;

public class main {
        private static boolean gameRunning = true;
        static Scanner input = new Scanner(System.in);
        private static location[][] map = new location[4][4]; 
        private static Character mainCharacter = new Character();
        private static String menuLocation;
        static Story RunningStory = new Story();


    public static void setUpGame(){
        //'location' counts as one individual room. each is one object
        // to string in the class for location display

        //chart for idiots (me)
        /*
        -------------------------
        | 0.0 | 0.1 | 0.2 | 0.3 |
        | 1.0 | 1.1 | 1.2 | 1.3 |
        | 2.0 | 2.1 | 2.2 | 2.3 |
        | 3.0 | 3.1 | 3.2 | 3.3 |
        -------------------------
        */


        // [col] [row] 
            map [3][0] = new location("Room 1 floor 1", "[3][0] Foyer", false);
            map [3][1] = new location("Room 2 floor 1", "[3][1] Elevator room", true);
            map [3][2] = new location("Room 3 floor 1", "[3][2] Rec room", false);
            map [3][3] = new location("Room 4 floor 1", "[3][3]---innacessable", false);

            map [2][0] = new location("Room 1 floor 2", "[2][0] n/a", false);
            map [2][1] = new location("Room 2 floor 2", "n/a", false);
            map [2][2] = new location("Room 3 floor 2", "n/a", false);
            map [2][3] = new location("Room 4 floor 2", "n/a", false);

            //floor 3
            map [1][0] = new location("Room 1 floor 3", "n/a", false);
            map [1][1] = new location("Room 2 floor 3", "n/a", false);
            map [1][2] = new location("Room 3 floor 3", "n/a", false);
            map [1][3] = new location("Room 4 floor 3", "n/a", false);

            //floor 4
            map [0][0] = new location("Room 1 floor 4", "n/a", false);
            map [0][1] = new location("Room 2 floor 4", "n/a", false);
            map [0][2] = new location("Room 3 floor 4", "n/a", false);
            map [0][3] = new location("Room 4 floor 4", "n/a", false);
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
        System.out.println("You are currently in...");
        System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]); 
        System.out.println("is elevator present? " + map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile());

    }

    public static void moveMenu(){

        System.out.println("\n");

        //boolean isElevatorPresent = location.getIsElevatorTile();
        if (map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile()) {
            System.out.println("1. north");
            System.out.println("2. east");
            System.out.println("3. west");
            System.out.println("4. South"); //need another condition for 1st and 3rd floor to hide north and south options
        } else {
            System.out.println("2. east");
            System.out.println("3. west");
        }


        menuLocation = input.nextLine();


            //north
        if (menuLocation.equals("1")){
            
            //can only go north if on elevator tile and not on 4th floor
            if (map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile()){
                mainCharacter.moveNorth();
                
            } else {
                
                System.out.println("Cannot go north");
            }
            

            //east
        } else if (menuLocation.equals("2")){

            //cannot go east if already at row 3 - furthest east
            if (mainCharacter.getRow() > 2){
                System.out.println(mainCharacter.getRow());
                System.out.println("Cannot go this way");
            } else {
                mainCharacter.moveEast();
                System.out.println("You have moved east. Current location:");
                System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]); 
                System.out.println("is elevator present? " + map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile());
            }
            

           

        } else if (menuLocation.equals("3")){
            mainCharacter.moveWest();
            
        } else if (menuLocation.equals("4")){
            mainCharacter.moveSouth();
        } 

    }
    

    
    public static void main(String[] args){
        setUpGame();
        System.out.println("New Game");

        //everything happens while running. Quitting stops this process
        do {

            
            /* delete comment to run story
            if (!RunningStory.isIntroCutsceneCompleted()){
                RunningStory.introCutscene(input);
            }

            if(!RunningStory.isEventFloor1Completed()){
                RunningStory.eventFloor1(input);
            }
            */
            
            


            showMenu();
            menuLocation = input.nextLine();

            if (menuLocation.equals("1")){
               showLocation();

            } else if (menuLocation.equals("2")){
                moveMenu();
                menuLocation = input.nextLine();
            }

        } while (gameRunning); //constantly looping fyi
         

    } 
}
