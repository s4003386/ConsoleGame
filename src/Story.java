package src;
import java.util.Scanner;
import java.util.Random;


public class Story {
    //add colours and timing delays if there is time
    private boolean introCutsceneCompleted = false; //default false always
    private boolean eventFloor1Room1Completed = false;
    private boolean eventFloor1Room2Completed = false;
    private int playerChoice;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String Speaker1 = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";



    public void introCutscene(Scanner input){
        //System.out.println("Press x to skip");
        //System.out.println("Press y for auto");
        System.out.println("The time is midnight. Below me is the body of the local 'red black' syndicate.");
            input.nextLine();
        System.out.println("I look up. The night sky is filled with light from the highest point in the city, Sharktown casino.");
        input.nextLine();
        System.out.println("My father disappeared a week ago. He left for Sharktown with the hope of hitting it big. Now I'm in destitution");
        input.nextLine();
        System.out.println("shuffle*");
        input.nextLine();
        System.out.println("In a red and black shirt, I head towards the flashing lights of the casino.");
        input.nextLine();

        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println("Floor 1: Lobby");
        input.nextLine();
        System.out.println("The security guard of this place took a quick glance at me, and simply nodded. It didn't matter if this outfit was covered in rain and blood. ");
        input.nextLine();
        System.out.println("My original goal was to get to the poker machines, but another man sitting on a couch hollers for my attention. ");
        input.nextLine();
        System.out.println(Speaker1 + " \"Who are you?\" He asks. \"I didn't know the guys out east had business with us.\" " + ANSI_RESET);
        input.nextLine();
        System.out.println("\"...They don't. I'm here by my own volition.\"");
        input.nextLine();
        System.out.println(Speaker1 + "\"If you're after the machines, lets play a game then eh? Whoever rolls highest is the winner and ill throw my chips your way.\""  + ANSI_RESET);
        input.nextLine();

        introCutsceneCompleted = true;
    } 

    /* no clue how to even set up a skip system T_T
    public void inputField(Scanner input){
        String inputFieldString = input.nextLine();
        if (inputFieldString.equals("x")){
            
        }
    }*/

    public boolean isIntroCutsceneCompleted(){
        return introCutsceneCompleted;
    }


    //"Floor 1 Room 1", "[3][0] Foyer",
    public void eventFloor1Room1(Scanner input){ //presumably inventory / buffsdebuffs etc also are inputted here
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
        System.out.println("He takes you to a bright red machine and gives you a peculiar coin. It pulses like a heart in your hand.");
        input.nextLine();
        System.out.println("All around you are people who's eyes are desperately glued to the machines. They aren't checking if they are winning or losing at all.");
        input.nextLine();
        System.out.println("\"What are you waiting for? Just spin already\"");
        input.nextLine();   

        System.out.println("----");
        System.out.println("1. Pull the lever");
        input.nextLine();

        Random rng = new Random();
        int coinflip = rng.nextInt(1, 3);
        System.out.println("Rolled a " + coinflip);

        if (coinflip == 1){
            System.out.println("Event coinflip head");

            /*
            
            On win: 

            “What!? I paid good money to get those chips. Don’t tell me I gave you the good one!?”

            “Whatever. Follow me and I’ll give you what I got.”

            Agree:

            “…Chap, you got to stop believing in what everyone says. I’m trying to rob you over here.”

            (Battle initiated) Received a cheap good roll coin x1 

            Disagree:

            I never said you had a choice, did I?

            (Battle initiated).Received a cheap good roll coin x1
            */
        } else {
            System.out.println("Event coinflip tails");

        }
        
    }
    public void eventFloor1Room1Choice2(Scanner input){ //player says 'no thanks'
        System.out.println("\"Don't give me that answer\"");
        input.nextLine();
        
            /*
                “Don’t give me that answer”

                He dragged me by the arm to a place behind the poker machines. 

                “You see these things in my hand?”

                He flips a coin with his thumb several times. It always landed on heads.

                “See this? I paid good money for this coin. Blokes from out back don’t know this but the house here makes and sells their own coin.”

                “This stuff mogs physics. You wont see this thing lose… Usually. Which is why your pockets are looking real good at the moment.” 

                “Homeboy is strapped for cash and if you know what's good, ill leave you unshanked if you hand over what you got right now.”

                <Battle initiated>

            */
    }
    
    public boolean isEventFloor1Room1Completed(){
        return eventFloor1Room1Completed;
    }




//"Floor 1 Room 2", "[3][1] Elevator room", 
    public void eventFloor1Room2(){

    }
    public boolean isEventFloor1Room2Completed(){
        return eventFloor1Room2Completed;
    }

    public void eventFloor2Room1(){

    }

}
