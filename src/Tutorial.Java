import java.util.Scanner;

/**
 * This Class is literally just a text block with pacing
 */
public class Tutorial{// the tutorial is basically just a text output that explains the combat system to you
    public static void runTut(){
        Scanner scanner = new scanner(System.in);
        System.out.print("Tutorial Start....... \n\n Enemy 1: Grunt \n Hp:20 \n Enemy 2: Grunt \n Hp:20 \n\n Example Card \n Card ID: 1 \n Action 1 1d4 atk \n Action 2: 1d6 atk \n Power: 1")
        System.out.print("In a real fight you would have 3 cards in your hand \n Press enter to continue")
        scanner.nextLine();
        System.out.print("The card has a few important sections to look at \n First Power, you start of with 5 power, to action a card you must have sufficient power");
        System.out.print("If you dont have enough power you cant play the card\n to gain power you can either discard cards, action no cards or gain a certain amount in the 3 turn event")
        System.out.print("Press Enter to continue");
        scanner.nextLine();
        System.out.print("The cards Description will include the 2 actions each card can do.\n Atk - Attacking (dealing damage to enemies) \n Def - Defending (Increases your own def stat teporarily)");
        System.out.print("Boost - Boosts Next Instance of an Atk action, \n however, all Boost cards avaliable are made in such a way that \n They are really just One turn Atk Cards in a All or Nothing style");
        System.out.print("Press Enter to continue");
        scanner.nextLine();
        System.out.print("During your turn you will be asked yo select what cards you want to discard and what cards you want to play");
        System.out.print("To do so you will need to refer to the Card ID"); //sadly i am not feeling perticularly inventive so they dont get any fun names also this was its less likly to fall into typo issues
        System.out.print("Warning, you cannot play and discard a card at the same time (You can try if u want)");
        System.out.print("Press Enter to continue");
        scanner.nextLine();
        System.out.print("Once you have finished picking your cards they will be actioned\n Every action will go though the combat order* untill it fails to land.");
        System.out.print("The Def Value, instead of minimizing how much damage you can take, it rather minimizes how often you get hit.");
        System.out.print("Every Atack action has a hidden internal dice that rolls a number between 1 and 20 \n Say for example if i rolled a 6 tryig to atack you i would fail and that atack would no longer propagate though the combat list \n had it been a 18 i would have been able to deal damage to you and continue atacking with that half of the card.");
        System.out.print("Basically (to save you from a lot of yabbering) your atacks will atack every enemy utill they fail");
        System.out.print("Now before you panick, no enemies dont get to atack you multiple times, \n they get 1 card per turn");
        System.out.print("Press Enter to continue");
        scanner.nextLine();
        System.out.print("And thats about it for the basics, feel free to replay this if you ever forget anything");
        System.out.print("1d4 = one 4 sided dice or 1 x (random number from 1-4)");
        System.out.print("2d7 = two 7 sided dice or 2 x (random number from 1-7)");
        System.out.print("Press Enter to continue");
        scanner.nextLine();
    }
    
}