package src;

import java.util.ArrayList;

public class Character {
    //instance variable/attributes
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    //position
    private int currentRow;  
    private int currentCol;
    //private static boolean isElevatorTile;

    //attributes
    private int health;

    //inventory
    private ArrayList<String> buffAndDebuff; 
    private int[] NoOfCoin = new int[7];
    private String[] NameOfCoin = new String[7];
    
    //cards and such
    private ArrayList<String> cardList; //not sure how you are planning on storing cards but I'm putting them here






    public int getRow(){
        return currentRow;
    }
    
    public int getCol(){
        return currentCol;
    }


    //default constructor
    public Character(){
        this.currentCol = 3; //start bottom left
        this.currentRow = 0;
        //this.isElevatorTile = false;
    }

    

    //position methods
    public void setPosition(int row, int col){
        this.currentRow = row;
        this.currentCol = col;
    }

    public void moveNorth() {
        currentCol--;
    }

    public void moveSouth (){
        currentCol++;
    }

    public void moveEast(){
        currentRow++;
    }

    public void moveWest() {
        currentRow--;
    }

    /* 

    //inventory methods
    public void addItem(String item){
        inventory.add(item);
    }
        */

    public void showInventory() {
        System.out.println("\n =========Inventory");
    
        //check if inven is populated with items
        if (buffAndDebuff.isEmpty()){
            System.out.println("inven is empty");
        } else {
            //if inven has items, then print:
            for(String item: buffAndDebuff) {
                System.out.println("- " + item);
            }
        }
    }
        
}
