package com.giuseppebrb.asd.exams.Lab20160208.model;

import java.util.Random;

public class WhatsupTest {
	public static void main(String[] args) {
		Random rnd = new Random();
		Whatsup seven = new Whatsup();
		Whatsup nine = new Whatsup();
		Whatsup thirteen = new Whatsup();
		
		for(int i=0; i < 7; i++){
			if(i == 6)
				seven.addPacchetto(new Pacchetto("Io", "Malerba", rnd.nextInt(1000), "pacchetto " + i + " ", true));
			else
				seven.addPacchetto(new Pacchetto("Io", "Malerba", rnd.nextInt(1000), "pacchetto " + i + " ", false));
		}
		
		for(int i=0; i < 9; i++){
			if(i == 8)
				nine.addPacchetto(new Pacchetto("Io", "Malerba", rnd.nextInt(1000), "pacchetto " + i + " ", true));
			else
				nine.addPacchetto(new Pacchetto("Io", "Malerba", rnd.nextInt(1000), "pacchetto " + i + " ", false));
		}
		
		for(int i=0; i < 13; i++){
			if(i == 12)
				thirteen.addPacchetto(new Pacchetto("Io", "Malerba", rnd.nextInt(1000), "pacchetto " + i + " ", true));
			else
				thirteen.addPacchetto(new Pacchetto("Io", "Malerba", rnd.nextInt(1000), "pacchetto " + i + " ", false));
		}
		
		if(seven.complete())
			System.out.println(seven.toString());
		if(nine.complete())
			System.out.println(nine.toString());
		if(thirteen.complete())
			System.out.println(thirteen.toString());
		
		System.out.println("Comparazione prima comunicazione e seconda: " + seven.compareTo(nine));
		System.out.println("Comparazione seconda comunicazione e terza: " + nine.compareTo(thirteen));
		System.out.println("Comparazione prima comunicazione e terza: " + seven.compareTo(thirteen));
	}
}
