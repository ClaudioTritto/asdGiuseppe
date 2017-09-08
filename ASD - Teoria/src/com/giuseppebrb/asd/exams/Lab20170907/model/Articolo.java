package com.giuseppebrb.asd.exams.Lab20170907.model;

import com.giuseppebrb.asd.exams.Lab20170907.datastructure.VectorList;

public class Articolo {
    private VectorList<String> authors;
    private String title;

    public Articolo(VectorList<String> authors, String title){
        this.authors = authors;
        this.title = title;
    }

    public VectorList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(VectorList<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
