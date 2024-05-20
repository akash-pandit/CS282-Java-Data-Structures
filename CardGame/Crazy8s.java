import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Crazy8s {
    static Scanner scan = new Scanner(System.in);
    static Deck deck = new Deck();
    static ArrayList<Card> discardPile = new ArrayList<>();

    public static void main(String[] args) {
        int choice = mainMenu();
            switch (choice) {
                case 1:
                    runGame();
                    break;

                case 2:
                    printRules();
                    break;

                case 3:
                    TestMenu.main(args);
                    break;
            }
    }

    /**
     * Print the main menu for the game, providing users with three
     * menu options denoted by integers.
     * @returns selected menu option
     */
    public static int mainMenu() {
        System.out.println("- = - = [ Crazy Eights ] = - = -");
        System.out.println("        1 - Run game");
        System.out.println("        2 - Rules");
        System.out.println("        3 - Run test mode");
        System.out.println("- = - = - = - <> = - = - = - = -");

        int choice = 0;
        while (choice < 1 || choice > 3) {
            try {
                choice = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: please pick a valid option.");
                choice = 0;
            }
        }
        return choice;
    }


    /**
     * Runs a game of crazy eights.
     */
    public static void runGame() {
        // Pregame setup
        ArrayList<Player> players = getPlayers();
        deck.shuffle();
        discardPile.add(0, deck.deal()); // first card

        // Game loop
        boolean isWinner = false;

        while (!isWinner) // 1 round
        { 
            for (int i = 0; i < players.size(); i++) // 1 player action
            {  
                Player player = players.get(i);
                // player action

                isWinner = checkForWinner(player);
                if (isWinner)
                    break;
            }
        }
    }


    /**
     * Check if a given player has won the game
     * @param player current player
     * @return whether player won the game
     */
    public static boolean checkForWinner(Player player) {
        if (player.getHandSize() == 0)
            return true;
        return false;
    }


    /**
     * see the top card of the discard pile (return a copy)
     * @return a view of the top card
     */
    public static Card peekDiscardTop() {
        return discardPile.get(0);
    }


    /**
     * create and return an arraylist of players for the game
     * @return arraylist of players
     */
    public static ArrayList<Player> getPlayers() {
        int playerCount = 0;
        while (playerCount < 2 || playerCount > 5) {
            try {
                System.out.print("Number of players (2 to 5): ");
                playerCount = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid player count.");
                playerCount = 0;
            }
        }
        
        ArrayList<Player> players = new ArrayList<>();
        String playerName;

        for (int i = 0; i < playerCount; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            playerName = scan.nextLine();
            players.add(new Player(playerName));
        }

        return players;
    }


    /**
     * Prints the rules for crazy eights.
     */
    public static void printRules() {
        String rules = "Rules for Crazy Eights\n\n";
        rules += "Note: This version of Crazy Eights is played as a variation of UNO, scrapping the point system.\n\n";
        rules += "Objective: The goal of the game is to be the first player to get rid of all of their cards.\n\n";

        rules += "Pregame: The cards are shuffled so that the top card is not an eight. The deck is then placed\n";
        rules += "face-down (not visible). The top card is removed from the deck and placed face-up (visible) and\n";
        rules += "is where players play their cards. Players are dealt five cards each from the stack. No more than\n";
        rules += "5 players can play at once.\n\n";

        rules += "Gameplay: Players take their turn in the order that they are input into the program. On a player's\n";
        rules += "turn, they can place a card ";
        System.out.println(rules);
    }
}
