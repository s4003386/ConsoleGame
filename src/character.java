package src;

import java.util.ArrayList;

public class character {
    //instance variable/attributes
    private String name;

    //position
    private static int currentRow = 3;  // starting position
    private static int currentCol = 0;

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

    public int getCol(){
        return col;
    }

    //position methods
    public void setPosition(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void moveNorth() {
        row --;
    }

    public void moveSouth (){
        row++;
    }

    public void moveEast(){
        col++;
    }

    public void moveWest() {
        col--;
    }


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
