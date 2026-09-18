package com.example.campusvoice.quarter2.MiniPeta3;

import java.util.Scanner;

public class RegistrationFeature {

    String registeredName = "";
    String registeredStudentID = "";
    String registeredEmail = "";
    String registeredUsername = "";
    String registeredPassword = "";
    String accountType = "";

    public void registerAccount(Scanner scanner) {
        System.out.println("\n========================");
        System.out.println(" CREATE ACCOUNT");
        System.out.println("========================");

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Email Address: ");
        String email = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Confirm Password: ");
        String confirmPassword = scanner.nextLine();

        System.out.println("\nAccount Type:");
        System.out.println("1. Student");
        System.out.println("2. Administrator");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        if (fullName.isEmpty() || studentID.isEmpty() || email.isEmpty()
                || username.isEmpty() || password.isEmpty()
                || confirmPassword.isEmpty()) {
            System.out.println("Please complete all fields.");

        } else if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match.");

        } else if (choice.equals("1")) {
            registeredName = fullName;
            registeredStudentID = studentID;
            registeredEmail = email;
            registeredUsername = username;
            registeredPassword = password;
            accountType = "student";

            System.out.println("Student account created successfully!");

        } else if (choice.equals("2")) {
            System.out.print("Enter Administrator Registration Code: ");
            String adminCode = scanner.nextLine();

            if (adminCode.equals("ADMIN123")) {
                registeredName = fullName;
                registeredStudentID = studentID;
                registeredEmail = email;
                registeredUsername = username;
                registeredPassword = password;
                accountType = "admin";

                System.out.println("Administrator account created successfully!");
            } else {
                System.out.println("Invalid administrator registration code.");
            }

        } else {
            System.out.println("Invalid account type.");
        }
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public String getRegisteredStudentID() {
        return registeredStudentID;
    }

    public String getRegisteredEmail() {
        return registeredEmail;
    }

    public String getRegisteredUsername() {
        return registeredUsername;
    }

    public String getRegisteredPassword() {
        return registeredPassword;
    }

    public String getAccountType() {
        return accountType;
    }
}

