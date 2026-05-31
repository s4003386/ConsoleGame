import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 * This class simply defines the the cards,
 */
// This class is where all the cards are defined and their packaging created 
public class Cards{
    public static Map<Integer, CardDetails> cardDictionary = new HashMap<>();
    public static void cards(){ //Defining all cards 

        //discard faction is fortuna 
        cardDictionary.put(1, new CardDetails(1,0,4,0,6,"Empty",0)); //Used for toubleshooting and ai default
        cardDictionary.put(1, new CardDetails(1,1,4,1,6,"Action 1: 1d4 atk \\n Action 2: 1d6 atk",1)); //Base Deck Given to player who finished the tutorial   
        cardDictionary.put(2, new CardDetails(1,1,6,2,4,"Action 1: 1d4 atk \\n Action 2: 1d6 atk",1)); 
        cardDictionary.put(3, new CardDetails(2,1,4,1,4,"Action 1: 1d4 atk \\n Action 2: 1d6 def",1));        
        cardDictionary.put(4, new CardDetails(2,1,6,2,6,"Action 1: 1d4 atk \\n Action 2: 1d6 def",1)); 
        cardDictionary.put(5, new CardDetails(3,1,12,1,4,"Action 1: 1d4 def \\n Action 2: 1d6 atk",1));        //// DEF CHANGED LOWER TF OUT OF THEM >:D
        cardDictionary.put(6, new CardDetails(3,1,4,2,6,"Action 1: 1d4 def \\n Action 2: 1d6 atk",1)); 
        cardDictionary.put(7, new CardDetails(4,1,4,1,6,"Action 1: 1d4 def \\n Action 2: 1d6 def",1));        
        cardDictionary.put(8, new CardDetails(4,1,12,2,4,"Action 1: 1d4 def \n Action 2: 1d6 def",1)); 
        cardDictionary.put(9, new CardDetails(5,1,4,1,4,"Action 1: 1d4 boost \\n Action 2: 1d6 atk",1));        
        cardDictionary.put(10, new CardDetails(5,1,2,2,4,"Action 1: 1d4 boost \\n Action 2: 1d6 atk",1)); //Base Deck Ends
    }

    //Allows me to get all cards of a certain type (used for the ai)
    public static List<Integer> getCardsByType(int targetType){
        ArrayList<Integer> matchingCardId = new ArrayList<>();

        for(Map.Entry<Integer, CardDetails> temp : cardDictionary.entrySet()) {
            if (temp.getValue().type == targetType){
                matchingCardId.add(temp.getKey());
            }
        }

        return matchingCardId;
    }
}

/**
 * This class defines the carddetails container
 */
//defnining the class Carddetails that is used to store card descriptions in the dictionary without me using fancy stuff I found on google :D
class CardDetails {
    int type; 
    /*different types of cards have different actions
     a = action, d = defence, b = boost
    type 1 - aa
    type 2 - ad 
    type 3 - da
    type 4 - dd
    type 5 - ba
    type 6 - ab 
    i am doing this so that instead of storing this information in 2 extra variables i am able to store it in 1 
    also not all card types are avaliable to AI to futher simplyfy the Ai tree*/

    int num; //number of "dice" we will throw to action the card
    int dice; //how many sides does the dice have
    int num2; //for the second action
    int dice2; //for the second action
    String display; //text that will be displayed to the user in the inventory / game
    int cost;

    public CardDetails(int Type, int Num, int Dice, int Num2, int Dice2, String Display, int Cost){
        this.type = Type;
        this.num = Num;
        this.dice = Dice;
        this.num2 = Num2;
        this.dice2 = Dice2;
        this.display = Display;
        this.cost = Cost;
    }
}