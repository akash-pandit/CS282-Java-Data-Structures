import java.util.ArrayList;

class Player {
    private String name;
    private ArrayList<Card> hand;
    // private int points;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        // this.points = 0;
    }

    /**
     * Adds the drawn card to your hand.
     * @param card the drawn card
     */
    public void drawCard(Card card) {
        hand.add(card);
    }


    /**
     * Get number of cards in player's hand (check for win cond)
     * @return number of cards in player's hand
     */
    public int getHandSize() {
        return hand.size();
    }


    /**
     * Prints the contents of your hand.
     */
    public void viewHand() {
        System.out.printf("%s's hand: ", this.name);
        String handString = "";
        for (Card card : hand) {
            handString += String.format("%s, ", card);
        }
        handString = handString.substring(0, handString.length() - 2);
        System.out.println(handString);
    }

    
    /**
     * Play a card from your hand. If the card is invalid, the play will not work.
     * @param index the index of the card to play from your hand
     * @return the played card or null if play is invalid
     */
    public Card playCard(int index, Card discardPileTop) {
        if (index < 0 || index >= hand.size()) {
            System.err.println("Error: no card at index " + index + ".");
            return null;
        }

        Card cardToPlay = hand.get(index);

        if (cardToPlay.isEight() ||
            cardToPlay.getRank() == discardPileTop.getRank() || 
            cardToPlay.getClass() == discardPileTop.getClass()) 
                hand.remove(index);
        else {
            System.err.printf("Error: Card %d (%s) cannot be played here.\n", index, cardToPlay);
            System.out.print("If you have no playable cards, draw from the pile until you do.");
            cardToPlay = null;
        }
        return cardToPlay;
    }


    // public void incrementPoints() {
    //     int roundPoints = 0;
    //     for (Card card : hand)
    //         roundPoints += card.getPointVal();

    //     System.out.printf("%s: +%d points (total: %d)\n", this.name, roundPoints, this.points);
    //     points += roundPoints;
    // }
}