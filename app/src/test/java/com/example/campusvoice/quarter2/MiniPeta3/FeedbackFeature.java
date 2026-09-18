package com.example.campusvoice.quarter2.MiniPeta3;

import java.util.Scanner;

public class FeedbackFeature {

    String feedback = "";
    String feedbackStatus = "";
    String rating = "";

    public void studentFeedback(Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n========================");
            System.out.println(" FEEDBACK FEATURE");
            System.out.println("========================");
            System.out.println("1. Submit Feedback");
            System.out.println("2. View Feedback");
            System.out.println("3. Back to Dashboard");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter your feedback: ");
                feedback = scanner.nextLine();

                if (feedback.isEmpty()) {
                    System.out.println("Feedback cannot be empty.");
                } else {
                    System.out.print("Enter rating (1-5): ");
                    rating = scanner.nextLine();

                    if (rating.equals("1") || rating.equals("2") ||
                            rating.equals("3") || rating.equals("4") ||
                            rating.equals("5")) {
                        feedbackStatus = "Unread";
                        System.out.println("Feedback sent successfully!");
                    } else {
                        feedback = "";
                        rating = "";
                        System.out.println("Invalid rating.");
                    }
                }

            } else if (choice.equals("2")) {
                if (feedback.isEmpty()) {
                    System.out.println("No feedback submitted.");
                } else {
                    System.out.println("\nYour Feedback: " + feedback);
                    System.out.println("Rating: " + rating + "/5");
                    System.out.println("Status: " + feedbackStatus);
                }

            } else if (choice.equals("3")) {
                isRunning = false;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public void adminFeedback(Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n========================");
            System.out.println(" REVIEW FEEDBACK");
            System.out.println("========================");
            System.out.println("1. View Feedback");
            System.out.println("2. Mark Feedback as Read");
            System.out.println("3. Back to Dashboard");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                if (feedback.isEmpty()) {
                    System.out.println("No feedback available.");
                } else {
                    System.out.println("\nFeedback: " + feedback);
                    System.out.println("Rating: " + rating + "/5");
                    System.out.println("Status: " + feedbackStatus);
                }

            } else if (choice.equals("2")) {
                if (feedback.isEmpty()) {
                    System.out.println("No feedback available.");
                } else {
                    feedbackStatus = "Read";
                    System.out.println("Feedback marked as read.");
                }

            } else if (choice.equals("3")) {
                isRunning = false;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}

