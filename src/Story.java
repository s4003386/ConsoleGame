//package src;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Story {
    //add colours and timing delays if there is time
    private boolean introCutsceneCompleted = false; //default false always

    //possibly the worst way of doing this but I digress. Gets marked completed if the method associated with it is called
    private boolean eventFloor1Room1Completed = false;
    private boolean eventFloor1Room2Completed = false;
    private boolean eventFloor1Room3Completed = false;

    private boolean eventFloor2Room1Completed = false;
    private boolean eventFloor2Room2Completed = false;
    private boolean eventFloor2Room3Completed = false;

    private boolean eventFloor3Room1Completed = false;
    private boolean eventFloor3Room2Completed = false;
    private boolean eventFloor3Room3Completed = false;

    private boolean eventFloor4Room1Completed = false;
    private boolean eventFloor4Room2Completed = false;
    private boolean eventFloor4Room3Completed = false;
    private boolean eventFloor4Room4Completed = false;

    private boolean eventFloor3Room4Completed = false;
    private boolean eventFloor2Room4Completed = false;
    private boolean eventFloor1Room4Completed = false;
    

    private boolean debugWinLoseEvent = false;





    //floor 1 room 1
    Coin[] F1R1Reward = {new Coin(Coin.CoinType.BLACK), new Coin(Coin.CoinType.WHITE)}; //every coin is an object 'coin' with an enum type to deternine roll chance
    ArrayList<String> EmptyArray = new ArrayList<String>(); //add whatever
    Battle F1R1 = new Battle("F1R1Battle", 1 ,  F1R1Reward, EmptyArray, EmptyArray, EmptyArray); //called when the story calls for it
    //everything temporary right now is just an ArrayList string but it can be changed when it needs to in the battles class. just dont forget to change them here
    //floor 1 room 2 elevator
    Coin[] F1R2Reward = {new Coin(Coin.CoinType.BLUE), new Coin(Coin.CoinType.GREEN), new Coin(Coin.CoinType.BLACK), new Coin(Coin.CoinType.WHITE)};
    ArrayList<String> F1R2KeyItems = new ArrayList<String>(List.of("Floor2_Keycard"));
    Battle F1R2 = new Battle("F1R2Battle", 1 ,  F1R2Reward, EmptyArray, F1R2KeyItems, EmptyArray); //called when the story calls for it

    //floor 2 ////////////////////////////////////////////////////
    Coin[] F2R2Reward = {new Coin(Coin.CoinType.RED), new Coin(Coin.CoinType.PURPLE), new Coin(Coin.CoinType.GREEN)}; 
    Battle F2R2 = new Battle("F2R2Battle", 1 ,  F2R2Reward, EmptyArray, EmptyArray, EmptyArray); 
    //west r1
    Coin[] F2R1Reward = {new Coin(Coin.CoinType.YELLOW), new Coin(Coin.CoinType.RED), new Coin(Coin.CoinType.BLUE)}; 
    ArrayList<String> F2R1KeyItems = new ArrayList<String>(List.of("Floor3_Keycard"));
    Battle F2R1 = new Battle("F2R1Battle", 1 ,  F2R1Reward, EmptyArray, F2R1KeyItems, EmptyArray); 
    //east r3
    Coin[] F2R3Reward = {new Coin(Coin.CoinType.BLACK), new Coin(Coin.CoinType.BLACK)}; 
    ArrayList<String> F2R3KeyItems = new ArrayList<String>(List.of("Floor3_Keycard"));
    Battle F2R3 = new Battle("F2R3Battle", 1 ,  F2R3Reward, EmptyArray, F2R3KeyItems, EmptyArray); 

    //floor 3 ////////////////////////////////////////////////////
    Coin[] F3R2Reward = {new Coin(Coin.CoinType.GREEN), new Coin(Coin.CoinType.YELLOW), new Coin(Coin.CoinType.WHITE)}; 
    Battle F3R2 = new Battle("F3R2Battle", 1 ,  F3R2Reward, EmptyArray, EmptyArray, EmptyArray); 
    //west r1
    Coin[] F3R1Reward = {new Coin(Coin.CoinType.RED), new Coin(Coin.CoinType.PURPLE), new Coin(Coin.CoinType.GREEN)}; 
    ArrayList<String> F3R1KeyItems = new ArrayList<String>(List.of("Floor4_Keycard")); 
    Battle F3R1 = new Battle("F3R1Battle", 1 ,  F2R2Reward, EmptyArray, F3R1KeyItems, EmptyArray); 
    //east r3
    Coin[] F3R3Reward = {new Coin(Coin.CoinType.PURPLE), new Coin(Coin.CoinType.GREY), new Coin(Coin.CoinType.PURPLE)}; 
    ArrayList<String> F3R3KeyItems = new ArrayList<String>(List.of("Floor4_Keycard")); 
    Battle F3R3 = new Battle("F3R3Battle", 1 ,  F3R3Reward, EmptyArray, F3R3KeyItems, EmptyArray); 


    //floor 4 ///////////////////////////////////////////////////////
    //no fight for elevator floor
    //west - secretary
    Coin[] F4R1Reward = {new Coin(Coin.CoinType.GREY), new Coin(Coin.CoinType.YELLOW), new Coin(Coin.CoinType.PURPLE)}; 
    Battle F4R1 = new Battle("F4R1Battle", 1 ,  F4R1Reward, EmptyArray, EmptyArray, EmptyArray); 
    //no fights for east room

    //special






    //misc
    //F1R3 coin event
     Coin[] F1R3WinCoinEvent = {new Coin(Coin.CoinType.PURPLE), new Coin(Coin.CoinType.PURPLE), new Coin(Coin.CoinType.PURPLE)};

     //f3r1 coin event
    Coin[] F3R1WinCoinEvent = {new Coin(Coin.CoinType.GREY), new Coin(Coin.CoinType.GREY), new Coin(Coin.CoinType.GREY)};

    public static final String ANSI_RESET = "\u001B[0m"; //reset
    public static final String Speaker1 = "\u001B[31m"; //red
    public static final String Speaker2 = "\u001B[32m";//green
    public static final String Speaker3 = "\u001B[34m";//blue
    public static final String Speaker4 = "\u001B[33m"; // yellow


