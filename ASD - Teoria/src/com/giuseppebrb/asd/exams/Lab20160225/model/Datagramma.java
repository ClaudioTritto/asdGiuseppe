package com.giuseppebrb.asd.exams.Lab20160225.model;

import java.net.InetAddress;

public class Datagramma {
	private InetAddress sorgente;
	private InetAddress destinazione;
	private int identificativo;
	private String dati;
	private boolean ultimo;
	
	public Datagramma(InetAddress sorgente, InetAddress destinazione, int identificativo, String dati, boolean ultimo) {
		this.sorgente = sorgente;
		this.destinazione = destinazione;
		this.identificativo = identificativo;
		this.dati = dati;
		this.ultimo = ultimo;
	}

	public InetAddress getSorgente() {
		return sorgente;
	}

	public InetAddress getDestinazione() {
		return destinazione;
	}

	public int getIdentificativo() {
		return identificativo;
	}

	public String getDati() {
		return dati;
	}

	public boolean isUltimo() {
		return ultimo;
	}
	
	

}
