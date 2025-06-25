package com.learnJava;

import java.util.Scanner;

public class Discount {
    public static void main(String args[]){
        System.out.print("Enter purchase amount: ");
        Scanner sc=new Scanner(System.in);
        double bill=sc.nextDouble();
        if(bill>=100 && bill<500){
            System.out.println("Discount=10%");
            Double dis=bill-(0.1*bill);
            System.out.println("With Discount: "+dis);
        }
        if(bill>=500){
            System.out.println("Discount=20%");
            Double dis = bill-(0.2*bill);
            System.out.println("With Discount: "+dis);
        }
    }
}
