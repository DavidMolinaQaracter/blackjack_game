package model;

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
                    playGame(sc);
                    break;

                case 2:
                    System.out.println("\n--- Game History ---");
                    System.out.println("Feature not implemented yet.");
                    break;

                case 3:
                    System.out.println("\nByee!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println("Press enter to continue...");
            sc.nextLine();

        }while (option != 3);

        sc.close();
    }

    private static void showMenu() {
        System.out.println("\n=== BLACKJACK ===");
        System.out.println("1. Play");
        System.out.println("2. Show game history");
        System.out.println("3. Exit");
    }

    private static void playGame(Scanner sc) {
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



}
