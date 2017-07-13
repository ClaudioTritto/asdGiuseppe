package com.giuseppebrb.asd.fundamentaldatastructures.stack;

import com.giuseppebrb.asd.fundamentaldatastructures.dictionary.EccezioneChiaveNonTrovata;

/**
 * Created by giuse on 13/07/2017.
 */
public class PilaArray<T> implements Stack<T> {
    private T[] pila = (T[]) new Object[1];
    private int n = 0;

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void push(T e) {
        pila[n] = e;
        n++;
        if(n == pila.length){
            T[] temp = (T[]) new Object[pila.length * 2];
            System.arraycopy(pila, 0, temp, 0, n);
            pila = temp;
        }
    }

    @Override
    public T top() {
        if (isEmpty())
            throw new EccezioneStrutturaVuota();
        return pila[n-1];
    }

    @Override
    public void pop() {
        if (isEmpty())
            throw new EccezioneStrutturaVuota();
        n = n - 1;
        Object e = pila[n];
        if (n > 1 && n == pila.length / 4){
            T[] temp = (T[]) new Object[pila.length / 2];
            System.arraycopy(pila,0, temp, 0, n);
            pila = temp;
        }
    }

    public static void main(String[] args){
        PilaArray<String> test = new PilaArray<>();
        test.push("Uno");
        test.push("Due");
        test.push("Tre");

        while (!test.isEmpty()){
            System.out.println(test.top());
            test.pop();
        }

        System.out.println("Is stack now empty? " + test.isEmpty());
    }
}
