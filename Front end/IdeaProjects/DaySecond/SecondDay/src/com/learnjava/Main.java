package com.learnjava;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String args[]) {
        String word1 = "hello";
        char[] charArray1 = word1.toCharArray();
        String word2 = " ";
        char[] charArray2 = word2.toCharArray();
        System.out.println(charArray1[0]);

        double x=(int)Math.random();    //explicit
        System.out.println(x);  //cast it to (int), which removes the decimal part, i.e., it always becomes 0 because it's always less than 1.0.

        double x1=(int)(Math.random() * 10); // Generates 0 to 9
        System.out.println(x1);

        double x2=Math.random() * 10; // Generates a double between 0.0 and 10.0
        System.out.println(x2);

        int[] num = new int[5];
        num[0] = 1;
        num[1] = 2;
        System.out.println(Arrays.toString(num));

        int[][] nums = {{1, 2, 3},{6, 8, 5}};
        System.out.println(Arrays.deepToString(nums));

        NumberFormat n=NumberFormat.getCurrencyInstance();
        System.out.println(n.format(12_344_567F)); //or 12344567

        NumberFormat percentage=NumberFormat.getPercentInstance();
        System.out.println(percentage.format(0.1));

        NumberFormat number=NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(number.format(12344567));


    }
}
