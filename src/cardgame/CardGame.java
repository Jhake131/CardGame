package cardgame;

import cardgame.Card.Suit;
import cardgame.Card.Value;
import java.util.Random;
import java.util.Scanner;

/**
 * This class models a simple card guessing game
 * 
 * @author Jose Camotes Iv 
 * February 2, 2022
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Scanner input = new Scanner(System.in);

        Value[] cardValues = Value.values();

        Suit[] cardSuits = Suit.values();
        
        Card[] hand = CardHandGenerator.generateHand(7, cardValues, cardSuits);



        // print them out for debugging purposes
        System.out.println("Here are the cards in the hand");
        for (Card card : hand) {
            System.out.printf("%d of %s\n", card.getValue(), card.getSuit());
        }

        // Now ask the user for a card
        System.out.println("Pick a suit for your card");
        for (int i = 0; i < Card.SUITS.length; i++) {
            System.out.println((i + 1) + ": " + Card.SUITS[i]);
        }
        int suit = input.nextInt();

        System.out.println("Enter a value (1 to 13)");
        int value = input.nextInt();

        Card userGuess = new Card(value, Card.SUITS[suit - 1]);

        boolean match = false;
        for (Card card : hand) {
            if (card.getValue() == userGuess.getValue()
                    && card.getSuit().equals(userGuess.getSuit())) {
                match = true;
                break;
           }
        }
    
        String response = match ? "Right guess": "No match";
        
        System.out.println(response);
    }
    
}
