//package src;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class simply defines the battles attributes, and Handles some of the combat function.
 * The parameters for creating an object of this class define its ID (which battle is this?), The number of waves, Coin rewards etc
 * Objects of this class are defined in the Story class.
 * Also contains methods for distrubiting coin/key item rewards
 */
public class Battle {
     private String BattleID;

    private Coin[] rewardedCoins;
    private ArrayList<String> rewardedKeyItems;
    private ArrayList<String> EnemiesList;
    private ArrayList<Integer> EnemiesListType;
    private ArrayList<Integer> EnemiesListDef;
    private ArrayList<Integer> EnemiesListCmv;
    private ArrayList<Integer> EnemiesListHp;
 


    public Battle(String BattleID, Coin[] rewardedCoins, ArrayList<String> rewardedKeyItems, ArrayList<String> EnemiesList, ArrayList<Integer> EnemiesListType, ArrayList<Integer> EnemiesListDef, ArrayList<Integer> EnemiesListCmv, ArrayList<Integer> EnemiesListHp){

        this.BattleID = BattleID;
        this.rewardedCoins = rewardedCoins;
        this.rewardedKeyItems = rewardedKeyItems;
        this.EnemiesList = EnemiesList;
        this.EnemiesListType = EnemiesListType;
        this.EnemiesListDef = EnemiesListDef;
        this.EnemiesListCmv = EnemiesListCmv;
        this.EnemiesListHp = EnemiesListHp;    
    }
    public ArrayList<String> getNamesL(){
        return EnemiesList;
    }
    public ArrayList<Integer> getEnemiesTypesL(){
        return EnemiesListType;
    }
    public ArrayList<Integer> getEnemyDefL(){
        return EnemiesListDef;
    }
    public ArrayList<Integer> getEnemyCMVL(){
        return EnemiesListCmv;
    }
    public ArrayList<Integer> getEnemyHPL(){
        return EnemiesListHp;
    }

    public String getBattleID(){
        return BattleID;
    }

    public Coin[] getCoinRewards(){
        return rewardedCoins;
    }

    public boolean isCoinEmpty(Coin[] CoinList) {
        boolean isEmpty;
        if (CoinList != null && CoinList.length > 0) {
            isEmpty = false;
        } else {
            isEmpty = true;
        }
        return isEmpty;
    }

    public int getCoinFrequency(Coin[] Coins, Coin target){
        int quantity = Collections.frequency(Arrays.asList(Coins), target);
        return quantity;
    }

    public ArrayList<String> getKeyItemsRewards(){
        return rewardedKeyItems;
    }

