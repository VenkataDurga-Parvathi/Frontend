package com.learnjava;

import java.util.Date;

public class PrintDate {
    public static void main(String args[]){
        Date date = new Date();
        System.out.println(date);
        String day = date.toString();
        String weekDay=day.substring(0,3);
        System.out.println(weekDay.substring(0,3));
        switch(weekDay){
            case "Mon":
                System.out.println("Hai");
                break;
            case "Tue":
                System.out.println("Hello tue");
                break;
            case "Wed":
                System.out.println("Half way");
                break;
            case "Ths":
                System.out.println("Abt to end");
                break;
            case "Fri":
                System.out.println("Happy WeekEnd");
                break;
            case "Sat":
                System.out.println("Jolly");
                break;
            case "Sun":
                System.out.println("Bye");
                break;
        }
    }
}
