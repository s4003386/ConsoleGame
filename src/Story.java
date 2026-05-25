package src;
import java.util.Scanner;


public class Story {
    //add colours and timing delays if there is time
    private boolean introCutsceneCompleted = false; //default false always
    private boolean eventFloor1Completed = false;
    private int playerChoice;
    private String speaker;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String Speaker1 = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";



    public void introCutscene(Scanner input){
        //System.out.println("Press x to skip");
        //System.out.println("Press y for auto");
        System.out.println("The time is midnight. Below me is the body of the local ‘red black’ syndicate.");
        input.nextLine();
        System.out.println("I look up. The night sky is filled with light from the highest point in the city, Sharktown casino.");
        input.nextLine();
        System.out.println("My father disappeared a week ago. He left to Sharktown with the hope of hitting it big. Now I’m in destitute.");
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
        System.out.println("The security guard of this place took a quick glance at me, and simply nodded. It didn’t matter if this outfit was covered in rain and blood. ");
        input.nextLine();
        System.out.println("My original goal was to get to the poker machines, but another man sitting on a couch hollers for my attention. ");
        input.nextLine();
        System.out.println(Speaker1 + "“Who are you?” He asks. “I didn’t know the guys out east had business with us.”" + ANSI_RESET);
        input.nextLine();
        System.out.println("“…They don’t. I’m here by my own volition.”");
        input.nextLine();
        System.out.println("“If you’re after the machines, lets play a game then eh? Whoever rolls highest is the winner and ill throw my chips your way.”");
        input.nextLine();

        introCutsceneCompleted = true;
    } 

    public boolean isIntroCutsceneCompleted(){
        return introCutsceneCompleted;
    }


    public void eventFloor1(Scanner input){ //presumably inventory / buffsdebuffs etc also are inputted here
        System.out.println("make a choice");

        System.out.println("----");
        System.out.println("1. Choice 1");
        System.out.println("2. Choice 2");

        playerChoice = input.nextInt(); //add checkers for incorrect inputs at some point
        input.nextLine();

        if (playerChoice == 1){
            System.out.println("You picked choice 1");

        } else if (playerChoice == 2){
            System.out.println("You picked choice 2");

        }

        eventFloor1Completed = true;


        //probably return something. Status effects that last the entire time, items, etc...
    }

    public boolean isEventFloor1Completed(){
        return eventFloor1Completed;
    }

    public void getSpeaker(){

    }

    public void setSpeaker(){

    }

}
