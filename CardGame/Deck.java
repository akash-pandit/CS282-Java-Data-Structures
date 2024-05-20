import java.util.LinkedList;
import java.util.Collections;

public class Deck {
    private LinkedList<Card> deck;
    private static String[] suits = {"D", "C", "H", "S"};

    public Deck() {
        deck = new LinkedList<>();

        for (String suit : suits) {
            for (int rank = 1; rank < 14; rank++)
                deck.add(new Card(rank, suit));
        }
    }


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


    public String toString() {
        String output = "";
        for (Card card : deck) {
            output += card + "\n";
        }
        return output;
    }
}
