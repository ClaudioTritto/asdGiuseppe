package com.giuseppebrb.asd.exams.Lab20150921.model;

import com.giuseppebrb.asd.exams.Lab20150921.datastructure.AList;

public class Proteina extends Polimero {
	
	public Proteina(String polimero) {
		super.sequenza = new AList();
		Aminoacidi.inizializzaAminoacidi();
		for(int i=0; i < polimero.length(); i++){
			super.sequenza.add(Aminoacidi.aminoacidiMap.get(polimero.charAt(i)));
		}
	}

}
