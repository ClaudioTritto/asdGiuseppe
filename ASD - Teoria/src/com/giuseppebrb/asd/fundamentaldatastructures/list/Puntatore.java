package com.giuseppebrb.asd.fundamentaldatastructures.list;

/**
 * Created by giuse on 15/07/2017.
 */
public class Puntatore implements Posizione {
    public Cella link;
    public Puntatore(Cella c){
        link = c;
    }
}
