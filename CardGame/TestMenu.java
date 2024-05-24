import java.util.Scanner;


/**
 * class TestMenu
 * 
 * a rudimentary class that provides an interface to demonstrate deck creation, sorting, and dealing.
 * 
 * @author Akash Pandit (aspandit@ucsc.edu)
 */
public class TestMenu {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player("TestPlayer");
        int menuSelection;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("== Test Menu ==");
            System.out.println("1. Print deck");
            System.out.println("2. Randomize deck");
            System.out.println("3. Deal card to player");
            System.out.println("4. Exit");

            menuSelection = scan.nextInt();
            scan.nextLine();

            switch (menuSelection) {
                case 1:
                    System.out.println("Printing deck...");
                    System.out.println(deck);
                    break;
                case 2:
                    System.out.println("Shuffling deck...");
                    deck.shuffle();
                    System.out.println("Print deck to see changes.");
                    break;
                case 3:
                    System.out.println("Dealing card to player...");
                    player.drawCard(deck);
                    player.displayHand();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
            }
            System.out.println();
        } while (menuSelection != 4);
        scan.close();
    }
}
