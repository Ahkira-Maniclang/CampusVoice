package com.example.campusvoice.quarter2.MiniPeta3;

import java.util.Scanner;


public class MainMenu {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n========================");
            System.out.println(" MAIN MENU ");
            System.out.println("========================");
            System.out.println("1.Complaint");
            System.out.println("2.Feedback");
            System.out.println("Settings");

            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine();

            //COMPLAINT MENU
            if (choice == 1) {
                System.out.println("\n========================");
                System.out.println(" COMPLAINT ");
                System.out.println("========================");

                System.out.print("Enter your complaint: ");
                String complaint = input.nextLine();

                if (!complaint.isEmpty()) {
                    System.out.println("Complaint submitted successfully!");
                } else {
                    System.out.println("Invalid complaint. Please try again.");
                }

            //FEEDBACK MENU
            }else if (choice == 2){
                System.out.println("\n========================");
                System.out.println(" FEEDBACK ");
                System.out.println("========================");

                System.out.print("Enter your feedback: ");
                String feedback = input.nextLine();

                if (!feedback.isEmpty()) {
                    System.out.println("Feedback submitted successfully!");
                } else {
                    System.out.println("Invalid feedback. Please try again.");
                }

            //SETTINGS MENU
            } else if (choice == 3) {
                System.out.println("\n========================");
                System.out.println(" SETTINGS ");
                System.out.println("========================");

                System.out.println("1. Change Username");
                System.out.println("2. Change Password");
                System.out.println("3. Back Main Menu");

                System.out.print("Choose an option: ");
                int settingChoice = input.nextInt();
                input.nextLine();

                //USERNAME SETTINGS
                if (settingChoice == 1) {
                    System.out.print("Enter new username: ");
                    String newUsername = input.nextLine();
                    System.out.println("Username changed successfully!");

                //PASSWORD SETTINGS
                } else if (settingChoice == 2) {
                    System.out.print("Enter new password: ");
                    String newPassword = input.nextLine();
                    System.out.println("Password changed successfully!");

                //BACK TO MAIN MENU
                } else if (settingChoice == 3) {
                    System.out.println("Returning to main menu...");
                    break;

                //INVALID CHOICE
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }

            }

        }while(choice != 3);

        input.close();
    }

 }