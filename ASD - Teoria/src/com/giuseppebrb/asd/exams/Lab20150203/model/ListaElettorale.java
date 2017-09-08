package com.giuseppebrb.asd.exams.Lab20150203.model;

import java.util.List;

public class ListaElettorale implements Comparable<String> {
	
	private String name;
	private List<String> candidates;
	
	public ListaElettorale (String name, List<String> candidates){
		this.name = name;
		this.candidates = candidates;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public int compareTo(String arg0) {
		return name.compareTo(arg0);
	}
	
	public void printList(){
		System.out.println(name.toUpperCase());
	}

}
