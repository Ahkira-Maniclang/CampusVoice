package com.example.campusvoice.quarter2.MiniPeta3;

import com.example.campusvoice.quarter2.MiniPeta3.ComplaintFeature;
import com.example.campusvoice.quarter2.MiniPeta3.FeedbackFeature;
import com.example.campusvoice.quarter2.MiniPeta3.SettingsFeature;

import java.util.Scanner;

public class MainMenu {

    private final ComplaintFeature complaintFeature = new ComplaintFeature();
    private final FeedbackFeature feedbackFeature = new FeedbackFeature();
    private final SettingsFeature settingsFeature = new SettingsFeature();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MainMenu mainSystem = new MainMenu();
        mainSystem.start(input);
        input.close();
    }

    public void start(Scanner input) {
        int choice = 0;

        do {
            System.out.println("\n========================");
            System.out.println(" MAIN MENU ");
            System.out.println("========================");
            System.out.println("1. Complaint");
            System.out.println("2. Feedback");
            System.out.println("3. Settings");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            if (!input.hasNextInt()) {
                if (input.hasNext()) {
                    input.nextLine();
                    continue;
                } else {
                    break;
                }
            }
            choice = input.nextInt();
            input.nextLine();

            // COMPLAINT MENU
            if (choice == 1) {
                complaintFeature.studentComplaint(input);

                // FEEDBACK MENU
            } else if (choice == 2) {
                feedbackFeature.studentFeedback(input);

                // SETTINGS MENU
            } else if (choice == 3) {
                settingsFeature.settingsMenu(input);

                // EXIT SYSTEM
            } else if (choice == 4) {
                System.out.println("Exiting system. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }
}