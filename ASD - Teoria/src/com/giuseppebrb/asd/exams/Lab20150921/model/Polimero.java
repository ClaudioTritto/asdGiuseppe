package com.giuseppebrb.asd.exams.Lab20150921.model;

import com.giuseppebrb.asd.exams.Lab20150921.datastructure.ListaSemplice;

public abstract class Polimero {
	protected ListaSemplice sequenza = null;
	
	public String toString(){
		String polymer = "";
		while(sequenza.hasNext())
			polymer += sequenza.next().toString();
		return polymer;
	}
}
