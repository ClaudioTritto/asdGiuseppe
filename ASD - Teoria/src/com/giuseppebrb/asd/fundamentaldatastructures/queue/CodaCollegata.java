package com.giuseppebrb.asd.fundamentaldatastructures.queue;

import com.giuseppebrb.asd.fundamentaldatastructures.EccezioneStrutturaVuota;

/**
 * Created by giuse on 13/07/2017.
 */
public class CodaCollegata implements Coda {
    private Record inizio = null, fine = null;

    private class Record {
        public Object elem;
        public Record next;
        public Record(Object e) {
            elem = e;
            next = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return inizio == null;
    }

    @Override
    public void enqueue(Object e) {
        if (isEmpty())
            inizio = fine = new Record(e);
        else {
            fine.next = new Record(e);
            fine = fine.next;
        }
    }

    @Override
    public Object first() {
        if (isEmpty())
            throw new EccezioneStrutturaVuota();
        return inizio.elem;
    }

    @Override
    public Object dequeue() {
        if (isEmpty())
            throw new EccezioneStrutturaVuota();
        Object e = inizio.elem;
        inizio = inizio.next;
        return e;
    }

    public static void main (String [] args){
        CodaCollegata test = new CodaCollegata();
        test.enqueue("Uno");
        test.enqueue("Due");
        test.enqueue("Tre");

        System.out.println(test.first());
        test.dequeue();
        System.out.println(test.first());
    }

}
