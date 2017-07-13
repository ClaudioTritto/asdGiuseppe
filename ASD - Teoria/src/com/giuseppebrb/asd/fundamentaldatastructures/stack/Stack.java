package com.giuseppebrb.asd.fundamentaldatastructures.stack;

/**
 * Created by giuse on 13/07/2017.
 */
public interface Stack<T> {
    boolean isEmpty();
    void push(T e);
    T top();
    void pop();
}
