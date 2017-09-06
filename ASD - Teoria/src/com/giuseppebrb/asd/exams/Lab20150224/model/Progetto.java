package com.giuseppebrb.asd.exams.Lab20150224.model;

public class Progetto {
	private static int codeCounter = 0;
	private String name;
	private int idCode;
	
	public Progetto(String name){
		this.name = name;
		idCode = codeCounter;
		codeCounter++;
	}
	
	public int codice(){
		return idCode;
	}

}