// start of game
    public void introCutscene(Scanner input){
        String[] lines = {
            "The time is midnight. Below me is the body of the local 'red black' syndicate.",
            "I look up. The night sky is filled with light from the highest point in the city, Sharktown casino.",
            "My father disappeared a week ago. He left for Sharktown with the hope of hitting it big. Now I'm in destitution",
            "*Shuffle*",
            "In a red and black shirt, I head towards the flashing lights of the casino.",
            ".",
            ".",
            ".",
            "Floor 1 Room 1 - Foyer",
            "The security guard of this place took a quick glance at me, and simply nodded. It didn't matter if this outfit was covered in rain and blood.",
            "My original goal was to get to the poker machines, but another man sitting on a couch hollers for my attention.",
            Speaker1 + " \"Who are you?\" He asks. \"I didn't know the guys out east had business with us.\" " + ANSI_RESET,
            "\"...They don't. I'm here by my own volition.\"",
            Speaker1 + "\"If you're after the machines, lets play a game then eh? Whoever rolls highest is the winner and ill throw my chips your way.\"" + ANSI_RESET
        };

        System.out.println("Story event: Enter to continue text, Press x to skip");
        String choice = input.nextLine().trim().toLowerCase(); //'choice' is used to record input

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); //wont allow mid cutscene skip but i'm too stoopid rn to think of anything that works
            }
            
        }

        introCutsceneCompleted = true;
    } 
    public boolean isIntroCutsceneCompleted(){
        return introCutsceneCompleted;
    }


    //debugging methods
    public boolean winBattleDebug(){
        //System.out.println(".");
        //System.out.println("Win or lose this event? (debug)"); // default win for now
        //System.out.println("Encounter won (debug - winBattleDebug())");
        //System.out.println("");
        debugWinLoseEvent = true;
        return debugWinLoseEvent;

    }

    public void showCompletedEvents(){
        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());
        System.out.println("[3][1] F1 R2 elevator: " + isEventFloor1Room2Completed());
        System.out.println("[3][2] F1 R3: " + isEventFloor1Room3Completed());
        
        
        System.out.println("[2][0] F2 R1: " + isEventFloor2Room1Completed());
        System.out.println("[2][1] F2 R2: " + isEventFloor2Room2Completed());
        System.out.println("[2][2] F2 R3: " + isEventFloor2Room3Completed());

        System.out.println("[1][0] F3 R1: " + isEventFloor3Room1Completed());
        System.out.println("[1][1] F3 R2: " + isEventFloor3Room2Completed());
        System.out.println("[1][2] F3 R3: " + isEventFloor3Room3Completed());

        System.out.println("[0][0] F4 R1: " + isEventFloor4Room1Completed());
        System.out.println("[0][1] F4 R2: " + isEventFloor4Room2Completed());
        System.out.println("[0][2] F4 R3: " + isEventFloor4Room3Completed());
        System.out.println("[0][3] F4 R4: " + isEventFloor4Room4Completed());

        //special
        System.out.println("[1][3] F3 R4: " + isEventFloor3Room4Completed());
        System.out.println("[2][3] F2 R4: " + isEventFloor2Room4Completed());
        System.out.println("[3][3] F1 R4: " + isEventFloor1Room4Completed());
        
    }


    //absolute spagghetti
    public void storyBattle(Battle Battle){

        main.callBattle(Battle);

    }



// FLOOR 11111111111111111111111111111111111111111111111


//"Floor 1 Room 1", "[3][0] Foyer",
    public void eventFloor1Room1(Scanner input){ //presumably inventory / buffsdebuffs etc also are inputted here
        int playerChoice;


        System.out.println("Will you play a game?");

        System.out.println("----");
        System.out.println("1. Bet");
        System.out.println("2. No thanks");

        

        playerChoice = input.nextInt(); //add checkers for incorrect inputs at some point
        input.nextLine();

        boolean hasPlayerMadeChoice = false;

        while (hasPlayerMadeChoice == false){
            if (playerChoice == 1){
                System.out.println("");
                System.out.println("You picked choice 1");
                eventFloor1Room1Choice1(input);
                hasPlayerMadeChoice = true;
                break;

            } else if (playerChoice == 2){
                System.out.println("");
                System.out.println("You picked choice 2");
                eventFloor1Room1Choice2(input);
                hasPlayerMadeChoice = true;
                break;
            }
        }

        eventFloor1Room1Completed = true;
    }
    public void eventFloor1Room1Choice1(Scanner input){ //player aggrees to play a game
        int playerChoice;
        System.out.println("(Story event: x to skip, enter to continue)"); 
        
        String[] lines = {"He takes you to a bright red machine and gives you a peculiar coin. It pulses like a heart in your hand.",
                            "All around you are people who's eyes are desperately glued to the machines. They aren't checking if they are winning or losing at all.",
                            Speaker1 + "\"What are you waiting for? Just spin already\"" + ANSI_RESET
                        };
        String choice = input.nextLine().trim().toLowerCase();
        

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
        }



        boolean hasPulledTheLever = false;
        System.out.println("What will you do?");
        System.out.println("----");
        while (!hasPulledTheLever){
            System.out.println("1. Pull the lever");
            String nextInput = input.nextLine();

            if (nextInput.equals("1")){
                hasPulledTheLever = true;
            }
        }


        Random rng = new Random();
        int coinflip = rng.nextInt(1, 3);
        System.out.println("");

        if (coinflip == 1){
            System.out.println("Coinflip event: Rolled head");
            System.out.println("");

            System.out.println(Speaker1 + "\"What!? I paid good money to get those chips. Don't tell me I gave you the good one!?\"" + ANSI_RESET);
            input.nextLine();
            System.out.println(Speaker1 + "\"Whatever. Follow me and I'll give you what I got.\"" + ANSI_RESET); 
            System.out.println("- - - - -");
            System.out.println("1. Agree");
            System.out.println("2. Disagree");

            playerChoice = input.nextInt();
            input.nextLine();

            if (playerChoice == 1){
                System.out.println("You chose option 1");
                System.out.println("");
                System.out.println(Speaker1 + "\"...Chap, you got to stop believing in what everyone says. I'm trying to rob you over here.\"" + ANSI_RESET);
                input.nextLine();

                System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println("");
                storyBattle(F1R1); //

            
            } else if (playerChoice == 2){
                System.out.println("You chose option 2");
                System.out.println("");
                System.out.println(Speaker1 + "\"I never said you had a choice, did I?\"" + ANSI_RESET);
                input.nextLine();


                System.out.println("*Battle start*");///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println(""); 
                storyBattle(F1R1);
            }
            

        } else {
            System.out.println("Coinflip event: Rolled Tails");
            input.nextLine();

            System.out.println(Speaker1 + " \"Chap you should have known that everything here is rigged.\" " + ANSI_RESET);
            input.nextLine();
            System.out.println("He flipped a coin with his thumb. It always landed on heads.");
            input.nextLine();
            System.out.println(Speaker1 + " \"See this? I paid good money for this coin. Blokes from out back don't know this but the house here makes and sells their own coin.\" ");
            input.nextLine();
            System.out.println(" \"This stuff mogs physics. You won't see this thing lose… Usually. Which is why your pockets are looking real good at the moment.\"");
            input.nextLine();
            System.out.println(" \"Homeboy is strapped for cash and if you know what's good, I'll leave you unshanked if you hand over what you got right now.\"" + ANSI_RESET);
            input.nextLine();
            

            System.out.println("*Battle initiated*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("");
            storyBattle(F1R1);
            //main.callBattle(BattleFloor1Room1);

            
        }
        
    }



    public void eventFloor1Room1Choice2(Scanner input){ //player says 'no thanks'
        System.out.println("(Story event: x to skip, enter to continue)");    
    
        String[] lines = {Speaker1 + "\"Don't give me that answer.\"" + ANSI_RESET,
                            "He dragged me by the arm to a place behind the poker machines. ",
                            Speaker1 + " \"You see these things in my hand?\"" + ANSI_RESET,
                            "He flips a coin with his thumb several times. It always landed on heads.",
                            Speaker1 + " \" See this? I paid good money for this coin. Blokes from out back don't know this but the house here makes and sells their own coin.\"" + ANSI_RESET,
                            Speaker1 + " \"This stuff mogs physics. You wont see this thing lose… Usually. Which is why your pockets are looking real good at the moment.\" " + ANSI_RESET,
                            Speaker1 + "\"Homeboy is strapped for cash and if you know what's good, ill leave you unshanked if you hand over what you got right now.\"" + ANSI_RESET
        };
        String choice = input.nextLine().trim().toLowerCase(); //to be honest, there is probably a better way of doing this but I cant really be bothered rn
    
        System.out.println(""); //formatting
        
        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
        }

        System.out.println("*Battle Initiated*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("");
        storyBattle(F1R1);
        //main.callBattle(BattleFloor1Room1);
        

    }
    public boolean isEventFloor1Room1Completed(){
        return eventFloor1Room1Completed;
    }



