package com.giuseppebrb.asd.exams.Lab20160901.model;

import java.util.Random;

public class ItemReccomender {
	private Sessioni sessioni = new Sessioni();
	private Random rnd = new Random();
	public Prodotto[] elencoProdotti = {new Prodotto("Boosted Board", 1264), new Prodotto("Sony a7", 600), new Prodotto("Note 8", 800), new Prodotto("Xiaomi Yi", 80), new Prodotto("GoPro Hero 5", 500),
			new Prodotto("MacBook Pro", 1700), new Prodotto("PlayStation 4", 299), new Prodotto("Ultimo", 60)};
	
	public ItemReccomender(int n) {
		for(int i=0; i<n; i++){
			SessioneLL session = new SessioneLL();
			int shopSize = (rnd.nextInt(4)+2);
			for(int j=0; j < shopSize; j++){
				session.prodotti.add(elencoProdotti[rnd.nextInt(8)]);
			}
			sessioni.addSessione(session);
		}
	}
	
	public int acquistiAssociati(Prodotto a, Prodotto b){
        int occurences = 0;
        for (SessioneLL sessione : sessioni.getSessioni()){
            boolean foundA = false, foundB = false;
            for (Prodotto p : sessione.prodotti)
                if (p == a)
                    foundA = true;
                else if (p == b)
                    foundB = true;
            if (foundA == true && foundB == true)
                occurences++;
        }
        return occurences;
    }
	
	public void printSessions(){
		int i = 1;
		for(SessioneLL sessione: sessioni.getSessioni()){
			System.out.println(i + "------------");
			for(Prodotto p: sessione.prodotti)
				System.out.println(p.getNome() + " $"+p.getPrezzo());
			System.out.println("------------");
			i++;
		}
	}
}
