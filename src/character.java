import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The character class defines the player's attributes + inventory
 * Also contains certain methods for displaying and changing inventory
 * Also keeps track of the location, and contains methods for moving. 
 * Almost all of them are used by the main class.
 */
public class Character {
    //instance variable/attributes
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    private int hp; //health points
    private int maxHp;
    private int def; //defence
    private int power;// to be added
    private int cmv; //coin mood value (-100 to 100) 0 is default :|

    private ArrayList<Integer> cardList; //Empty as player doesnt start with enough cards to edit their deck ?
    private ArrayList<Integer> activeDeck;

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

        this.maxHp = 20;
        this.hp = 20;
        this.def = 12;
        this.cmv = 0;
        this.power = 5;

        this.activeDeck = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10)); // if time lessen cards and add deck editing
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

    //dmg methods
    public int getHp(){
        return hp;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public ArrayList<Integer> getDeck(){
        return activeDeck;
    }
    public int getDef(){
        return def;
    }
    public int getPwr(){
        return power;
    }
    public int getCmv(){
        return cmv;
    }
    public void takeDmg(int dmgTaken){ //for healing just do negative dmg
        hp -= dmgTaken;
    }
    public void defBst(int defenceBoost){ //for healing just do negative dmg
        def -= defenceBoost;
    }
    public void changePwr(int pwrLost){ //for healing just do negative dmg
        power -= pwrLost;
    }

    //Inventory methods
    public void addCoinItem(Coin[] rewardedCoinItem){
        Coins.addAll(Arrays.asList(rewardedCoinItem));
    }

    public ArrayList<Coin> getCoinItems(){
        return this.Coins;
    }

    public void loseAllCoins(){
        this.Coins.removeAll(Coins);
    }
    public void lose1Coin(){
        System.out.println("You lost a coin"); //find out how to name a specific coin at some point
        this.Coins.remove(1);
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

    public void showCardDeck(){
        System.out.println("\n =========Card Deck");
        System.out.println(" === Active Card Deck === ");
        for (Integer card : activeDeck) {
            String CardDets = Cards.cardDictionary.get(card).display;
            System.out.println("Card ID :"+ card);
            System.out.println(CardDets);
        }
        if(!cardList.isEmpty()){
            System.out.println(" === List of all Cards === ");
            for (Integer card : cardList) {
                String CardDets = Cards.cardDictionary.get(card).display;
                System.out.println("Card ID :"+ card);
                System.out.println(CardDets);
            }
        }
        // add deck edititing
    }

    public boolean hasCoinInInventory(Coin targetCoin){
        boolean hasCoin = false;
        if(Coins.contains(targetCoin)){
            hasCoin = true;
        }
        return hasCoin;
    }
    
        
}