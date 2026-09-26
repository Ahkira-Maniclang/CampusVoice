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

            if (choice == 3) {
                running = false;
            }
        }
    }
}
