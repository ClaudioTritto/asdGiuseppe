package com.giuseppebrb.asd.fundamentaldatastructures.queue;

/**
 * Created by giuse on 13/07/2017.
 */
public interface Coda {
    boolean isEmpty();
    void enqueue(Object e);
    Object first();
    Object dequeue();
}