//"Floor 1 Room 2", "[3][1] Elevator room", 
    public void eventFloor1Room2(Scanner input){
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"Before you could do anything, a group of 3 blocked your route towards the elevator.",
            Speaker1 + "\"Look, to be frank, the moment you started running your mouth, I knew you weren't one of us folk.\"",
            "\"Who did you have to beat up to get that shirt? Huh? We aren't letting this go.\"" + ANSI_RESET,
        };
        String choice = input.nextLine().trim().toLowerCase(); //'choice' is used to record input

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); //wont allow mid cutscene skip but i'm too stoopid rn to think of anything that works
            }
            
        }

        System.out.println("*Battle initiated*"); ////////////////////////////////////////////////////
        input.nextLine();
        System.out.println("");
        storyBattle(F1R2);

        if(winBattleDebug()){ ////!!!!!!!!!!!!! replace with getter method in whatever class is used for the actual fight
            eventFloor1Room2OnWin(input);
        }
    }

    public void eventFloor1Room2OnWin(Scanner input){
        System.out.println("===============");
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {Speaker1 +  "\"Okay, okay, I get it. You can stop. I may be a hooligan but I know my limits\"",
            "\"Mates, we leave this one\""  + ANSI_RESET, 
            "They ran away.",
            "(You have reached a space with an elevator. After completing any events that happen in this space, you may choose to go up the elevator to the next floor or explore around in other rooms for a bit.)",
            "(Exploring comes with risks, but you might find many useful items to help you on your way to the top floor."
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); //wont allow mid cutscene skip but i'm too stoopid rn to think of anything that works
            }
            
        }


        eventFloor1Room2Completed = true;

    }
    public boolean isEventFloor1Room2Completed(){
        return eventFloor1Room2Completed;
    }




