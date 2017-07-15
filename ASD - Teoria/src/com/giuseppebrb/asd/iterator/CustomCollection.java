package com.giuseppebrb.asd.iterator;

import java.util.Iterator;

/**
 * Questa classe mostra la strutturazione di un oggetto ex-novo che implementa un
 * proprio iteratore. Se si vuole vedere un esempio più approfondito, controllare la struttura Lista
 * nel package dei dati astratti fondamentali.
 *
 * @param <T> tipo della collezione
 * @author Giuseppe Barbato
 */
public class CustomCollection<T> implements Iterable<T>, List<T> {
    private T[] items = (T[]) new Object[1];
    private int n = 0;

    @Override
    public Iterator<T> iterator() {
        return new ItemIterator<>(items);
    }

    @Override
    public void add(T e) {
        if (n == items.length) {
            T[] temp = (T[]) new Object[2 * items.length]; // System.arraycopy(); it's fine too
            for (int i = 0; i < n; i++)
                temp[i] = items[i];
            items = temp;
        }
        items[n] = e;
        n++;
    }

    /**
     * NOTE: This method doesn't work. To work, the class should implements {@link Comparable} and define the behaviour
     * of the compareTo() method. I could do it but I don't want to.
     *
     * @param e item to remove.
     */
    @Override
    public void remove(T e) {
        if (isEmpty())
            throw new StrutturaVuotaException("Cannot delete because structure is empty.");

        n -= 1;

        if (n > 1 && n == items.length / 4) {
            T[] temp = (T[]) new Object[items.length / 2];
            int i = 0;
            while (i < n) {
                if (temp[i] != e)
                    temp[i] = items[i];
                else
                    break;
                n++;
            }

            for (i++; i < n; i++) {
                temp[i] = items[i];
            }
            items = temp;
        }
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    private class ItemIterator<E> implements Iterator<E> {

        private E[] items;
        private int next;

        public ItemIterator(E[] items) {
            this.items = items;
            next = 0;
        }

        @Override
        public boolean hasNext() {
            return next < items.length;
        }

        @Override
        public E next() {
            E elem = items[next];
            next += 1;
            return elem;
        }

    }

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
