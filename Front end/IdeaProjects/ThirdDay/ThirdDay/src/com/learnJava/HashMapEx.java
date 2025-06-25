package com.learnJava;

import java.util.HashMap;

public class HashMapEx {
    public static void main(String args[]){
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("Suma",21);
        hm.put("Shar",19);
        hm.put("Par",15);
        System.out.println("Shar age: "+hm.get("Shar"));

        for(String s:hm.keySet()){
            System.out.println(s +" age: "+hm.get(s));
        }
    }
}