//"Floor 1 Room 3", "[3][2] Rec room",
    public void eventFloor1Room3(Scanner input){
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"The noise of the machines disappears as soon as you enter the room. Dust that was disturbed by your entrance begins to settle on your nose and you let out a sneeze.",
        "You see that there is something huge covered by a cloth in the back of the room."
        };
        String choice = input.nextLine().trim().toLowerCase();
        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }

        boolean hasPlayerMadeChoice = false;
        
        System.out.println("What will you do?");
        System.out.println("----");
        while(!hasPlayerMadeChoice){
            System.out.println("1. Take off the cloth");
            System.out.println("2. Leave and go back to the elevator");
            String playerInput = input.nextLine().trim().toLowerCase();
            System.out.println("");

            if(playerInput.equals("1")){
                //recieve 1 special item if there is time to implement
                System.out.println("The off white sheet falls to the ground");
                input.nextLine();
                eventFloor1Room3Choice1(input);
                hasPlayerMadeChoice = true;

                
            } else if (playerInput.equals("2")){
                eventFloor1Room3Choice1(input);
                hasPlayerMadeChoice = true;
            }

        }

        eventFloor1Room3Completed = true;
    }
    public void eventFloor1Room3Choice1(Scanner input){
        System.out.println("You see that the sheet was hiding a monster of a slot machine underneath. A chair is needed to even reach the lever. ");
        input.nextLine();

        boolean hasPlayerMadeChoice = false;
        boolean hasPlayerMadeCoinChoice = false;
        
        
        System.out.println("There is already a coin in the slot. You can:");
        System.out.println("----");
        while(!hasPlayerMadeChoice){
            System.out.println("1. Swap the coin with your own and pull the lever");
            System.out.println("2. Pull the lever anyways");
            System.out.println("3. Take the coin out of the slot");
            String playerInput = input.nextLine().trim().toLowerCase();
            System.out.println("");

            if(playerInput.equals("1")){ // swap the coin
                System.out.println(".");
                input.nextLine();

                /* 
                
                while (!hasPlayerMadeCoinChoice){ //note, hasplayermadechoice is not turned true in this branch
                    
                    System.out.println("Your current inventory");
                    main.showInventory();
                    input.nextLine();


                    System.out.println("Select a coin to use:");
                    System.out.println("----");
                    System.out.println("1. White coin (1% odds success)");
                    System.out.println("2. Red coin (20% odds success)");
                    System.out.println("3. Blue coin (35% odds success)");
                    System.out.println("4. Green coin (50% odds success)");
                    System.out.println("5. Black coin (65% odds success)");
                    System.out.println("6. Purple coin (80% odds success)");
                    System.out.println("7. Yellow coin (99% odds success)");
                    System.out.println("8. Grey coin (100% odds success)");
                    String playerCoinInput = input.nextLine().trim().toLowerCase();

                    if(playerCoinInput.equals("1")){
                        boolean hasWhiteCoin = false;
                        for (Coin coin : main.getCoinItems()) {
                            if (coin.getCoinType() == Coin.CoinType.WHITE) {
                                hasWhiteCoin = true;
                                break; 
                            }
                        }

                        if (hasWhiteCoin){
                            System.out.println("Found white coin");
                            System.out.println("Use the White coin?"); //you have x amount
                            System.out.println("----");
                            System.out.println("1. Yes");
                            System.out.println("2. No");

                            String useCoinChoiceInput = input.nextLine().trim().toLowerCase();
                            
                            if (useCoinChoiceInput.equals("1")){
                                //main.F1R3CoinEvent();
                                hasPlayerMadeCoinChoice = true;
                            }
                            
                            
                        } else {
                            System.out.println("No white coin found in inventory");
                        }
                    }
                }*/
                
                Random RNG = new Random();
                int coinflip = RNG.nextInt(1, 3);

                if (coinflip==1){ //win coin
                    System.out.println("Coinflip event: Heads");
                    input.nextLine();
                    System.out.println("You won something!");

                    //win some coins
                    main.winCoinEvent(F1R3WinCoinEvent);
                    //Coin[] F1R3WinCoinEvent = {new Coin(Coin.CoinType.PURPLE), new Coin(Coin.CoinType.PURPLE), new Coin(Coin.CoinType.PURPLE)};
                    
                    hasPlayerMadeChoice = true;
                    
                }else if (coinflip==2){ // lose coin
                    System.out.println("Coinflip event: Tails");
                    input.nextLine();
                    System.out.println("You lost.");
                    input.nextLine();

                    main.lose1CoinEvent();

                    //lose a coin

                    hasPlayerMadeChoice = true;
                }
                    

                
            } else if (playerInput.equals("2")){
                System.out.println("You pulled the lever");
                input.nextLine();
                System.err.println(".");
                input.nextLine();
                System.out.println("Nothing happened");
                input.nextLine();

                hasPlayerMadeChoice = true;
            } else if (playerInput.equals("3")){
                System.out.println("You took the coin out");
                input.nextLine();

                //recieve a white coin

                hasPlayerMadeChoice = true;
            }

            /* */


        }
        
    }
    public void eventFloor1Room3Choice2(Scanner input){
        System.out.println("You decided to leave.");
        input.nextLine();

        //force move player method if there is time
    }
    public boolean isEventFloor1Room3Completed(){
        return eventFloor1Room3Completed;
    }

















// FLOOR 22222222222222222222222222222222

