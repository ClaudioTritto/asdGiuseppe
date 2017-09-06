package com.giuseppebrb.asd.exams.Lab20150921.model;

public class Aminoacido extends Monomero {
	private String name;
	private char symbol;
	
	public Aminoacido(String name, char symbol) {
		if(name == "Adenina" || name == "Citosina" || name == "Guanina" || name == "Timina")
			throw new IllegalAminoacidoException();
		this.name = name;
		this.symbol = symbol;
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
