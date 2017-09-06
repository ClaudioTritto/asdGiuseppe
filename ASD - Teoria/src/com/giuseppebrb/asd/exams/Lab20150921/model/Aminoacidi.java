package com.giuseppebrb.asd.exams.Lab20150921.model;

import java.util.HashMap;

public class Aminoacidi {
	public static HashMap<Character, Aminoacido> aminoacidiMap;
	private Aminoacidi(){}
	
	public static void inizializzaAminoacidi(){
		aminoacidiMap = new HashMap<>();
		aminoacidiMap.put('A', new Aminoacido("Alanina", 'A'));
		aminoacidiMap.put('C', new Aminoacido("Cisteina", 'C'));
		aminoacidiMap.put('D', new Aminoacido("Acido Aspartico", 'D'));
		aminoacidiMap.put('E', new Aminoacido("Acido Gluttamico", 'E'));
		aminoacidiMap.put('F', new Aminoacido("Fenilanina", 'F'));
		aminoacidiMap.put('G', new Aminoacido("Glicina", 'G'));
		aminoacidiMap.put('H', new Aminoacido("Istidina", 'H'));
		aminoacidiMap.put('I', new Aminoacido("Isoleucina", 'I'));
		aminoacidiMap.put('K', new Aminoacido("Lisina", 'K'));
		aminoacidiMap.put('L', new Aminoacido("Leucina", 'L'));
		aminoacidiMap.put('M', new Aminoacido("Metionina", 'M'));
		aminoacidiMap.put('N', new Aminoacido("Aspargina", 'N'));
		aminoacidiMap.put('P', new Aminoacido("Prolina", 'P'));
		aminoacidiMap.put('Q', new Aminoacido("Glutammina", 'Q'));
		aminoacidiMap.put('R', new Aminoacido("Arginina", 'R'));
		aminoacidiMap.put('S', new Aminoacido("Serina", 'S'));
		aminoacidiMap.put('T', new Aminoacido("Treonina", 'T'));
		aminoacidiMap.put('V', new Aminoacido("Valina", 'V'));
		aminoacidiMap.put('W', new Aminoacido("Triptofano", 'W'));
		aminoacidiMap.put('Y', new Aminoacido("Tirosina", 'Y'));
	}
	
	public static void main(String[] args) {
		Aminoacidi.inizializzaAminoacidi();
		for(Character n : Aminoacidi.aminoacidiMap.keySet())
			System.out.println(Aminoacidi.aminoacidiMap.get(n).getName());
	}
}