//"Floor 2 Room 2", "[2][1] Elevator", done
    public void eventFloor2Room2(Scanner input){
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"You attempted to pick the topmost floor, but it seems you were only allowed to travel one floor upward without a keycard.",
            "Leaving the elevator reveals a wide open space with poker tables scattered around evenly. These tables were populated with various syndicates of people.",
            Speaker2 + "\"Look, I got another one.\"" + ANSI_RESET,
            Speaker4 + "\"Looking a little rough there eh?\"" + ANSI_RESET,
            "The fellow in the flashy suit gestures to your dirty shirt.",
            "Another taps me on the shoulder as the dealer begins handing out cards.",
            Speaker3 + "\"Don't question it. It 's just like this 'round this floor.\"" + ANSI_RESET,
            "There are 3 others on this table. One in a black suit with golden embroidery, another is a woman an ordinary dress shirt with chinos, and the last - a good looking man in a red vest and bowtie.",
            "You take another glance at the chips on the table. They are like the chips from before, vaguely pulsating with emotions that you can feel.",
            Speaker3 + "\"How much 'r youse betting, mate?\"" + ANSI_RESET,
            "You placed an amount of chips on the table. The player next to you bets half.",
            Speaker3 + "\"Awright.\"" + ANSI_RESET,
            "The dealer hands out the 2 face down cards. You have a 10 and king of hearts.",
            Speaker2 + "\"Ha, I'm calling it. I'm winning.\"" + ANSI_RESET,
            Speaker3 + "\"Big talk for someone who lost the round before.\"" +ANSI_RESET,
            Speaker2 + "\"Don't give me that! I got bucketloads to spend tonight.\"" + ANSI_RESET,
            "She raises the bet with 2 purple coins.",
            Speaker4 + "\"Says you. You folk need to see my Lotus Emira in the basement.\"" + ANSI_RESET,
            Speaker2 + "\"You brought your car to this place without private parking? That piece of junk'l just get stolen ere.\"" + ANSI_RESET,
            Speaker4 + "\"Who cares, I'll get a new one after this.\"" + ANSI_RESET,
            "The dealer places one more community card. It is a king of hearts",
            Speaker2 + "\"All in!\"",
            Speaker4 + "\"What!?\"",
            Speaker2 + "I said what I said." + ANSI_RESET,
            "Everyone finally reveals their cards. You have a royal flush.",
            Speaker2 + "\"Huh!??\"" + Speaker3 +"\"Huh.\"" + Speaker4 + "\"Haa!?\"" + ANSI_RESET,
            "There was silence around the table. Everyone is looking at you.",
            Speaker2 + "Say, why don't we settle this with hands instead?" + ANSI_RESET
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }


        //battle
        System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("");
        storyBattle(F2R2);

        eventFloor2Room2Completed = true;
    }
    public boolean isEventFloor2Room2Completed(){
        return eventFloor2Room2Completed;
    }


    //"Floor 2 Room 1", "[2][0] West - Fortuna", done - need to add colour text at some point
    public void eventFloor2Room1(Scanner input){
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"You enter a room full of well dressed individuals. All of them turn to you awkwardly.",
            "\"Did any of you invite this guy?\"",
            "They all mumbled under their breath. \"No sir\", \"I said nothing sir\", \"Not a word sir.\"",
            "\"Who are you?\"",
        };

        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }

        boolean hasPlayerMadeChoice = false;
        
        System.out.println("\"Who are you?\"");
        System.out.println("----");
        while (!hasPlayerMadeChoice){
            System.out.println("1. \"I'm just some guy\"");
            System.out.println("2. \"I'm the Don of the RedBlacks\"");
            choice = input.nextLine().trim().toLowerCase();

            if (choice.equals("1")) {
                System.out.println("\"Give this guy a good shank then.\"");
                input.nextLine();

                System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println("");
                storyBattle(F2R1);

                hasPlayerMadeChoice = true;


            } else if (choice.equals("2")){

                Random RNG = new Random();
                int coinflip = RNG.nextInt(1, 3); //suppose to be based off modd or whatever but i'm lazy
                
                if(coinflip == 1){
                    System.out.println("");
                    System.out.println("Coinflip event win");
                    input.nextLine();
                    eventFloor2Room1eventWin(input);
                    hasPlayerMadeChoice = true;

                }else if ( coinflip == 2){
                    System.out.println("");
                    System.out.println("Coinflip event lose");
                    input.nextLine();
                    System.out.println("\"Yeah right. We see through your bluff.\"");
                    input.nextLine();
                    System.out.println("The men in the back start standing straight.");
                    input.nextLine();

                    System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    System.out.println("");
                    storyBattle(F2R1);

                    hasPlayerMadeChoice = true;

                }
            }
        }
        eventFloor2Room1Completed = true;
    }

    public void eventFloor2Room1eventWin(Scanner input){
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"\"Ah… You are?\"",
            "\"What business do you have with us tonight then?\"",
            "You say you are here to collect a debt",
            "\"Any of you remember something like this?\"",
            "\"Actually, I do. You remember the week before? Yvonne should have the invoice.\"",
            "\"Well I'll be damned.\"",
            "\"Look, I'm going to be honest here. We don't have your money, and you're looking real easy to shut up.\"",
            "He points to your bloodied shirt. The men in the back start standing straight",
            "\"I'll give you a choice. Join us in this match to earn your winnings back or lose the cash. Capiche? Winner takes all and a dinner at the top\"",
            "\"No way, we're inviting this guy in?\"",
            "'Perry' promptly had his pinky cut off",
            "\"Stay in line will you! \"",
            "A goon nudges and whispers to you",
            "\"Fortuna takes loyalty veeeery seriously.\"",
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }

        boolean hasPlayerMadeChoice = false;

        System.out.println("\"Tell me, what is your answer?\"");
        System.out.println("----");
        while (!hasPlayerMadeChoice){
            System.out.println("1. Join the table");
            System.out.println("2. Drop out and leave");
            choice = input.nextLine().trim().toLowerCase();

            if(choice.equals("1")){
                System.out.println("");
                System.out.println("You sit down at the table and begin to play a game...");
                input.nextLine();
                System.out.println(".");
                input.nextLine();
                System.out.println(".");
                input.nextLine();
                System.out.println("!!!");
                input.nextLine();

                Random RNG = new Random();
                int coinflip = RNG.nextInt(1, 3);

                if (coinflip == 1){
                    System.out.println("Coinflip event: Heads");
                    input.nextLine();
                    System.out.println("You won the match.");
                    input.nextLine();
                    System.out.println("One of the men whispers from the back");
                    input.nextLine();
                    System.out.println("\"Boss. What do we do?\"");
                    input.nextLine();
                    System.out.println("\"Never said we weren't allowed to rob them eh? My intentions are honest.\"");
                    input.nextLine();

                    System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    System.out.println("");
                    storyBattle(F2R1);

                    hasPlayerMadeChoice = true;

                } else if (coinflip == 2){
                    System.out.println("Coinflip event: Tails");
                    input.nextLine();
                    System.out.println("You lost the match.");
                    input.nextLine();
                    System.out.println("\"Pleasure doing business with you...\"");
                    input.nextLine();

                    main.loseCoinEvent();

                    //lose all coins event
                    //no keycard rewarded

                    hasPlayerMadeChoice = true;
                 }

            } else if (choice.equals("2")){
                System.out.println("Perry locks the doors behind you");
                input.nextLine();
                System.out.println("\"You know the drill, boys!\"");
                input.nextLine();

                System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println("");
                storyBattle(F2R1);

                hasPlayerMadeChoice = true;

            }
        }


    }

    public boolean isEventFloor2Room1Completed(){
        return eventFloor2Room1Completed;
    }


//"Floor 2 Room 3", "[2][2] East - Fixwood", Mood changing event + colour tba
    public void eventFloor2Room3(Scanner input){
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"A gaggle of plain clothed individuals sat around the poker table.",
            "\"Marcus, who is this?\"",
            "I don't know",
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }

        boolean hasPlayerMadeChoice = false;

        System.out.println("\"Are you one of the Redblack fellas? I didn't think they liked being up here.\"");
        System.out.println("----");
        while (!hasPlayerMadeChoice){
            System.out.println("1. Say yes.");
            System.out.println("2. Say no.");
            choice = input.nextLine().trim().toLowerCase();

            if(choice.equals("1")){
                System.out.println("");
                System.out.println("\"You must be new, because our kind have been told to kill you on sight. We have bounties to keep, you know?\"");
                input.nextLine();

                //lower mood event

                hasPlayerMadeChoice = true;
            } else if (choice.equals("2")){
                System.out.println("");
                System.out.println("\"Well good. One less to worry about.\"");
                input.nextLine();
                System.out.println("\"Say though, your pockets are looking awfully full for a regular layperson, and rent is due.\"");
                input.nextLine();

                //raise mood event

                hasPlayerMadeChoice = true;
            }
        }

        //battle
        System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("");
        storyBattle(F2R3);

        eventFloor2Room3Completed = true;
    }
    public boolean isEventFloor2Room3Completed(){
        return eventFloor2Room3Completed;
    }








