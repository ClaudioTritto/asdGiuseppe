package com.giuseppebrb.asd.exams.Lab20150903.model;

import java.util.Random;

import com.giuseppebrb.asd.exams.Lab20150903.datastructure.ALSession;
import com.giuseppebrb.asd.exams.Lab20150903.datastructure.ArrList;
import com.giuseppebrb.asd.exams.Lab20150903.datastructure.Sessions;

public class PurchaseSystem {
	private Sessions sessioni;
	public Item [] catalog = {new Item("Infamous 2", 68), new Item("Gta V", 54), new Item("Proxy Page", 150), new Item("Tomb Raider", 32), new Item("Batman Arkham City", 50),
			new Item("Uncharted 4", 70), new Item("Fifa 18", 75), new Item("PES 18", 69)};
	
	public PurchaseSystem(int n) {
		if(n <= 0)
			throw new RuntimeException("Indice di popolamento uguale o inferiore a zero");
		Random rnd = new Random();
		sessioni = new Sessions();
		sessioni.sessions = new ArrList<>();
		
		for (int i=0; i < n; i++){
			ALSession entrySession = new ALSession();
			int carrelloSize = rnd.nextInt(5)+1;
			for(int j=0; j <= carrelloSize; j++){
				entrySession.addItem(catalog[rnd.nextInt(8)]);
			}
			sessioni.sessions.add(entrySession);
		}
	}
	
	public int associatePurchases(Item a, Item b){
		int cooccurences = 0;
		boolean foundA = false, foundB = false;
		for(ALSession session : sessioni.sessions)
			for(Item e : session.getItems()){
				if(e.getName().equalsIgnoreCase(a.getName()))
					foundA = true;
				else if(e.getName().equalsIgnoreCase(b.getName()))
					foundB = true;
				
				if(foundA == true && foundB == true){
					cooccurences ++;
					foundA = false;
					foundB = false;
				}
			}
		return cooccurences;
	}
	
	public void printSessioni(){
		int index = 1;
		for(ALSession session : sessioni.sessions){
			System.out.printf("\n---- Sessione n. %d ----\n", index);
			index++;
			for(Item e : session.getItems())
				System.out.println(e.getName() + " $" + e.getPrice());
		}	
	}
	
	public void printCooccorrenze(){
		for(int i=0; i < catalog.length; i++){
			for(int j=0; j < catalog.length; j++){
				if(i != j)
					System.out.printf("Co-occorrenze tra %s e %s : %d \n", catalog[i].getName(), catalog[j].getName(), associatePurchases(catalog[i], catalog[j]));
			}
		}
	}
}
