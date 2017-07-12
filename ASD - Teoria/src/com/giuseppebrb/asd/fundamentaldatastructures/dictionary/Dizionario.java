package com.giuseppebrb.asd.fundamentaldatastructures.dictionary;

/**
 * Created by giuse on 12/07/2017.
 */
public interface Dizionario {
    void insert(Object e, Comparable k);
    void delete(Comparable k);
    Object search(Comparable k);
}
