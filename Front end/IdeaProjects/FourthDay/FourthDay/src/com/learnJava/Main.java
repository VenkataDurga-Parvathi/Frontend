package com.learnJava;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String filename = "my_notes.txt"; // The name of the file to write to
        String content1 = "This is the first line of my notes.";
        String content2 = "Java File I/O is important!";
        String content3 = "Each line will be separated.";

        // Using try-with-resources ensures the writer is closed automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content1); // Write the first line
            writer.newLine();       // Add a new line character
            writer.write(content2);
            writer.newLine();
            writer.write(content3);
            // No need for writer.close() explicitly here, try-with-resources handles it.

            System.out.println("Successfully wrote data to " + filename);

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace(); // Prints the stack trace for debugging
        }
    }
}
