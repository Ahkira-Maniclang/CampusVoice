package com.example.campusvoice.quarter2.PracticalExam;

import java.util.Scanner;

/**
 * ArcadeMenu Class
 * Feature file representing the interactive menu system for the Arcade Counter.
 * Follows Dependency Injection guidelines by accepting a Scanner as a method parameter
 * and avoiding any instantiation of 'new Scanner(System.in)' inside this feature class.
 */
public class ArcadeMenu {

    /**
     * Starts and executes the Arcade Menu control loop with inner logic and calculations.
     *
     * @param scanner The Scanner instance injected as a method parameter.
     */
    public void start(Scanner scanner) {
        boolean running = true;

        // ==========================================
        // INNER LOGIC AND MATH - STATE TRACKING VARIABLES
        // ==========================================
        final double TOKEN_PRICE_RATE = 5.0; // Math constant: 5.0 PHP per token
        int totalTokensPurchased = 0;       // Math accumulator: Cumulative tokens bought
        double totalAmountSpent = 0.0;       // Math accumulator: Cumulative money spent in PHP
        int totalTicketsRedeemed = 0;      // Math accumulator: Cumulative tickets used
        int totalPrizesClaimed = 0;        // Math counter: Total prizes won
        int tokenTransactionsCount = 0;    // Math counter: Number of token transactions

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

                        // ==========================================
                        // INNER LOGIC AND MATH - TOKEN COST CALCULATION
                        // ==========================================
                        double transactionCost = tokens * TOKEN_PRICE_RATE; // Core Calculation: Tokens x Rate
                        totalTokensPurchased += tokens;                   // Core Math: Accumulate tokens
                        totalAmountSpent += transactionCost;               // Core Math: Accumulate total cost
                        tokenTransactionsCount++;                          // Increment transaction counter

                        System.out.println("Cost: " + tokens + " tokens x " + TOKEN_PRICE_RATE + " PHP = " + transactionCost + " PHP");
                        System.out.println("Total Balance: " + totalTokensPurchased + " tokens purchased so far.");
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

                        // ==========================================
                        // INNER LOGIC AND MATH - PRIZE TIER CALCULATIONS
                        // ==========================================
                        if (tickets >= 500) {
                            int remainingTickets = tickets - 500; // Core Math: Calculate remaining tickets
                            totalTicketsRedeemed += 500;           // Core Math: Accumulate redeemed tickets
                            totalPrizesClaimed++;                  // Core Math: Increment prize count

                            System.out.println("Congratulations! Teddy Bear Won!");
                            System.out.println("Remaining tickets after claim: " + remainingTickets);
                            System.out.println("Prize claimed successfully!");

                        } else if (tickets >= 200) {
                            int remainingTickets = tickets - 200; // Core Math: Calculate remaining tickets
                            totalTicketsRedeemed += 200;           // Core Math: Accumulate redeemed tickets
                            totalPrizesClaimed++;                  // Core Math: Increment prize count

                            System.out.println("Congratulations! Candy Won!");
                            System.out.println("Remaining tickets after claim: " + remainingTickets);
                            System.out.println("Prize claimed successfully!");

                        } else if (tickets >= 100) {
                            int remainingTickets = tickets - 100; // Core Math: Calculate remaining tickets
                            totalTicketsRedeemed += 100;           // Core Math: Accumulate redeemed tickets
                            totalPrizesClaimed++;                  // Core Math: Increment prize count

                            System.out.println("Congratulations! Gum Won!");
                            System.out.println("Remaining tickets after claim: " + remainingTickets);
                            System.out.println("Prize claimed successfully!");

                        } else {
                            int ticketsNeeded = 100 - tickets; // Core Math: Calculate missing tickets needed for lowest tier
                            System.out.println("Need " + ticketsNeeded + " more tickets to claim a prize!");
                            System.out.println("Keep Playing to earn more tickets!");
                        }
                    } else {
                        System.out.println("Invalid ticket count input.");
                    }
                    break;

                case 3:
                    // Route 3: Exit System
                    System.out.println("Exiting Arcade Menu. Thank you for playing!");

                    // ==========================================
                    // INNER LOGIC AND MATH - SESSION SUMMARY CALCULATIONS
                    // ==========================================
                    System.out.println("\n--- SESSION SUMMARY & CALCULATIONS ---");
                    System.out.println("Total Token Transactions: " + tokenTransactionsCount);
                    System.out.println("Total Tokens Purchased: " + totalTokensPurchased);
                    System.out.println("Total Amount Spent: " + totalAmountSpent + " PHP");
                    System.out.println("Total Tickets Redeemed: " + totalTicketsRedeemed);
                    System.out.println("Total Prizes Claimed: " + totalPrizesClaimed);

                    running = false; // Terminate loop
                    break;

                default:
                    // Route Default: Invalid Choice Handling
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
