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
        handString = handString.substring(0, handString.length() - 1);
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
     * @param cardToPlay if present, only checks that card else checks whole hand
     * @param discardPileTop top card on the discard pile
     * @param suitIfEight suit to play if discardpiletop is eight else null
     * @return whether a card can be played from the hand or not (or the given card)
     */
    public boolean canPlayCard(Card cardToPlay, Card discardPileTop, String suitIfEight) {
        if (suitIfEight != null && cardToPlay != null) {
            // an eight has been played
            return (cardToPlay.isEight() || cardToPlay.getSuit().equals(suitIfEight));
        }

        if (cardToPlay != null) {
            return (cardToPlay.isEight() || cardToPlay.getRank() == discardPileTop.getRank() || cardToPlay.getSuit() == discardPileTop.getSuit());
        }

        if (suitIfEight != null) {
            for (Card currentCard : hand) {
                if (currentCard.isEight() || currentCard.getSuit().equals(suitIfEight)) {
                    return true;
                }
            }
            return false;
        }
        for (Card currentCard : hand) {
            if (currentCard.isEight() ||
                currentCard.getRank() == discardPileTop.getRank() || 
                currentCard.getSuit() == discardPileTop.getSuit()) {
                return true;
            }

        }
        return false;
    } 

    
    /**
     * Check if the player can only play eights, false if either
     * no playable cards period or playable non-eights
     * @param discardPileTop top of discard pile
     * @param suitIfEight if discardTop is eight, string saying which suit player picked, else null
     * @return whether player could only play their eight
     */
    public boolean onlyEightsPlayable(Card discardPileTop, String suitIfEight) {
        
        if (!canPlayCard(null, discardPileTop, suitIfEight)) {
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
     * @param discardTop top card on discard pile
     * @param suitIfEight if discardTop is eight, string saying which suit player picked, else null
     * @return the card to play
     */
    public Card selectCardToPlay(Card discardTop, String suitIfEight) {
        int index = -1;
        while (index == -1) {
            try {
                System.out.print("Select a card by index: (1st card = 0, 2nd = 1, etc.): ");
                if (onlyEightsPlayable(discardTop, suitIfEight)) {
                    System.out.print("\nSince you can only play an eight, you can also choose -1 to draw a card: ");
                }
                index = scan.nextInt();
                scan.nextLine();
                if (index < 0 || index >= hand.size()) {
                    System.out.println("Invalid index.");
                    index = -1;
                    continue;
                }
                Card cardToPlay = hand.get(index);
                if (!canPlayCard(cardToPlay, discardTop, suitIfEight)) {
                    if (suitIfEight != null)
                        System.out.printf("Cannot play this card. Valid cards are 8s, %ss, or %s.\n", discardTop.rankToStr(discardTop.getRank()), discardTop.getSuit());
                    else
                        System.out.println("Cannot play this card. Valid cards are 8s or " + suitIfEight + ".");
                    index = -1;
                    scan.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid integer index.");
                index = -1;
                scan.nextLine();
            }
        }

        Card cardToPlay = hand.get(index);
        hand.remove(index);
        return cardToPlay;
    }

    
    /**
     * return player's name
     */
    public String toString() {
        return name;
    }
}