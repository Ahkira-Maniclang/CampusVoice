package com.example.campusvoice.quarter2.PracticalExam;

import java.util.Scanner;

public class FastFoodMenu {

    public void start(Scanner scanner) {

        boolean running = true;

        // ==========================================
        // INNER LOGIC AND MATH - STATE VARIABLES
        // ==========================================

        final double BURGER_COMBO_PRICE = 120.00;
        final double BURGER_SOLO_PRICE = 80.00;
        final double FRIES_PRICE = 50.00;

        int totalOrders = 0;
        double totalAmountSpent = 0.0;

        // ==========================================
        // MAIN CONTROL LOOP
        // ==========================================

        while (running) {

            System.out.println("\n==========================");
            System.out.println("     FAST FOOD MENU");
            System.out.println("==========================");
            System.out.println("1. Order Burger");
            System.out.println("2. Order Fries");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // INPUT ROUTING
            int choice = scanner.nextInt();

            // ==========================================
            // ORDER BURGER
            // ==========================================

            if (choice == 1) {

                System.out.println("\n--- BURGER OPTIONS ---");
                System.out.println("1. Combo - PHP " + BURGER_COMBO_PRICE);
                System.out.println("2. Solo - PHP " + BURGER_SOLO_PRICE);
                System.out.print("Choose an option: ");

                int burgerChoice = scanner.nextInt();

                if (burgerChoice == 1) {

                    System.out.println("Burger Combo ordered.");
                    System.out.println("Price: PHP " + BURGER_COMBO_PRICE);

                    totalOrders++;
                    totalAmountSpent += BURGER_COMBO_PRICE;

                } else if (burgerChoice == 2) {

                    System.out.println("Burger Solo ordered.");
                    System.out.println("Price: PHP " + BURGER_SOLO_PRICE);

                    totalOrders++;
                    totalAmountSpent += BURGER_SOLO_PRICE;

                } else {

                    System.out.println("Invalid burger option.");
                }

                // ==========================================
                // ORDER FRIES
                // ==========================================

            } else if (choice == 2) {

                System.out.println("Fries ordered.");
                System.out.println("Price: PHP " + FRIES_PRICE);

                totalOrders++;
                totalAmountSpent += FRIES_PRICE;

                // ==========================================
                // EXIT
                // ==========================================

            } else if (choice == 3) {

                System.out.println("\n==========================");
                System.out.println("      ORDER SUMMARY");
                System.out.println("==========================");
                System.out.println("Total Orders: " + totalOrders);
                System.out.println("Total Amount: PHP " + totalAmountSpent);
                System.out.println("Thank you for ordering!");
                System.out.println("Exiting Fast Food Menu...");

                running = false;

            } else {

                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}