// FLOOR 333333333333333333333333333333333333

//"Floor 3 Room 2", "[1][1] elevator",
    public void eventFloor3Room2(Scanner input){ // only needs colours 

        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"There was a man standing in the way of the entrance. He was a big guy with an even bigger suitcase, wearing a bespoke tailored black suit.",
            "Behind him was more of the same. I stood out like a sore thumb.",
            "\"You weren't who we were expecting, but we will let you in nonetheless.\"",
            "He leads me to a large green table. In the back there is a bar with a man and a woman serving as bartenders.",
            "\"Jack, is this really the guy who is meant to be here? I don't see no checks on him.\"",
            "\"Don't go doubting someone cuz they aren't docked up to the nines, eh?\"",
            "The bartender slid me a drink, and a voice calls out from the back",
            "\"Baccarat tonite, drinks on me.\"",
            "\"I hand over the district area to you if you best me this round\"",
            "\"Bet\"",
            ".",
            ".",
            ".",
            "And thus, a lively game of Baccarat took place.",
            "\"You &*%%&@#& I'll *&%$#$%^\"",
            "*Loud slamming*",
            "Every few seconds, glass shattering can be heard.",
            "Someone grabs your shirt and flings you across the table.",
            "There is no way you are leaving this room without a fight."
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }

        //battle
        System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("");
        storyBattle(F3R2);

        eventFloor3Room2Completed = true;
    }
    public boolean isEventFloor3Room2Completed(){
        return eventFloor3Room2Completed;
    }

//"Floor 3 Room 1", "[1][0] Foyer Fortuna west", colour
    public void eventFloor3Room1(Scanner input){
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"There was a grizzled man sitting on the far side of the bar. He sat alone, empty glass cup in hand with his subordinates off to the side discussing something unimportant.",
            "The windows revealed the reflection of his face as well as yourself standing near the entrance of the room.",
            "By now, you looked like a mess. He noticed.",
            "\"Who are you? You gonna roughhouse this place like the rest of em?\"",
            "You stood in place.",
            "\"I've seen many people like you before. \"",
            "He invites you to sit.",
            "\"If y'ask me, Fortuna has lost its way. I was once the right hand advisor to the big boss, believe it or not.\"",
            "\"Those threads on you tell me Fortuna has not changed since they disgraced me.\"",
            "The soldato in the back quiet down.",
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }
        boolean hasPlayerMadeChoice = false;

        System.out.println("\"Kid, what's your goal here? What are you trying to do?\"");
        System.out.println("----");
        while (!hasPlayerMadeChoice){
            System.out.println("1. Be honest. Say you are looking for your father");
            System.out.println("2. Say you are here to make it big.");
            choice = input.nextLine().trim().toLowerCase();

            if(choice.equals("1")){
                System.out.println("");
                F3r1eventChoice1(input);

                hasPlayerMadeChoice = true;
            } else if (choice.equals("2")){
                System.out.println("");
                F3r1eventChoice2(input);

                hasPlayerMadeChoice = true;
            }
        }
        eventFloor3Room1Completed = true;
    }
    public void F3r1eventChoice1(Scanner input){//inconsistent naming, i'm sowwyyy. //choice 1 - player is honest
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"\"Is it just that?\"",
            "\"Kid, I'll let you in on something. Your father is long gone. I guarantee it.\"",
            "\"This place collects 'debt'. All sorts of debt. If yer father was lost here, his debt has already been collected.\"",
            "\"...\"",
            "\"I'll tell you right now. It's not worth the effort.\"",
            "\"I tried in the past. Oh, I tried real hard. But big guys get big money to swing around. Their hands are everywhere.\"",
            "\"The moment power gets to some people's head, they get a sickness. I've tried to cure it all I could but you see me. They don't want to be cured.\"",
            "\"I warn you not to fall into the same sickness. Neither to fall to debt to the likes of us sharks.\"",
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }

        main.winCoinEvent(F3R1WinCoinEvent);
        main.winKeyItemEvent(F3R1KeyItems);
        //another event to give the keycard

    }
    public void F3r1eventChoice2(Scanner input){//choice 2 - player says they want to make it big
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"\"I've seen many like you… Always terrible at lying.\"",
            "\"I don't know why you are here - or why you hide it - but if your goal is the top with nothing but scraps on you, a wake up call is what you really need.\"",
            "\"Prove it to me. Prove you can make it big then.\"",
            "He raises his hand and clicks his fingers. The soldato behind him are alerted immediately and ready their guns."
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }

        //battle
        System.out.println("*Battle start*");///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println(""); 
        storyBattle(F3R1);

    }
    public boolean isEventFloor3Room1Completed(){ 
        return eventFloor3Room1Completed;
    }



