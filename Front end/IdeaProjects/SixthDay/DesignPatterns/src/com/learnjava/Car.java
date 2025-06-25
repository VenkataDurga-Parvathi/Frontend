package com.learn.java;

public class Car extends Vehicle {
    private int fuelLevel;

    public Car(String brand, int fuelLevel) {
        super(brand);
        this.fuelLevel = fuelLevel;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        if (fuelLevel >= 0) {
            this.fuelLevel = fuelLevel;
        } else {
            System.out.println("Fuel level can't be negative!");
        }
    }

    @Override
    public void start() {
        if (fuelLevel > 0) {
            System.out.println("Car started! 🚗💨");
        } else {
            System.out.println("Fuel empty! Please refuel.");
        }
    }
}
