//package src;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

//something something remember 3 data types need to be used as inputs for game..?


//current list of bugs:
//when moving west from [3][1], input is still allowed. This shouldnt be the case and is probably also true for other movement options

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

            map [2][0] = new location("Floor 2 Room 1", "[2][0] Lower Fortuna West Wing", false);
            map [2][1] = new location("Floor 2 Room 2", "[2][1] Poker tables", true); // elevator
            map [2][2] = new location("Floor 2 Room 3", "[2][2] Lower Fixwood East Wing", false);
            map [2][3] = new location("Floor 2 Room 4", "[2][3] Head office elevator 2", false); //special

            //floor 3
            map [1][0] = new location("Floor 3 Room 1", "[1][0] Upper Fortuna Private room - West", false);
            map [1][1] = new location("Floor 3 Room 2", "[1][1] Upper level Bar", true); // elevator
            map [1][2] = new location("Floor 3 Room 3", "[1][2] Upper Fixwood Private room - East", false); 
            map [1][3] = new location("Floor 3 Room 4", "[1][3] Head office elevator 1", false); //special

            //floor 4
            map [0][0] = new location("Floor 4 Room 1", "[0][0] Top Floor Lookout", false);
            map [0][1] = new location("Floor 4 Room 2", "[0][1] Decorated hall", true); //elevator
            map [0][2] = new location("Floor 4 Room 3", "[0][2] Main corridor", false);
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
            System.out.println("Menu");
            System.out.println("=====================");
            System.out.println("1. Show current location");
            System.out.println("2. Move to a new location");
            System.out.println("3. Show inventory");
            //show active passive
            //show current deck 
            //etc
            System.out.println("4. *Debug* What story is marked complete?"); //debuuuug. remove later
            System.out.println("5. Debug, lose coins");

            menuLocation = input.nextLine();

            if (menuLocation.equals("1")){
                showLocation();
            } else if (menuLocation.equals("2")){
                moveMenu();
                menuLocation = input.nextLine();
                locationStoryCheck(input);

                //leaveMenu = true;
            } else if (menuLocation.equals("3")){
                
                mainCharacter.showInventory();
                //System.out.println("For now, innacessable");
            } else if (menuLocation.equals("4")){
                RunningStory.showCompletedEvents();
            } else if (menuLocation.equals("5")){
                loseCoinEvent();
            }
        }
    }

    public static void showLocation(){
        System.out.println("");
        System.out.println("- - - - - -");
        System.out.println("You are currently in...");
        System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]); 
        
        boolean isElevatorTile = map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile();
        if (isElevatorTile){
            System.out.println("You are currently near an elevator. You may travel upwards.");
        }
        System.out.println("- - - - - -");
        System.out.println("");
        
    }

    public static void showInventory(){
        mainCharacter.showInventory();
    }

    public static void moveMenu(){
        System.out.println("\n");
        System.out.println("- - - - - -");
        System.out.println("Move in which direction?");
        
        //condition: Is player at [3][x] - unable to move south
        //condition: Is player at [0][x] - unable to move north

        //condition: Is player at [x][0] - unable to move west
        //condition: Is player at [x][2] - unable to move east UNLESS on floor [0][x]

        //condition: If player is on [x][3] - ONLY able to move south - may be forcibly moved?

        int currentCol = mainCharacter.getCol();
        int currentRow = mainCharacter.getRow();
        //System.out.println("col:" + currentCol + "\nrow:" + currentRow);
   

        //if on elevator tile, check
        //:eyebrow_raise
        if (map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile()) {
            if (currentCol == 3){ //ground floor
                if(keyItemCheckFloor2()){ //check if player has floor 2 keycard
                    System.out.println("1. Upwards");
                    System.out.println("2. East");
                    System.out.println("3. West");
                } else {
                    System.out.println("2. East");
                    System.out.println("3. West");
                }

            } else if (currentCol == 0){ // 4th floor
                if (currentRow == 3) { //Special rooms. 
                    System.out.println("4. South"); 
                } else {
                    System.out.println("2. East");
                    System.out.println("3. West");
                    System.out.println("4. South"); 
                }
            } else if (currentCol == 2){ //2nd floor
                if(keyItemCheckFloor3()){ //check if player has floor 3 keycard
                    System.out.println("1. Upwards");
                    System.out.println("2. East");
                    System.out.println("3. West");
                    System.out.println("4. South"); 
                } else {
                    System.out.println("2. East");
                    System.out.println("3. West");
                    System.out.println("4. South"); 
                }

            } else if (currentCol == 1){ //3rd floor
                if(keyItemCheckFloor4()){ //check if player has floor 4 keycard
                    System.out.println("1. Upwards");
                    System.out.println("2. East");
                    System.out.println("3. West");
                    System.out.println("4. South"); 
                } else {
                    System.out.println("2. East");
                    System.out.println("3. West");
                    System.out.println("4. South"); 
                }
                 
                
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


        boolean isElevatorTile = map[mainCharacter.getCol()][mainCharacter.getRow()].getIsElevatorTile();

        System.out.println("");
            //north
        if (menuLocation.equals("1")){
            
            //can only go north if on elevator tile and not on 4th floor
            if (isElevatorTile){ //is on elevator tile
                if (currentCol == 3){ // if moving from ground floor to floor 2
                    if(keyItemCheckFloor2()){ //has keycard
                        mainCharacter.moveNorth();
                        
                        System.out.println("You have moved Upwards. Current location:");
                        System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]); 
                    
                        
                    }

                } else if (currentCol == 2){ //floor 2 --> f3
                    if (keyItemCheckFloor3()){
                        mainCharacter.moveNorth();

                        System.out.println("You have moved Upwards. Current location:");
                        System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]);                         
                    }

                } else if (currentCol == 1){
                    if (keyItemCheckFloor4()){
                        mainCharacter.moveNorth();
                        
                        System.out.println("You have moved Upwards. Current location:");
                        System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]);                         
                    }

                } else if (currentCol == 0){

                } else {
                    System.out.println("Something wrong occured (moveMenu)");
                }
            } else {
                System.out.println("Cannot go Upwards");
            }
            

            //east
        } else if (menuLocation.equals("2")){

            //check if at floor 4 (col0). 
            //Floor 4 true, row > 2 - able to go to the furthest east room 
            //floor 4 false, row > 1 - prevent moving into special room


            if (currentCol == 0){ //floor 4
                if (mainCharacter.getRow() > 2){
                    System.out.println(mainCharacter.getRow());
                    System.out.println("Cannot go this way");

                    //ideally, once in floor 4 room 4, controls for location are taken away because of the boss fight
                } else {
                    mainCharacter.moveEast();
                    System.out.println("You have moved east. Current location:");
                    System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]); 
                    if(isElevatorTile){
                        System.out.println("You are near an elevator. You may move upwards");
                    }

                }
            } else { //every other floor
                if (mainCharacter.getRow() > 1){
                    System.out.println(mainCharacter.getRow());
                    System.out.println("Cannot go this way");
                } else {
                    mainCharacter.moveEast();
                    System.out.println("You have moved east. Current location:");
                    System.out.println(map[mainCharacter.getCol()][mainCharacter.getRow()]); 
                    if(isElevatorTile){
                        System.out.println("You are near an elevator. You may move upwards");
                    }
                }
            }
            //cannot go east if already at row 3 - furthest east

            

           

        } else if (menuLocation.equals("3")){
            mainCharacter.moveWest();
        } else if (menuLocation.equals("4")){
            mainCharacter.moveSouth();
        } 

    }
                

    //checks if the story has already been completed for any new area that the player moves in
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
        }
    
        //checks if a player can move up to a certain floor
            //Floor2_Keycard
            //Floor3_Keycard
            //Floor4_Keycard
    public static boolean keyItemCheckFloor2(){
            ArrayList<String> keyItemList = mainCharacter.getKeyItems();
            boolean floor2Unlock = false;

            if (keyItemList.contains("Floor2_Keycard")){
                floor2Unlock = true;
            } 
            return floor2Unlock;
        }
    public static boolean keyItemCheckFloor3(){
            ArrayList<String> keyItemList = mainCharacter.getKeyItems();
            boolean floor3Unlock = false;

            if (keyItemList.contains("Floor3_Keycard")){
                floor3Unlock = true;
            } 
            return floor3Unlock;
        }
    public static boolean keyItemCheckFloor4(){
            ArrayList<String> keyItemList = mainCharacter.getKeyItems();
            boolean floor4Unlock = false;

            if (keyItemList.contains("Floor4_Keycard")){
                floor4Unlock = true;
            } 
            return floor4Unlock;
    }


    //misc methods 
    public static ArrayList<Coin> getCoinItems(){ //getter
        return mainCharacter.getCoinItems();
    }
    public static void F1R3CoinEvent(Coin.CoinType targetType){
        //fix later. zz
        mainCharacter.getCoinItems();
    }
    public static void F3R1Event(){
        //if no battle occured, hand over the keycard anyways
    }

    public static void lose1CoinEvent(){ //F1R3 lose roll event
        mainCharacter.lose1Coin();
    }

    public static void winCoinEvent(Coin[] coinsWon){ //F1R3 win coin event
        mainCharacter.addCoinItem(coinsWon);

        System.out.println("");
        System.out.println("You recieved: ");
        for(Coin item: coinsWon) {

            System.out.println("- " + item + " COIN"); 
        }
        System.out.println("");
    }
    public static void loseCoinEvent(){ //F2R1 event - Win deception event, lose Table event
        mainCharacter.loseAllCoins();
        System.out.println("You lost all your coins");
        System.out.println("");
        mainCharacter.showInventory();
        System.out.println("");
    }

    public static boolean doesHaveCoin(Coin targetCoin){
        boolean hasCoin = false;
        if (mainCharacter.hasCoinInInventory(targetCoin)){
            hasCoin = true;
        }
        return hasCoin;
    }


    
    public static void callBattle(Battle Battle){ //Called from story class
        Boolean isBattleWon = false;

        System.out.println("========================");


        isBattleWon = RunningStory.winBattleDebug(); // replace winBattleDebug with real getter method at some point
        
        System.out.println("Won battle " + Battle.getBattleID()); //battleID from story class
       

        if (isBattleWon){ //Rewards are dispensed here.

            //if coins exist as a reward

            if(!Battle.isCoinEmpty(Battle.getCoinRewards())){
                mainCharacter.addCoinItem(Battle.getCoinRewards()); //add to inventory

                //print which coins recieved
                System.out.println("");
                System.out.println("You recieved: ");
                for(Coin item: Battle.getCoinRewards()) {
                    
                    System.out.println("- " + Battle.getCoinFrequency(Battle.getCoinRewards(), item) + " "+ item + " COIN"); 
                }
            }

            //if key items exists as a reward 
            if(!Battle.getKeyItemsRewards().isEmpty()){
                //add key items to inventory
                mainCharacter.addKeyItem(Battle.getKeyItemsRewards());
                System.out.println("- " + Battle.getKeyItemsRewards());
            }


            





            System.out.println("========================");
            System.out.println("");
            //passives or whatever else
        } //else do something else on loss

        // Kiera I have no idea what you are doing so just change it to suit whatever you have written
    }

    
    public static void main(String[] args) {
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

