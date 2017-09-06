package com.giuseppebrb.asd.exams.Lab20150921.model;

public class Nucleotide extends Monomero {
	private String name;
	private char symbol;
	
	public Nucleotide(String name, char symbol) {
		if(name == "Adenina" || name == "Citosina" || name == "Guanina" || name == "Timina"){
			this.name = name;
			this.symbol = symbol;
		}else
			throw new IllegalNucleotideException();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public char getSymbol() {
		return symbol;
	}
	
	@Override
	public String toString() {
		return String.valueOf(symbol);
	}

}
