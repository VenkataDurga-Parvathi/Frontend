package com.learnJava;

import java.util.ArrayList;
import java.util.Iterator; // For iterating

public class Main {

    public static void main(String[] args) {
        // 1. Declaration and Initialization
        // Creating an ArrayList to store String objects (student names)
        ArrayList<String> studentNames = new ArrayList<>();
        System.out.println("Initial studentNames: " + studentNames); // Output: []

        // 2. Adding Elements
        studentNames.add("Alice"); // Adds to the end
        studentNames.add("Bob");
        studentNames.add("Charlie");
        System.out.println("After adding 3 names: " + studentNames); // Output: [Alice, Bob, Charlie]

        studentNames.add(1, "David"); // Adds "David" at index 1, shifting Bob and Charlie
        System.out.println("After adding David at index 1: " + studentNames); // Output: [Alice, David, Bob, Charlie]

        // 3. Accessing Elements
        String firstStudent = studentNames.get(0);
        System.out.println("First student: " + firstStudent); // Output: Alice

        String thirdStudent = studentNames.get(2);
        System.out.println("Third student: " + thirdStudent); // Output: Bob

        // 4. Updating Elements
        studentNames.set(3, "Eve"); // Replaces the element at index 3 (Charlie) with Eve
        System.out.println("After updating index 3 to Eve: " + studentNames); // Output: [Alice, David, Bob, Eve]

        // 5. Removing Elements
        studentNames.remove(1); // Removes element at index 1 (David)
        System.out.println("After removing student at index 1: " + studentNames); // Output: [Alice, Bob, Eve]

        studentNames.remove("Bob"); // Removes the first occurrence of "Bob"
        System.out.println("After removing Bob: " + studentNames); // Output: [Alice, Eve]

        // 6. Checking Size
        System.out.println("Current number of students: " + studentNames.size()); // Output: 2

        // 7. Iterating (Looping through elements)
        System.out.println("\n--- Iterating through student names ---");
        // Using enhanced for loop (most common and readable)
        for (String name : studentNames) {
            System.out.println("Student: " + name);
        }

        // Using traditional for loop (useful if you need the index)
        System.out.println("\n--- Iterating with index ---");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println("Student at index " + i + ": " + studentNames.get(i));
        }

        // Using Iterator (more flexible for some scenarios, e.g., removing elements while iterating)
        System.out.println("\n--- Iterating with Iterator ---");
        studentNames.add("Frank"); // Add one more for iterator example
        Iterator<String> iterator = studentNames.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("Iterator Student: " + name);
            if (name.equals("Eve")) {
                iterator.remove(); // Removes Eve safely during iteration
            }
        }
        System.out.println("After iterator removal of Eve: " + studentNames); // Output: [Alice, Frank]


        // 8. Checking if an element exists
        System.out.println("Contains 'Alice'? " + studentNames.contains("Alice")); // true
        System.out.println("Contains 'Charlie'? " + studentNames.contains("Charlie")); // false

        // 9. Clearing the ArrayList
        studentNames.clear();
        System.out.println("After clearing: " + studentNames); // Output: []
        System.out.println("Is studentNames empty? " + studentNames.isEmpty()); // true
    }

}

