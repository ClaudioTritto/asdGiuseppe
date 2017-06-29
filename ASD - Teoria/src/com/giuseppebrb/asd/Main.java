package com.giuseppebrb.asd;

import com.giuseppebrb.asd.iterator.CustomCollection;

/**
 * Created by Giuseppe Barbato
 */
public class Main {

    public static void main(String[] args) {
        CustomCollection<String> collection = new CustomCollection<>();
        System.out.println("----- Structure is empty: " + collection.isEmpty() + " -----");

        collection.add("First Item");
        collection.add("Second Item");
        collection.add("Third Item");
        collection.add("Fourth Item");
        System.out.println("----- Items added -----");

        for (String s : collection)
            System.out.println(s);
    }

}
