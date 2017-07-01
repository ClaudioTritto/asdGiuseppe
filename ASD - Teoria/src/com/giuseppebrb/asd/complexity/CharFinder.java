package com.giuseppebrb.asd.complexity;

/**
 * Created by Giuseppe Barbato
 */
public class CharFinder {

    /**
     * Donato Badgrass asked to define this function and to analyze its complexity into the 2015-07-02 exam.
     *
     * @param values array of chars to analyze
     * @param item   char to find in the array
     * @return the index (from 0 to length-1) of the last occurrence of item into the array. if not found return -1
     */
    public static int lastIndexOf(char[] values, char item) {
        int j;
        for (j = values.length - 1; j >= 0; j--)
            if (values[j] == item)
                return j;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(lastIndexOf(new char[]{'v', 'c', 'k', 'n', 'c', 'f', 'g'}, 'c'));
    }
}
