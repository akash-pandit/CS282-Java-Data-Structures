public class Card {
    private int rank;
    private String suit;
    private int pointVal;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        this.pointVal = rank;
        if (rank > 10)
            this.pointVal = 10;
        if (rank == 8)
            this.pointVal = 50;
    }

    public int getRank() {
        return rank;
    }


    public String getSuit() {
        return suit;
    }


    public int getPointVal() {
        return this.pointVal;
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
