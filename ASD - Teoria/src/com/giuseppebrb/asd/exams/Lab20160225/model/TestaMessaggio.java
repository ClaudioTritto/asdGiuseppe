package com.giuseppebrb.asd.exams.Lab20160225.model;

import java.util.Random;

public class TestaMessaggio {
	public static void main(String[] args) {
		Messaggio test = new Messaggio();
		Random rnd = new Random();
		for(int i=0; i<10; i++){
			if(i==9)
				test.addDatagramma(new Datagramma(null, null, rnd.nextInt(1000), "datagramma: "+ i + " ", true));
			else
				test.addDatagramma(new Datagramma(null, null, rnd.nextInt(1000), "datagramma: "+ i+ " ", false));
		}
		System.out.println("Il datagramma � completo: " + test.completo());
		System.out.println("Risultato datagramma:\n" + test.toString());
	}
}
