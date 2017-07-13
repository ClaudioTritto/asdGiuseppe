package com.giuseppebrb.asd.fundamentaldatastructures.dictionary;

import com.giuseppebrb.asd.fundamentaldatastructures.EccezioneChiaveNonTrovata;

/**
 * Forma basica ed elementare del dizionario.
 * Questo dizionario mantiene ordinati tutti gli elementi al suo interno e non prevede alcuna tecnica di raddoppiamento/dimezzamento.
 */
public class ArrayOrdinato implements Dizionario {

    private Coppia[] S = new Coppia[0];

    @Override
    public void insert(Object e, Comparable k) {
        int i, j;
        Coppia[] temp = new Coppia[S.length + 1];
        for (i = 0; i < S.length; i++)
            temp[i] = S[i];
        S = temp;

        for (i = 0; i < S.length - 1; i++)
            if (k.compareTo(S[i].key) <= 0)
                break;

        for (j = S.length - 1; j > i; j--)
            S[j] = S[j - 1];

        S[i] = new Coppia(e, k);
    }

    @Override
    public void delete(Comparable k) {
        int i, j;
        for (i = 0; i < S.length; i++)
            if (k.compareTo(S[i].key) == 0)
                break;
        if (i == S.length)
            throw new EccezioneChiaveNonTrovata();

        for (j = i; j < S.length - 1; j++)
            S[j] = S[j+1];

        Coppia [] temp = new Coppia[S.length - 1];
        for (i = 0; i < temp.length; i++)
            temp[i] = S[i];

        S = temp;
    }

    @Override
    public Object search(Comparable k) {
        int i = 0;
        int j = S.length;

        while (i < j) {
            int m = (i + j) / 2;
            if (k.compareTo(S[m].key) == 0)
                return S[m].elem;
            else {
                if (k.compareTo(S[m].key) < 0)
                    j = m;
                else
                    i = m + 1;
            }
        }
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

    public static void main(String[] args){
        ArrayOrdinato test = new ArrayOrdinato();

        test.insert("0801234567","Jobs");
        test.insert("0807654321","Wozniak");

        System.out.println("Jobs number: " + test.search("Jobs"));
        System.out.println("Wozniak number: " + test.search("Wozniak"));

        test.delete("Jobs");
        System.out.println("Jobs number after been erased: " + test.search("Jobs"));
    }

}
