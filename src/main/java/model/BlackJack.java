package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BlackJack {

    private final Deck deck;
    private final Hand playerHand;
    private final Hand croupierHand;
    private final Scanner  sc;

    public BlackJack() {
        sc = new Scanner(System.in);
        deck = new Deck();
        playerHand = new Hand();
        croupierHand = new Hand();
    }

    public void startGame() throws InterruptedException {
        initialDeal();
        playerTurn();
        croupierTurn();
        TimeUnit.SECONDS.sleep(1);
        determineWinner();
    }

    private void initialDeal() { //Two cards for each one at the begin
        playerHand.addCard(deck.removeCard());
        croupierHand.addCard(deck.removeCard());
        playerHand.addCard(deck.removeCard());
        croupierHand.addCard(deck.removeCard());

        System.out.println("\nCroupier's hand:");
        croupierHand.showPrettyHand(false);

        System.out.println("\nYour hand:");
        playerHand.showPrettyHand(true);
    }

    private void playerTurn() throws InterruptedException {
        while (true) {
            playerHand.calculateValue();

            if (playerHand.isBlackjack()) {
                System.out.println("\nBlackjack!");
                return;
            }

            if (playerHand.hasLost()) {
                System.out.println("\nYou went over 21!");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("\nGAME OVER!");
                TimeUnit.SECONDS.sleep(1);

                return;
            }

            String choice = askHitOrStand(); //Always gonna be 'h' or 's'

            if (choice.equals("h")) {
                playerHand.addCard(deck.removeCard());
                System.out.println("\nYour hand:");
                playerHand.showPrettyHand(true);
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

    private void croupierTurn() throws InterruptedException {
        if (playerHand.hasLost()) { //If player has lost Croupier wins
            return;
        }

        System.out.println("\n--- Croupier's turn ---");
        croupierHand.showPrettyHand(true);


        croupierHand.calculateValue();
        while (croupierHand.getHandValue() < 17) {
            System.out.println("\nCroupier hits...");
            TimeUnit.SECONDS.sleep(1);
            croupierHand.addCard(deck.removeCard());
            croupierHand.showPrettyHand(true);
            croupierHand.calculateValue();
            TimeUnit.SECONDS.sleep(1);
        }

        if (!croupierHand.hasLost())
            System.out.println("\nCroupier stands...");
        else
            System.out.println("\nThe croupier went over 21!");

        System.out.println("\nGAME OVER!");
        TimeUnit.SECONDS.sleep(1);
    }

    private void determineWinner() {

        int playerWin = 0; //0 if player lose, 1 if player win, 2 if tie
        playerHand.calculateValue();
        int playerValue = playerHand.getHandValue();
        croupierHand.calculateValue();
        int croupierValue = croupierHand.getHandValue();

        System.out.println("\n--- Final Hands ---");
        System.out.println("Croupier's hand:");
        croupierHand.showPrettyHand(true);

        System.out.println("\nPlayer's hand:");
        playerHand.showPrettyHand(true);

        if (playerHand.hasLost()) {
            System.out.println("\nYou LOSE!");
        } else if (croupierHand.hasLost()) {
            System.out.println("\nYou WIN!");
            playerWin = 1;
        } else if (playerValue > croupierValue) {
            System.out.println("\nYou WIN!");
            playerWin = 1;
        } else if (playerValue < croupierValue) {
            System.out.println("\nYou LOSE!");
        } else {
            System.out.println("\nIt's a TIE!");
            playerWin = 2;
        }

        writeGameHistory(playerWin);
    }


    private void writeGameHistory(int winner) {
        String fileName = "src/main/java/game_history.txt";

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.now();
        String formattedDate = currentDate.format(format);

        StringBuilder sb = new StringBuilder();

        sb.append(formattedDate).append(" | ");

        sb.append("Player's Hand: ")
                .append(playerHand.showSimpleHand(true))
                .append(" | Croupier's Hand: ")
                .append(croupierHand.showSimpleHand(true))
                .append(" | RESULT: ");

        if (winner == 0) {
            sb.append("Player LOSE");
        } else if (winner == 1) {
            sb.append("Player WIN");
        } else if (winner == 2) {
            sb.append("TIE");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(sb.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing game history.");
        }
    }
}
