package com.example.campusvoice.quarter2.PracticalExam;

import java.util.Scanner;

public class CinemaMenu {

    public void start(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("=== CINEMA MENU ===");
            System.out.println("1. Buy Ticket");
            System.out.println("2. Buy Snacks");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter age:");
                int age = scanner.nextInt();

                if (age < 18) {
                    System.out.println("Access Denied");
                } else {
                    System.out.println("Ticket Printed");
                }

            } else if (choice == 2) {
                System.out.println("Snack purchase selected.");

            } else if (choice == 3) {
                running = false;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}