//"Floor 3 Room 3", "[1][2] Foyer east - fixwood", 
    public void eventFloor3Room3(Scanner input){
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"You enter a strange room with a deerhead, several pool tables, darts, and another bar counter. Its aesthetics are completely different to the rest of the building.",
            "All of the people in the room seem to be too absorbed in activity to notice that you are inside with them. It isn't until a woman with a cigar and suspenders turns to the front entrance that your presence becomes known.",
            "\"We got a new mate joining us. Looks like they've been through the shitter.\"",
            "\"Kid, what are you even doing here? You lost? You should get lost.\"",
            "A janitor comes up behind you and sweeps your dirt-ladden shoeprints off the shiny wooden flooring.",
            "\"Ay, if they've made it here, test his luck!\"",
            "The others look around and clamour among themselves.",
            "The woman huffs the cigar for a moment, and turns to you.",
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }

        System.out.println("\"Young blood, you play darts?\"");
        System.out.println("----");
        System.out.println("1. Nod your head");
        System.out.println("2. Shake your head");
        input.nextLine();

        f3r3pt2(input);


        eventFloor3Room3Completed = true;
    }
    public void f3r3pt2(Scanner input){
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"She ignores your response and drags you over to the oche. She then leans over and whispers:",
            "\"You look like me when I first stepped onto this floor. I'll give you a shot to keep your place here. If you miss or hit a single, I'm grounding you to a paste.\"",
            "She then hands you a single dart. It pulses like the chips.",
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }

        boolean hasPlayerMadeChoice = false;
        boolean hasWonDartsGame = false;

        System.out.println("Play darts");
        input.nextLine(); 

        while (!hasPlayerMadeChoice){
            System.out.println("1. Throw the dart");
            choice = input.nextLine().trim().toLowerCase();
            //darts game

            if(choice.equals("1")){
                System.out.println(".");
                Random RNG = new Random();
                int dartsChance = RNG.nextInt(1,101);

                if (dartsChance<=30){
                    System.out.println("You missed completely");
                    hasWonDartsGame = false;
                } else if (dartsChance<=80){
                    System.out.println("You hit a single");
                    hasWonDartsGame = false;
                } else if (dartsChance <= 90){
                    System.out.println("You hit a double ring");
                    hasWonDartsGame = true;
                    
                } else if (dartsChance <= 95){
                    System.out.println("You hit a triple ring");
                    hasWonDartsGame = true;

                } else {
                    System.out.println("You hit bullseye");
                    hasWonDartsGame = true;
                }
                
                hasPlayerMadeChoice = true;
            }
            
        }

        if(hasWonDartsGame){
            System.out.println("");
            System.out.println("Not bad.");
            input.nextLine();

            main.winCoinEvent(F3R1WinCoinEvent); //same grey coins
            input.nextLine();
            System.out.println("One last test before I let you loose kid. Keep your place if you can win against me!");
            input.nextLine();


        } else {

            System.out.println("");
            System.out.println("\"Batters up! Hahaha!\"");
            input.nextLine();


        }

        System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("");
        storyBattle(F3R3); //
    
    }
    public boolean isEventFloor3Room3Completed(){
        return eventFloor3Room3Completed;
    }






// FLOOR 4444444444444444444444444444444


//"Floor 4 Room 1", "[0][0] The edge, west",
    public void eventFloor4Room1(Scanner input){
        System.out.println("Story event: x to skip, enter to continue");
        String[] lines = {"This place is a lounge with large windows spanning the entire area. It is possible to see almost all of Sharktown from here.",
            "There was a slim man standing in front of the windows, observing the happenings below him.",
            "...",
            "\"I know you are there.\"",
            "He does not turn around.",
            "\"It has been a long time since someone unauthorised has come up here.\"",
            "\"My name is Lanksy. I am a mere secretary.\"",
            "\"Let me guess. You have perhaps lost something? Or someone?\"",
            "\"This place may one day crumble, but a Shark will always rule. This shark may step on people's toes. It may benefit only its close circle. It may also be benevolent. Regardless, it will always exist. It is the nature of humanity.\"",
            "\"I too have lost many things. I believe you would not be here otherwise.\"",
            "He clicks his pen and brings out a small notepad. His hand moves so fast that you cannot tell what he is writing.",
        };
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
                System.out.println("");
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); 
            }
            
        }

        boolean hasPlayerMadeChoice = false;

        System.out.println("\"Tell me. Do you agree that the strong must rule against the weak?\"");
        System.out.println("----");
        while (!hasPlayerMadeChoice){
            System.out.println("1. Yes");
            System.out.println("2. No");

            choice = input.nextLine().trim().toLowerCase();

            if (choice.equals("1")){ //yes (strong control the weak)
                f1r1Choice1(input);
                hasPlayerMadeChoice = true;

            } else if (choice.equals("2")){ //no (strong control the weak)
                f1r1Choice2(input);
                hasPlayerMadeChoice = true;
            }
        }
        eventFloor4Room1Completed = true;
    }

    //the strong must rule against the weak
    public void f1r1Choice1(Scanner input){ // yes, strong control the weak
        boolean hasPlayerMadeChoice = false;
        
        System.out.println("He writes some more");
        input.nextLine();
        System.out.println("\"Do you consider yourself strong?\"");
        System.out.println("----");

        while (!hasPlayerMadeChoice) {
            System.out.println("1. Yes");
            System.out.println("2. No");

            String choice = input.nextLine().trim().toLowerCase();

            if(choice.equals("1")){
                f1r1Choice1_Choice1(input);
                hasPlayerMadeChoice = true;
            } else if (choice.equals("2")){
                f1r1Choice1_Choice2(input);
                hasPlayerMadeChoice = true;
            }
        }

    }
    
    //dead end - the strong must rule - I am strong
    public void f1r1Choice1_Choice1(Scanner input){ //Do you consider yourself strong? - yes
        System.out.println("\"I see. So this is how it is.\"");
        input.nextLine();
        System.out.println("Prove your theory then. Beat me, and beat the one behind the oaken doors. When you reach the top, tell me if you are happy?");
        input.nextLine();

        System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("");
        storyBattle(F4R1); //
    }
    //the strong must rule - I am not strong
    public void f1r1Choice1_Choice2(Scanner input){ //Do you consider yourself strong? - no
        boolean hasPlayerMadeChoice = false;

        System.out.println("\"How curious.\"");
        input.nextLine();
        System.out.println("\"Are you happy like this? Being weak?\"");
        System.out.println("----");

        while (!hasPlayerMadeChoice) {
            System.out.println("1. Yes");
            System.out.println("2. No");

            String choice = input.nextLine().trim().toLowerCase();

            if(choice.equals("1")){
                //f1r1Choice1_Choice2_Choice1(input);
                System.out.println("\"Then why are you here? If not to prove you are strong? Stronger than those who took what you lost?\"");
                input.nextLine();
                System.out.println("\"Beat me, and see if you are truly happy if you lose.\"");
                input.nextLine();

                System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println("");
                storyBattle(F4R1); //

                hasPlayerMadeChoice = true;
            } else if (choice.equals("2")){
                f1r1Choice1_Choice2_Choice2(input);
                hasPlayerMadeChoice = true;
            }
        }
    }
    
    //dead end / the strong must rule - I am not strong - I'm not happy like this
    public void f1r1Choice1_Choice2_Choice2(Scanner input){ //What will you do about it then?
        boolean hasPlayerMadeChoice = false;

        System.out.println("What will you do about it then?");
        System.out.println("----");

        while (!hasPlayerMadeChoice) {
            System.out.println("1. I will become strong");
            System.out.println("2. I don't know");

            String choice = input.nextLine().trim().toLowerCase();

            if(choice.equals("1")){
                //f1r1Choice1_Choice2_Choice1(input);
                System.out.println("\"Beat me then, and see if you are truly happy if you win.\"");
                input.nextLine();

                System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println("");
                storyBattle(F4R1); //

                hasPlayerMadeChoice = true;
            } else if (choice.equals("2")){
                System.out.println("\"The mind is plagued, yet you have proven yourself stronger than most. Go to the oaken doors and tell me if you are truly happy after your ordeal.\"");
                input.nextLine();

                hasPlayerMadeChoice = true;
            }
            
        }
    }


    
    // the strong do not control the weak
    public void f1r1Choice2(Scanner input){
        boolean hasPlayerMadeChoice = false;

        System.out.println("\"Then who rules over the rest?\"");
        System.out.println("----");

        while (!hasPlayerMadeChoice) {
            System.out.println("1. The wealthy");
            System.out.println("2. I don't know");

            String choice = input.nextLine().trim().toLowerCase();

            if(choice.equals("1")){
                f1r1Choice2_Choice1(input);
                hasPlayerMadeChoice = true;
            } else if (choice.equals("2")){
                f1r1Choice2_Choice2(input);
                hasPlayerMadeChoice = true;
            }
        }
    }
    // the strong do not control the weak - the wealthy
    public void f1r1Choice2_Choice1(Scanner input){
        boolean hasPlayerMadeChoice = false;

        System.out.println("\"So money buys strength? How does one gain money then if the money is already controlled by the strong?\"");
        System.out.println("----");

        while (!hasPlayerMadeChoice) {
            System.out.println("1. They were not always strong");
            System.out.println("2. They gain money by being strong");

            String choice = input.nextLine().trim().toLowerCase();

            if(choice.equals("1")){
                f1r1Choice2_Choice1_Choice1(input);
                hasPlayerMadeChoice = true;
            } else if (choice.equals("2")){
                f1r1Choice2_Choice1_Choice1(input); //intentional
                hasPlayerMadeChoice = true;
            }
        }

    }
    //dead end - the wealthy - They were not always strong
    public void f1r1Choice2_Choice1_Choice1(Scanner input){
        boolean hasPlayerMadeChoice = false;

        System.out.println("\"I see. Will you be happy if you are strong?\"");
        System.out.println("----");

        while (!hasPlayerMadeChoice) {
            System.out.println("1. Yes");
            System.out.println("2. No");

            String choice = input.nextLine().trim().toLowerCase();

            if(choice.equals("1")){
                System.out.println("\"Beat me then, and see if you are truly happy if you win.\"");
                input.nextLine();

                System.out.println("*Battle start*"); ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println("");
                storyBattle(F4R1); //

                hasPlayerMadeChoice = true;
            } else if (choice.equals("2")){
                System.out.println("Then what will make you happy?");
                System.out.println("----");

                while (!hasPlayerMadeChoice) {
                    System.out.println("1. Closure");

                    choice = input.nextLine().trim().toLowerCase();

                    if(choice.equals("1")){
                        System.out.println("\"Go to the oaken doors and tell me if you are truly happy after your ordeal.\"");
                        input.nextLine();
                        hasPlayerMadeChoice = true;
                    }
                }

                
            }
        }

    }

    //dead end - who rules - I dont know
    public void f1r1Choice2_Choice2(Scanner input){
        boolean hasPlayerMadeChoice = false;

        System.out.println("\"One comes here to the 4th floor without having thought of much, I see.\"");
        input.nextLine();
        System.out.println("\"What are you truly looking for then?\"");
        System.out.println("----");

        while (!hasPlayerMadeChoice) {
            System.out.println("1. Closure");

            String choice = input.nextLine().trim().toLowerCase();

            if(choice.equals("1")){
                System.out.println("\"I see. Go to the oaken doors and tell me if you are truly happy after your ordeal.\"");
                input.nextLine();
                hasPlayerMadeChoice = true;
            }
        }

    }



    public boolean isEventFloor4Room1Completed(){
        return eventFloor4Room1Completed;
    }

