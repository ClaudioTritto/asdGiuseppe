package com.giuseppebrb.asd.exams.Lab20160208.model;

import com.giuseppebrb.asd.exams.Lab20160208.datastructure.IndexedAL;
import com.giuseppebrb.asd.exams.Lab20160208.datastructure.IndexedList;

public class Whatsup implements Comparable {
	private IndexedList<Pacchetto> comunicazione = new IndexedAL<Pacchetto>();
	
	public void addPacchetto(Pacchetto pacchetto){
		comunicazione.addItem(pacchetto, pacchetto.getIdentificiativo());
	}
	
	public boolean complete(){
		for(Pacchetto p : comunicazione)
			if(p.isUltimo())
				return true;
		return false;
	}
	
	public String toString(){
		String dati = "";
		for(Pacchetto p : comunicazione)
			dati += p.getDati();
		return dati;
	}

	@Override
	public int compareTo(Object o) {
		Whatsup other = (Whatsup) o;
		return this.toString().compareTo(other.toString());
	}

}
