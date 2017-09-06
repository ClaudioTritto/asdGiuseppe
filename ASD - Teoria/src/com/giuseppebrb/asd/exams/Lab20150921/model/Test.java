package com.giuseppebrb.asd.exams.Lab20150921.model;

public class Test {
	
	public static void main(String[] args) {
		Polimero d = new DNA("TTCAGGC");
		Polimero p = new Proteina("HHNC");
		System.out.println("Istanza di DNA: " + d.toString());
		System.out.println("Istanza di Proteina: " + p.toString());
	}

}
