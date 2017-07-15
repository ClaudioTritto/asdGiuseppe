package com.giuseppebrb.asd.fundamentaldatastructures.list;

import com.giuseppebrb.asd.fundamentaldatastructures.EccezioneStrutturaVuota;

import java.util.Iterator;

/**
 * Implementazione di una lista con Vettore, che prevede la tecnica del raddoppiamento/dimezzamento
 * ed implemnenta un iteratore.
 */
public class ListDoubling<T> implements Lista<T> {
    private T[] list = (T[]) new Object[1];
    private int n = 0;

    protected boolean checkPosition(Posizione p) {
        if (((Indice) p).index < 0 || ((Indice) p).index > n)
            return false;
        else
            return true;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public T readList(Posizione p) {
        if (!checkPosition(p))
            throw new IndexOutOfBoundsException("posizione non valida");
        return list[((Indice) p).index];
    }

    @Override
    public Posizione firstList() {
        return new Indice();
    }

    @Override
    public boolean endList(Posizione p) {
        return ((Indice) p).index == n;
    }

    @Override
    public Posizione succ(Posizione p) {
        if (endList(p))
            throw new IndexOutOfBoundsException("L'ultima posizione della lista è " + n);
        Indice pos = new Indice();
        pos.index = ((Indice) p).index + 1;
        return pos;
    }

    @Override
    public Posizione prec(Posizione p) {
        if (((Indice) p).index == 0)
            throw new IndexOutOfBoundsException("Non si può tornare più indietro del primo elemento");
        Indice pos = new Indice();
        pos.index = ((Indice) p).index - 1;
        return pos;
    }

    @Override
    public void insert(T e, Posizione p) {
        if (!checkPosition(p))
            throw new IndexOutOfBoundsException("Posizione di inserimento non valida");
        for (int i = n; i > ((Indice) p).index; i--)
            list[i] = list[i - 1];
        list[((Indice) p).index] = e;
        n++;
        if (n == list.length) {
            T[] temp = (T[]) new Object[2 * list.length];
            for (Indice pos = (Indice) firstList(); !endList(pos); pos = (Indice) succ(pos))
                temp[pos.index] = list[pos.index];
            list = temp;
        }
    }

    @Override
    public void remove(Posizione p) {
        if (isEmpty())
            throw new EccezioneStrutturaVuota();
        if (!checkPosition(p))
            throw new IndexOutOfBoundsException("Posizione di inserimento non valida");

        n -= 1;
        for (int i = ((Indice) p).index; i < n; i++) {
            list[i] = list[i + 1];
        }

        if (n > 1 && n == list.length / 4) {
            T[] temp = (T[]) new Object[list.length / 2];
            System.arraycopy(list, 0, temp, 0, n);
            list = temp;
        }

    }

    public static void main(String[] args) {
        Lista<String> list = new ListDoubling();
        System.out.println("la lista è vuota:" + list.isEmpty() + "\n ");
        list.insert(" a", list.firstList());
        list.insert(" b ", list.firstList());
        list.insert(" c ", list.firstList());
        list.insert(" d ", list.firstList());
        list.insert(" e ", list.firstList());
        System.out.println(" inserisco f in seconda posizione \n ");
        list.insert(" f ", list.succ(list.firstList()));
        System.out.println("Si stampa la lista");
        Posizione p = list.firstList();
        while (!list.endList(p)) {
            System.out.println(list.readList(p));
            p = list.succ(p);
        }
        System.out.println("\n Rimozione elemento in prima posizione");
        list.remove(list.firstList());
        p = list.firstList();
        while (!list.endList(p)) {
            System.out.println(list.readList(p));
            p = list.succ(p);
        }

        System.out.println("Stampa di tutti gli elementi presenti nella lista usando l'iteratore");
        for (String s : list)
            System.out.println(s);


    }

    public Iterator iterator() {
        return new ListDoublingIterator<T>(this);
    }

    private class ListDoublingIterator<T> implements Iterator<T> {
        private Lista<T> list;
        private Posizione p;

        public ListDoublingIterator(Lista<T> l) {
            list = l;
            p = l.firstList();
        }

        @Override
        public boolean hasNext() {
            return !list.endList(p);
        }

        @Override
        public T next() {
            Posizione q = p;
            p = list.succ(p);
            return list.readList(q);
        }
    }
}
