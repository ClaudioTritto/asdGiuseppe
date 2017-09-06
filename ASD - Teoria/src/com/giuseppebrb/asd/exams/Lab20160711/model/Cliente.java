package com.giuseppebrb.asd.exams.Lab20160711.model;

public class Cliente {
	private Posto p;
	private int n;
	private static int count = 0;
	public Cliente(Posto p){
		this.p = p;
		n = count;
		count++;
	}
	
	public int getID(){
		return n;
	}
	
	public Posto getPosto(){
		return p;
	}
	
	public String toString(){
		return "Fila "+ p.getFila() + " posizione " + p.getPos();
	}
}
