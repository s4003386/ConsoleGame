package src;
import java.util.Scanner;
import java.util.Random;


public class Story {
    //add colours and timing delays if there is time
    private boolean introCutsceneCompleted = false; //default false always

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

    public static final String ANSI_RESET = "\u001B[0m"; //reset
    public static final String Speaker1 = "\u001B[31m"; //red
    public static final String Speaker2 = "\u001B[32m";//green
    public static final String Speaker3 = "\u001B[34m";//blue


// start of game
    public void introCutscene(Scanner input){
        String[] lines = {
            "The time is midnight. Below me is the body of the local 'red black' syndicate.",
            "I look up. The night sky is filled with light from the highest point in the city, Sharktown casino.",
            "My father disappeared a week ago. He left for Sharktown with the hope of hitting it big. Now I'm in destitution",
            "shuffle*",
            "In a red and black shirt, I head towards the flashing lights of the casino.",
            ".",
            ".",
            ".",
            "Floor 1 Room 1 - [3][0] Foyer",
            "The security guard of this place took a quick glance at me, and simply nodded. It didn't matter if this outfit was covered in rain and blood.",
            "My original goal was to get to the poker machines, but another man sitting on a couch hollers for my attention.",
            Speaker1 + " \"Who are you?\" He asks. \"I didn't know the guys out east had business with us.\" " + ANSI_RESET,
            "\"...They don't. I'm here by my own volition.\"",
            Speaker1 + "\"If you're after the machines, lets play a game then eh? Whoever rolls highest is the winner and ill throw my chips your way.\"" + ANSI_RESET
        };

        System.out.println("Enter to continue text, Press x to skip");
        String choice = input.nextLine().trim().toLowerCase(); //'choice' is used to record input

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
            }
            /* 
        } else if (choice.equals("y")){
            for (String i : lines){
                System.out.println(i); //figure the timing out later
            }
        */
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
        System.out.println(".");
        System.out.println("Win or lose this event? (debug)"); // default win for now
        System.out.println("Encounter won (debug - winBattleDebug())");
        debugWinLoseEvent = true;
        return debugWinLoseEvent;

    }

    public void showCompletedEvents(){
        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());
        System.out.println("[3][1] F1 R2 elevator: " + isEventFloor1Room2Completed());
        System.out.println("[3][2] F1 R3: " + isEventFloor1Room3Completed());
        
        /* 
        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());
        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());
        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());

        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());
        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());
        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());

        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());
        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());
        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());
        System.out.println("[3][0] F1 R1: " + isEventFloor1Room1Completed());
        */
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
                System.out.println("You picked choice 1");
                eventFloor1Room1Choice1(input);
                hasPlayerMadeChoice = true;
                break;

            } else if (playerChoice == 2){
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



        System.out.println("----");
        System.out.println("1. Pull the lever");
        input.nextLine();

        Random rng = new Random();
        int coinflip = rng.nextInt(1, 3);
        System.out.println("Rolled a " + coinflip);

        if (coinflip == 1){
           // boolean hasPlayerChose = false;
            System.out.println("Event coinflip head");

            System.out.println(Speaker1 + "\"What!? I paid good money to get those chips. Don't tell me I gave you the good one!?\"" + ANSI_RESET);
            input.nextLine();
            System.out.println(Speaker1 + "\"Whatever. Follow me and I'll give you what I got.\"" + ANSI_RESET); 
            System.out.println("- - - - -");
            System.out.println("1. Agree");
            System.out.println("2. Disagree");

            playerChoice = input.nextInt();
            input.nextLine();
            //hasPlayerChose = false;

            
            if (playerChoice == 1){
                System.out.println("You chose option 1");
                System.out.println(Speaker1 + "\"…Chap, you got to stop believing in what everyone says. I'm trying to rob you over here.\"" + ANSI_RESET);
                input.nextLine();

                System.out.println("*Battle start*");

                //battle initiated here
                //on battle win, recieve a white coin
                //battle 1 here. Return if battle won or lost btw so I can do after battle story
            } else if (playerChoice == 2){
                System.out.println("You chose option 2");
                System.out.println(Speaker1 + "\"I never said you had a choice, did I?\"" + ANSI_RESET);
                input.nextLine();
                System.out.println("*Battle start*");
                            

                //(Battle initiated).Received a cheap good roll coin x1
                //Battle 1 here
            }
            

        } else {
            System.out.println("Event coinflip tails");
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
            

            System.out.println("*Battle initiated*");

            //Battle 1 here
        }
        
    }
    public void eventFloor1Room1Choice2(Scanner input){ //player says 'no thanks'
        String[] lines = {"\"Don't give me that answer.\"",
                            "He dragged me by the arm to a place behind the poker machines. ",
                            " \"You see these things in my hand?\"",
                            "He flips a coin with his thumb several times. It always landed on heads.",
                            " \" See this? I paid good money for this coin. Blokes from out back don't know this but the house here makes and sells their own coin.\"",
                            " \"This stuff mogs physics. You wont see this thing lose… Usually. Which is why your pockets are looking real good at the moment.\" ",
                            "\"Homeboy is strapped for cash and if you know what's good, ill leave you unshanked if you hand over what you got right now.\""
        };
        String choice = input.nextLine().trim().toLowerCase(); //to be honest, there is probably a better way of doing this but I cant really be bothered rn
    
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

        System.out.println("*Battle Initiated*");
        //Battle 1 initiated. Same thing as before

    }
    public boolean isEventFloor1Room1Completed(){
        return eventFloor1Room1Completed;
    }

