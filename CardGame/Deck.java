import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;


/**
 * class Deck
 * container structure that acts as the blueprint for game decks. Contains the actual deck and a reference array of suits.
 * 
 * Creating a deck object initializes a new deck and populates it with a full unsorted deck of 52 cards.
 * Methods allow for users to deal from the deck, shuffle the deck, get the deck's size, and recycle the discard
 * pile into a new deck for when it runs out if necessary.
 * 
 * @author Akash Pandit (aspandit@ucsc.edu)
 */
public class Deck {
    private LinkedList<Card> deck;
    private static String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};


    /**
     * Creates and populates a deck of cards
     */
    public Deck() {
        deck = new LinkedList<>();

        for (String suit : suits) {
            for (int rank = 1; rank < 14; rank++)
                deck.add(new Card(rank, suit));
        }
    }


    /**
     * convert discard pile into new deck
     * @param discardPile 
     */
    public void recycleDiscardPile(ArrayList<Card> discardPile) {
        for (Card card : discardPile) {
            deck.addFirst(card);
        }
    }


    /**
     * deal a card from the deck (remove from deck & return)
     * @return dealt card
     */
    public Card deal() {
        if (deck.peek() == null) {
            System.err.println("Error: deck is empty.");
            return null;
        }
        Card dealtCard = deck.pop();
        return dealtCard;
    }


    /**
     * pregame shuffling of the deck while the top card (starter) is not 8
     */
    public void shuffle() {
        boolean isEight = false;
        do {
            Collections.shuffle(deck);
            isEight = deck.get(0).isEight();
        } while (isEight);
    }

    /**
     * get the number of cards in the deck
     * @return deck size
     */
    public int getSize() {
        return deck.size();
    }


    public String toString() {
        String output = "";
        for (Card card : deck) {
            output += card + "\n";
        }
        return output;
    }
}
