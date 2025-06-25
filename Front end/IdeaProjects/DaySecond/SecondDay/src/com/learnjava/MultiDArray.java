package com.learnjava;
//multi dim array with for each loop
public class MultiDArray {
    public static void main(String args[]) {
        int[][] numbers = {{1, 2, 3}, {5, 6, 7}};
        for (int[] rows : numbers){
            for (int num : rows) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
        for (int[] rows : numbers){
            for(int i = 0; i < rows.length; i++){
                System.out.print(rows[i]+" ");
            }
            System.out.println();
        }
    }
}
