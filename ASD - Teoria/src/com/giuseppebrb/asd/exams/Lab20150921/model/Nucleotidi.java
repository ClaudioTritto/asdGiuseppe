package com.giuseppebrb.asd.exams.Lab20150921.model;

import java.util.HashMap;

public class Nucleotidi {
	
	public static HashMap<Character, Nucleotide> nucleotidiMap;
	private Nucleotidi(){
	}
	
	public static void inizializzaNucleotidi(){
		nucleotidiMap = new HashMap<>();
		nucleotidiMap.put('A', new Nucleotide("Adenina", 'A'));
		nucleotidiMap.put('C', new Nucleotide("Citosina", 'C'));
		nucleotidiMap.put('G', new Nucleotide("Guanina", 'G'));
		nucleotidiMap.put('T', new Nucleotide("Timina", 'T'));
	}
	
	public static void main(String[] args) {
		Nucleotidi.inizializzaNucleotidi();
		for(Character n : Nucleotidi.nucleotidiMap.keySet())
			System.out.println(Nucleotidi.nucleotidiMap.get(n).getName());
	}

}
