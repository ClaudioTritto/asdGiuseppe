package com.giuseppebrb.asd.fundamentaldatastructures.list;

/**
 * Created by giuse on 15/07/2017.
 */
public class Cella<T> {
    T elem;
    Puntatore next = null;
    public Cella(T e){
        elem = e;
    }
}
