package com.mycompany.app;

import java.io.*;
import java.util.*;

public class ShootingCombinations {

    public static void main(String[] args) {
        try {
            // Reading from SHO.IN file
            Scanner sc = new Scanner(new File("data/SHO.IN"));

            // Number of blocks of data
            int numberOfBlocks = sc.nextInt();

            // To store results for all blocks
            List<List<Integer>> allResults = new ArrayList<>();

            // Iterate for each block
            for (int block = 0; block < numberOfBlocks; block++) {
                // Reading number of rows and columns
                int rows = sc.nextInt();
                int cols = sc.nextInt();

                // Constructing the data array for current block
                int[][] data = new int[cols][2];
                for (int i = 0; i < cols; i++) {
                    data[i][0] = sc.nextInt();
                    data[i][1] = sc.nextInt();
                }

                // Get valid shots for the current block
                List<List<Integer>> validShots = findValidShots(data);

                if (validShots.size() > 0) {
                    allResults.add(validShots.get(0));  // store the first valid shot for current block
                } else {
                    allResults.add(new ArrayList<>());  // Empty list represents "NO"
                }
            }
            sc.close();

            // Writing results to SHO.OUT file
            PrintWriter pw = new PrintWriter(new File("data/SHO.OUT"));
            for (List<Integer> result : allResults) {
                if (result.isEmpty()) {
                    pw.println("NO");
                } else {
                    for (int i = 0; i < result.size(); i++) {
                        if (i > 0) {
                            pw.print(" ");  // Separate numbers with a space
                        }
                        pw.print(result.get(i));
                    }
                    pw.println();  // Move to next line for next block's result
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: Plik SHO.IN nie został znaleziony.");
        } catch (IOException e) {
            System.err.println("Error: Błąd podczas odczytywania lub zapisywania pliku.");
        } catch (InputMismatchException e) {
            System.err.println("Error: Nieprawidłowy format danych.");
        } catch (NoSuchElementException e) {
            System.err.println("Error: Błąd w formatowaniu pliku SHO.IN");
        }
    }

    private static List<List<Integer>> findValidShots(int[][] data) {
        List<List<Integer>> validShots = new ArrayList<>();
        findCombinations(data, 0, new ArrayList<>(), validShots);
        return validShots;
    }

    private static void findCombinations(int[][] data, int currentIndex, List<Integer> currentList, List<List<Integer>> validShots) {
        if (currentIndex == data.length) {
            if (new HashSet<>(currentList).size() == currentList.size()) {
                validShots.add(new ArrayList<>(currentList));
            }
            return;
        }

        for (int i = 0; i < data[currentIndex].length; i++) {
            currentList.add(data[currentIndex][i]);
            findCombinations(data, currentIndex + 1, currentList, validShots);
            currentList.remove(currentList.size() - 1);
        }
    }
}
