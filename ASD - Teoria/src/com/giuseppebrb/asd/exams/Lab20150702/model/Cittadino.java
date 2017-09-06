package com.giuseppebrb.asd.exams.Lab20150702.model;

public class Cittadino implements Comparable<Cittadino> {
	private static int globalId = 0;
	private int id;
	private String nome;
	private String cognome;
	
	public Cittadino(String name, String surname){
		nome = name;
		cognome = surname;
		id = globalId;
		globalId++;
	}
	

	public int getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getCognome() {
		return cognome;
	}


	@Override
	public int compareTo(Cittadino arg0) {
		if(id == arg0.getId())
			return 0;
		else if(id > arg0.getId())
			return 1;
		else
			return -1;
	}
	
	public String toString(){
		return "Id: " + id + " Nome Completo: " + nome + " " + cognome;
	}

}
