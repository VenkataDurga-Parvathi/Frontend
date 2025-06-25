package com.learnJava;

import java.io.Serializable; // Good practice for objects that will be serialized

class Student implements Serializable { // Serializable marks it as capable of being written to a stream
    private String studentId;
    private String name;
    private int age;
    private String major;

    // Constructor
    public Student(String studentId, String name, int age, String major) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    // Getters (to access private fields)
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    // toString() method for easy printing of Student objects
    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Age: " + age + ", Major: " + major;
    }

    // Method to convert Student object to a String for file storage (CSV-like format)
    public String toFileString() {
        return studentId + "," + name + "," + age + "," + major;
    }

    // Static method to create a Student object from a file string
    public static Student fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        if (parts.length == 4) {
            try {
                String id = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String major = parts[3];
                return new Student(id, name, age, major);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing age from file string: " + fileString);
                return null;
            }
        }
        System.err.println("Invalid file string format: " + fileString);
        return null;
    }
}
