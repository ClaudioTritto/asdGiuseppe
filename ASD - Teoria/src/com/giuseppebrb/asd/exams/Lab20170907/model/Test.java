package com.giuseppebrb.asd.exams.Lab20170907.model;

import com.giuseppebrb.asd.exams.Lab20170907.datastructure.VectorList;

public class Test {
    public static void main(String[] args){
        VectorList<String> authors = new VectorList<>();
        authors.add("Nicola Di Mauro");
        authors.add("Teresa M.A. Basile");
        authors.add("Stefano Ferilli");
        authors.add("Floriana Esposito");

        Articolo articolo = new Articolo(authors, "Grasp and Path-Relinking for Coalition Structure Generation");
        System.out.println("Autori: " + articolo.getAuthors().toString());
        System.out.println("Titolo: " + articolo.getTitle());
    }
}
