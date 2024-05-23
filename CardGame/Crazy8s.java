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

        // distribute beginning hands
        for (Player player : players) {
            for (int i = 0; i < 5; i++)
                player.drawCard(deck);
        }

        // Game loop
        Player winner = null;
        while (winner == null) // 1 round
        { 
            for (int i = 0; i < players.size(); i++) // 1 player action
            {  
                Player player = players.get(i);
                // player action
                Card topCard = discardPile.get(0);
                Card cardToPlay = null;

                while (!player.canPlayCard(topCard)) 
                { // no playable
                    winner = safeDrawCard(player, players, winner);
                }  // end no playable
                if (player.canPlayCard(topCard)) 
                {  // eights
                    if (!player.onlyEightsPlayable(topCard)) 
                    {  // playable cards
                        System.out.printf("CURRENT CARD: %s\n\n", topCard);
                        player.displayHand();



                        // TODO: fix selectCardToPlay to validate a correct choice
                        
                        
                        
                        cardToPlay = player.selectCardToPlay(false);
                        discardPile.add(0, cardToPlay);
                    }  // end eights
                    else 
                    {  // playable non 8 cards
                        while (player.onlyEightsPlayable(topCard)) 
                        {  // only 8s (play or draw)
                            int index = getCardIndex(player);
                            if (index == -1) {  // draw card
                                winner = safeDrawCard(player, players, winner);
                            }  // end draw card
                            else 
                            {  // play card
                                System.out.printf("CURRENT CARD: %s\n\n", topCard);
                                player.displayHand();
                                        


                                // TODO: fix selectCardToPlay to validate a correct choice
                                
                                
                                
                                cardToPlay = player.selectCardToPlay(false);
                                discardPile.add(0, cardToPlay);
                            }  // end play card
                        }  // end only 8s (play or draw)
                    }  // end playable non 8 cards
                }  // end playable cards
                
                winner = checkForWinner(player);
                if (winner != null)
                    break;
            }  // end round
        }
    }


    /**
     * play or draw a card by index gotten with stdin scanner
     * @param player player to get hand from
     * @return index of card to play or -1 to draw
     */
    public static int getCardIndex(Player player) {
        int index = -2;
        while (index == -2) 
        {  // index validation
            try {
                System.out.print("Select a card by index: (1st card = 0, 2nd = 1, etc.): ");
                index = scan.nextInt();
                scan.nextLine();
                if (index < -2 || index >= player.getHand().size()) {
                    System.out.println("Invalid index.");
                    index = -2;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid integer index.");
                index = -2;
            }
        }  // end index validation
        return index;
    }


    /**
     * Draw a card while handling empty deck/discard pile and check for a winner
     * @param player - the player object to draw the card with
     * @param players - arraylist of all players
     * @param winner - current winner, likely null
     * @return new winner if change, else old winner
     */
    public static Player safeDrawCard(Player player, ArrayList<Player> players, Player winner) {
        if (deck.getSize() == 0) 
        {  // empty deck
            if (discardPile.size() == 0)  // no cards in circulation
                winner = players.get(getSmallestHand(players));
            deck.recycleDiscardPile(discardPile);
            discardPile.add(0, deck.deal());
        }  // end empty deck
        player.drawCard(deck);
        return winner;
    }


    /**
     * Check if a given player has won the game
     * @param player current player
     * @return the player if they won, else null
     */
    public static Player checkForWinner(Player player) {
        if (player.getHand().isEmpty()) {
            return player;
        }
        return null;
    }

    /**
     * run on the condition that all cards are out of circulation,
     * the winner is the player with the least cards
     * @return index of winning player in player array
     */
    public static int getSmallestHand(ArrayList<Player> players) {
        int min = 53;
        int winnerInd = 0;
        for (int i = 0; i < players.size(); i++) {
            int cardCount = players.get(i).getHand().size();
            if (cardCount < min) {
                min = cardCount;
                winnerInd = i;
            }
        }
        return winnerInd;
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
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.err.println("Error: Invalid player count.");
                playerCount = 0;
            }
        }
        scan.nextLine();
        
        ArrayList<Player> players = new ArrayList<>();
        String playerName;

        for (int i = 0; i < playerCount; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            playerName = scan.nextLine();
            while (playerName == "") {
                System.out.print("Please input a valid player name: ");
                playerName = scan.nextLine();
            }
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
