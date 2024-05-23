public class Card {
    private int rank;
    private String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    
    public int getRank() {
        return rank;
    }


    public String getSuit() {
        return suit;
    }


    public boolean isEight() {
        return rank == 8;
    }


    public String rankToStr(int rank) {
        switch (rank) {
            case 1:
                return "A";
            case 10:
                return "10";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K"; 
            default:
                return String.format("%c", 48 + rank);
        }
    }


    public String toString() {
        return rankToStr(rank) + " of " + suit;
    }
}
