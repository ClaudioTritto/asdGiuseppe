package com.giuseppebrb.asd.exams.Lab20151119.model;

import com.giuseppebrb.asd.exams.Lab20151119.datastructure.Orologio;

public class OrologioDaPolso extends Orologio {
	private Orologio<Ora> ore;
	private Orologio<Minuto> minuti;
	
	public OrologioDaPolso() {
		ore = new Orologio<>();
		minuti = new Orologio<>();
		for(int i = 0; i <= 23; i++)
			ore.add(new Ora(String.valueOf(i)));
		for(int i = 0; i<= 59; i++)
			minuti.add(new Minuto(String.valueOf(i)));
		
		for(Ora o : ore)
			for(Minuto m : minuti)
				System.out.println(o.getName() + ":"+ m.getName());
	}
	
	
	public void start(){
		String oraInizio = ore.value().getName();
		String minutoInizio = minuti.value().getName();
		
		do {
			System.out.println(ore.value().getName() + ":" + minuti.value().getName());
			if(minuti.value().getName() == "59"){
				ore.rotateF();
			}
			minuti.rotateF();
		} while (ore.value().getName() == "23" && minuti.value().getName() == minutoInizio);
	}
	
	public static void main(String[] args) {
		OrologioDaPolso odp = new OrologioDaPolso();
		System.out.println("Invocazione start()");
		odp.start();
	}

}
