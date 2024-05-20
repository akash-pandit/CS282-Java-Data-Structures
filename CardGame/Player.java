import java.util.ArrayList;

class Player {
    private String name;
    private ArrayList<Card> hand;
    private int points;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.points = 0;
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public void viewHand() {
        System.out.printf("%s's hand: ", this.name);
        String handString = "";
        for (Card card : hand) {
            handString += String.format("%s, ", card);
        }
        handString = handString.substring(0, handString.length() - 2);
        System.out.println(handString);
    }
}