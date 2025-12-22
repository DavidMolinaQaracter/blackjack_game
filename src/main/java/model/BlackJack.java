package model;

import java.util.Scanner;

public class BlackJack{

    private Deck deck;
    private Hand playerHand;
    private Hand croupierHand;
    private Scanner sc;

    public BlackJack() {
        sc = new Scanner(System.in);
        deck = new Deck();
        playerHand = new Hand(false);
        croupierHand = new Hand(true);
    }

    public void startGame() {
        initialDeal();
        playerTurn();
        croupierTurn();
        determineWinner();
    }

    private void initialDeal() { //Two cards for each one at the begin
        playerHand.addCard(deck.removeCard());
        croupierHand.addCard(deck.removeCard());
        playerHand.addCard(deck.removeCard());
        croupierHand.addCard(deck.removeCard());

        System.out.println("Cropier's hand:");
        croupierHand.showHand();

        System.out.println("\nYour hand:");
        playerHand.showHand();
    }

    private void playerTurn() {
        while (true) {
            if (playerHand.isBlackjack()) {
                System.out.println("\nBlackjack!");
                return;
            }

            if (playerHand.hasLost()) {
                return;
            }

            String choice = askHitOrStand();

            if (choice.equals("h")) {
                playerHand.addCard(deck.removeCard());
                System.out.println("\nYour hand:");
                playerHand.showHand();
            } else if (choice.equals("s")) {
                return;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private String askHitOrStand() {
        String input;

        while (true) {
            System.out.print("\nDo you want to (h)it or (s)tand? ");
            input = sc.nextLine().trim().toLowerCase();

            if (input.equals("h") || input.equals("s")) { //Valid inputs 'h', 's', 'H', 'S'
                return input;
            }

            System.out.println("Invalid input. Please enter 'h' for hit or 's' for stand.");
        }
    }

    private void croupierTurn() {
        if (playerHand.hasLost()) { //If player has lost Croupier wins
            return;
        }

        System.out.println("\n--- Croupier's turn ---");
        croupierHand.showHand();

        while (croupierHand.getHandValue() < 17) {
            System.out.println("Croupier hits...");
            croupierHand.addCard(deck.removeCard());
            croupierHand.showHand();
        }

        if (croupierHand.hasLost()) {
            System.out.println("Croupier has lost!");
        }
    }

    private void determineWinner() {
        int playerValue = playerHand.getHandValue();
        int dealerValue = croupierHand.getHandValue();

        System.out.println("\n--- Final Hands ---");
        System.out.println("Croupier's hand:");
        croupierHand.showHand();

        System.out.println("\nPlayer's hand:");
        playerHand.showHand();

        if (playerHand.hasLost()) {
            System.out.println("\nYou lose.");
        } else if (croupierHand.hasLost()) {
            System.out.println("\nYou win!");
        } else if (playerValue > dealerValue) {
            System.out.println("\nYou win!");
        } else if (playerValue < dealerValue) {
            System.out.println("\nDealer wins.");
        } else {
            System.out.println("\nIt's a tie.");
        }
    }
}
