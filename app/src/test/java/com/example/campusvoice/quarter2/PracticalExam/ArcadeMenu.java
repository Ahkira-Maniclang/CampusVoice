package com.example.campusvoice.quarter2.PracticalExam;

import java.util.Scanner;

/**
 * ArcadeMenu Class
 * Represents the interactive menu system for the Arcade Counter.
 * Handles token purchases, prize redemptions, and system exit choices
 * using a control loop.
 */
public class ArcadeMenu {

    /**
     * Starts and executes the Arcade Menu control loop.
     *
     * @param scanner The Scanner instance used to read user inputs.
     */
    public void start(Scanner scanner) {
        // Control flag to manage the execution lifecycle of the menu loop
        boolean running = true;

        // SYSTEM 1: Main Control Loop (While Loop Structure)
        // Continues displaying menu options and processing user requests until exit is chosen.
        while (running) {
            // Display system options header
            System.out.println("\n========================");
            System.out.println("=== ARCADE MENU ===");
            System.out.println("========================");
            System.out.println("1. Buy Tokens");
            System.out.println("2. Claim Prize");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // Read the user's menu option choice
            if (!scanner.hasNextInt()) {
                if (scanner.hasNext()) {
                    scanner.next();
                    System.out.println("Invalid choice. Please enter a valid number.");
                    continue;
                } else {
                    break;
                }
            }
            int choice = scanner.nextInt();

            // SYSTEM 2: Option Selection & Request Processing
            if (choice == 1) {
                // SYSTEM 2.1: Token Purchase System
                System.out.println("Enter tokens count:");
                if (scanner.hasNextInt()) {
                    int tokens = scanner.nextInt();
                    System.out.println("Buying " + tokens + " tokens...");
                    System.out.println("Tokens purchased successfully!");
                } else {
                    System.out.println("Invalid token quantity input.");
                }

            } else if (choice == 2) {
                // SYSTEM 2.2: Prize Redemption System
                System.out.println("Enter tickets count:");
                if (scanner.hasNextInt()) {
                    int tickets = scanner.nextInt();
                    System.out.println("Claiming prize for " + tickets + " tickets...");

                    // Prize Tier Evaluation
                    if (tickets >= 500) {
                        System.out.println("Congratulations! Teddy Bear Won!");
                        System.out.println("Prize claimed successfully!");
                    } else if (tickets >= 200) {
                        System.out.println("Congratulations! Candy Won!");
                        System.out.println("Prize claimed successfully!");
                    } else if (tickets >= 100) {
                        System.out.println("Congratulations! Gum Won!");
                        System.out.println("Prize claimed successfully!");
                    } else {
                        System.out.println("Keep Playing to earn more tickets!");
                    }
                } else {
                    System.out.println("Invalid ticket count input.");
                }

            } else if (choice == 3) {
                // SYSTEM 2.3: Exit System
                System.out.println("Exiting Arcade Menu. Thank you for playing!");
                running = false; // Gracefully terminates the while loop

            } else {
                // SYSTEM 2.4: Invalid Input System
                System.out.println("Invalid choice. Please try again.");
                // Continues loop to prompt user again
            }
        }
    }

    /**
     * Main method to allow standalone execution of the Arcade Menu.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArcadeMenu arcadeMenu = new ArcadeMenu();
        arcadeMenu.start(scanner);
        scanner.close();
    }
}
