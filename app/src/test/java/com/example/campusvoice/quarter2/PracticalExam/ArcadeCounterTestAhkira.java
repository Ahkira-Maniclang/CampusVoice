package com.example.campusvoice.quarter2.PracticalExam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * ArcadeCounterTestAhkira Class
 * Unit test class to simulate and verify automated user flows through the Arcade Counter system.
 */
public class ArcadeCounterTestAhkira {

    /**
     * Tests the automated complete user interaction flow for the Arcade Menu system.
     */
    @Test
    public void testArcadeFlow() {
        /*
         * SYSTEM 1: Automated Input Generation (Virtual Keyboard)
         * Uses StringBuilder to simulate user typing actions sequentially.
         */
        StringBuilder automatedInput = new StringBuilder();

        System.out.println("--- GENERATING ARCADE TEST DATA ---");

        // STEP 1: Test Token Purchase System (Option 1)
        automatedInput.append("1\n"); // Select Option 1: Buy Tokens
        automatedInput.append("50\n"); // Enter 50 tokens quantity

        automatedInput.append("1\n"); // Select Option 1: Buy Tokens
        automatedInput.append("100\n"); // Enter 100 tokens quantity

        automatedInput.append("1\n"); // Select Option 1: Buy Tokens
        automatedInput.append("150\n"); // Enter 150 tokens quantity

        // STEP 2: Test Prize Claim System with various Ticket Tiers (Option 2)
        automatedInput.append("2\n"); // Select Option 2: Claim Prize
        automatedInput.append("100\n"); // Enter 100 tickets (Expected: Gum Won)

        automatedInput.append("2\n"); // Select Option 2: Claim Prize
        automatedInput.append("200\n"); // Enter 200 tickets (Expected: Candy Won)

        automatedInput.append("2\n"); // Select Option 2: Claim Prize
        automatedInput.append("300\n"); // Enter 300 tickets (Expected: Candy Won)

        automatedInput.append("2\n"); // Select Option 2: Claim Prize
        automatedInput.append("400\n"); // Enter 400 tickets (Expected: Candy Won)

        automatedInput.append("2\n"); // Select Option 2: Claim Prize
        automatedInput.append("500\n"); // Enter 500 tickets (Expected: Teddy Bear Won)

        automatedInput.append("2\n"); // Select Option 2: Claim Prize
        automatedInput.append("600\n"); // Enter 600 tickets (Expected: Teddy Bear Won)

        // STEP 3: Test Invalid Choice Handling System
        automatedInput.append("99\n"); // Enter invalid choice '99'

        // STEP 4: Test System Exit (Option 3)
        automatedInput.append("3\n"); // Select Option 3: Exit

        System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");

        /*
         * SYSTEM 2: Stream Input Conversion
         * Converts the generated String sequence into a ByteArrayInputStream
         * to simulate hardware keyboard input for the Scanner.
         */
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(automatedInput.toString().getBytes());

        /*
         * SYSTEM 3: Scanner Initialization
         * Wraps the input stream in a Scanner instance passed into ArcadeMenu.
         */
        Scanner scanner = new Scanner(inputStream);

        /*
         * SYSTEM 4: System Execution & Connection
         * Instantiates ArcadeMenu and executes the automated test flow.
         */
        ArcadeMenu arcadeSystem = new ArcadeMenu();
        arcadeSystem.start(scanner);
        scanner.close();
    }
}
