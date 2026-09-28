package com.example.campusvoice.quarter2.PracticalExam;

import java.util.Scanner;

public class FastFoodMenu {

    public void start(Scanner scanner) {

        boolean running = true;

        while (running) {

            System.out.println("\n======================");
            System.out.println("=== FAST FOOD MENU ===");
            System.out.println("======================");
            System.out.println("1. Order Burger");
            System.out.println("2. Order Fries");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {

                System.out.println("Burger selected.");

            } else if (choice == 2) {

                System.out.println("Fries selected.");

            } else if (choice == 3) {

                System.out.println("Exiting Fast Food Menu.");
                running = false;

            } else {

                System.out.println("Invalid choice.");

            }
        }
    }
}
