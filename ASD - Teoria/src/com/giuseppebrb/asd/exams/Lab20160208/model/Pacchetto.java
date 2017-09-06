package com.giuseppebrb.asd.exams.Lab20160208.model;

public class Pacchetto {
	
	private String mittente;
	private String destinatario;
	private int identificiativo;
	private String dati;
	private boolean ultimo;
	
	public Pacchetto(String mittente, String destinatario, int identificativo, String dati, boolean ultimo){
		this.mittente = mittente;
		this.destinatario = destinatario;
		this.identificiativo = identificativo;
		this.dati = dati;
		this.ultimo = ultimo;
	}
	
	public String getMittente() {
		return mittente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public int getIdentificiativo() {
		return identificiativo;
	}
	public String getDati() {
		return dati;
	}
	public boolean isUltimo() {
		return ultimo;
	}
	

}
