package com.giuseppebrb.asd.exams.Lab20150921.model;

import com.giuseppebrb.asd.exams.Lab20150921.datastructure.AList;

public class DNA extends Polimero {
	
	public DNA(String polimero) {
		super.sequenza = new AList();
		Nucleotidi.inizializzaNucleotidi();
		for(int i=0; i < polimero.length(); i++){
			super.sequenza.add(Nucleotidi.nucleotidiMap.get(polimero.charAt(i)));
		}
	}
	
}
