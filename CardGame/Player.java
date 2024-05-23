import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


class Player {
    private String name;
    private ArrayList<Card> hand;
    private Scanner scan = new Scanner(System.in);

    
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /* -------------------- hand methods ---------------------- */ 

    /**
     * @return the player's hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }


    /**
     * Prints the contents of the player's hand.
     */
    public void displayHand() {
        System.out.printf("%s's hand:\n", this.name);
        String handString = "";
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            handString += String.format("\t%d: %s\n", i, card);
        }
        handString = handString.substring(0, handString.length() - 2);
        System.out.println(handString);
    }

    /* ---------------- card drawing methods ------------------ */

    /**
     * Adds the drawn card to the player's hand.
     * @param card the drawn card
     */
    public void drawCard(Deck deck) {
        Card drawnCard = deck.deal();
        if (drawnCard == null) {
            return;
        }
        hand.add(drawnCard);
    }

    /* ---------------- card playing methods ------------------ */

    /**
     * Validate if the player has a card to play
     * @param discardPileTop top card on the discard pile
     * @return whether a card can be played from the hand or not
     */
    public boolean canPlayCard(Card discardPileTop) {
        for (Card currentCard : hand) {

            if (currentCard.isEight() ||
                currentCard.getRank() == discardPileTop.getRank() || 
                currentCard.getClass() == discardPileTop.getClass()) {
                return true;
            }
        }
        return false;
    } 

    
    /**
     * Check if the player can only play eights, false if either
     * no playable cards period or playable non-eights
     * @param discardPileTop
     * @return whether player could only play their eight
     */
    public boolean onlyEightsPlayable(Card discardPileTop) {
        if (!canPlayCard(discardPileTop)) {
            return false;
        }

        for (Card currentCard : hand) {
            if (currentCard.getRank() == discardPileTop.getRank() || 
                currentCard.getClass() == discardPileTop.getClass()) {
                return false;
            }
        }
        return true;
    }


    /**
     * Play a card from your hand. Given a valid index, removes the matching card and returns it.
     * Assumed that the player has a valid card to play.
     * @return the card to play
     */
    public Card selectCardToPlay(boolean allowDraw) {
        int index = -1;
        while (index == -1) {
            try {
                System.out.print("Select a card by index: (1st card = 0, 2nd = 1, etc.): ");
                index = scan.nextInt();
                scan.nextLine();
                if (index < 0 || index >= hand.size()) {
                    System.out.println("Invalid index.");
                    index = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid integer index.");
                index = -1;
            }
        }

        Card cardToPlay = hand.get(index);
        hand.remove(index);
        return cardToPlay;
    }
}