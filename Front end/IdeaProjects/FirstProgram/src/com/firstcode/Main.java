package com.firstcode;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to Java Full Stack");
        int x=1;
        int y=x;
        x=2;
        System.out.println(x);
        System.out.println(y);
        Point point1=new Point(x=1,y=4);
        Point point2=point1;
        point1.x=3;
        System.out.println(point1);
        System.out.println(point2);
        String s="alphuza";
        System.out.println(s.replace('a','q'));

        String val="1.1";
        double sum=10;
        double num=Double.parseDouble(val);
        sum+=num;
        System.out.println(sum);
//sum+=Integer.parseInt(val);
    }
}
