package com.giuseppebrb.asd.fundamentaldatastructures.list;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by giuse on 15/07/2017.
 */
public class LinkedList<T> implements Lista<T> {
    private Puntatore inizioLista = null;

    @Override
    public boolean isEmpty() {
        return inizioLista == null;
    }

    @Override
    public T readList(Posizione p) {
        if (isEmpty()) throw new IndexOutOfBoundsException("Lista vuota");
        if (p == firstList())
            return (T) inizioLista.link.elem;
        else
            return (T) ((Puntatore) p).link.next.link.elem;
    }

    @Override
    public Posizione firstList() {
        return null;
    }

    @Override
    public boolean endList(Posizione p) {
        if (isEmpty()) return true;
        if (p == firstList()) return false;
        else return ((Puntatore) p).link.next == null;
    }

    @Override
    public Posizione succ(Posizione p) {
        if (endList(p))
            throw new IndexOutOfBoundsException("Posizione fine lista non valida");
        if (isEmpty())
            throw new IndexOutOfBoundsException("Lista vuota");
        if (p == firstList()) // p==null
            return inizioLista;
        else return ((Puntatore) p).link.next;
    }

    @Override
    public Posizione prec(Posizione p) {
        return null;
    }

    @Override
    public void insert(T e, Posizione p) {
        Puntatore temp, q;
        if (!isEmpty()) {
            if (firstList() == p) {
                temp = inizioLista;
                inizioLista = new Puntatore(new Cella(e));
                inizioLista.link.next = temp;
            } else {
                temp = ((Puntatore) p).link.next;
                q = new Puntatore(new Cella(e));
                ((Puntatore) p).link.next = q;
                q.link.next = temp;
            }
        } else {
            inizioLista = new Puntatore(new Cella(e));
        }
    }

    @Override
    public void remove(Posizione p) {

    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
