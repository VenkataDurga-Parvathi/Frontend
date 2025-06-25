package com.example.aopfirst.service;

import com.example.aopfirst.exception.MyCustomException;

import org.springframework.stereotype.Service;

@Service // Mark as a Spring service component
public class MyService {

    public void doSomething() {
        System.out.println("MyService: 'doSomething()' method is executing.");
        // Simulate some work
    }

    public String doSomethingWithArgs(String param1, int param2) {
        System.out.println("MyService: 'doSomethingWithArgs()' method is executing with args: " + param1 + ", " + param2);
        // Simulate some work
        System.out.println("Hey, You! Welcome to myService! Practice session");
        return "Processed: " + param1 + " and " + param2;
    }

    public void doSomethingThatThrowsException() {
        System.out.println("MyService: 'doSomethingThatThrowsException()' method is about to throw an exception.");
        throw new MyCustomException("Something went wrong in MyService!");
    }
}