package com.giuseppebrb.asd.iterator;

/**
 * NOTA: Questa interfaccia di lista è utile prevalentemnte per lo scritto e non per il laboratorio.
 */
public interface List<E> {
    void add(E e);

    void remove(E e);

    int size();

    boolean isEmpty();
}
