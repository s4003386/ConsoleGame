package src;
import java.util.ArrayList;

public class Coin {
    private CoinType type;
    private int CoinRollChance; //out of 100

    public enum CoinType {
        WHITE,
        RED,
        BLUE,
        GREEN,
        BLACK,
        PURPLE,
        YELLOW,
        GREY
    }

    
    public CoinType getCoinType(Coin target){
        return target.type;
    }


    public Coin(CoinType coinType){
        this.type = coinType;

        switch (coinType) { //no default, has to be any of these
            case WHITE:
                CoinRollChance = 1;
                break;
        
            case RED:
                CoinRollChance = 20;
                break;

            case BLUE:
                CoinRollChance = 35;
                break;
            
            case GREEN:
                CoinRollChance = 50;
                break;

            case BLACK:
                CoinRollChance = 65;
                break;

            case PURPLE:
                CoinRollChance = 80;
                break;

            case YELLOW:
                CoinRollChance = 99;
                break;

            case GREY:
                CoinRollChance = 100;
                break;

        }
    }

    @Override
    public String toString() {
        return type.toString();
    }


    
}
