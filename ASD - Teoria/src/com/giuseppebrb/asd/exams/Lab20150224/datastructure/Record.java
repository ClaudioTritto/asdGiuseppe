package com.giuseppebrb.asd.exams.Lab20150224.datastructure;

import com.giuseppebrb.asd.exams.Lab20150224.model.Progetto;

public class Record implements Comparable<Record>{
	
	private Progetto progetto;
	private float punteggio;
	
	public Record(Progetto progetto, float punteggio){
		this.progetto = progetto;
		if(punteggio >= 0 && punteggio <= 15.0)
			this.punteggio = punteggio;
		else
			throw new PunteggioErratoException();
	}

	public Progetto getProgetto() {
		return progetto;
	}

	public float getPunteggio() {
		return punteggio;
	}

	@Override
	public int compareTo(Record o) {
		float extPunt = o.getPunteggio();
		if(punteggio == extPunt)
			return 0;
		else if(punteggio < extPunt)
			return -1;
		else
			return 1;
	}

}
