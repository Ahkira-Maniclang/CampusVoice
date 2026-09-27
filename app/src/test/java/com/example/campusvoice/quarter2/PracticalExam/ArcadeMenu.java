package com.example.campusvoice.quarter2.PracticalExam;

import java.util.Scanner;

/**
 * ArcadeMenu Class
 * Represents the interactive menu system for the Arcade Counter.
 * Handles input routing using Scanner reads, switch blocks for top-level menu routing,
 * and if-else blocks for nested conditional evaluation.
 */
public class ArcadeMenu {

    /**
     * Starts and executes the Arcade Menu control loop.
     *
     * @param scanner The Scanner instance used to read user inputs.
     */
    public void start(Scanner scanner) {
        boolean running = true;

        // MAIN CONTROL LOOP (While Loop Structure)
        while (running) {
            // Display system options header
            System.out.println("\n========================");
            System.out.println("=== ARCADE MENU ===");
            System.out.println("========================");
            System.out.println("1. Buy Tokens");
            System.out.println("2. Claim Prize");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // ==========================================
            // INPUT ROUTING - SCANNER READ
            // ==========================================
            if (!scanner.hasNextInt()) {
                if (scanner.hasNext()) {
                    scanner.next(); // Clear invalid input token
                    System.out.println("Invalid choice. Please enter a valid number.");
                    continue;
                } else {
                    break;
                }
            }

            // Scanner Read: Reading the user's menu option
            int choice = scanner.nextInt();

            // ==========================================
            // INPUT ROUTING - SWITCH BLOCK
            // ==========================================
            switch (choice) {
                case 1:
                    // Route 1: Token Purchase System
                    System.out.println("Enter tokens count:");

                    // Scanner Read & If-Else Block: Token quantity input
                    if (scanner.hasNextInt()) {
                        int tokens = scanner.nextInt();
                        System.out.println("Buying " + tokens + " tokens...");
                        System.out.println("Tokens purchased successfully!");
                    } else {
                        System.out.println("Invalid token quantity input.");
                    }
                    break;

                case 2:
                    // Route 2: Prize Claim System
                    System.out.println("Enter tickets count:");

                    // Scanner Read & If-Else Block: Prize Tier Evaluation
                    if (scanner.hasNextInt()) {
                        int tickets = scanner.nextInt();
                        System.out.println("Claiming prize for " + tickets + " tickets...");

                        // If-Else Block: Evaluating prize tiers based on ticket count
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
                    break;

                case 3:
                    // Route 3: Exit System
                    System.out.println("Exiting Arcade Menu. Thank you for playing!");
                    running = false; // Terminate loop
                    break;

                default:
                    // Route Default: Invalid Choice Handling
                    System.out.println("Invalid choice. Please try again.");
                    break;
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
