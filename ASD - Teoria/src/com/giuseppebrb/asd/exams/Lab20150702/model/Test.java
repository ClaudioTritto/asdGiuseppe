package com.giuseppebrb.asd.exams.Lab20150702.model;

import java.util.Random;

public class Test {
	static Referendum test = new Referendum();
	
	public static void main(String [] args){
		inizializza();
		vota();
		test.chiudiReferendum();
		if(test.votanti().size() > 10)
			System.out.println("Quorum raggiunto");
		else
			System.out.println("Quorum non raggiunto");
		System.out.println("Schede SI: " + test.votiSi());
		System.out.println("Schede NO: " + test.votiNo());
		System.out.println("Schede Bianche: " + test.votiBianche());
		System.out.println("Schede Nulle: " + test.votiNulli());
	}
	
	public static void inizializza(){
		for(int i = 0; i <= 20; i++){
			Cittadino entry = new Cittadino("Nome"+i, "Cognome"+1);
			test.addCittadino(entry);
		}
	}
	
	public static void vota(){
		test.apriReferendum();
		for(int i = 0; i <= 11; i++){
			test.vota(getCittadinoRegistrato(i), randomVoto());
		}
		test.vota(new Cittadino("Gianni", "Esposito"), Voto.NO);
	}
	
	private static Cittadino getCittadinoRegistrato(int i){
		for(Cittadino c : test.registrati())
			if(c.getId() == i)
				return c;
		return null;
	}
	
	private static Voto randomVoto(){
		Random rnd = new Random();
		Voto v;
		switch (rnd.nextInt(4)) {
		case 0:
			v = Voto.SI;
			break;
		case 1:
			v = Voto.NO;
			break;
		case 2:
			v = Voto.NULLA;
			break;
		default:
			v = Voto.BIANCA;
			break;
		}
		
		return v;
	}

}
