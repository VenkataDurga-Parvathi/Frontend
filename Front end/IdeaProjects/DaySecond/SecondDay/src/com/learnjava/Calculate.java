package com.learnjava;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Calculate {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principle value: ");
        int p = sc.nextInt();
        System.out.print("Enter Rate of Interest: ");
        double anualrate = sc.nextDouble();
        double r = (anualrate/100)/12;
        System.out.print("Enter no.of payments: ");
        int monthCal = sc.nextInt();
        int n = monthCal * 12;
        double m = p * r * Math.pow(1 + r, n)/((Math.pow(1 + r, n))-1);
        System.out.println("Mortgage Payment: "+m);
    }
}
