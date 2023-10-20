package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShootingCombinationsTest {

    private File inputFile;
    private File outputFile;

    @Before
    public void setup() throws IOException {
        inputFile = new File("data/SHO.IN");
        outputFile = new File("data/SHO.OUT");
    }

    @Test
    public void testValidInput() throws IOException {
        // Create a sample input file
        try (PrintWriter writer = new PrintWriter(inputFile)) {
            writer.println("1");  // One block of data
            writer.println("2 2");  // 2 rows, 2 columns
            writer.println("1 2");
            writer.println("3 4");
        }

        // Run the program
        ShootingCombinations.main(new String[]{});

        // Check the output
        try (Scanner scanner = new Scanner(outputFile)) {
            assertTrue(scanner.hasNext());
            String result = scanner.nextLine();
            assertEquals("1 3", result.trim());
        }
    }

    @Test
    public void testNoValidShots() throws IOException {
        // Create a sample input file
        try (PrintWriter writer = new PrintWriter(inputFile)) {
            writer.println("1");  // One block of data
            writer.println("5 5");  // 2 rows, 2 columns
            writer.println("1 5");
            writer.println("2 4");
            writer.println("3 4");
            writer.println("2 4");
            writer.println("2 3");
        }

        // Run the program
        ShootingCombinations.main(new String[]{});

        // Check the output
        try (Scanner scanner = new Scanner(outputFile)) {
            assertTrue(scanner.hasNext());
            String result = scanner.nextLine();
            assertEquals("NO", result.trim());
        }
    }
}
