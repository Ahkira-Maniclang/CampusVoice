package com.example.campusvoice.quarter2.MiniPeta3;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MenuTestingFile {

    @Test
    public void testCompleteSystemFlow() {
        /*
         * 1. THE VIRTUAL KEYBOARD
         * A 'StringBuilder' acts as our virtual keyboard.
         * Instead of physically typing into the console, we will "append" (add)
         * every number or word the user would type into this builder.
         */
        StringBuilder simulatedUserInput = new StringBuilder();

        System.out.println("--- GENERATING SIMULATED USER INPUTS ---");

        /*
         * PART 1: Simulating Repetitive Tasks
         * We can use a while loop here to generate multiple inputs efficiently.
         * Think of this as a customer making 3 different orders or transactions.
         */
        int interactionCount = 1;
        while (interactionCount <= 3) {
            System.out.println("Generating inputs for interaction #" + interactionCount);

            if (interactionCount == 1) {
                // Simulating user choosing Complaint (1), submitting a complaint, viewing it, and returning
                simulatedUserInput.append("1\n"); // Choose Complaint
                simulatedUserInput.append("1\n"); // Submit Complaint
                simulatedUserInput.append("Broken chair in Room 301\n"); // Complaint text
                simulatedUserInput.append("2\n"); // View Complaint
                simulatedUserInput.append("3\n"); // Back to Dashboard
            } else if (interactionCount == 2) {
                // Simulating user choosing Feedback (2), submitting feedback, entering rating, viewing it, and returning
                simulatedUserInput.append("2\n"); // Choose Feedback
                simulatedUserInput.append("1\n"); // Submit Feedback
                simulatedUserInput.append("Great facility upgrades!\n"); // Feedback text
                simulatedUserInput.append("5\n"); // Rating
                simulatedUserInput.append("2\n"); // View Feedback
                simulatedUserInput.append("3\n"); // Back to Dashboard
            } else {
                // Simulating user choosing Feedback (2) to view previously submitted feedback
                simulatedUserInput.append("2\n"); // Choose Feedback
                simulatedUserInput.append("2\n"); // View Feedback
                simulatedUserInput.append("3\n"); // Back to Dashboard
            }
            interactionCount++;
        }

        /*
         * PART 2: Simulating Sub-Menus or Specific Features
         * You don't always need a loop to test inputs. You can hardcode
         * a specific path the user takes through your menus.
         */
        System.out.println("Generating inputs for specific features...");
        simulatedUserInput.append("3\n");          // Enter Settings sub-menu
        simulatedUserInput.append("1\n");          // View Profile
        simulatedUserInput.append("2\n");          // Change Password
        simulatedUserInput.append("1234\n");       // Enter current password
        simulatedUserInput.append("newpass9999\n"); // Enter new password
        simulatedUserInput.append("3\n");          // Go back to the Main Menu

        /*
         * PART 3: Simulating the Exit Command
         * CRITICAL: You MUST send the exit number so your main 'while(isRunning)' loop stops.
         * If you don't, your program will keep asking for inputs, but the virtual keyboard
         * is empty, causing the test to crash!
         */
        System.out.println("Generating input to Exit the system...");
        simulatedUserInput.append("4\n"); // Exit option '4'

        System.out.println("--- INPUT GENERATION COMPLETE ---\n");

        /*
         * 2. THE MAGIC CONVERSION
         * This converts our long string of inputs into an "InputStream".
         * It tricks Java into thinking this string is a hardware device like a keyboard.
         */
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedUserInput.toString().getBytes());

        /*
         * 3. THE AUTOMATED SCANNER
         * We give that stream to a normal Scanner. Now, whenever your code uses
         * scanner.nextInt() or scanner.nextLine(), it reads from our StringBuilder!
         */
        Scanner scanner = new Scanner(inputStream);

        /*
         * 4. RUNNING YOUR ACTUAL PROGRAM
         */
        MainMenu mainSystem = new MainMenu();

        // Start your system and pass our automated scanner into it.
        mainSystem.start(scanner);
    }
}