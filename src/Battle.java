package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import src.Coin.CoinType;

public class Battle {
    private String BattleID;

    private int numberOfWaves;
    private Coin[] rewardedCoins;
    private ArrayList<String> rewardedKeyItems;
    private ArrayList<String> rewardedPassives;
    private ArrayList<String> EnemiesList; //...?

    //passives etc, idk. u figure it out.



    public Battle(String BattleID, int numberOfWaves, Coin[] rewardedCoins, ArrayList<String> rewardedPassives, ArrayList<String> rewardedKeyItems, ArrayList<String> EnemiesList){

        this.BattleID = BattleID;
        this.numberOfWaves = numberOfWaves;
        this.rewardedCoins = rewardedCoins;
        this.rewardedKeyItems = rewardedKeyItems;
        this.rewardedPassives = rewardedPassives;
        this.EnemiesList = EnemiesList;
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

    public int getCoinFrequency(Coin[] Coins, CoinType target){
        int quantity = Collections.frequency(Arrays.asList(Coins), target);
        return quantity;
    }


    public ArrayList<String> getKeyItemsRewards(){
        return rewardedKeyItems;
    }





}
