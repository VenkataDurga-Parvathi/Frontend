package com.learnJava;

import java.io.FileWriter;
import java.io.IOException;

public class File {
    public static void main(String[] args){
        try{
            FileWriter w=new FileWriter("ex.txt");
            w.write("Hello, World!");
            w.close();
        }
        catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}

