package com.giuseppebrb.asd.exams.Lab20150203.model;

import java.util.Random;

import com.giuseppebrb.asd.exams.Lab20150203.datastructure.HashDict;

public class Test {
	public static void main(String[]args){
		Random rn = new Random();
		Elezione ele = new Elezione(30);
		String [] nomi = {"Todos Caballeros", "Non ci siamo", "Futuro incerto"};
		ele.aggiungiLista(new ListaElettorale(nomi[0], null));
		ele.aggiungiLista(new ListaElettorale(nomi[1], null));
		ele.aggiungiLista(new ListaElettorale(nomi[2], null));
		for(int i=0; i<30; i++){
			int n = rn.nextInt(5);
			System.out.println(n);
			Voto v;
			if(n <= 2){
				v = new Voto(new ListaElettorale(nomi[n], null));
				ele.scrutinaVoto(v);
			}else if(n== 3){
				v = new Voto();
			} else {
				v = new Voto(null);
			}
		}
		
		System.out.println("Bianche: " + ele.bianche());
		System.out.println("Nulle: " + ele.nulle());
	}
}
