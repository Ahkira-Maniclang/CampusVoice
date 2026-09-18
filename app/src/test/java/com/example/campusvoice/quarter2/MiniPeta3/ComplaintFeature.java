package com.example.campusvoice.quarter2.MiniPeta3;

import java.util.Scanner;

public class ComplaintFeature {

    String complaint = "";
    String complaintStatus = "";
    String response = "";

    public void studentComplaint(Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n========================");
            System.out.println(" COMPLAINT FEATURE");
            System.out.println("========================");
            System.out.println("1. Submit Complaint");
            System.out.println("2. View Complaint");
            System.out.println("3. Back to Dashboard");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter your complaint: ");
                complaint = scanner.nextLine();

                if (complaint.isEmpty()) {
                    System.out.println("Complaint cannot be empty.");
                } else {
                    complaintStatus = "Pending";
                    response = "";
                    System.out.println("Complaint sent successfully!");
                    System.out.println("Status: Pending");
                }

            } else if (choice.equals("2")) {
                if (complaint.isEmpty()) {
                    System.out.println("No complaint submitted.");
                } else {
                    System.out.println("\nYour Complaint: " + complaint);
                    System.out.println("Status: " + complaintStatus);

                    if (!response.isEmpty()) {
                        System.out.println("Admin Response: " + response);
                    }
                }

            } else if (choice.equals("3")) {
                isRunning = false;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public void adminComplaint(Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n========================");
            System.out.println(" REVIEW COMPLAINT");
            System.out.println("========================");
            System.out.println("1. View Complaint");
            System.out.println("2. Respond to Complaint");
            System.out.println("3. Mark as Completed");
            System.out.println("4. Back to Dashboard");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                if (complaint.isEmpty()) {
                    System.out.println("No complaint available.");
                } else {
                    System.out.println("\nComplaint: " + complaint);
                    System.out.println("Status: " + complaintStatus);

                    if (!response.isEmpty()) {
                        System.out.println("Response: " + response);
                    }
                }

            } else if (choice.equals("2")) {
                if (complaint.isEmpty()) {
                    System.out.println("No complaint available.");
                } else {
                    System.out.print("Enter your response: ");
                    response = scanner.nextLine();

                    if (response.isEmpty()) {
                        System.out.println("Response cannot be empty.");
                    } else {
                        System.out.println("Response sent successfully!");
                    }
                }

            } else if (choice.equals("3")) {
                if (complaint.isEmpty()) {
                    System.out.println("No complaint available.");
                } else {
                    complaintStatus = "Completed";
                    System.out.println("Complaint marked as completed.");
                }

            } else if (choice.equals("4")) {
                isRunning = false;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
