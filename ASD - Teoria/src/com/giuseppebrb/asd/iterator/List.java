package com.giuseppebrb.asd.iterator;

/**
 * Created by Giuseppe Barbato
 */
public interface List<E> {
    void add(E e);

    void remove(E e);

    int size();

    boolean isEmpty();
}
