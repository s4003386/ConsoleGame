package src;

import java.util.Scanner;

public class main {
        private static boolean gameRunning = true;
        static Scanner input = new Scanner(System.in);
        private static location[][] map = new location[4][4];
        private static character mainCharacter = new character();


    public static void setUpGame(){

        //'location' counts as one individual room. each is one object

            map [3][0] = new location("Room 1 floor 1", "Foyer");
            map [3][1] = new location("Room 2 floor 1", "Elevator room");
            map [3][2] = new location("Room 3 floor 1", "Rec room");
            map [3][3] = new location("Room 4 floor 1", " ---innacessable");

            map [2][0] = new location("Room 1 floor 1", "n/a");
            map [2][1] = new location("Room 2 floor 1", "n/a");
            map [2][2] = new location("Room 3 floor 1", "n/a");
            map [2][3] = new location("Room 4 floor 1", "n/a");
    }

    public static void showMenu(){

    }
    

    
    public static void main(String[] args){
        System.out.println("main");
        
        setUpGame();
            System.out.println("New Game");


            //for testing
            System.out.println("Press 1 for location, 2 to move");
            String menuLocation = input.nextLine();

            if (menuLocation.equals("1")){
                System.out.println("You are currently in...");
                System.out.println(map[3][0]); 
            }

        /* 
        do {
        } while (gameRunning);
         */

    } 
}
