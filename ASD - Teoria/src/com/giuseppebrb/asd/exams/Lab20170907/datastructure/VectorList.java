package com.giuseppebrb.asd.exams.Lab20170907.datastructure;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class VectorList<S> implements AddOnlyList<S> {
    private S[] list = (S[]) new Object[1];
    private int n=0;

    @Override
    public void add(S e) {
        if(n == list.length){
            S[] temp = (S[]) new Object[list.length * 2];
            System.arraycopy(list, 0, temp,0, n);
            list = temp;
        }
        list[n] = e;
        n++;
    }

    @Override
    public Iterator<S> iterator() {
        return new VectorListIterator(list, n);
    }

    @Override
    public String toString(){
        String result = "";
        for(int i=0; i<n; i++)
            if(i== n-1)
                result += list[i].toString();
        else
                result += list[i].toString() + ", ";
        return result;
    }

    private class VectorListIterator implements Iterator<S>{
        private S[] list;
        private int n, pos;

        public VectorListIterator(S[] list, int n){
            this.list = list;
            this.n = n;
            pos=0;
        }
        @Override
        public boolean hasNext() {
            return pos<n;
        }

        @Override
        public S next() {
            S item = list[pos];
            pos++;
            return item;
        }
    }
}
