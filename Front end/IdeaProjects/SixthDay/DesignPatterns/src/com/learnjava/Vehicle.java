package com.learn.java;

// Vehicle.java
public abstract class Vehicle {
    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void showBrand() {
        System.out.println("Brand: " + brand);
    }

    public abstract void start(); // abstract = abstraction in action
}