package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BlackJack{

    private Deck deck;
    private Hand playerHand;
    private Hand croupierHand;
    private Scanner sc;

    public BlackJack() {
        sc = new Scanner(System.in);
        deck = new Deck();
        playerHand = new Hand();
        croupierHand = new Hand();
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

        System.out.println("\nCroupier's hand:");
        croupierHand.showHand(false);

        System.out.println("\nYour hand:");
        playerHand.showHand(true);
    }

    private void playerTurn() {
        while (true) {
            playerHand.calculateValue();

            if (playerHand.isBlackjack()) {
                System.out.println("\nBlackjack!");
                return;
            }

            if (playerHand.hasLost()) {
                return;
            }

            String choice = askHitOrStand(); //Always gonna be 'h' or 's'

            if (choice.equals("h")) {
                playerHand.addCard(deck.removeCard());
                System.out.println("\nYour hand:");
                playerHand.showHand(true);
            } else if (choice.equals("s")) {
                return;
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
        croupierHand.showHand(true);

        croupierHand.calculateValue();
        while (croupierHand.getHandValue() < 17) {
            System.out.println("Croupier hits...");
            croupierHand.addCard(deck.removeCard());
            croupierHand.showHand(true);
            croupierHand.calculateValue();
        }

        if (croupierHand.hasLost()) {
            System.out.println("Croupier has lost!");
        }else{
            System.out.println("Croupier stands...");
        }

    }

    private void determineWinner() {

        int playerWin = 0; //0 if player lose, 1 if player win, 2 if tie
        playerHand.calculateValue();
        int playerValue = playerHand.getHandValue();
        croupierHand.calculateValue();
        int croupierValue = croupierHand.getHandValue();

        System.out.println("\n--- Final Hands ---");
        System.out.println("Croupier's hand:");
        croupierHand.showHand(true);

        System.out.println("\nPlayer's hand:");
        playerHand.showHand(true);

        if (playerHand.hasLost()) {
            System.out.println("\nYou lose.");
        } else if (croupierHand.hasLost()) {
            System.out.println("\nYou win!");
            playerWin = 1;
        } else if (playerValue > croupierValue) {
            System.out.println("\nYou win!");
            playerWin = 1;
        } else if (playerValue < croupierValue) {
            System.out.println("\nCroupier wins.");
        } else {
            System.out.println("\nIt's a tie.");
            playerWin = 2;
        }

        writeGameHistory(playerWin);
    }


    private void writeGameHistory(int winner) {
        String fileName = "model/game_history.txt";

        StringBuilder sb = new StringBuilder();

        sb.append("Player's Hand Value: ")
                .append(playerHand.getHandValue())
                .append(" | Croupier's Hand Value: ")
                .append(croupierHand.getHandValue())
                .append(" | RESULT: ");

        if (winner == 0){
            sb.append("Player lose");
        } else if (winner == 1) {
            sb.append("Player win");
        }else if (winner == 2){
            sb.append("Tie");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(sb.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing game history.");
        }
    }
}
