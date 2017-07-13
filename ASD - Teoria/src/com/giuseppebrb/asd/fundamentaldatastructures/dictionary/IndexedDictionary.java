package com.giuseppebrb.asd.fundamentaldatastructures.dictionary;

import com.giuseppebrb.asd.fundamentaldatastructures.EccezioneChiaveNonTrovata;

/**
 * Questo tipo di dizionario è indicizzato e prevede l'adottamento della tecnica del
 * raddoppiamento/dimezzamento, tuttavia non prevede ordinamento degli elementi.
 */
public class IndexedDictionary implements Dizionario {

    private Coppia[] S = new Coppia[1];
    private int n;

    @Override
    public void insert(Object e, Comparable k) {
        if (n == S.length) {
            Coppia[] temp = new Coppia[2 * S.length];
            for (int i = 0; i < n; i++)
                temp[i] = S[i];
            S = temp;
        }

        S[n] = new Coppia(e, k);
        n = n + 1;
    }

    @Override
    public void delete(Comparable k) {
        int i;
        for (i = 0; i < S.length; i++)
            if (k.compareTo(S[i].key) == 0)
                break;
        if (i == S.length)
            throw new EccezioneChiaveNonTrovata();
        n = n - 1;
        S[i] = S[n];

        if (n > 1 && n == S.length / 4) {
            Coppia[] temp = new Coppia[S.length / 2];
            for (i = 0; i < n; i++)
                temp[i] = S[i];
            S = temp;
        }
    }

    @Override
    public Object search(Comparable k) {
        for (int i = 0; i < n; i++)
            if (k.compareTo(S[i].key) == 0)
                return S[i].elem;
        return null;
    }

    private class Coppia {
        public Object elem;
        public Comparable key;

        public Coppia(Object e, Comparable k) {
            elem = e;
            key = k;
        }
    }

    public static void main(String[] args) {
        IndexedDictionary test = new IndexedDictionary();

        test.insert("0801234567", "Jobs");
        test.insert("0807654321", "Wozniak");

        System.out.println("Jobs number: " + test.search("Jobs"));
        System.out.println("Wozniak number: " + test.search("Wozniak"));

        test.delete("Jobs");
        System.out.println("Jobs number after been erased: " + test.search("Jobs"));
    }
}
