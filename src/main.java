package src;

import java.util.Scanner;

//something something remember 3 data types need to be used as inputs for game..?

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
            map [3][0] = new location("Floor 1 Room 1", "[3][0] Foyer", false);
            map [3][1] = new location("Floor 1 Room 2", "[3][1] Elevator room", true);
            map [3][2] = new location("Floor 1 Room 3", "[3][2] Rec room", false);
            map [3][3] = new location("Floor 1 Room 4", "[3][3] Head office elevator - Factory floor", false); //special

            map [2][0] = new location("Floor 2 Room 1", "[2][0] n/a", false);
            map [2][1] = new location("Floor 2 Room 2", "[2][1] n/a", true); // elevator
            map [2][2] = new location("Floor 2 Room 3", "[2][2] n/a", false);
            map [2][3] = new location("Floor 2 Room 4", "[2][3] Head office elevator 2", false); //special

            //floor 3
            map [1][0] = new location("Floor 3 Room 1", "[1][0] n/a", false);
            map [1][1] = new location("Floor 3 Room 2", "[1][1] n/a", true); // elevator
            map [1][2] = new location("Floor 3 Room 3", "[1][2] n/a", false); 
            map [1][3] = new location("Floor 3 Room 4", "[1][3] Head office elevator 1", false); //special

            //floor 4
            map [0][0] = new location("Floor 4 Room 1", "[0][0] n/a", false);
            map [0][1] = new location("Floor 4 Room 2", "[0][1] n/a", true); //elevator
            map [0][2] = new location("Floor 4 Room 3", "[0][2] n/a", false);
            map [0][3] = new location("Floor 4 Room 4", "[0][3] Head office", false); //special
    }

    public static void setUpPlayerName(Scanner input){
        System.out.println("What is your name?");
        String inputName = input.nextLine();
        mainCharacter.setName(inputName);
    }

    public static void showMenu(){
        boolean leaveMenu = false;
        while (leaveMenu==false){
            System.out.println("=====================");
            System.out.println("Test menu");
            System.out.println("=====================");
            System.out.println("1. Show current location");
            System.out.println("2. Move to a new location");
            System.out.println("3. Show inventory");
            System.out.println("4. *Debug* What story is marked complete?"); //debuuuug. remove later

            menuLocation = input.nextLine();

            if (menuLocation.equals("1")){
                showLocation();
            } else if (menuLocation.equals("2")){
                moveMenu();
                menuLocation = input.nextLine();
                locationStoryCheck(input);

                //leaveMenu = true;
            } else if (menuLocation.equals("3")){
                //showInventory(); chat look, I found a bug
                System.out.println("For now, innacessable");
            } else if (menuLocation.equals("4")){
                RunningStory.showCompletedEvents();
            }
        }



    }

    public static void showLocation(){
        System.out.println("You are currently in...");
        System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]); 
        System.out.println("is elevator present? " + map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile());

    }

    public static void showInventory(){
        mainCharacter.showInventory();
    }

    public static void showCompletedEvents(){

    }

    public static void moveMenu(){

        System.out.println("\n");

        //boolean isElevatorPresent = location.getIsElevatorTile();
        //I feel like this would be a case where enums would be used...?


        //condition: Is player at [3][x] - unable to move south
        //condition: Is player at [0][x] - unable to move north

        //condition: Is player at [x][0] - unable to move west
        //condition: Is player at [x][2] - unable to move east UNLESS on floor [0][x]

        //condition: If player is on [x][3] - ONLY able to move south - may be forcibly moved?

        int currentCol = mainCharacter.getCol();
        int currentRow = mainCharacter.getRow();
        boolean hasMoved = false;

        

        while (!hasMoved){ //while having not moved

        }

        //:eyebrow_raise
        if (map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile()) {
            if (currentCol == 3){ //ground floor
            System.out.println("1. North");
            System.out.println("2. East");
            System.out.println("3. West");

            } else if (currentCol == 0){ // 4th floor
                if (currentRow == 3) { //Special rooms. 
                    System.out.println("4. South"); 
                } else {
                    System.out.println("2. East");
                    System.out.println("3. West");
                    System.out.println("4. South"); 
                }
            } else { //2-3 floor
                System.out.println("1. North");
                System.out.println("2. East");
                System.out.println("3. West");
                System.out.println("4. South"); 
            }

        } else { //not an elevator tile
            if (currentRow == 3) {// special rooms
                System.out.println("4. South"); 
            } else if (currentRow == 2){ //rightmost nonspecial room
                System.out.println("3. West");
            } else if (currentRow == 0){ //leftmost room
                System.out.println("2. East");
            } else { // technically not needed, I guess? center room
                System.out.println("2. East");
                System.out.println("3. West");
            }

        }


        menuLocation = input.nextLine();


            //north
        if (menuLocation.equals("1")){
            
            //can only go north if on elevator tile and not on 4th floor
            if (map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile()){
                //should only be able to move north if prerequisites are met.
                
                mainCharacter.moveNorth();
                System.out.println("You have moved north. Current location:");
                System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]); 
                System.out.println("is elevator present? " + map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile());
                
            } else {
                System.out.println("Cannot go north");
            }
            

            //east
        } else if (menuLocation.equals("2")){

            //check if at floor 4 (col0). 
            //Floor 4 true, row > 2
            //floor 4 false, row > 1 - prevent moving into special room


            if (currentCol == 0){ //floor 4
                if (mainCharacter.getRow() > 2){
                    System.out.println(mainCharacter.getRow());
                    System.out.println("Cannot go this way");
                } else {
                    mainCharacter.moveEast();
                    System.out.println("You have moved east. Current location:");
                    System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]); 
                    System.out.println("is elevator present? " + map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile());
                }
            } else { //every other floor
                if (mainCharacter.getRow() > 1){
                    System.out.println(mainCharacter.getRow());
                    System.out.println("Cannot go this way");
                } else {
                    mainCharacter.moveEast();
                    System.out.println("You have moved east. Current location:");
                    System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]); 
                    System.out.println("is elevator present? " + map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile());
                }
            }
            //cannot go east if already at row 3 - furthest east

            

           

        } else if (menuLocation.equals("3")){
            mainCharacter.moveWest();
            
        } else if (menuLocation.equals("4")){
            mainCharacter.moveSouth();
        } 

    }
    
    public static void locationStoryCheck(Scanner input){
        //int[][] currentMap = new int[mainCharacter.getCol()][mainCharacter.getRow()];

        int currentRow = mainCharacter.getRow();
        int currentCol = mainCharacter.getCol();
        
        
        //possibly also an awful way of doing this. idk.
        if (currentCol == 3){ // floor 1
            if (currentRow == 0){ // Floor 1 Room 1
                boolean eventCompleted = RunningStory.isEventFloor1Room1Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor1Room1(input);
                }
            } else if (currentRow == 1){ // Floor 1 Room 2 ELEVATOR
                boolean eventCompleted = RunningStory.isEventFloor1Room2Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor1Room2(input);
                }
            } else if (currentRow == 2){ // Floor 1 Room 3
                boolean eventCompleted = RunningStory.isEventFloor1Room3Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor1Room3(input);
                }
            } else if (currentRow == 3){ // Floor 1 Room 4 UNIQUE
                boolean eventCompleted = RunningStory.isEventFloor1Room4Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor1Room4(input);
                }
            } 
        
        } else if (currentCol == 2){ // floor 2

           if (currentRow == 0){ // Floor 2 Room 1
                boolean eventCompleted = RunningStory.isEventFloor2Room1Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor2Room1(input);
                }
            } else if (currentRow == 1){ // Floor 2 Room 2 ELEVATOR
                boolean eventCompleted = RunningStory.isEventFloor2Room2Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor2Room2(input);
                }
            } else if (currentRow == 2){ // Floor 1 Room 3
                boolean eventCompleted = RunningStory.isEventFloor2Room3Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor2Room3(input);
                }
            } else if (currentRow == 3){ // Floor 1 Room 4 UNIQUE
                boolean eventCompleted = RunningStory.isEventFloor2Room4Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor2Room4(input);
                }
            }
        
        } else if (currentCol == 1){ // floor 3

            if (currentRow == 0){ // Floor 1 Room 1
                boolean eventCompleted = RunningStory.isEventFloor3Room1Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor3Room1(input);
                }
            } else if (currentRow == 1){ // Floor 1 Room 2 ELEVATOR
                boolean eventCompleted = RunningStory.isEventFloor3Room2Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor3Room2(input);
                }
            } else if (currentRow == 2){ // Floor 1 Room 3
                boolean eventCompleted = RunningStory.isEventFloor3Room3Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor3Room3(input);
                }
            } else if (currentRow == 3){ // Floor 1 Room 4 UNIQUE
                boolean eventCompleted = RunningStory.isEventFloor3Room4Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor3Room4(input);
                }
            } 

        } else if (currentCol == 0){ // floor 4

            if (currentRow == 0){ // Floor 1 Room 1
                boolean eventCompleted = RunningStory.isEventFloor4Room1Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor4Room1(input);
                }
            } else if (currentRow == 1){ // Floor 1 Room 2 ELEVATOR
                boolean eventCompleted = RunningStory.isEventFloor4Room2Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor4Room2(input);
                }
            } else if (currentRow == 2){ // Floor 1 Room 3
                boolean eventCompleted = RunningStory.isEventFloor4Room3Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor4Room3(input);
                }
            } else if (currentRow == 3){ // Floor 1 Room 4 UNIQUE
                boolean eventCompleted = RunningStory.isEventFloor4Room4Completed();
                if (eventCompleted){
                    System.out.println("There is nothing left here to do.");
                } else {
                    RunningStory.eventFloor4Room4(input);
                }

            } 
        } else {
            System.out.println("Something went wrong (locationStoryCheck - CurrentCol)");
        }
        
        /* 
        switch(currentCol) {
            case 1: //floor 1

                switch (currentRow) {
                    case 1: //floor 1 room 1
                        boolean eventCompleted = RunningStory.isEventFloor1Room1Completed();

                        break;
                    case 2: //floor 1 room 2
                        boolean eventCompleted = RunningStory.isEventFloor1Room1Completed();
                        break;
                    case 3: //floor 1 room 3
                        break;
                        
                    default:
                        System.out.println("Something is missing (locationStoryCheck - Floor 1 row x)");
                        break;
                }
                break;
            case 2:
                // code block
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                // code block
            }
        */
    }
    
    public static void callBattle( /*Whatever input is needed, I guess */){ //Called from story class
        Boolean isBattleWon = false;
        System.out.println("debug, floor1room1battle method");
        System.out.println("========================");
        

        isBattleWon = RunningStory.winBattleDebug();
        /*
        System.out.println("Won battle " + BattleID);

        

        //Rewards are dispensed here. Kiera I have no idea what you are doing so just change it to suit whatever you have written
        if (isBattleWon){
            System.out.println("You have won the battle");
            //add inventory
            switch (BattleID) {
                case F1R1: // Magic number :(. Floor 1 Room 1
                    
                    break;
                
                default:
                    break;
            }
        }
             */
    }
    public static void main(String[] args){
        System.out.println("New Game");
        setUpGame();

        do {
            //1st story trigger always runs regardless of player input
            if (!RunningStory.isIntroCutsceneCompleted()){
                RunningStory.introCutscene(input);
            }
            if(!RunningStory.isEventFloor1Room1Completed()){
                RunningStory.eventFloor1Room1(input);
            }
            
            
            showMenu(); //navigation happens in menu. This thing just loops forever


        } while (gameRunning); //constantly looping fyi
         

    } 
}
