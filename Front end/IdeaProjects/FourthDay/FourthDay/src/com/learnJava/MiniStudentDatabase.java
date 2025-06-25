package com.learnJava;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MiniStudentDatabase {

    private static final String DATABASE_FILE = "students.txt"; // File to store student data
    private HashMap<String, Student> studentMap; // Key: studentId, Value: Student object
    private ArrayList<Student> studentList;      // For ordered storage and easy saving

    private Scanner scanner;

    public MiniStudentDatabase() {
        studentMap = new HashMap<>();
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadStudentsFromFile(); // Load existing students when the database starts
    }

    // --- Core Database Operations ---

    public void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        // Check if student ID already exists
        if (studentMap.containsKey(id)) {
            System.out.println("Error: Student with ID '" + id + "' already exists. Please use a unique ID.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        int age = -1;
        while (age == -1) {
            try {
                System.out.print("Enter Student Age: ");
                age = scanner.nextInt();
                if (age <= 0) {
                    System.out.println("Age must be a positive number. Please try again.");
                    age = -1; // Reset to loop again
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for age. Please enter a number.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
            }
        }
        scanner.nextLine(); // Consume the leftover newline character after nextInt()

        System.out.print("Enter Student Major: ");
        String major = scanner.nextLine();

        Student newStudent = new Student(id, name, age, major);
        studentMap.put(id, newStudent); // Add to HashMap for quick lookup
        studentList.add(newStudent);    // Add to ArrayList for maintaining order and saving

        System.out.println("Student added successfully: " + newStudent);
        saveStudentsToFile(); // Save immediately after adding
    }

    public void displayAllStudents() {
        System.out.println("\n--- All Students ---");
        if (studentList.isEmpty()) {
            System.out.println("No students in the database.");
            return;
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void searchStudentById() {
        System.out.println("\n--- Search Student by ID ---");
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();

        Student foundStudent = studentMap.get(id); // Fast lookup using HashMap
        if (foundStudent != null) {
            System.out.println("Student Found: " + foundStudent);
        } else {
            System.out.println("Student with ID '" + id + "' not found.");
        }
    }

    // --- File I/O Operations ---

    private void saveStudentsToFile() {
        // Use BufferedWriter for efficient writing, FileWriter to connect to the file
        // try-with-resources ensures the writer is closed automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE))) {
            for (Student student : studentList) {
                writer.write(student.toFileString()); // Write student data as a single line
                writer.newLine(); // Add a new line after each student
            }
            System.out.println("\nStudent data saved to " + DATABASE_FILE);
        } catch (IOException e) {
            System.err.println("Error saving students to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadStudentsFromFile() {
        // Use BufferedReader for efficient reading, FileReader to connect to the file
        // try-with-resources ensures the reader is closed automatically
        File databaseFile = new File(DATABASE_FILE);
        if (!databaseFile.exists()) {
            System.out.println("Database file not found. Starting with an empty database.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromFileString(line); // Convert line to Student object
                if (student != null) {
                    studentMap.put(student.getStudentId(), student);
                    studentList.add(student);
                }
            }
            System.out.println("Loaded " + studentList.size() + " students from " + DATABASE_FILE);
        } catch (IOException e) {
            System.err.println("Error loading students from file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // --- Main Program Loop ---

    public void run() {
        int choice;
        do {
            System.out.println("\n--- Student Database Menu ---");
            System.out.println("1. Add New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Enter to File");
            System.out.println("5. Display File Content");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayAllStudents();
                        break;
                    case 3:
                        searchStudentById();
                        break;
                    case 4:
                        saveStudentsToFile();
                        break;
                    case 5:
                        loadStudentsFromFile();
                        break;
                    case 6:
                        System.out.println("Exiting Student Database. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = 0; // Set to 0 to re-enter loop
            }

        } while (choice != 6);

        scanner.close(); // Close scanner when done
    }

    public static void main(String[] args) {
        MiniStudentDatabase app = new MiniStudentDatabase();
        app.run();
    }
}

