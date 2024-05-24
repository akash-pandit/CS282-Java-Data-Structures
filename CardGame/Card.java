public class Card {
    private int rank;
    private String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    
    /**
     * getter for rank
     * @return rank
     */
    public int getRank() {
        return rank;
    }

    
    /**
     * getter for suit
     * @return suit
     */
    public String getSuit() {
        return suit;
    }


    /**
     * tells us if a card is eight
     * @return if its eight
     */
    public boolean isEight() {
        return rank == 8;
    }

    /**
     * Convert a card's rank to a printable format
     * @param rank card's integer rank
     * @return string form of rank
     */
    public String rankToStr(int rank) {
        switch (rank) {
            case 1:
                return "Ace";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King"; 
            default:
                return String.format("%c", 48 + rank);
        }
    }


    public String toString() {
        String output = rankToStr(rank) + " of " + suit;
        
        if (isEight())
            return output + " (wildcard)";
        return output;
    }
}
