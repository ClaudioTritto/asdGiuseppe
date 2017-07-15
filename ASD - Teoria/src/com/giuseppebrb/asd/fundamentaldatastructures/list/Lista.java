package com.giuseppebrb.asd.fundamentaldatastructures.list;

/**
 * Interfaccia di Lista che estende Iterable per poter implementare un'iteratore.
 */
public interface Lista<T> extends Iterable<T> {
    boolean isEmpty();

    T readList(Posizione p);

    Posizione firstList();

    boolean endList(Posizione p);

    Posizione succ(Posizione p);

    Posizione prec(Posizione p);

    void insert(T e, Posizione p);

    void remove(Posizione p);
}
