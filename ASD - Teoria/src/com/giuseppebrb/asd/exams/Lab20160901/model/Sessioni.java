package com.giuseppebrb.asd.exams.Lab20160901.model;

import com.giuseppebrb.asd.exams.Lab20160901.datastructure.AddOnlyList;
import com.giuseppebrb.asd.exams.Lab20160901.datastructure.LinkedList;

public class Sessioni {
	private AddOnlyList<SessioneLL> sessioni = new LinkedList<>();
	
	public void addSessione(SessioneLL sessione){
		sessioni.add(sessione);
	}
	
	public AddOnlyList<SessioneLL> getSessioni(){
		return sessioni;
	}
}
