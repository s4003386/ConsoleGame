package src;
import java.util.ArrayList;

public class Battle {
    private String BattleID;

    private int numberOfWaves;
    private Coin[] rewardedCoins;
    private ArrayList<String> rewardedPassives;
    private ArrayList<String> EnemiesList; //...?

    //passives etc, idk. u figure it out.



    public Battle(String BattleID, int numberOfWaves, Coin[] rewardedCoins, ArrayList<String> rewardedPassives, ArrayList<String> EnemiesList){

        this.BattleID = BattleID;
        this.numberOfWaves = numberOfWaves;
        this.rewardedCoins = rewardedCoins;
        this.rewardedPassives = rewardedPassives;
        this.EnemiesList = EnemiesList;
    }

    public String getBattleID(){
        return BattleID;
    }

    public Coin[] getCoinRewards(){
        return rewardedCoins;
    }





}
