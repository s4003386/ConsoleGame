import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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
    private ArrayList<String> buffAndDebuff = new ArrayList<>(); 
    private ArrayList<String> keyItems = new ArrayList<>(); //contains keycards for travelling up floors, etc
    private ArrayList<Coin> Coins = new ArrayList<>();
    
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










    //Inventory methods
    public void addCoinItem(Coin[] rewardedCoinItem){
        Coins.addAll(Arrays.asList(rewardedCoinItem));
    }

    public void addKeyItem(ArrayList<String> rewardedKeyItem){
        keyItems.addAll(rewardedKeyItem);
    }

    public ArrayList<String> getKeyItems(){
        return keyItems;
    }

    public void showInventory() {
        System.out.println("\n =========Inventory");
    

        System.out.println(" === coins ===");
        if(Coins.isEmpty()){
            System.out.println("Inventory is empty.");
        } else {


            //what is long?
            Map<Coin, Long> counts = Coins.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

            counts.forEach((coin, count) ->
                System.out.println(count + " x " + coin)
            );


            /* 
            for(Coin item: Coins) {
                System.out.println("- " + item); 
            }*/

        }

        System.out.println(" === Key Items === ");
        if(keyItems.isEmpty()){
            System.out.println("Inventory is empty.");
        } else {
            for(String items: keyItems){
                System.out.println("- " + items);
            }
        }
    }

    
        
}