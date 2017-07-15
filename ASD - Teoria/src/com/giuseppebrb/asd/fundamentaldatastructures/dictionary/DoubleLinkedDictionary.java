package com.giuseppebrb.asd.fundamentaldatastructures.dictionary;

import com.giuseppebrb.asd.fundamentaldatastructures.EccezioneChiaveNonTrovata;

/**
 * Questa implementazione del Dizionario è basato su una struttura (doppiamente) collegata,
 * ad anello, che prevede la presenza di una classse interna record.
 */
public class DoubleLinkedDictionary implements Dizionario {
    private Record list = null;
    @Override
    public void insert(Object e, Comparable k) {
        Record p = new Record(e, k);
        if(list == null)
            list = p.prev = p.next = p;
        else{
            p.next = list.next;
            p.prev = list;
            list.next.prev = p;
            list.next = p;
        }
    }

    @Override
    public void delete(Comparable k) {
        Record p = null;
        if(list != null)
            for(p = list.next; ; p = p.next){
                if(p.key.equals(k))
                    break;
                if(p == list){
                    p = null; // vuol dire che il ciclo è tornato alla coda di testa e
                              // non ha trovato alcun elemento corrispondente alla chiave
                    break;
                }
            }
        if (p == null)
            throw new EccezioneChiaveNonTrovata();

        if (p.next == p)
            list = null;
        else {
            if (list == p)
                list = p.next;
            p.next.prev = p.prev;
            p.prev.next = p.next;
        }
    }

    @Override
    public Object search(Comparable k) {
        if (list == null)
            return null;
        for (Record p = list; ; p = p.next){
            if (p.key.equals(k))
                return p.elem;
            if (p == list.prev)
                return null;
        }
    }

    private final class Record {
        public Object elem;
        public Comparable key;
        public Record next;
        public Record prev;
        public Record(Object e, Comparable k) {
            elem = e;
            key = k;
            next = prev = null;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedDictionary test = new DoubleLinkedDictionary();

        test.insert("0801234567", "Jobs");
        test.insert("0807654321", "Wozniak");

        System.out.println("Jobs number: " + test.search("Jobs"));
        System.out.println("Wozniak number: " + test.search("Wozniak"));

        test.delete("Jobs");
        System.out.println("Jobs number after been erased: " + test.search("Jobs"));
    }
}
