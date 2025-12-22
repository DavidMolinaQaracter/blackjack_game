package model;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option = 0;

        do {
            showMenu();

            while (true) {
                System.out.print("Choose an option: ");

                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.nextLine(); // clearing invalid input
                }
            }

            switch (option) {
                case 1:
                    try {
                        playGame(sc);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 2:
                    showRules();
                    break;

                case 3:
                    showGameHistory();
                    break;

                case 4:
                    System.out.println("\nByee!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (option != 4){
                System.out.println("\nPress enter to continue...");
                sc.nextLine();
            }
        } while (option != 4);

        sc.close();
    }

    private static void showMenu() {
        System.out.println("\n=== BLACKJACK ===");
        System.out.println("1. Play");
        System.out.println("2. Show game rules");
        System.out.println("3. Show game history");
        System.out.println("4. Exit");
    }

    private static void playGame(Scanner sc) throws InterruptedException {
        boolean playAgain = true;

        while (playAgain) {
            BlackJack game = new BlackJack();
            game.startGame();

            playAgain = askPlayAgain(sc);
        }
    }

    private static boolean askPlayAgain(Scanner sc) {
        String input;

        while (true) {
            System.out.print("\nDo you want to play again? (y/n): ");
            input = sc.nextLine().trim().toLowerCase();

            if (input.equals("y")) return true;
            if (input.equals("n")) return false;

            System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
        }
    }

    private static void showGameHistory() {
        String fileName = "src/main/java/game_history.txt";
        File file = new File(fileName);

        //if file is empty
        if (!file.exists() || file.length() == 0) {
            System.out.println("No game history found yet.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n--- Game History ---");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the history file: " + e.getMessage());
        }
    }

    private static void showRules() {
        System.out.println("\n--- BLACKJACK RULES ---");
        System.out.println("1. GOAL: Get a hand value closer to 21 than the Croupier without exceeding 21.");
        System.out.println("2. CARD VALUES:");
        System.out.println("   - 2 through 10: Face value.");
        System.out.println("   - J, Q, K: 10 points.");
        System.out.println("   - Ace: 1 or 11 points.");
        System.out.println("3. THE DEAL: You get two cards. The Croupier gets two cards, but one is hidden.");
        System.out.println("    - [X] represents the Croupier's hidden card.");
        System.out.println("4. YOUR TURN: Choose 'h' to Hit (take a card) or 's' to Stand (keep your hand).");
        System.out.println("5. CROUPIER'S TURN: The Croupier must hit until their hand is 17 or higher.");
        System.out.println("6. WINNING: You win if your total is higher than the Croupier's (without busting) or if the Croupier busts.");
    }

}
