package src;
import java.util.Scanner;


public class Story {
    //add colours and timing delays if there is time
    private boolean introCutsceneCompleted = false; //default false always
    private boolean eventFloor1Completed = false;
    private int playerChoice;



    public void introCutscene(Scanner input){
        //System.out.println("Press x to skip");
        //System.out.println("Press y for auto");
        System.out.println("Line 1");
        input.nextLine();
        System.out.println("Line 2");
        input.nextLine();
        System.out.println("Line 3");
        input.nextLine();
        System.out.println("Line 4");
        input.nextLine();
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println("Floor 1: Lobby");
        input.nextLine();
        System.out.println("Line 5");
        input.nextLine();
        System.out.println("Line 6");
        input.nextLine();
        System.out.println("Line 7");
        input.nextLine();
        System.out.println("Line 8");
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

}