//"Floor 4 Room 2", "[0][1] Elevator hall",
    public void eventFloor4Room2(Scanner input){
        System.out.println("eventFloor4Room2");
        input.nextLine();

        eventFloor4Room2Completed = true;
    }
    public boolean isEventFloor4Room2Completed(){
        return eventFloor4Room2Completed;
    }







    
//"Floor 4 Room 3", "[0][2] Foyer",
    public void eventFloor4Room3(Scanner input){
        System.out.println("eventFloor4Room3");
        input.nextLine();

        eventFloor4Room3Completed = true;
    }
    public boolean isEventFloor4Room3Completed(){
        return eventFloor4Room3Completed;
    }



//SPECIAL ROOOOOOOOOOOOOOOOOOOOMS


//"Floor 4 Room 4", "[0][3] Head office",
    public void eventFloor4Room4(Scanner input){
        System.out.println("eventFloor4Room4");
        input.nextLine();

        eventFloor4Room4Completed = true;
    }
    public boolean isEventFloor4Room4Completed(){
        return eventFloor4Room4Completed;
    }

//"Floor 3 Room 4", "[1][3] Head office elevator 1",
    public void eventFloor3Room4(Scanner input){
        System.out.println("eventFloor3Room4");
        input.nextLine();

        eventFloor3Room4Completed = true;
    }
    public boolean isEventFloor3Room4Completed(){
        return eventFloor3Room4Completed;
    }

//"Floor 2 Room 4", "[2][3] Head office elevator 2",
    public void eventFloor2Room4(Scanner input){
        System.out.println("eventFloor2Room4");
        input.nextLine();

        eventFloor2Room4Completed = true;
    }
    public boolean isEventFloor2Room4Completed(){
        return eventFloor2Room4Completed;
    }

//"Floor 1 Room 4", "[3][3] Head office elevator 3 - Factory floor",
    public void eventFloor1Room4(Scanner input){
        System.out.println("eventFloor1Room4");
        input.nextLine();

        eventFloor1Room4Completed = true;
    }
    public boolean isEventFloor1Room4Completed(){
        return eventFloor1Room4Completed;
    }


}