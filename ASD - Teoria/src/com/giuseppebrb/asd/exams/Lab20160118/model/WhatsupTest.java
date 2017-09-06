package Lab20160118.model;

import java.util.Random;

public class WhatsupTest {
	private static String [] parole = {"Questa ", "è ", "una ", "prova ", "un ", " po' ", "più ", "lunga!", "Hai ", "capito ", "coglione? ", "Utlime due ", "stringhe"};
	public static void main(String[] args) {
		Whatsup test = new Whatsup();
		Whatsup test1 = new Whatsup();
		Whatsup test2 = new Whatsup();
		
		Random rnd = new Random();
		
		for(int i=0; i <= 7; i++){
			Pacchetto p;
			if(i == 6)
				p = new Pacchetto("Giulio Golia", "Enrico Lucci", rnd.nextInt(1000), parole[i],  true);
			else
				p = new Pacchetto("Giulio Golia", "Enrico Lucci", rnd.nextInt(1000), parole[i],  false);
			test.addPacchetto(p);
		}
		
		for(int i=0; i <= 9; i++){
			Pacchetto p;
			if(i == 8)
				p = new Pacchetto("Giulio Golia", "Enrico Lucci", rnd.nextInt(1000), parole[i],  true);
			else
				p = new Pacchetto("Giulio Golia", "Enrico Lucci", rnd.nextInt(1000), parole[i],  false);
			test1.addPacchetto(p);
		}
		
		for(int i=0; i < 13; i++){
			Pacchetto p;
			if(i == 12)
				p = new Pacchetto("Giulio Golia", "Enrico Lucci", rnd.nextInt(1000), parole[i],  true);
			else
				p = new Pacchetto("Giulio Golia", "Enrico Lucci", rnd.nextInt(1000), parole[i],  false);
			test2.addPacchetto(p);
		}
		System.out.println("La generazione degli indici è pseudocasuale quindi potrebbe essere che un'eccezione ItemALreadyPresent venga lanciata. Se dovesse avvenire rilanciare.");
		System.out.println("Comunicazione 1: " + test.toString());
		System.out.println("Comunicazione 2: " + test1.toString());
		System.out.println("Comunicazione 3: " + test2.toString());
		
		System.out.println("Comunicazione 1 e 2 sono uguali? " + test.compareTo(test1));
		System.out.println("Comunicazione 2 e 3 sono uguali? " + test1.compareTo(test2));
		System.out.println("Comunicazione 1 e 3 sono uguali? " + test.compareTo(test2));
	}
}
