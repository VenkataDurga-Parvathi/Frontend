package com.learnJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {
        String filename = "ex.txt"; // The name of the file to read from

        // Using try-with-resources ensures the reader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("--- Reading from " + filename + " ---");
            // Read line by line until there are no more lines (readLine() returns null)
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line
            }
            System.out.println("--- Finished reading ---");

        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}