//"Floor 1 Room 2", "[3][1] Elevator room", 
    public void eventFloor1Room2(Scanner input){
        String[] lines = {"Before you could do anything, a group of 3 blocked your route towards the elevator.",
            "\"Look, to be frank, the moment you started running your mouth, I knew you weren't one of us folk.\"",
            "\"Who did you have to beat up to get that shirt? Huh? We aren't letting this go.\"",
        };
        String choice = input.nextLine().trim().toLowerCase(); //'choice' is used to record input

        if (choice.equals("x")) {
            for (String i : lines){
                System.out.println(i);
            }
        } else {
            for (String i : lines){
                System.out.println(i);
                input.nextLine(); //wont allow mid cutscene skip but i'm too stoopid rn to think of anything that works
            }
            
        }

        System.out.println("*Battle initiated*");
        input.nextLine();



        /*

        Battle won
        “Okay, okay, I get it. You can stop. I may be a hooligan but I know my limits.”
        “Mates, we leave this one”
        They ran away.
        (You have reached a space with an elevator. After completing any events that happen in this space, you may choose to go up the elevator to the next floor or explore around in other rooms for a bit.)
        (Exploring comes with risks, but you might find many useful items to help you on your way to the top floor.
        */

        //on win
        eventFloor1Room2Completed = true;

    }
    public boolean isEventFloor1Room2Completed(){
        return eventFloor1Room2Completed;
    }

//"Floor 1 Room 3", "[3][2] Rec room",
    public void eventFloor1Room3(Scanner input){
        System.out.println("eventFloor1Room3");
        input.nextLine();

        eventFloor1Room3Completed = true;
    }
    public boolean isEventFloor1Room3Completed(){
        return eventFloor1Room3Completed;
    }


// FLOOR 22222222222222222222222222222222



//"Floor 2 Room 1", "[2][0] Foyer",
    public void eventFloor2Room1(Scanner input){
        System.out.println("eventFloor2Room1");
        input.nextLine();

        eventFloor2Room1Completed = true;
    }
    public boolean isEventFloor2Room1Completed(){
        return eventFloor2Room1Completed;
    }
    
//"Floor 2 Room 2", "[2][1] Foyer",
    public void eventFloor2Room2(Scanner input){
        System.out.println("eventFloor2Room2");
        input.nextLine();

        eventFloor2Room2Completed = true;
    }
    public boolean isEventFloor2Room2Completed(){
        return eventFloor2Room2Completed;
    }

//"Floor 2 Room 3", "[2][2] Foyer",
    public void eventFloor2Room3(Scanner input){
        System.out.println("eventFloor2Room3");
        input.nextLine();

        eventFloor2Room3Completed = true;
    }
    public boolean isEventFloor2Room3Completed(){
        return eventFloor2Room3Completed;
    }


// FLOOR 333333333333333333333333333333333333


//"Floor 3 Room 1", "[1][0] Foyer",
    public void eventFloor3Room1(Scanner input){
        System.out.println("eventFloor3Room1");
        input.nextLine();

        eventFloor3Room1Completed = true;
    }
    public boolean isEventFloor3Room1Completed(){
        return eventFloor3Room1Completed;
    }

//"Floor 3 Room 2", "[1][1] Foyer",
    public void eventFloor3Room2(Scanner input){
        System.out.println("eventFloor3Room2");
        input.nextLine();

        eventFloor3Room2Completed = true;
    }
    public boolean isEventFloor3Room2Completed(){
        return eventFloor3Room2Completed;
    }

//"Floor 3 Room 3", "[1][2] Foyer",
    public void eventFloor3Room3(Scanner input){
        System.out.println("eventFloor3Room3");
        input.nextLine();

        eventFloor3Room3Completed = true;
    }
    public boolean isEventFloor3Room3Completed(){
        return eventFloor3Room3Completed;
    }


// FLOOR 4444444444444444444444444444444


//"Floor 4 Room 1", "[0][0] Foyer",
    public void eventFloor4Room1(Scanner input){
        System.out.println("eventFloor4Room1");
        input.nextLine();

        eventFloor4Room1Completed = true;
    }
    public boolean isEventFloor4Room1Completed(){
        return eventFloor4Room1Completed;
    }

//"Floor 4 Room 2", "[0][1] Foyer",
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
    public boolean isEventFloor3Room4(){
        return eventFloor3Room4Completed;
    }

//"Floor 2 Room 4", "[2][3] Head office elevator 2",
    public void eventFloor2Room4(Scanner input){
        System.out.println("eventFloor2Room4");
        input.nextLine();

        eventFloor2Room4Completed = true;
    }
    public boolean isEventFloor2Room4(){
        return eventFloor2Room4Completed;
    }

//"Floor 1 Room 4", "[3][3] Head office elevator 3 - Factory floor",
    public void eventFloor1Room4(Scanner input){
        System.out.println("eventFloor1Room4");
        input.nextLine();

        eventFloor1Room4Completed = true;
    }
    public boolean isEventFloor1Room4(){
        return eventFloor1Room4Completed;
    }


}
