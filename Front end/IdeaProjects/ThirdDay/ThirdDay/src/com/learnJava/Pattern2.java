package com.learnJava;

public class Pattern2 {
    public static void main(String args[]){
        for(int i = 5; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = 5; k >= i; k--) {
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}
