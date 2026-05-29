//package src;

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

    public Coin(CoinType coinType){
        this.type = coinType;

        switch (coinType) { //no default, has to be any of these
            case WHITE:
                this.CoinRollChance = 1;
                break;
        
            case RED:
                this.CoinRollChance = 20;
                break;

            case BLUE:
                this.CoinRollChance = 35;
                break;
            
            case GREEN:
                this.CoinRollChance = 50;
                break;

            case BLACK:
                this.CoinRollChance = 65;
                break;

            case PURPLE:
                this.CoinRollChance = 80;
                break;

            case YELLOW:
                this.CoinRollChance = 99;
                break;

            case GREY:
                this.CoinRollChance = 100;
                break;

        }
    }

    public CoinType getCoinType(Coin targetCoin){
        return this.type;
    }

    public CoinType getCoinType(){
        return this.type;
    }
    

    public CoinType getCoinType(String targetCoin){
        return this.type;
    }



    @Override
    public String toString() {
        return type.toString();
    }


    
}
