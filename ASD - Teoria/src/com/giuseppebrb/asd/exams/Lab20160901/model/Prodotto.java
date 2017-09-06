package com.giuseppebrb.asd.exams.Lab20160901.model;

public class Prodotto {
	private String nome;
	private int prezzo;
	public Prodotto(String name, int price) {
		this.nome = name;
		this.prezzo = price;
	}
	public String getNome() {
		return nome;
	}
	public int getPrezzo() {
		return prezzo;
	}
}
