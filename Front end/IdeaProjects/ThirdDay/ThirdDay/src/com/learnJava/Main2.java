package com.learnJava;

import java.util.HashMap;
import java.util.Map; // For Map.Entry

public class Main2 {

    public static void main(String[] args) {
        // 1. Declaration and Initialization
        // Creating a HashMap to store String keys (student IDs) and String values (student names)
        HashMap<String, String> studentRecords = new HashMap<>();
        System.out.println("Initial studentRecords: " + studentRecords); // Output: {}

        // 2. Adding Key-Value Pairs (Putting elements)
        studentRecords.put("S001", "Alice Smith");
        studentRecords.put("S002", "Bob Johnson");
        studentRecords.put("S003", "Charlie Brown");
        System.out.println("After adding 3 records: " + studentRecords);
        // Output might vary in order: {S003=Charlie Brown, S002=Bob Johnson, S001=Alice Smith}

        // Overwriting a value for an existing key
        studentRecords.put("S001", "Alicia Smith"); // Alice Smith is replaced by Alicia Smith
        System.out.println("After updating S001: " + studentRecords);
        // Output: {S003=Charlie Brown, S002=Bob Johnson, S001=Alicia Smith}

        // 3. Accessing Values
        String studentS002 = studentRecords.get("S002");
        System.out.println("Student with ID S002: " + studentS002); // Output: Bob Johnson

        String studentS004 = studentRecords.get("S004"); // Key not found
        System.out.println("Student with ID S004: " + studentS004); // Output: null

        // 4. Removing Key-Value Pairs
        studentRecords.remove("S003"); // Removes the entry for S003
        System.out.println("After removing S003: " + studentRecords);
        // Output: {S002=Bob Johnson, S001=Alicia Smith}

        // 5. Checking Size
        System.out.println("Current number of student records: " + studentRecords.size()); // Output: 2

        // 6. Checking for Keys and Values
        System.out.println("Contains key S001? " + studentRecords.containsKey("S001")); // true
        System.out.println("Contains key S003? " + studentRecords.containsKey("S003")); // false
        System.out.println("Contains value \"Bob Johnson\"? " + studentRecords.containsValue("Bob Johnson")); // true

        // 7. Iterating (Looping through HashMap)
        System.out.println("\n--- Iterating through keys ---");
        for (String studentId : studentRecords.keySet()) {
            System.out.println("ID: " + studentId);
        }

        System.out.println("\n--- Iterating through values ---");
        for (String studentName : studentRecords.values()) {
            System.out.println("Name: " + studentName);
        }

        System.out.println("\n--- Iterating through key-value pairs (Entry Set) ---");
        for (Map.Entry<String, String> entry : studentRecords.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }

        // 8. Clearing the HashMap
        studentRecords.clear();
        System.out.println("After clearing: " + studentRecords); // Output: {}
        System.out.println("Is studentRecords empty? " + studentRecords.isEmpty()); // true
    }
}
