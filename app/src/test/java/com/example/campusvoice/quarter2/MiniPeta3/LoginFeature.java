package com.example.campusvoice.quarter2.MiniPeta3;

import java.util.Scanner;

public class LoginFeature {

   public static void main(String[] args){
     Scanner input = new Scanner(System.in);

     String registeredUsername = "";
     String registeredPassword = "";

     //LOGIN INTERFACE
     System.out.println("\n========================");
     System.out.println(" LOGIN INTERFACE ");
     System.out.println("========================");

       System.out.print("Username: ");
       String username = input.nextLine();

       System.out.print("Password: ");
       String password = input.nextLine();

       //Checking Login Info
       if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
           System.out.println("========================");
           System.out.println("Login Successful!");
           System.out.println("Welcome " + username);
           System.out.println("========================");
       } else {
           System.out.println("Login Failed!");
           System.out.println("Invalid username or password");
           System.out.println("Please try again.");
           return;
       }

       //ADMINISTRATOR OR STUDENT INTERFACE
       System.out.println("\nAccount Type:");
       System.out.println("1. Student");
       System.out.println("2. Administrator");
       System.out.print("Enter choice: ");

       Scanner scanner = new Scanner(System.in);
       scanner.nextLine();
       int choice = scanner.nextInt();

       if (choice == 1) {
           System.out.println("Welcome Student!");
           System.out.println("========================");
           System.out.println("STUDENT INTERFACE");
           System.out.println("========================");
       } else if (choice == 2) {
           System.out.println("Welcome Administrator!");
           System.out.println("========================");
           System.out.println("ADMINISTRATOR INTERFACE");
           System.out.println("========================");
       } else {
           System.out.println("Invalid choice!");
           System.out.println("Please try again.");
       }
       input.close();
       scanner.close();
   }
}
