package com.giuseppebrb.asd.complexity;

/**
 * Created by Giuseppe Barbato
 */
public class RecursiveFibonacci {

    private static int counter = 0;

    /**
     * Donato Badgrass asked to define this function and to analyze its complexity into the 2015-21-09 exam.
     * @param n Number for the succession
     * @return n-fibonacci numeber
     */
    public static int recursiveFibonacci(int n){
        counter++;
        if(n==0 || n == 1)
            return 1;
        else
            return (int) ((Math.pow(recursiveFibonacci(n-1), 2)) + (Math.pow(recursiveFibonacci(n-2), 2)));

    }

    public static void main (String [] args){
        System.out.println(recursiveFibonacci(4));
        System.out.println("Number of recursions: " + counter);
    }
}
