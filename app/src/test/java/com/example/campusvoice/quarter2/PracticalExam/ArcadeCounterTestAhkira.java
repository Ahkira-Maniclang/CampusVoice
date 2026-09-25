package com.example.campusvoice.quarter2.PracticalExam;

    import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
    public class ArcadeCounterTestAhkira {
        @Test
        public void testArcadeFlow() {
            StringBuilder automatedInput = new StringBuilder();
            System.out.println("--- GENERATING ARCADE TEST DATA ---");
// Step 1: Buy tokens option
            automatedInput.append("1\n"); // Choose Buy Tokens
// Step 2: Test low ticket count for prize (< 500)
            automatedInput.append("2\n"); // Choose Claim Prize
            automatedInput.append("200\n"); // Enter 200 tickets (Expected: Keep Playing)
// Step 3: Test high ticket count for prize (>= 500)
            automatedInput.append("2\n"); // Choose Claim Prize
            automatedInput.append("600\n"); // Enter 600 tickets (Expected: Teddy Bear Won)
// Step 4: Exit system
            automatedInput.append("3\n"); // Choose Exit
            System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");
            ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.toString().getBytes());
            Scanner scanner = new Scanner(inputStream);

            ArcadeCounterTestAhkira arcadeSystem = new ArcadeCounterTestAhkira();
            arcadeSystem.start(scanner);
            scanner.close();
        }

        public void start(Scanner scanner) {
            boolean running = true;
            while (running) {
                System.out.println("\n--- ARCADE COUNTER SYSTEM ---");
                System.out.println("1. Buy Tokens");
                System.out.println("2. Claim Prize");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                if (!scanner.hasNextInt()) {
                    if (scanner.hasNext()) scanner.next();
                    continue;
                }
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Tokens purchased successfully!");
                        break;
                    case 2:
                        System.out.print("Enter tickets count: ");
                        if (scanner.hasNextInt()) {
                            int tickets = scanner.nextInt();
                            if (tickets >= 500) {
                                System.out.println("Congratulations! Teddy Bear Won!");
                            } else {
                                System.out.println("Keep Playing to earn more tickets!");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Exiting system. Thank you!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }
    }

