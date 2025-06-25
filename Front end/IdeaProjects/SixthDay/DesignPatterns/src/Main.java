// Main.java
package com.learn.java;
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Tesla", 50);

        myCar.showBrand();         // from abstract class
        myCar.start();             // checks fuel level before starting
        myCar.setFuelLevel(-10);   // shows encapsulation guard
        myCar.setFuelLevel(30);    // updates safely
        System.out.println("Fuel: " + myCar.getFuelLevel());
    }
}