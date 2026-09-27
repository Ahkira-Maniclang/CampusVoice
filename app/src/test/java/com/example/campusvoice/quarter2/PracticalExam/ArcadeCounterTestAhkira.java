package com.example.campusvoice.quarter2.PracticalExam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * ArcadeCounterTestAhkira Class
 * Unit test class to simulate and verify automated input routing through the Arcade Counter system.
 */
public class ArcadeCounterTestAhkira {

    /**
     * Tests automated input routing for the Arcade Menu system.
     */
    @Test
    public void testArcadeFlow() {
        /*
         * AUTOMATED INPUT ROUTING SETUP
         * StringBuilder acts as a virtual keyboard feeding simulated user inputs
         * to the Scanner reader.
         */
        StringBuilder automatedInput = new StringBuilder();

        System.out.println("--- GENERATING ARCADE TEST DATA ---");

        // ROUTE 1: Token Purchase Inputs (Choice 1 -> Token Count)
        automatedInput.append("1\n"); // Choice 1: Buy Tokens
        automatedInput.append("50\n"); // Token quantity: 50

        automatedInput.append("1\n"); // Choice 1: Buy Tokens
        automatedInput.append("100\n"); // Token quantity: 100

        automatedInput.append("1\n"); // Choice 1: Buy Tokens
        automatedInput.append("150\n"); // Token quantity: 150

        // ROUTE 2: Prize Claim Inputs (Choice 2 -> Ticket Count)
        automatedInput.append("2\n"); // Choice 2: Claim Prize
        automatedInput.append("100\n"); // Ticket count: 100 (Gum Tier)

        automatedInput.append("2\n"); // Choice 2: Claim Prize
        automatedInput.append("200\n"); // Ticket count: 200 (Candy Tier)

        automatedInput.append("2\n"); // Choice 2: Claim Prize
        automatedInput.append("300\n"); // Ticket count: 300 (Candy Tier)

        automatedInput.append("2\n"); // Choice 2: Claim Prize
        automatedInput.append("400\n"); // Ticket count: 400 (Candy Tier)

        automatedInput.append("2\n"); // Choice 2: Claim Prize
        automatedInput.append("500\n"); // Ticket count: 500 (Teddy Bear Tier)

        automatedInput.append("2\n"); // Choice 2: Claim Prize
        automatedInput.append("600\n"); // Ticket count: 600 (Teddy Bear Tier)

        // ROUTE DEFAULT: Invalid Choice Input
        automatedInput.append("99\n"); // Invalid menu option '99'

        // ROUTE 3: Exit System Input
        automatedInput.append("3\n"); // Choice 3: Exit

        System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");

        /*
         * SCANNER READ INITIALIZATION & INPUT ROUTING EXECUTION
         * Converts input string to stream and passes Scanner into ArcadeMenu.
         */
        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(automatedInput.toString().getBytes());
        Scanner scanner = new Scanner(inputStream);

        ArcadeMenu arcadeSystem = new ArcadeMenu();
        arcadeSystem.start(scanner);
        scanner.close();
    }
}
