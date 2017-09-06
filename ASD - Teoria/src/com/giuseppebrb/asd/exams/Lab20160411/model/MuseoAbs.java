package com.giuseppebrb.asd.exams.Lab20160411.model;

import java.util.ArrayList;

import com.giuseppebrb.asd.exams.Lab20160411.datastructure.Dictionary;
import com.giuseppebrb.asd.exams.Lab20160411.datastructure.Record;

public abstract class MuseoAbs {
	protected Dictionary<String, Record> opere;
	
	public boolean museoVuoto(){
		int n=0;
		for(String s: opere)
			n++;
		return n==0;
	}
	
	public void addOp(String codice, Opera opera){
		Record entry = new Record(opera, false);
		opere.insert(codice, entry);
	}
	
	public Opera opera (String codice){
		return opere.search(codice).getOpera();
	}
	
	public void prestito(String codice, String esposizione){
		if(!opere.search(codice).isLanded()){
			opere.search(codice).setLanded(true);
			opere.search(codice).setExposition(esposizione);
		}
	}
	
	
	public void restituzione(String codice, String esposizione){
		if(opere.search(codice).isLanded()){
			opere.search(codice).setLanded(false);
			opere.search(codice).setExposition(esposizione);
		}
	}
	
	public boolean prestata(String codice){
		return opere.search(codice).isLanded();
	}
	
	public ArrayList<Opera> prestiti(String esposizione){
		ArrayList<Opera> test = new ArrayList<>();
		for(String s: opere)
			if(opere.search(s).isLanded() && opere.search(s).getExposition().equalsIgnoreCase(esposizione))
				test.add(opere.search(s).getOpera());
		return test;
	}

}
