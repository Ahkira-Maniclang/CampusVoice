package com.example.campusvoice.quarter2.PracticalExam;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class CinemaTicketingTest {

    @Test
    public void testCinemaFlow() {
        StringBuilder automatedInput = new StringBuilder();

        System.out.println("--- GENERATING CINEMA TEST DATA ---");

        // Step 1: Test underage restriction (< 18)
        automatedInput.append("1\n");
        automatedInput.append("15\n");

        // Step 2: Test legal age access (>= 18)
        automatedInput.append("1\n");
        automatedInput.append("20\n");

        // Step 3: Test snack purchase
        automatedInput.append("2\n");

        // Step 4: Exit system
        automatedInput.append("3\n");

        System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(automatedInput.toString().getBytes());
        Scanner scanner = new Scanner(inputStream);

        CinemaMenu cinemaSystem = new CinemaMenu();
        cinemaSystem.start(scanner);
    }
}
