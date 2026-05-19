package src;

import java.util.ArrayList;

public class Character {
    //instance variable/attributes
    private String name;

    //position
    private static int currentRow;  
    private static int currentCol;
    //private static boolean isElevatorTile;

    //attributes
    private int health;

    //inventory
    //private ArrayList<String> inventory; //should it be string...?
    //cards and such





    //constructors

    /* 
    public Character(String name) {
        this.name = name; 

        //start position
        this.row = 0;
        this.col = 0;

        inventory = new ArrayList<>();
    }

    //getters
    public String  getName() {
        return name;
    }

    */

    public int getRow(){
        return currentRow;
    }
    
    public int getCol(){
        return currentCol;
    }

    /* 
    public boolean getIsElevatorTile(){
        return isElevatorTile;
    }*/

    //default constructor
    public Character(){
        this.currentRow = 3; //start bottom left
        this.currentCol = 0;
        //this.isElevatorTile = false;
    }

    

    //position methods
    public void setPosition(int row, int col){
        this.currentRow = row;
        this.currentCol = col;
    }

    public void moveNorth() {
        currentRow --;
    }

    public void moveSouth (){
        currentRow++;
    }

    public void moveEast(){
        currentCol++;
    }

    public void moveWest() {
        currentCol--;
    }

    /* 

    //inventory methods
    public void addItem(String item){
        inventory.add(item);

    }

    public void showInventory() {
        System.out.println("\n =========Inventory");
    
        //check if inven is populated with items
        if (inventory.isEmpty()){
            System.out.println("inven is empty");
        } else {
            //if inven has items, then print:
            for(String item: inventory) {
                System.out.println("- " + item);
            }
        }
    }
        */
}
