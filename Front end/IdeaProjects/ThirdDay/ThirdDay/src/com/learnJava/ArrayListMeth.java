package com.learnJava;

import java.util.ArrayList;

public class ArrayListMeth {
    public static void main(String args[]){
        ArrayList<String> list=new ArrayList<>();
        list.add("Red");
        list.add("Blue");
        list.add("Green");
        System.out.println(list);
        list.set(1,"Purple");
        System.out.println(list.get(1));
        System.out.println(list);

    }
}
