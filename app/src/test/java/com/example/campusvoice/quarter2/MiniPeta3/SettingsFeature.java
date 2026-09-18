package com.example.campusvoice.quarter2.MiniPeta3;

import java.util.Scanner;

public class SettingsFeature {

    String name = "User";
    String username = "campususer";
    String password = "1234";

    public void settingsMenu(Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n========================");
            System.out.println(" SETTINGS");
            System.out.println("========================");
            System.out.println("1. View Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Back to Dashboard");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("\n===== PROFILE =====");
                System.out.println("Name: " + name);
                System.out.println("Username: " + username);

            } else if (choice.equals("2")) {
                System.out.print("Enter current password: ");
                String currentPassword = scanner.nextLine();

                if (currentPassword.equals(password)) {
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();

                    if (newPassword.isEmpty()) {
                        System.out.println("Password cannot be empty.");
                    } else {
                        password = newPassword;
                        System.out.println("Password changed successfully!");
                    }
                } else {
                    System.out.println("Incorrect current password.");
                }

            } else if (choice.equals("3")) {
                isRunning = false;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}