    ///all values that are not specifically maincharacter abc are enemy values
    public boolean startBattle(ArrayList<Integer> activedeck, ArrayList<String> enemyList, ArrayList<Integer> type, ArrayList<Integer> Def, ArrayList<Integer> CMV, ArrayList<Integer> HP, Character mainCharacter){
        boolean won = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combat start");
        ArrayList<Integer> currentHand = new ArrayList<>();
        ArrayList<Integer> discarded = new ArrayList<>();
        ArrayList<Integer> drawpile = new ArrayList<>();
        int waves = 0;

        drawpile.addAll(activedeck);
        Collections.shuffle(drawpile);
        List<Integer> Pop = drawpile.subList(drawpile.size() - 3, drawpile.size());
        currentHand.addAll(Pop);
        Pop.clear();
        System.out.println(currentHand);
        System.out.println(drawpile);

        ArrayList<String> combatOrder = new ArrayList<>();
        combatOrder.add("Player");
        combatOrder.addAll(enemyList);
        Collections.shuffle(combatOrder);
        System.out.println(combatOrder);

        ArrayList<Ai> aiList = new ArrayList<>();
        for (int i= 0; i <= enemyList.size(); i++){
            aiList.add(new Ai(type.get(i), enemyList.get(i), HP.get(i), Def.get(i), CMV.get(i),0));
        }

        //creating a sum of HP for win/ lose / move on to next wave conditions
        if  (HP.size()>4){ // this means we have a second wave
            waves = 1;
        }
        int sumHp = 0;
        for (int i = 0; i<=HP.size(); i++){
            sumHp += HP.get(i);
        }

        int sumHpMax = sumHp; // so i can check if i need to spawn in second wave of enemies
        int turnTally = 0;
        ArrayList<Integer> playerLastTurn = new ArrayList<>();
        while (sumHp > 0 || mainCharacter.getHp() == 0){
            playerLastTurn.clear();
            if (turnTally % 3 ==0){
                System.out.println("COIN TOSS EVENT");
                // set up once access to coin class is avaliable in main
                // potentially make it a random buff instead of power return
                mainCharacter.changePwr(-3); //-3 because it takes the value and subtracts it from the power value
            }
            if (waves == 1 && sumHpMax/2<= sumHp){
                //////////////////////////Spawn Second Half
                //sumHp = sumHpMax/2;
            }
            for (String unit : combatOrder) {
                if (unit == "Player"){
                    playerOutputBundle cards =  playerTurn(currentHand, enemyList, HP, combatOrder, mainCharacter);
                    currentHand.addAll(cards.hand());
                    discarded.addAll(cards.discard());
                    ArrayList<Integer> Play = new ArrayList<>();
                    Play.addAll(cards.play());
                    int moodV = mainCharacter.getCmv();

                    for (int cardId : Play) {
                        switch (Cards.cardDictionary.get(cardId).type) {
                            case 1: //aa
                                int dmg = rollDice(Cards.cardDictionary.get(cardId).num, Cards.cardDictionary.get(cardId).dice );
                                int dmg2 = rollDice(Cards.cardDictionary.get(cardId).num2, Cards.cardDictionary.get(cardId).dice2 );
                                for (String enemy : combatOrder) {
                                    if (enemy != "Player"){
                                        int temp = 0;
                                        for (int i = 0; i <= enemyList.size(); i++){
                                            if (enemy == enemyList.get(i)){
                                                temp = i;
                                            }
                                        }
                                        if(rollCMV(moodV) > temp){
                                            aiList.get(temp).aiDmgTaken(dmg);
                                            System.out.println( aiList.get(temp).getName() + "took " + dmg + "dmg");
                                        }
                                        else{
                                            System.out.println("The First Action Failed");
                                            break;
                                        }
                                    }
                                }
                                for (String enemy : combatOrder) {
                                    if (enemy != "Player"){
                                        int temp = 0;
                                        for (int i = 0; i <= enemyList.size(); i++){
                                            if (enemy == enemyList.get(i)){
                                                temp = i;
                                            }
                                        }
                                        int def = Def.get(temp);
                                        if(rollCMV(moodV) > temp){
                                            aiList.get(temp).aiDmgTaken(dmg2);
                                            System.out.println( aiList.get(temp).getName() + "took " + dmg + "dmg");
                                        }
                                        else{
                                            System.out.println("The Second Action Failed");
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 2: //ad
                                dmg = rollDice(Cards.cardDictionary.get(cardId).num, Cards.cardDictionary.get(cardId).dice );
                                int defbst = rollDice(Cards.cardDictionary.get(cardId).num2, Cards.cardDictionary.get(cardId).dice2);
                                for (String enemy : combatOrder) {
                                    if (enemy != "Player"){
                                        int temp = 0;
                                        for (int i = 0; i <= enemyList.size(); i++){
                                            if (enemy == enemyList.get(i)){
                                                temp = i;
                                            }
                                        }
                                        int def = aiList.get(temp).getDef();
                                        if(rollCMV(moodV) > temp){
                                            aiList.get(temp).aiDmgTaken(dmg);
                                            System.out.println( aiList.get(temp).getName() + "took " + dmg + "dmg");
                                        }
                                        else{
                                            System.out.println("The First Action Failed");
                                            break;
                                        }
                                    }
                                }
                                mainCharacter.defBst(defbst);
                                playerLastTurn.add(defbst);
                                System.out.println("Def has been raised by" + defbst);
                                break;
                            case 3: //da
                                dmg = rollDice(Cards.cardDictionary.get(cardId).num2, Cards.cardDictionary.get(cardId).dice2 );
                                defbst = rollDice(Cards.cardDictionary.get(cardId).num, Cards.cardDictionary.get(cardId).dice);
                                for (String enemy : combatOrder) {
                                    if (enemy != "Player"){
                                        int temp = 0;
                                        for (int i = 0; i <= enemyList.size(); i++){
                                            if (enemy == enemyList.get(i)){
                                                temp = i;
                                            }
                                        }
                                        int def = aiList.get(temp).getDef();
                                        if(rollCMV(moodV) > temp){
                                            aiList.get(temp).aiDmgTaken(dmg);
                                            System.out.println( aiList.get(temp).getName() + "took " + dmg + "dmg");
                                        }
                                        else{
                                            System.out.println("The First Action Failed");
                                            break;
                                        }
                                    }
                                    mainCharacter.defBst(defbst);
                                    playerLastTurn.add(defbst);
                                    System.out.println("Def has been raised by" + defbst);
                                }
                                mainCharacter.defBst(defbst);
                                playerLastTurn.add(defbst);
                                break;
                            case 5: //ba
                                int boostdmg = rollDice(Cards.cardDictionary.get(cardId).num, Cards.cardDictionary.get(cardId).dice );
                                dmg = rollDice(Cards.cardDictionary.get(cardId).num2, Cards.cardDictionary.get(cardId).dice2 );
                                for (String enemy : combatOrder) {
                                    if (enemy != "Player"){
                                        int temp = 0;
                                        for (int i = 0; i <= enemyList.size(); i++){
                                            if (enemy == enemyList.get(i)){
                                                temp = i;
                                            }
                                        }
                                        int def = Def.get(temp);
                                        if(rollCMV(moodV) > temp){
                                            aiList.get(temp).aiDmgTaken(dmg + boostdmg);
                                            System.out.println( aiList.get(temp).getName() + "took " + dmg + "dmg");
                                        }
                                        else{
                                            System.out.println("The Second Action Failed");
                                            break;
                                        }
                                    }
                                }
                                break;
                            default: //dd type 4
                                defbst = rollDice(Cards.cardDictionary.get(cardId).num, Cards.cardDictionary.get(cardId).dice );
                                int defbst2 = rollDice(Cards.cardDictionary.get(cardId).num2, Cards.cardDictionary.get(cardId).dice2);
                                mainCharacter.defBst(defbst + defbst2);
                                playerLastTurn.add(defbst);
                                playerLastTurn.add(defbst2);
                                System.out.println("Def has been raised by" + defbst + " + " + defbst2);
                                break;
                        }
                    }
                    
                    
                }
                else{
                    int temp = 0;
                    for (int i = 0; i <= enemyList.size(); i++){
                    if (unit == enemyList.get(i)){
                        temp = i;
                    }

                    int lowestHp = 20;
                    for (i = 0; i <= HP.size(); i++){
                        if (lowestHp > HP.get(i)){
                            lowestHp = HP.get(i);
                        }
                    }
                    int cardId = Ai.aiTree(mainCharacter.getHp(), aiList.get(temp).getHP(), lowestHp, aiList.get(temp).getType());
                    aiList.get(temp).aiLC(cardId);
                    switch (Cards.cardDictionary.get(cardId).type) {
                            case 1: //aa
                                int dmg = rollDice(Cards.cardDictionary.get(cardId).num, Cards.cardDictionary.get(cardId).dice );
                                int dmg2 = rollDice(Cards.cardDictionary.get(cardId).num2, Cards.cardDictionary.get(cardId).dice2 );
                                if (mainCharacter.getDef() <= rollCMV(aiList.get(temp).getDef())){
                                    mainCharacter.takeDmg(dmg +dmg2);
                                    System.out.println(aiList.get(temp).getName() + "did " + dmg + " + " + dmg2 + " dmg" );
                                }
                               
                            case 2: //ad
                                dmg = rollDice(Cards.cardDictionary.get(cardId).num, Cards.cardDictionary.get(cardId).dice );
                                int defbst = rollDice(Cards.cardDictionary.get(cardId).num2, Cards.cardDictionary.get(cardId).dice2);
                                aiList.get(temp).defenceBoost(defbst);
                                playerLastTurn.add(defbst);
                                System.out.println("Def has been raised by" + defbst + " for " + aiList.get(temp).getName());
                                if (mainCharacter.getDef() <= rollCMV(aiList.get(temp).getDef())){
                                    mainCharacter.takeDmg(dmg);
                                    System.out.println(aiList.get(temp).getName() + "did " + dmg +" dmg" );
                                }
                            
                                break;
                            case 3: //da
                                dmg = rollDice(Cards.cardDictionary.get(cardId).num, Cards.cardDictionary.get(cardId).dice );
                                defbst = rollDice(Cards.cardDictionary.get(cardId).num2, Cards.cardDictionary.get(cardId).dice2);
                                aiList.get(temp).defenceBoost(defbst);
                                playerLastTurn.add(defbst);
                                System.out.println("Def has been raised by" + defbst + " for " + aiList.get(temp).getName());
                                if (mainCharacter.getDef() <= rollCMV(aiList.get(temp).getDef())){
                                    mainCharacter.takeDmg(dmg);
                                    System.out.println(aiList.get(temp).getName() + "did " + dmg +" dmg" );
                                }
                                break;
                            default: //dd type 4
                                defbst = rollDice(Cards.cardDictionary.get(cardId).num, Cards.cardDictionary.get(cardId).dice );
                                int defbst2 = rollDice(Cards.cardDictionary.get(cardId).num2, Cards.cardDictionary.get(cardId).dice2);
                                mainCharacter.defBst(defbst + defbst2);
                                playerLastTurn.add(defbst);
                                playerLastTurn.add(defbst2);
                                System.out.println("Def has been raised by" + defbst + " + " + defbst2);
                                break;
                    }

                }
            }
            }
            while (currentHand.size() != 3){
                if (drawpile.size()<= 4){
                    drawpile.addAll(discarded);
                    Collections.shuffle(drawpile);
                }
                currentHand.add(drawpile.get(0));
                drawpile.remove(0);
            }
            System.out.println("Would you like to skip this battlle (x for yes anything else is a no)?");
            String skip = scanner.next();
            if (skip == "x"){
                break;
            }
        }
        if (sumHpMax == 0){
            mainCharacter.takeDmg(-1 * rollDice(2, 6)); //pealing post battle
            won = true;
        }
        return won;
    }

    public record playerOutputBundle(List<Integer> hand, List<Integer> discard, List<Integer> play) {} //used to get more than one array in out put 

    public playerOutputBundle playerTurn(ArrayList<Integer> currentHand, ArrayList<String> enemyList, ArrayList<Integer> enemyHp, ArrayList<String> combatOrder, Character mainCharacter){ //player more or less picking their cards
        Scanner scanner = new Scanner(System.in);
        System.out.println("All Enemies In Combat Order"); //Displays the Combat order
        for (int i = 0; i<= enemyList.size() - 1; i++){
            
            if (combatOrder.get(i) != "Player"){
                int ehp = 20;
                System.out.println("Order No " + i + " : " + combatOrder.get(i));
                for (String enemy : combatOrder) {
                    if (enemy == enemyList.get(i)){
                        ehp = enemyHp.get(i);
                    }
                }
                System.out.print("Hp: " + ehp);
            }
            else{
                System.out.println("Order No " + i + " : Player");
                System.out.println("Hp: " + mainCharacter.getHp());
            }
        }

        System.out.println("Dealt Cards"); //Displays the cards you have been given
        for (int i = 0; i<=3; i++){
            System.out.println("Card ID: " + currentHand.get(i));
            System.out.print("Cost of card " + Cards.cardDictionary.get(currentHand.get(i)).cost);
            System.out.print(Cards.cardDictionary.get(currentHand.get(i)).display);
        }
        
        System.out.println("You have " + mainCharacter.getPwr() + "power to use:");
        ArrayList<Integer> playedCards = new ArrayList<>();
        ArrayList<Integer> discardedCards = new ArrayList<>();
        int input = 0;
        while (input!=246){
            System.out.println("Please select an action: \n 1. Select Cards to discard \n 2. Select Cards to play \n 3. Veiw Cards Again \n 4.Submit Actions");
            input = scanner.nextInt();
            switch (input) {
                case 1: // discard
                    for (int i = 0; i <= 3; i++){
                        System.out.println("Card ID: " + currentHand.get(i));
                        System.out.print("Cost of card " + Cards.cardDictionary.get(currentHand.get(i)).cost);
                        System.out.print(Cards.cardDictionary.get(currentHand.get(i)).display);
                        System.out.println("would you like to discard this card? \n 1. Yes \n 2. No");
                        int del = scanner.nextInt();
                        if (del == 1){
                            int check = 0;
                            for (int card : playedCards) {
                                check++;
                                if (currentHand.get(i) == card){
                                    System.out.print("You cannot discard a played card");
                                    break;
                                }
                            }
                            if (check == 3){
                                System.out.print("The Card has been added to the discard pile");
                                discardedCards.add(currentHand.get(i));
                            }
                        }
                        else{
                            for (int card : discardedCards) {
                                if (currentHand.get(i) == card){
                                    System.out.print("Card has been undiscarded");
                                    discardedCards.remove(card);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 2: //play
                    for (int i = 0; i <= 3; i++){
                        System.out.println("Card ID: " + currentHand.get(i));
                        System.out.println("Cost of card " + Cards.cardDictionary.get(currentHand.get(i)).cost);
                        System.out.println(Cards.cardDictionary.get(currentHand.get(i)).display);
                        System.out.println("would you like to play this card? \n 1. Yes \n 2. No");
                        int del = scanner.nextInt();
                        if (del == 1){
                            int check = 0;
                            for (int card : discardedCards) {
                                check++;
                                if (currentHand.get(i) == card){
                                    System.out.print("You cannot play a discarded card");
                                    break;
                                }
                            }
                            if (check == 3){
                                if (mainCharacter.getPwr() > Cards.cardDictionary.get(currentHand.get(i)).cost){
                                    System.out.print("The Card has been added to the to be played cards list");
                                    playedCards.add(currentHand.get(i));
                                    mainCharacter.changePwr(-1 * Cards.cardDictionary.get(currentHand.get(i)).cost);
                                    System.out.print("This has consumed " + Cards.cardDictionary.get(currentHand.get(i)).cost + "power, you have " + mainCharacter.getPwr() + "power left");
                                }
                                
                            }
                        }
                        else{
                            for (int card : playedCards) {
                                if (currentHand.get(i) == card){
                                    System.out.print("Card has been taken out of the to be played list \n" + Cards.cardDictionary.get(currentHand.get(i)) + "power has been gained back, you now have " + mainCharacter.getPwr() + "Power left");
                                    playedCards.remove(card);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 3: //veiw
                    System.out.println("Dealt Cards"); //Displays the cards you have been given
                    for (int i = 0; i<=3; i++){
                        System.out.println("Card ID: " + currentHand.get(i));
                        System.out.println("Cost of card " + Cards.cardDictionary.get(currentHand.get(i)).cost);
                        System.out.println(Cards.cardDictionary.get(currentHand.get(i)).display);
                    }
                    if (discardedCards.size() > 0){
                        System.out.println("Discarded Cards"); //Displays the cards you have been given
                        for (int i = 0; i<=3; i++){
                            System.out.println("Card ID: " + discardedCards.get(i));
                            System.out.println("Cost of card " + Cards.cardDictionary.get(discardedCards.get(i)).cost);
                            System.out.println(Cards.cardDictionary.get(discardedCards.get(i)).display);
                        }
                    }
                    if (playedCards.size() > 0){
                        System.out.println("Played Cards"); //Displays the cards you have been given
                        for (int i = 0; i<=3; i++){
                            System.out.println("Card ID: " + playedCards.get(i));
                            System.out.println("Cost of card " + Cards.cardDictionary.get(playedCards.get(i)).cost);
                            System.out.println(Cards.cardDictionary.get(playedCards.get(i)).display);
                        }
                    }
                    break;
                case 4: // move on
                    input = 246;
                    break;
                default: //typo
                    System.out.println("Error please make sure you enter 1 2 or 3");
                   break;
            }
        }
        return new playerOutputBundle(currentHand, discardedCards, playedCards);
        
    }
    
    public static int rollDice(int num,int sides){
            Random random = new Random();
            int sum = 0;

            for(int i = 0; i<num;i++){
                sum += random.nextInt(1,sides + 1);
            }

            return sum;
    }
    public static int rollCMV(int CMV){
        int roll = 1;
        int cm10 = CMV / 10;
        Random random = new Random();
        roll = random.nextInt(1, 20 + 1 + cm10);
        if (roll>20){
            roll = 20;
        }
        return roll;
    } 
}